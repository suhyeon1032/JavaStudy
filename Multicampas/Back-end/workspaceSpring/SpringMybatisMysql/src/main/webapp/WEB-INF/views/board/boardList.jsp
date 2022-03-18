<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.boardList{
		overflow: auto;
	}
	.boardList>li{
		float:left;height:40px;line-height:40px;border-bottom:1px solid #ddd; width:10%;
	}
	.boardList>li:nth-child(5n+2){
		width:60%;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}
	/*페이징*/
	.paging{
        margin:30px 0;height: 30px;overflow: auto;
    }
	.paging>li{
		float:left; padding-right: 30px;
	}
	/*검색*/
	#searchFrm{
		padding:20px 200px; text-align: center;
	}
</style>
<script>
	$(function(){
		$("#searchFrm").submit(function(){
			if($("#searchWord").val()==""){
				alert("검색어를 입력하세요...");
				return false;
			}
		});
	});
</script>
<div class="container">
	<h1>게시판 목록</h1>
	<div><a href="<%=request.getContextPath()%>/board/boardWrite">글쓰기</a>
	<div>
		총 레코드 수 : ${pVO.totalRecord}, ${pVO.totalPage}/${pVO.pageNum} 검색어 ${pVO.searchWord}
	</div>
	<ul class="boardList">
		<li>번호</li>
		<li>제목</li>
		<li>글쓴이</li>
		<li>조회수</li>
		<li>등록일</li>
		
		<c:forEach var="vo" items="${list}">
			<li>${vo.no}</li>
			<li><a href="/myapp/board/boardView?no=${vo.no}">${vo.subject}</a></li>
			<li>${vo.userid}</li>
			<li>${vo.hit}</li>
			<li>${vo.writedate}</li>
		</c:forEach>
	</ul>
	
	<!-- 페이징 -->
	<ul class="paging">
		<!-- 1. 이전 페이지 -->
		<c:if test="${pVO.pageNum==1}">
		</c:if>
		<c:if test="${pVO.pageNum>1}">
			<li><a href="/myapp/board/boardList?pageNum=${pVO.pageNum-1}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">prev</a></li>
		</c:if>
		<!-- 2. 페이지 번호 -->
        <c:forEach var="p" begin="${pVO.startPage}" end="${pVO.startPage+pVO.onePageCount-1}">
        <!-- 총페이지수보다 출력할 페이지 수가 작을 때 -->
	        <c:if test ="${p<=pVO.totalPage}">
	        	<c:if test ="${p==pVO.pageNum}">
	        		<li style="background-color:red">
	        	</c:if>
	        	<c:if test ="${p!=pVO.pageNum}">
	        		<li>
	        	</c:if>
	        	<a href="/myapp/board/boardList?pageNum=${p}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">${p}</a></li>
	        </c:if>
		</c:forEach>
		<!-- 3. 다음 페이지 -->
        <c:if test="${pVO.pageNum==pVO.totalPage}">
        </c:if>
        <c:if test="${pVO.pageNum<pVO.totalPage}">
        	<li><a href="/myapp/board/boardList?pageNum=${pVO.pageNum+1}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">next</a></li>
        </c:if>
    </ul>
    <!-- 검색 -->
    <div>
    	<form method="get" action="/myapp/board/boardList" id="searchFrm">
	    	<select name="searchKey">
	    		<option value="subject">제목</option>
	    		<option value="content">글내용</option>
	    		<option value="userid">글쓴이</option>
	    	</select>
	    	<input type="text" name="searchWord" id="searchWord"/>
	    	<input type="submit" value="Search"/>
    	</form>
    </div>
	</div>
</div>