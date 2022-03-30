var http = require("http");

var myModule = require('./node04_custom_module_create');

var server = http.createServer(function(request, response){
    response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
    response.write("상품 코드 => " + myModule.productCode + "<br/>");
    response.write("상품명 => " + myModule.productName + "<br/>");

    response.write("hap(100,400) => " + myModule.hap(100,400) + "<br/>");
    response.write("minus(100,400) => " + myModule.minus(100,400) + "<br/><hr/>");
    response.write("gogodan(8)<br/>" + myModule.gugudan(8) + "<br/>");
    response.end("end!");

}).listen(10003, function(){
    console.log("server start...        http://127.0.0.1:10003");
});

