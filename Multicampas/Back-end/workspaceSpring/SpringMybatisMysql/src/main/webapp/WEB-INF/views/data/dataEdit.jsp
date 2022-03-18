<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="//cdn.ckeditor.com/4.17.2/full/ckeditor.js"></script>
<style>
	#subject{width:99.2%}
</style>
<script>
	$(function(){
		CKEDITOR.replace("content");
		//파일 갯수 처리하기 위한 변수 생성
		var fileCount = ${fileCount}
		
		//새로 추가되는 첨부파일
		$("#dataFrm b").click(function(){
			//1. 삭제할 파일명 숨기기
			$(this).parent().css("display","none");
			//2. 삭제파일 정보의 nam을 delFile로 변경
			$(this).parent().next().attr("name","delFile");
			//3. 새로운 파일을 선택 할 수 있도록 input창 열어주기
			$(this).parent().next().next().attr("type","file");
			//4. 파일의 갯수가 줄어들어야 한다
			fileCount--;
		});
		
		$("#dataFrm").submit(function(){
			
			if($("#subject").val()==""){
				alert("제목을 입력하세요..");
				return false;
			}
			if(CKEDITOR.instances.content.getData()==""){
				alert("내용을 입력하세요.");
				return false;
			}
			//첨부파일 선택 갯수
			if($("#filename1").val()!=''){//파일을 선택하지 않았다.
				fileCount++;
			}
			if($("#filename2").val()!=''){//파일을 선택하지 않았다.
				fileCount++;
			}
			
			if(fileCount<1){
				alert("첨부파일은 반드시 1개이상이여야 합니다.");
				return false;
			}
		});
	});
</script>
<div class="container">
	<h1>자료실 글수정 폼</h1>
	<!-- 			파일업로드의 기능이 있는 폼은 반드시 enctype속성을 명시하여야한다. -->
	<form id="dataFrm" method="post" action="/myapp/data/editOk" enctype="multipart/form-data">
		<input type="hidden" name="no" value="${vo.no }"/>
		<ul>
			<li>제목</li>
			<li><input type="text" name="subject" id="subject" value="${vo.subject}"/></li>
			<li>글내용</li>
			<li><textarea name="content" id="content">${vo.content }</textarea></li>
			<li>첨부파일</li>
			<li>
				<!-- 첫번째 첨부화일 -->
				<div> ${vo.filename1} &nbsp;&nbsp;&nbsp;<b>X</b></div>
				<!-- X를 누르면 삭제파일명이 있는  input의 name속성값을 delFile로 춤 -->
				<!-- 안보이게 파일 경로를 가지고 있을 객체 생성 -->
				<input type="hidden" name="" value="${vo.filename1}"/>
				<!-- X를 누르면 파일이 삭제되고 새로운 파일 선택 가능하도록 input만들어줌 -->
				<input type="hidden" name="filename" id="filename1"/>
			</li>
			<li>
				<c:if test="${vo.filename2!=null && vo.filename2!='' }">
					<!-- 두번째 첨부화일 있을떄 -->
					<div> ${vo.filename2} &nbsp;&nbsp;&nbsp;<b>X</b></div>
					<!-- X를 누르면 삭제파일명이 있는  input의 name속성값을 delFile로 춤 -->
					<!-- 안보이게 파일 경로를 가지고 있을 객체 생성 -->
					<input type="hidden" name="" value="${vo.filename2}"/>
					<!-- X를 누르면 파일이 삭제되고 새로운 파일 선택 가능하도록 input만들어줌 -->
					<input type="hidden" name="filename" id="filename2"/>
				</c:if>
				<!-- 두번째 첨부파일 없을때 -->
				<c:if test="${vo.filename2==null || vo.filename2==''}">
					<input type="file" name="filename" id="filename2">
				</c:if>
			</li>
			<li><input type="submit" value="자료실글수정"/></li>
		</ul>
	</form>
</div>