/*
    node.js : 이벤트기반 서버 프레임워크이다.
    모듈을 객체로 생성하여 사용할 수 있다.
*/

//  1. 서버 생성하기 : http 모듈을 이용하여 server을 생성한다.
//  http모듈을 객체초 생성하기
var http = require('http'); // 객체 생성하기 끝!

//  http객체를 이용하여 서버 만들기
var server = http.createServer(function(request, response){ // 클라이언트랑 서버랑 소통 가능해야 한기에 그 함수를 ()안에 넣어준다.
    // 접속자에 응답하기

    // 헤더 정보보내기  (200은 정상 처리) , (컨텐츠 타입)
    response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
    // 컨텐츠 보내기
    response.write("<h1>노드서버에서 보낸 컨텐츠</h1>");
    response.write("http모듈을 이용하여 객체를 생성 후 server를 생성함");
    // 종료 정보 보내기
    response.end("End!"); //() 공백이어도 되고 보낼 내용 보내도 됨
});

//  접속 대기   port   큘백함수           (port번호는 65000까지 사용 가능)
server.listen(10000, function(){
    console.log("server start.... http://127.0.0.1:10000");
}); // 접속을 기다리는 거임