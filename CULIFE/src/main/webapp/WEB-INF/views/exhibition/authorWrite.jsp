<link rel="stylesheet" href="/css/authorWrite.css" type="text/css" />

<main>
	<div class="container">
        <div class="containerWrap">
			<div class="exhibitionContainer">
			<form name="authorWrite" id="authorWrite">
				<div class="authorWriteTitle">
					<h1>작가 등록 ${mvo.no}</h1>
				</div>
				<div class="authorWriteContent">
					<div class="authorWriteID">
						<div>닉네임</div>
						<div>${mvo.nickname} ${vo.testNickName }</div>
						
					</div>
					<div class="authorWriteName">
						<div>작가명</div>
						<div><input type="text" id="authorWriteName"></div>
					</div>
					<div class="authorWriteSNS">
						<div>SNS 주소</div>
						<div><input type="text" id="authorWriteSNS"></div>
					</div>
					<div class="authorWriteThumbnail">
						<div>프로필 사진</div>
						<input type="file" name="authorThumbnail" id="authorThumbnail"/>
					</div>
				</div>
				<div>
					<button class="authorWriteBtn" id="authorWriteBtn">작가 신청하기</button>
					<input type="button" value="작가 신청" onclick="authorSubmit()"/><!-- 
					<input type="submit" id="submit" value="저장" class="btn"> -->
				</div>
				냥냥~
				 </form>
			</div>
		</div>
	</div>
</main>
<script type="text/javascript">

	function authorSubmit() {
		console.log("ff1");
		var authorNickname = "${mvo.nickname}";
		var params = "nickname=" + "${mvo.nickname}";
		var author = $("#authorWriteName").val();
		var sns_link = $("#authorWriteSNS").val();
		var author_thumbnail = $("#authorThumbnail").val();
		console.log(authorNickname);
		console.log(params);
		console.log(author);
		
		$.ajax({
			url: '/authorWriteOk',
			type: 'POST', 
			dataType: 'json',
			data : {
				nickName: '${mvo.nickname}',
				member_no: '${mvo.no}',
				author: $("#authorWriteName").val(),
				sns_link: $("#authorWriteSNS").val(),
				author_thumbnail: $("#authorThumbnail").val()
			},
			success: function(result) {
				if (result) {
					alert("작가 신청 완료되었습니다.");
				} else {
					alert("작가 신청 실패");
				}
				
			}
		});
		/* 
		document.getElementById('authorWrite').submit() */
	}

</script>