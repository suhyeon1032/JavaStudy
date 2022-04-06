var fs = require('fs');
//1. 비동기식으로 파일 쓰기
var writeDate = "비동기식으로 파일로 쓰기 연습중\r\n줄바꿈확인하기..";

//                      파일명          쓰기 할 내용,   인코딩, 콜백함수 
fs.writeFile(__dirname+'/file_write.txt',writeDate, 'utf-8', function(error){
    if(error){
        console.log('비동기 식으로 쓰기 실패' + error);

    } else{
        console.log('비동기식으로 파일 쓰기 성공');
    }

});


//2. 동기식으로 파일 쓰기
var writeDateSync = "동기식으로 파일 쓰기";
try{
    fs.writeFileSync(__dirname+"/file_write2.txt", writeDateSync, "utf-8");
    console.log('동기식 쓰기 완료 ');
}catch(error){
    console.log('동기식 쓰기 에러 ' + error);
}