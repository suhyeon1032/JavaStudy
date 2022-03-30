var http = require('http');
var fs = require('fs');

var server = http.createServer(function(request, response){
    fs.readFile(__dirname+'/img/11.png', function(e, imgSrc){
        if(!e){
            response.writeHead(200, {'Content-Type':'image/png'});
            response.write(imgSrc);
            response.end();
        }
    });
});

server.listen(10006, function(){
    console.log('server start..  http://127.0.0.1:10006');
});