// npm install express
// npm install request-ip       : 접속자의 ip를 구하는 모듈
// npm install mysql2           : DB 연동 모듈
// npm install ejs              : ejs 모듈
// npm install express-session  : 세션 모듈

var http = require('http');
var express = require('express');
var fs = require('fs');
var ejs = require('ejs');
var requestip = require('request-ip');
var session = require('express-session');   //세션 객체

// 서버 생성
var app =  express();
var server = http.createServer(app);

//---------------Post방식 접속시 데이터 request를 위한 설정---------------------
var bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({
    extended: false
}));

// --------Mysql Connection----------
var mysqldb = require('mysql2');
const res = require('express/lib/response');
//mysqldb.autoCommit(true);   // 자동 커밋

// DB연결 정보
var connection = mysqldb.createConnection({
    host : '127.0.0.1',
    port : 3306,
    user : 'root',
    password : '0000',
    database : 'campusdb'
});
connection.connect();

// ----------------------------------

// get(),   post()
// 홈페이지로 이동하기 :  http://127.0.0.1:10010/index
app.get('/index', function(req, res){
    fs.readFile(__dirname+'/index.html', 'utf-8', function(error, indexData){
        res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
        res.end(indexData);
    });
});

// 로그인 폼-------------------
app.get("/login", function(req, res){
    fs.readFile(__dirname+"/login.html", 'utf-8', function(error, loginData){
        res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
        res.end(loginData);
    });
});
// 로그인 하기
app.post('/loginOk', function(req, res){
    var userid = req.body.userid;
    var userpwd = req.body.userpwd;
    console.log('id=', userid, 'pwd=', userpwd);

    var sql = "select userid, username from member where userid=? and userpwd=?"

    connection.execute(sql, [userid, userpwd], function(error, record){
        console.log(record);
        if(record.length>0){  // 로그인 잘 된 경우
            session.user = {
                userid : record[0].userid,
                username : record[0].username,
                autorized : true    // 인증 받은, 검정 필
            }
            res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
            fs.readFile(__dirname+'/index.ejs', 'utf-8', function(err, data){
                if(err){
                    res.end("404 Page....");
                }else{
                    res.end(ejs.render(data, {
                        user : session.user,
                        logStatus : "Y"
                    }));               
                }
            });
        }else{  // 로그인이 안된 경우 로그인으로 이동
            res.redirect("/login");
        }
    });
});
// 로그아웃
app.get('/logout', (req,res)=>{
    if(session.user){   // 세션에 정보가 있으면 로그인 상태
        session.user = null;    // 세션의 정보 지우기
        fs.readFile(__dirname+'/index.ejs','utf-8', (e, d)=>{
            res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
            res.end(ejs.render(d, {logStatus:'N'}));
        });
    }else{  // 없으면 로그아웃 상태
        res.redirect('/login');
    }
});


// 게시판 리스트
app.get('/list', function(req, res){
    var sql = "select no, subject, userid, hit, date_format(writedate, '%m-%d %H:%i') writedate ";
    sql += "from board order by no desc";

    // 쿼리문 실행      쿼리문, 콜백함수()
    connection.execute(sql, function(error, result){
        // 선택한 레코드 수
        var totalRecord = result.length;
        // console.log(result);
        // console.log(__dirname);
        if(result.length>0){   // 선택한 레코드가 있으면 list페이지로 보내기
            fs.readFile(__dirname+'/list.ejs', 'utf-8',function(e, d){
                res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
                res.end(
                    ejs.render(d, {
                        results : result,
                        parsing : {
                            totalRecord : totalRecord, 
                            nowPage : 3, 
                            startPage : 1,
                            onePageRecord : 5
                        } 
                    })
                );
            });
        }
    });
});


//글쓰기폼
app.get('/write', (req,res)=>{
    fs.readFile(__dirname+'/write.html','utf-8',function(error, data){
        if(!error){
            res.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
            res.end(data);
        }
    });
});
//글쓰기 DB등록
app.post('/writeOk',(req,res)=>{
    var userid = req.body.userid;
    var subject= req.body.subject;
    var content = req.body.content;

    var ip = requestip.getClientIp(req).substring(7);//접속자 ip구하기   ::ffff:127.0.0.1

    var sql = "insert into board(userid, subject, content, ip) values(?,?,?,?)";
    var bindData = [userid, subject, content, ip];
    //               쿼리문
    connection.execute(sql, bindData, function(error, result){
        console.log(result);
        if(error || result.affectedRows < 1){//글쓰기 실패시
            res.redirect('/write');
        }else{//글쓰기 성공시
            res.redirect('/list');
        }
    });
});


//글 내용보기
app.get('/view',(req, res)=>{
    //get 방식 접속 데이터
    let url = req.url;
    let params = url.substring(url.indexOf('?')+1);
    let noObj = new URLSearchParams(params);
    var bindData = [noObj.get("no")];

    //조회수 증가
    var sql = "update board set hit=hit+1 where no=?";
    connection.execute(sql, bindData, (e, r)=>{
        console.log(r);
    });

    //글 선택
    sql = "select no, userid, subject, content, hit, writedate from board where no=?";
    connection.execute(sql, bindData, (e,r)=>{
        if(e){
            res.redirect("/list");

        }else{
            fs.readFile(__dirname+'/view.ejs', 'utf-8', (error, tag)=>{
                res.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
                res.end(
                    ejs.render(tag, {result:r})

                );
            });
        }
    })
})

//글수정
app.get('/edit', (req, res)=>{
    var params = new URLSearchParams(req.url.substring(req.url.indexOf('?')+1));
    var sql = "select subject, content, no from board where no=?";

    connection.execute(sql, [params.get("no")],(error, records)=>{
        if(error){
            res.redirect('/view?no='+params.get('no'));
        }else{
            fs.readFile(__dirname+'/edit.ejs', 'utf-8', (e, tag)=>{
                res.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
                res.end(
                    ejs.render(tag, {record:records})
                );
            });
        }
    });
})

//글수정 db
app.post('/editOk', (req, res)=>{
    var no = req.body.no;
    var subject = req.body.subject;
    var content = req.body.content;

    var sql = "update board set subject=?, content=? where no=?";
    var bindData = [subject, content, no];
    connection.execute(sql, bindData, (error, result)=>{
        console.log(result);
        if(error||result.changedRows<1){//수정 안됨
            res.redirect("/edit?no="+no);
        }else{ //수정됨
            res.redirect("/edit?no="+no);
        }
    })
     
});

//글 삭제 
app.get('/del', (req, res)=>{
    var params = new URLSearchParams(req.body.substring(req.url.indexOf('?')+1));
    var sql = "delete from board where no=?";
    connection.execute(sql, [params.get('no')], (error, result)=>{
        if(error){//삭제 실패
            res.redirect('/view?no='+params.get('no'));

        }else{//삭제 성공
            res.redirect('/list');

        }
    });

});
server.listen(10010, function(){
    console.log('server start....       http://127.0.0.1:10010/index'); //index.html
});