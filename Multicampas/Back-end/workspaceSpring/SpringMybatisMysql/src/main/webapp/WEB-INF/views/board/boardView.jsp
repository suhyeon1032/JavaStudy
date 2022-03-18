<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	function delCheck(){
		//사용자가 Y(true),N(false) 선택 가능
		if(confirm("삭제하시겠습니까?")){
			//확인 버튼 클릭시
			location.href="/myapp/board/boardDel?no=${vo.no}";
		}
	}
	//댓글
	$(function(){
		//2. 댓글 목록을 가져오는 함수
		function replyListAll(){//현재 글의 댓글을 모두 가져오기
			var url = "/myapp/reply/list";
			var params = "no=${vo.no}";
			$.ajax({
				url:url,
				data:params,
				success:function(result){
					var $result = $(result);//vo,vo,vo....
					
					var tag="<hr/><ul>";
					
					$result.each(function(idx, vo){
						tag += "<li><div>"+vo.userid;
						tag += "("+vo.writedate+")";
						if(vo.userid=='${logId}'){
							tag += "<input type='button' value='Edit'/>";
							tag += "<input type='button' value='Del' title='"+vo.replyno+"'/>";
						}
						
						tag += "<br/><br/>"+vo.coment+"</div>";
						if(vo.userid=='${logId}'){
							tag += "<div style='display:none;'><form method='post'>";
							tag += "<input type='hidden' name = 'replyno' value='"+vo.replyno+"'/>";
							tag += "<textarea name='coment' style='width:400px;'>"+vo.coment+"</textarea>";
							tag += "<input type='submit' value='수정'/>";
							tag += "</form></div>"
						}
						
						tag += "<hr/></li>";
					});
					
					tag+="</ul>";
					
					$("#replyList").html(tag);
					
				},error:function(e){
					console.log(e.responseText);
				}
			});
			
		}
		//1. 댓글 등록
		$("#replyFrm").submit(function(){
			event.preventDefault();//from 기본 이벤트 제거
			if($("#coment").val()==""){//댓글을 입력하지 않은 경우
				alert("먼저, 댓글을 입력해주세요!");
				return;
			}else{//댓글을 입력한 경우
				//form에 있는 데이터를 params에 담기
				var params = $("#replyFrm").serialize();
			
				$.ajax({
					url:'/myapp/reply/writeOk',
					data:params,
					type:'POST',
					success:function(r){//결과물이 r에 담김
						//1)폼에 입력된 내용을 지움
						$("#coment").val("");
						console.log("r",r);						
						//댓글 목록 refresh되어야 함
						replyListAll();
						
					},error:function(e){
						console.log(e.responseText);
					}
				});
			}
		});
	
		//댓글수정 버튼 클릭시 해당 폼 보여주기
		$(document).on('click','#replyList input[value=Edit]',function(){
			$(this).parent().css("display","none");//숨기기
			$(this).parent().next().css("display","block");//보여주기
		})
		//댓글 수정 DB 작업
		$(document).on('submit','#replyList form',function(){
			event.preventDefault();
			//데이터
			var params=$(this).serialize();
			var url='/myapp/reply/editOk';
			$.ajax({
				url:url,
				data:params,
				type:'POST',
				success:function(result){
					console.log(result);
					replyListAll();
				},error:function(){
					console.log('수정에러 발생');
				}
			})
		});
	
		//4. 댓글 삭제
		$(document).on('click','#replyList input[value=Del]',function(){
			if(confirm('댓글을 삭제하시려구요?')){
				var params = "replyno="+$(this).attr("title");
				$.ajax({
					url:'/myapp/reply/del',
					data:params,
					success:function(result){
						console.log(result);
						replyListAll();
					},error:function(){
						console.log("댓글 삭제 에러");
					}
				});
			}
		});
		
		//현재 글의 댓글
		replyListAll();
	});
</script>
<div class="container">
	<h1>글내용보기</h1>
	<ul>
		<li>번호 : ${vo.no}</li>
		<li>작성자 : ${vo.userid}</li>
		<li>작성일 : ${vo.writedate}, 조회수 : ${vo.hit}</li>
		<li><hr/>제목 : ${vo.subject}<hr/></li>
		<li>글내용 : </li>
		<li>${vo.content}</li>
	</ul>
	<div>
		<!-- 로그인 아이디와 글쓴이가 같은 경우 -->
		<c:if test="${logId==vo.userid}">
			<a href="/myapp/board/boardEdit?no=${vo.no}">수정</a>
			<a href="javascript:delCheck()">삭제</a>
		</c:if>
	</div>
	<hr/>
	<!-- 댓글쓰기 -->
	<c:if test="${logStatus=='Y'}">
		<form method='post' id='replyFrm'>
			<input type="hidden" name="no" value="${vo.no}"/>
			<textarea name="coment" id='coment'style='width:500px;height:80px;'></textarea>
			<input type="submit" value="댓글등록"/>
		</form>
	</c:if>
	<!-- 댓글 목록 나올 자리 -->
	<div id="replyList"></div>
</div>