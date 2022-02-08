<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표준 액션 태그를 배워보자</title>
</head>
<body>

	<h3>include</h3>
	
<%-- 	<p>
		또 다른 페이지를 포함하고자 할 때 쓰이는 방식
		
	</p>

	<h4>1. 기존의 include지시어를 이용한 방식(정적 include 방식 == 컴파일 시 포함되는 형태)</h4>
	
	<%@include file="footer.jsp" %>
	
	<br><br>
	
	특징 : include 하고있는 페이지 상에 선언되어 있는 변수를 현재 이 페이지에서도 사용 가능함<br>
	
	include한 페이지의 year변수값 : <%= year %> <br><br>
	
	단, 현재 이 페이지에서 동일한 이름의 변수를 선언할 수 없음
	
	<%
		String year = "2022";
	
	%> --%>
	
	<hr>
	
	
	<h4>2. jsp표준액션태그를 이용한 방식(동적 include방식 == 런타임 시 포함되는 형태)</h4>
	
	<!-- 
		"반드시" 시작태그와 종료태그를 같이 써야 한다.(XML 기술을 이용했으므로)
		단, 시작태그와 종료태그 사이에 넣을 값이 따로 없다면<시작태그/> 이렇게 표현한다.
	
	 -->
	
	<jsp:include page="footer.jsp"/>
	
	
	<br><br>
	
	특징1 : include하고 있는 페이지에 선언된 변수를 공유하지 않음(즉, 동일한 이름의 변수 선언 가능)<br>
	<%
		String year = "2022";
	%>
	특징2 : 포함 시 include하는 페이지로 값을 전달할 수 있음
	<br>
	----include 테스트 ----
	<br><br>
	
	<!-- 01.include.jsp에서 footer.jsp로 값을 전달해보겠다 -->
	
	<jsp:include page="footer.jsp">
		<jsp:param value="hello..?" name="test"/>
		<jsp:param value="1111" name="test"/>
	</jsp:include>
	
	<br>
	
	<jsp:include page="footer.jsp">
		<jsp:param value="Bye..?" name="test"/>
	</jsp:include>

	

</body>
</html>