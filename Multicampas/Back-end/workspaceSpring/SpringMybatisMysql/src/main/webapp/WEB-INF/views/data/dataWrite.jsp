<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="//cdn.ckeditor.com/4.17.2/full/ckeditor.js"></script>
<style>
	#subject{width:99.5%}
</style>
<script>
	$(function(){
		CKEDITOR.replace("content");//ckeditor불러오기
		$("#dataFrm").submit(function(){
			if($("#subject").val()==""){
				alert("제목을 입력해 주세요");
				return false;
			}
			if(CKEDITOR.instances.content.getData()==""){
				alert("글 내용을 입력하세요");
				return false;
			}
			//첨부파일 선택 갯수
			let fileCount=0;
			if($("#filename1").val()!=''){//파일을 선책했을 경우
				fileCount++;
			}
			if($("#filename2").val()!=''){
				fileount++;
			}
			if(fileCount<1){
				alert("첨부파일은 반드시 1개 이상이어야 합니다");
				return false;
			}
		});
	});
</script>
<div class="container">
	<h1>자료실 글 등록 폼</h1>
	<!-- 파일 업로드 기능이 있는 폼 : enctype속성 사용해야함 -->
	<form id="dataFrm" method="post" action="/myapp/data/writeOk" enctype="multipart/form-data">
	<ul>
		<li>제목</li>
		<li><input type="text" name="subject" id="subject"/></li>
		<li>글내용</li>
		<li><textarea name="content" id="content"></textarea></li>
		<li>첨부화일</li>
		<li>
			<input type="file" name="filename" id="filename1"/><br/>
			<input type="file" name="filename" id="filename2"/>
		</li>
		<li><input type="submit" value="자료실글등록"/></li>		
	</ul>
	</form>
</div>