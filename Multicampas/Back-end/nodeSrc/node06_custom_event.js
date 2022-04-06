var http = require('http');

//이벤트가  정의되어있는 events 모듈을 객체화 하여야 한다.
var events = require('events');

//이벤트 처리를 하기 위해서는 모듈을 담고 있는  eventEmmiter 객체를 초기화해야한다.
var event_obj = new events.EventEmitter();

//이벤트가 발생시 실행할 함수를 정의하기
// on(), addListener(), once()

//       이벤트 종류, 이벤트 발생시 실행될 함수
event_obj.on('call', ()=>{ //call이벤트 발생시 실행됨.
    console.log('call 이벤트 발생됨');
    
});

event_obj.addListener('call2', ()=>{ //call2 이벤트 발생시 실행됨.
    console.log('call2 이벤트 발생됨');
    
});

event_obj.once('call3', ()=>{ //call2 이벤트 발생시 실행됨.
    console.log('call3 이벤트 발생됨');
    
});
var server = http.createServer((req, res)=>{
    //서버에 접속을 하면 이벤트를 발생시킴 : emit()
    event_obj.emit('call');//call이벤트 발생시킴
    event_obj.emit('call2');//call2 이벤트 발생시킴
    event_obj.emit('call3');//call3 이벤트 발생시킴
    res.writeHead(200,  {'Content-Type':'text/html; charset=utf-8'});
    res.end("<h1>이벤트 테스트중..</h1>");

});

server.listen(10004, ()=>{
    console.log("start.... http://127.0.0.1:10004");
})