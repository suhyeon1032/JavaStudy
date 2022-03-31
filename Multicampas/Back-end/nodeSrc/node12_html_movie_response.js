var http = require('http');
var fs = require('fs'); //파일 읽기위한 파일시스템 변수 필요
var mime = require('Mime');

var server = http.createServer(function(req, res){
    var mapping = req.url;
    // html 문서보내기
    if(mapping=='/'){
        fs.readFile(__dirname+'/movie.html','utf-8',function(error, htmlData){
            if(!error){
                res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
                res.end(htmlData);
            }
        });
    }else if(mapping.indexOf('/img')==0){ // image 보내기       /img/9.jpg
        mimeName = mime.getType(mapping.substring(1));
        fs.readFile(__dirname+mapping, function(e, imgData){
            if(!e){
                res.writeHead(200, {"ContentType":mimeName});
                res.end(imgData);
            }
        });
    }else if(mapping.indexOf("/movie")==0){ // video 보내기
        // 동영상은 파일이 크기 때문에 스트리밍 처리로 전송한다. (65535byte읽어옴)

        // 1. 스트리밍 처리를 위한 객체를 생성한다.
        var stream = fs.createReadStream(mapping.substring(1));  //  movie/se.mp4
        
        // 2. 스트리밍 처리를 하기 위해서 여러 번 데이터를 전송해야 하며
        //    이벤트를 이용하여 처리한다.

        // 데이터가 read된 경우 호출되는 이벤트
        var cnt = 1;
        stream.on('data', function(movieData){
            res.write(movieData);
            console.log(cnt++ + '번째 전송됨. '+ movieData.length);
        });
        // end 이벤트 : 데이터가 read의 마지막일때 호출되는 이벤트
        stream.on('end', function(){
            res.end();
            console.log("stream end....");
        });

        // 데이터 read시 에러발생시 호출되는 이벤트
        stream.on('error', function(){
            res.end();
            console.log("error stream....");
        })
    }
});

server.listen(10008, function(){
    console.log('server start...        http://127.0.0.1:10008');
});