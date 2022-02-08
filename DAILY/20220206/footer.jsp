<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.SimpleDateFormat, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
		// Date 객체 => new Date() 오늘 날짜 나옴
		// 오늘 날짜 기준으로 년도만 뽑아서 채워넣겠다
		//=> SimpleDateFormat 객체를 이용해서 년도만 뽑자
		
		String year = new SimpleDateFormat("yyyy").format(new Date());
	
	%>


Copyright © 1998-<%= year %> KH Information Educational Institute All Right Reserved
<!-- 매년 해가 바뀔 때마다 직접적으로 년도를 바꾸는 것은 매우 성가시다 까먹을 수도 잇다. -->


<br>

01_include.jsp로부터 전달받은 test라는 키값의 밸류를 출력<br>
test : ${ param.test }
</body>
</html>