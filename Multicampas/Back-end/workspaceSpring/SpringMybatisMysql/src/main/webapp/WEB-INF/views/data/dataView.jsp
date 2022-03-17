<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	function dataDelCheck(){
		
		
	}
</script>

<div class="container">
    <h1>자료실 글 내용보기</h1>
    <ul>
        <li>번호 : ${dataVO.no}</li>
        <li>글쓴이 : ${dataVO.userid }</li>
        <li>등록일 : ${dataVO.writedate }</li>
        <hr/>
        <li>제목 : ${dataVO.subject }</li>
        <hr/>
        <li><h3>글내용</h3></li>
        <li>${dataVO.content }</li>
        <hr/>
        <li>첨부파일 : <a href="/myapp/upload/${dataVO.filename1 }" download>${dataVO.filename1 }</a></li>
            <c:if test="${dataVO.filename2 != null && dataVO.filename2 != '' }">
                , <a href='/myapp/upload/${dataVO.filename2 }' download>${dataVO.filename2 }</a>
            </c:if>
    </ul>
    <c:if test="${dataVO.userid==logId }">
    	<a href="/myapp/data/dataEdit?no=${dataVO.no }">수정</a>
    	<a href="javascript:dataDelCheck()">삭제</a>
    </c:if>
</div>