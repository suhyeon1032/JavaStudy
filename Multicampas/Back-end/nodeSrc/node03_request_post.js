var http = require('http');

var server = http.createServer(function(request, response){
    // 1. post로 전송받은 데이터를 누적시킬 변수
    var postData = '';

    // 2. post로 form의 데이터가 서버에 전송되면 data이벤트 발생
    request.on('data', function(data){
        postData += data;
    });

    // 3. form의 데이터 전송이 완료되면 end이벤트가 발생된다.
    request.on('end', function(){
        console.log(postData);
    });
    
});

server.listen(10002, function(){
    console.log("start ... http://127.0.0.1:10002");
});