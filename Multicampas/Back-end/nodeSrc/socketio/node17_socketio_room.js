var http = require('http');
var fs = require('fs');

var server = http.createServer((req, res)=>{
    if(req.url == '/room'){
        fs.readFile(__dirname+'/chatting_room.html', 'utf-8', function(e, d){
            console.log(e);
            if(!e){
                res.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
                res.end(d);
            }
        });
    }
});

server.listen(10030, function(){
    console.log("server start..         http://127.0.0.1:10030/room");
});

///////////////////////////////////////////
var socketio = require('socket.io');
var io = socketio.listen(server);

// 접속 대기
io.sockets.on('connection', function(socket){
    // 방만들기
    var rName;
    socket.on('join', function(roomName){
        rName = roomName;
        socket.join(roomName);

        socket.emit('res', rName+'방이 만들어졌습니다.');
    });

    // 클라이언트가 메세지를 보내면 받을 이벤트
    socket.on('message', function(data){
        // 같은 방에 있는 클라이언트에게 문자 보내기
        io.sockets.in(rName).emit('res', rName+"-->"+data);
    });
});