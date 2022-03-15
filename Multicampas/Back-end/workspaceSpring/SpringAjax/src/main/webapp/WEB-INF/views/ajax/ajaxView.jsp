<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
#resultView {
	padding: 20px;
	border: 1px solid gray;
	background-color: lightblue;
	height: 200px;
	margin: 20px;
}

.pList, .pList>li {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

.pList>li {
	float: left;
	height: 40px;
	line-height: 40px;
	border-bottom: 1px solid gray;
	width: 25%;
}
</style>
<script>
	$(function() {
		//비동기식으로 서버어ㅔ 접속하여 문자열 데이터 가져오기.
		$("#ajaxString").click(function() {
			var url = "/myapp/ajaxString"
			var params = "num=100&name=홍길동&addr=서울시 강남구 역삼동";
			$.ajax({
				url : url, //서버의 맵핑주소
				type : 'GET', //전송방식
				data : params, //서버로 보낼 데이터 
				success : function(result) {//서버에서 성공적으로 응답을 받으면 실행, 데이터는 result매개변수에 담긴다.
					//서버에서 받은 데이터를 뷰페이지에 표시
					$("#resultView").html(result);
				},
				error : function(error) {
					console.log(error.responseText);
				}
			});
		});//ajaxString

		//비동기식으로 서버에서 vo객체 가져오기
		$("#ajaxObject").on('click', function() {
			var url = "/myapp/ajaxObject";
			var params = "num=200&name=세종대왕"
			$.ajax({
				url : url,
				data : params,
				success : function(result) {
					var tag = "<ul>";
					tag += "<li>상품번호 : " + result.proNo + "</li>"
					tag += "<li>상품명 : " + result.proName + "</li>"
					tag += "<li>상품가격 : " + result.price + "</li>"
					tag += "<li>상품수량 : " + result.cnt + "</li>"
					$("#resultView").html(tag);
				},
				error : function(error) {
					console.log(error.responseText);
				}
			});
		});
		//비동기식으로 List 리턴받기
		$("#ajaxList")
				.click(
						function() {
							var url = "/myapp/ajaxList";
							$
									.ajax({
										url : url,
										success : function(result) {
											//result의 List를 $(result)로 처리하면 순서대로 접근이 가능하다
											var $result = $(result);

											var tag = "<ol class='pList'><li>상품코드</li><li>상품명</li><li>상품가격</li><li>상품수량</li>";

											//
											$result.each(function(idx, vo) {
												tag += "<li>" + vo.proNo
														+ "</li>";
												tag += "<li>" + vo.proName
														+ "</li>";
												tag += "<li>" + vo.price
														+ "</li>";
												tag += "<li>" + vo.cnt
														+ "</li>";
											});
											tag += "</ol>";

											$("#resultView").html(tag);
										},
										error : function() {
											console.log("전송에러...")
										}
									});
						});
		$("#ajaxMap").click(
				function() {

					var url = "/myapp/ajaxMap";
					$.ajax({
						url : url,
						success : function(result) {
							var tag = "<ul>";
							//			  	map.key.value 구조 		
							tag += "<li>" + result.p1.proNo + ", "
									+ result.p1.proName + ", "
									+ result.p1.price + ", " + result.p1.cnt
									+ "</li>";
							tag += "<li>" + result.p3.proNo + ", "
									+ result.p3.proName + ", "
									+ result.p3.price + ", " + result.p3.cnt
									+ "</li>";
							tag += "<li>" + result.p5.proNo + ", "
									+ result.p5.proName + ", "
									+ result.p5.price + ", " + result.p5.cnt
									+ "</li>";

							$("#resultView").html(tag);
						}
					});
				});
		//Json데이터 보내고 받기
		$("#ajaxJson").click(
				function() {

					var url = "/myapp/ajaxJson";
					var data = {
						no : 5555,
						name : '이순신',
						tel : '010-1234-5678'
					};

					$.ajax({
						url : url,
						data : data,
						dataType : 'json',
						success : function(result) {
							//1. 문자열을 json으로 변환한다.
							var jsonData1 = JSON.stringify(result);
							//2. json을 key와 value로 변환한다.
							var jsonData2 = JSON.parse(jsonData1);

							$("#resultView").html(
									"상품번호 :" + jsonData2.proNo + "<br/>상품명 :"
											+ jsonData2.proName + "<br/>상품번호 :"
											+ jsonData2.price)
						},
						error : function() {
							console.log("Error!!!!!");
						}
					});
				});

		$("#pFrm").submit(function() {
			event.preventDefault();
			var url = "/myapp/ajaxForm";
			//폼의 데이터를 json변환한다.
			var params = $("#pFrm").serialize();

			$.ajax({
				url : url,
				type : "POST",
				data : params,
				success : function(result) {
					$("#resultView").html(result);
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>Ajax로 비동기식 서버 통신</h1>
	<button id="ajaxString">ajax(문자열)</button>
	<button id="ajaxObject">ajax(Object)</button>
	<button id="ajaxList">ajax(List)</button>
	<button id="ajaxMap">ajax(Map)</button>
	<button id="ajaxJson">ajax(Json)</button>
	<hr />
	<form method="post" id="pFrm">
		상품명 : <input type="text" name="proName" id="proName" /><br /> 상품가격 :
		<input type="text" name="price" id="price" /><br /> <input
			type="submit" value="등록" />
	</form>
	<hr />
	<div id="resultView"></div>
</body>
</html>