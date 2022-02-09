<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러발생</title>
</head>
<body>

	<jsp:include page="menubar.jsp" />
	<h1 align="center" style="color:red">${ errorMsg }</h1>
</body>
</html>