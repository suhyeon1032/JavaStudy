<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="url" value="<%=request.getContextPath()%>"/>
<link rel="stylesheet" href="/css/exhibition/authorWrite.css" type="text/css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${url}/css/mypage/mypage.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>
$(function(){
		
	$("#authorWriteName").keyup(function(){
		console.log("kkkkkk");
		var author = $("#authorWriteName").val();
		if(author != ''){
			console.log(author);
			var url = "/authorNameCheck";
				
			$.ajax({
				url: url,
				data: "author="+author,
				type: "POST",
				success: function(result){
					if(result==author){
						$("#chk").html("이미 사용중인 작가명 입니다.");
						$("#authorchk").val("N");
						$("#chk").css("color","red");
					}else{//사용가능
						$("#chk").html("사용 가능한 작가명 입니다.");
						$("#authorchk").val("Y");
						$("#chk").css("color","blue");
					}
				}
			});
		}
	});
	
	$('input[name="authorThumbnail"]').change(function(){
	    setImageFromFile(this, '#preview');
	});

	function setImageFromFile(input, expression) {
	    if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function (e) {
	    $(expression).attr('src', e.target.result);
	  }
	  reader.readAsDataURL(input.files[0]);
	  }
	}
	
});


function authorSubmit() {
	var authorNickname = "${mvo.nickname}";
	var params = "nickname=" + "${mvo.nickname}";
	var author = $("#authorWriteName").val();
	var sns_link = $("#authorWriteSNS").val();
	var author_thumbnail = $("#authorThumbnail").val();
	var debut_year = $("#authorDebutYear").val();
	var author_msg = $("#authorMsg").val();
	console.log(authorNickname);
	console.log(params);
	console.log(author);
	console.log(debut_year);
	if (author == '' ) {
		alert("작가명을 입력해 주세요")
	} 
	else if (sns_link == '' ) {
		alert("sns링크를 입력해 주세요")
	}
	else if (author_thumbnail == '' ) {
		alert("프로필사진을 첨부해 주세요")
	}
	else if (debut_year == '' ) {
		alert("데뷔년도를 입력해 주세요")
	} else {
	
		$.ajax({
			url: '/authorWriteOk',
			type: 'POST', 
			dataType: 'json',
			data : {
				nickName: '${mvo.nickname}',
				member_no: '${mvo.no}',
				author: $("#authorWriteName").val(),
				sns_link: $("#authorWriteSNS").val(),
				author_thumbnail: $("#authorThumbnail").val(),
				debut_year: $("#authorDebutYear").val(),
				author_msg: $("#authorMsg").val()
			},
			
			success: function(result) {
				if (result) {
					alert("작가 신청 완료되었습니다.");
				} else {
					alert("작가 신청 실패");
				}
					
			}
		});
	}
}
</script>
<main id="mypage_member" class="container-fluid">
	<div class="row" style="height: 100%;">
		<div class="col-9" id="mypage_col">
			<div class="containerWrap">
				<div class="exhibitionContainer">
					<form name="authorWrite" id="authorWrite"
						enctype="multipart/form-data">
						<div class="authorWriteThumbnail">
							<img src="/img/member/default_thumbnail.png" id="preview"
								style="width: 170px; height: 170px;" /> 
							<input type="file" name="authorThumbnail" class="files" id="authorThumbnail"
								style="width: 270px; height: 46px;" value="사진 선택">
						</div>
						<div class="authorWriteContent">
							<div class="authorWriteID">
								<label>닉네임</label>
								<input type="text" value="${mvo.nickname}" class="form-control" id="authorWriteName" readonly>
								

							</div>
							<div class="authorWriteName">
								<div>작가명</div>
								<div>
									<input type="text" class="form-control" id="authorWriteName" placeholder='작가명 입력'>
								</div>
								<span id="chk"></span>
								<!-- <div><input type ="text" id="authorchk" value ="N" style="visibility:hidden"/></div> -->
							</div>
							<div class="authorWriteSNS">
								<div>SNS 주소</div>
								<div>
									<input type="text" class="form-control" id="authorWriteSNS">
								</div>
							</div>

							<div class="authorDebutYear">
								<div>데뷔년도</div>
								<div>
									<input type="text" class="form-control" id="authorDebutYear">
								</div>
							</div>
							<div class="authorMsg">
								<div>자기소개</div>
								<div>
									<input type="text" class="form-control" id="authorMsg">
								</div>
							</div>
						</div>
						<div>
							<input type="button" id="memberForm_member_edit_btn" class="btn btn-outline-secondary" value="작가 신청" onclick="authorSubmit()" />
						</div>
					</form>
				</div>
			</div>
			<!-- mypage_container end -->
		</div>
		<div class="col-3" id="mypage_sidebar">
			<div class="container" id="mypage_sidebar_container">
				<h1 class="h1">${mvo.nickname}님
					반갑습니다.<img id="mypage_notification"
						src="${url}/img/member/mypage_notification.png">
				</h1>
				<hr />
				<ul>
					<li><a href="${url}/mypage/review/movie">리뷰</a></li>
					<li><a href="${url}/mypage/review">감상평</a></li>
					<li><a href="${url}/mypage/board">작성글</a></li>
					<li><a href="${url}/mypage/fan">팔로잉 작가</a></li>
					<c:if test="${grade == 0}">
						<li><a class="selected_menu" style="color: #9DC3E6"
							href="${url}/mypage/authorWrite">작가등록 신청</a></li>
					</c:if>
					<c:if test="${grade == 1}">
						<li><a href="${url}/mypage/author">작가 정보</a></li>
					</c:if>
				</ul>
				<hr />
				<ul>
					<li><a href="${url}/mypage/member">내정보</a></li>
					<li><a
						href="https://kauth.kakao.com/oauth/logout?client_id=f20eb18d7d37d79e45a5dff8cb9e3b9e&logout_redirect_uri=http://localhost:8080/logout/kakao">로그아웃</a></li>
				</ul>
			</div>
		</div>
	</div>
</main>