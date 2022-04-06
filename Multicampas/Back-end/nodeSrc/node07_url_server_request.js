var http = require('http');

http.createServer(function(req, res){
console.log(req.url);
var pathName=req.url;
res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});

if(pathName=='/username'){
    res.write("<h1>");
    res.end("이름 : 홍길동</h1>");
}else if(pathName=='/tel'){
    res.end("<h2 style='color>연락처  : 010-1234-1234</h2>");
}else if(pathName=='/address'){
    res.end("<h3>주소 : 강남구 역삼동 멀티캠퍼스</h1>");
}else{
    res.end("<h4>404page Not Found....</h4>");
}

}).listen(10005,function(){
   console.log("start.... http://127.0.0.1:10005"); 
   console.log("start.... http://127.0.0.1:10005/username"); 
   console.log("start.... http://127.0.0.1:10005/tel"); 
   console.log("start.... http://127.0.0.1:10005/address"); 
});