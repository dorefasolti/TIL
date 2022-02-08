<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- http://localhost:8003/el/views/2_StandardAction/02_forward.jsp 이게 url로 찍힘 -->

	<h1>여기는 포워딩 페이지야</h1>
	
	<!-- jsp:forward : 화면을 전환시켜주는 태그 
		특징 : url은 그대로고 화면만 바뀐다
	-->
	
	<jsp:forward page="footer.jsp"/>
</body>
</html>