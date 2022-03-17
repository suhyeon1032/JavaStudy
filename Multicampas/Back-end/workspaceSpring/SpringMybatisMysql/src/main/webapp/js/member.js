function memberCheck(){
	//아이디
	let userid = document.getElementById("userid");
	if(userid.value == ''){
		alert("아이디 입력하세요!");
		userid.focus();
		return false;
	}
	//////////////////////////////////////////////////////
	if(document.getElementById("idchk").value=='N'){
		alert("아이디 중복검사 필요");
		return false;
	}
	//////////////////////////////////////////////////////
	//비밀번호
	let userpwd = document.getElementById("userpwd");
	let userpwd2 = document.getElementById("userpwd2");
	if(userpwd.value == '' || userpwd2.value == ''){
		alert("비밀번호를 입력하세요!");
		userpwd.focus();
		return false;
	}
	if(userpwd.value != userpwd2.value){
		alert("비밀번호가 일치하지 않습니다!");
		userpwd2.focus();
		return false;
	}
	//이름
	let username = document.getElementById("username");
	if(username.value == ''){
		alert("이름을 입력하세요!");
		username.focus();
		return false;
	}
	
	//전화번호
	let tel2 = document.getElementById("tel2");
	let tel3 = document.getElementById("tel3");
	
	let regExp1 = /^[0-9]{3,4}$/;	//tel2
	let regExp2 = /^[0-9]{4}$/;		//tel3
	if(!regExp1.test(tel2.value) || !regExp2.test(tel3.value)){
		alert("전화번호를 잘못입력하였습니다.")
		tel2.focus();
		return false;
	}
	
	return true;
}