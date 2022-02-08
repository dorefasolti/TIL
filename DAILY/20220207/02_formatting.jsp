<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>1. formatNumber 태그</h1>
	
	<p>
		숫자형 데이터의 포맷(형식)을 지정<br>
		- 표현하고자 하는 숫자 데이터의 형식을 통화기호, %등 원하는 쓰임에 맞게 지정하는 태그<br><br>
		
		[표현법]
		
		&lt;fmt:formatNumber value="출력할 값" groupingUsed="true/false" type="percent/currency" currencySymbol="$"/&gt;<br>
		
		(groupingUserd, type, currencySymbol은 생략가능한 속성)
		
	</p>
	
	<!-- 테스트할 변수 생성 -->
	<!-- 
		Unknow tag : 라이브러리 선언을 안해서 나는 오류(taglib지시어를 사용하면 해결)
		No end tag : 종료 태그를 안닫아준것
	 -->
	 
	 <c:set var="num1" value="123456789"/>
	 <c:set var="num2" value="0.75"/>
	 <c:set var="num3" value="50000"/>
	 
	 num1의 경우 <br>
	 그냥 출력 : ${ num1 } <br>
	 세자리마다 구분하여 출력 : <fmt:formatNumber value="${ num1 }" /><br>
	 숫자그대로출력 : <fmt:formatNumber value="${ num1 }" groupingUsed="false"/> <br><br>
	 
	 <!-- groupingUsed속성 : 3자리마다 ,로 구분해주는 속성(생략가능 기본값은 true) -->
	
	
	num2의 경우<br>
	percent : <fmt:formatNumber value="${ num2 }" type="percent"/> <br><br>
	<!-- type="percent" : 소숫점을 백분율로 변경해서 보여줌 -->
	
	num3의 경우 <br>
	currency : <fmt:formatNumber value="${ num3 }" type="currency" /><br>
	<!-- 
		type="currency":통화(돈) 단위로 보여짐
						현재 내가 쓰고있는 컴퓨터의 로컬정보에 따라서 단위가 정해짐
						
		+ groupingUsed 속성이 기본값이 true이기 때문에 3자리마다 ,도 찍혀있음
	 -->
	 
	 currency $: <fmt:formatNumber value="${ num3 }" type="currency" currencySymbol="$" />
	 <!-- currencySymbol : 통화기호 문자의 종류를 지정하는 속성 -->
	 
	 
	 <hr>
	 
	 <h3>2. formatDate 태그</h3>
	 
	 <p>
	 	날짜 및 시간 데이터의 포맷(형식)을 지정<br>
	 	
	 	단, java.util.Date클래스 객체를 이용해야만 한다.<br>
	 </p>
	 
	 <c:set var="current" value="<%= new java.util.Date() %>" />
	 
	 그냥출력 : ${ current } <br>
	 
	 <ul>
	 	<li>
	 		현재 날짜 : <fmt:formatDate value="${ current }"/>
	 		<!-- type속성은 생략 가능, 생략 시 기본값은 type="date" -->
	 	</li>
	 	<li>
	 		현재 시간 : <fmt:formatDate value="${ current }" type="time"/>
	 		<!-- type="time" : 시간을 출력하겠다 -->
	 	
	 	</li>
	 	<li>
	 		현재 날짜 및 시간 : <fmt:formatDate value="${ current }" type="both"/>
	 		<!-- type="both" : 날짜와 시간 둘 다 출력하겠다. -->
	 	
	 	</li>
	 	<li>
	 		medium : <fmt:formatDate value="${ current }" type="both" dateStyle="medium" timeStyle="medium"/>
	 		<!-- dateStyle, timeStyle이 "medium"일 경우 : 기본설정, 기본길이형식 -->
	 	
	 	</li>
	 	<li>
	 		long  : <fmt:formatDate value="${ current }" type="both" dateStyle="long" timeStyle="long"/>
	 	
	 	</li>
	 	<li>
	 		full  : <fmt:formatDate value="${ current }" type="both" dateStyle="full" timeStyle="full"/>
	 	
	 	</li>
	 	<li>
	 		short  : <fmt:formatDate value="${ current }" type="both" dateStyle="short" timeStyle="short"/>
	 	
	 	</li>
	 	<li>
	 		customizing : <fmt:formatDate value="${ current }" type="both" pattern="yyyy-MM-dd(E) a:HH:mm:ss"/>
	 	
	 	</li>
	 	
	 </ul>
</body>
</html>