<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errorMsg = (String)request.getAttribute("errorMsg"); //반환형이 object 강제형변환필요
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러가 났다</title>
</head>
<body>
	<h1 align="center" style="color:red;"><%= errorMsg%></h1>
</body>
</html>