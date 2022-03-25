<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#dataList>li {
	float: left;
	width: 10%;
	height: 40px;
	line-height: 40px;
	border-bottom: 1px solid gray;
}
h1{text-align: center;}
#dataList>li:nth-child(5n+2) {
	width: 60%;
}
#container>div{padding: 5px;}
</style>

<div class="container">
<div>
	<h1>리뷰 게시판</h1>
	<c:choose>
		<c:when test="${logJob eq 'job1'}">
			<a href="/myapp/data/write">글쓰기</a>
		</c:when>
	</c:choose>

	<ul id="dataList">
		<li>번호</li>
		<li>제목</li>
		<li>글쓴이</li>
		<li>첨부파일</li>
		<li>등록일</li>

		<c:forEach var="vo" items="${lst}">
			<li>${vo.no }</li>
			<li><a href="/myapp/data/view?no=${vo.no}">${vo.subject}</a></li>
			<li>${vo.userid }</li>
			<li>
				<!-- 다운로드 가능하게 해줄거임 --> <!-- 첫번째 첨부파일(무조건있음) --> <a
				href="/myapp/upload/${vo.filename1}" download><img
					src="/myapp/img/disk.png" title="${vo.filename1}" /></a> <!-- 두번재 첨부파일 -->
				<c:if test="${vo.filename2!=null && vo.filename2!=''}">
					<a href='/myapp/upload/${vo.filename2}' download><img
						src='/myapp/img/disk.png' title='${vo.filename2}'></a>
				</c:if>
			</li>
			<li>${vo.writedate }</li>
		</c:forEach>

	</ul>
</div>
</div>
