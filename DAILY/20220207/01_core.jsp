<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL Core Library</h1>
	
	<h3>1. 변수(속성==attribute)</h3>
	
	<pre>
		* 변수 선언 &lt; c:set var="변수명" value="리터럴" scope="스코프영역지정(생략가능)"/ &gt;
		- 변수를 선언하고 초기값을 대입해두는 기능을 제공
		- 더 나아가서 해당 변수를 어떤 scope 영역에 담아둘건지 지정 가능함
		(단, scope 속성을 생략 시 pageScope에 담김)
		=> 즉, 해당 scope 영역에 setAttribute라는 메소드를 이용해서ㅐ
		key + value 형태로 데이터를 담아둔다라고 생각하면 된다.
		=> c:set을 통해 선언된 변수는 EL로 접근해서 사용가능
		(단, 스크립팅 원소로는 접근 불가능)
		
		* 주의사항
		- 변수의 타입을 별도로 지정하지 않음
		- 반드시 해당 변수의 담아두고자 하는 값(value 속성에 담는 리터럴)을 무조건 셋팅해야 함
		(즉, 선언과 동시에 초기화)
		
		
	</pre>
	
	<c:set var="num1" value="10" /> <!-- pageScope에 담김 pageContext.setAttribute("num1", "10"); -->
	<c:set var="num2" value="20" scope="request"/> <!-- requestScope에 담김 request.setAttribute("num2", "20"); -->
	
	
	num1 변수값 : ${ num1 }<br> 
	num2 변수값 : ${ num2 }<br>
	
	<c:set var="result" value="${ num1 + num2 }" scope="session" /> <!-- sessionScope에 담김 -->
	
	result 변수값 : ${ result } <br>
	
	
	<!-- 
		변수명만 제시하면 공유 범위가 작은 곳에서부터 찾아지게 됨
		: 티가 나지는 않지만 속도가 좀 느려질 수 는 있다.(스코프영역.변수명을 권장)
	
	 -->
	 
	 
	 ${ pageScope.num1 } <br>
	 ${ requestScope.num2 }<br>
	 ${ sessionScope.result }<br><br>
	 requestScope에서 result라는 변수명을 제시하면? : ${ requestScope.result } <br><br>
	 
	 <c:set var="result" scope="request">9999</c:set>
	 <!-- value 속성 말고 시작태그와 종료태그 사이에도 대입할 값을 기술 가능 -->
	 
	 ${ requestScope.result } <br>
	 ${ sessionScope.result } <br>
	 
	 
	 <hr>
	 
	 
	 <pre>
	 	* 변수 삭제 &lt; c:remove var="제거하고자하는변수명" scope="스코프영역지정가능(생략가능)"/ &gt;
	 	- 해당 변수를 scope에서 찾아서 제거하는 태그
	 	- scope지정 생략 시 모든 scope에서 해당 변수를 다 찾아서 제거함
	 	
	 	=> 즉 해당 scope에 .removeAttribute("키값"); 메소드를 이용해서 제거하는거라고 생각하면 된다.
	 	
	 	
	 
	 </pre>
	 
	 
	 삭제 전 result : ${ result } <br>
	 
	 1) 특정 scope를 지정해서 삭제<br>
	 <c:remove var="result" scope="request" />
	 request에서 삭제 후 result : ${ result } <br>
	 
	 2) 모든 scope에서 삭제 <br>
	 <c:remove var="result"/>
	 모든 scope에서 삭제 후 result: ${ result } <br>
	 
	 <hr>
	 
	 <pre>
	 	* 변수 출력 &lt; c:out value="출력하고자하는값" default="기본값(생략가능)" escapeXml="true(기본값, 생략가능)/false" / &gt;
	 	- 데이터를 출력하고자 할 때 사용하는 태그
	 	- default : 기본값, value속성에 출력하고자 하는 값이 없을 경우 대체해서 기본값으로 출력할 내용물을 기술(생략가능)
	 	- escapeXml : 태그로서 해석할지 출력할지 여부(생략가능, 생략 시 true가 기본값)
	 
	 </pre>
	 
	 result를 EL로 출력 : ${ result } <br>
	 result를 c:out으로 출력 : <c:out value="${result}" /> <br>
	 result를 c:out으로 출력할건데 default를 지정해서 출력 : <c:out value="${ result }" default="값이 없음" /><br><br>
	 
	 
	 <!-- escapeXml 테스트 -->
	 <!-- 테스트하기위한 변수 선언 -->
	 <c:set var="outTest" value="<b>출력테스트</b>" />
	 
	 
	 outTest를 c:out으로 출력할건데 escapeXml 속성을 생략하고 출력 (true) : <c:out value="${ outTest }"/><br>
	 outTest를 c:out으로 출력할건데 escapeXml 속성을 false로 지정하고 출력 (true) : <c:out value="${ outTest }" escapeXml="false"/><br>
	 <!-- escapeXml생략 시 기본값이 true이고, html태그가 해석 안됨(단순한 문자열로 취급) -->
	 
	 <hr>
	 
	 
	 <h3>2. 조건문 - if &lt; c:if test="조건식" &gt; 조건이 true일 때 실행할 코드 &lt;/c:if&gt;</h3>
	 
	 <pre>
	 	-JAVA의 단일 if문과 비슷한 역할을 하는 태그
	 	- 조건식은 test라는 속성에 작성(*** 조건을 작성하는 경우 반드시 EL구문으로 작성해야 함 ***)
	 </pre>
	 
	 
	 <%-- 기존방식
	 	<% if(조건식) { %>
	 		어쩌구저쩌구
	 	<% } %>
	 
	  --%>
	 
	 <c:if test="${ num1 gt num2 }">
	 	<b>num1이 num2보다 크다</b>
	 
	 </c:if>
	 
	 <c:if test="${ num1 le num2 }">
	 	<b>num1이 num2보다 작거나 같다</b>
	 </c:if>
	 
	 <br>
	 
	 str이라는 이름의 변수 안에 "안녕하세요"를 할당하시오
	<c:set var="str" value="안녕하세요" />
	
	<c:if test="${ str eq '안녕하세요'}">
		<mark>Hello World</mark>
	</c:if>
	
	<c:if test="${ str ne '안녕하세요' }">
		<mark>Goodbye World~</mark>
	</c:if>
	
	<br>
	
	<h3>3. 조건문 - choose, when, otherwise</h3>
	
	<pre>
		[ 표현법 ]
		&lt;c:choose &gt;
			&lt;c:when test="조건1"&gt; ~~~~~&lt;/c:when &gt;
			&lt;c:when test="조건2"&gt; ~~~~~&lt;/c:when &gt;
			...
			&lt;c:otherwise &gt;~~~&lt; /c:otherwise &gt; => else블럭에 해당 // switch의  default에 해당
		&lt;/c:choose &gt;
		
		- JAVA의 if-else, switch문과 비슷한 역할을 하는 태그
		- 각 조건들은 c:choose의 하위요소로 c:when을 통해서 작성
		- c:otherwise에는 조건을 적어주지 않음
	
	</pre>
	

<!-- c:choose 안에 주석 넣으면 에러남 c:when에 넣어야함 -->	
	<c:choose>
		<c:when test="${ num1 eq 20 }"> <!-- if블럭 -->
			<b>처음뵙겠습니다.</b>
		</c:when>
		<c:when test="${ num1 eq 10 }">
			<b>또뵙네요</b>
		</c:when>
		<c:otherwise><!-- else 블럭 -->
			<b>잘가시고</b>
		</c:otherwise>
	</c:choose>
		<!-- if문 대용으로 사용 가능 -->
		
		
	<hr>
	
	<h3>4. 반복문 - forEach</h3>
	
	<pre>
		[표현법 ]
		for loop문
		&lt;c:forEach var="변수명" begin="초기값" end="끝값" step="증가시킬값(생략가능)"&gt;
			반복적으로 실행할 코드
		&lt;/c:forEach&gt;
		=> step 생략 시 기본값은 1
		
		향상된 for문
		&lt;c:forEach var="변수명" items="순차적으로접근할 배열명 또는 컬렉션명"&gt;	
			반복적으로 실행할 코드
		&lt;/c:forEach&gt;
		
		** var 속성으로 선언된 변수는 접근하고자 할 때 EL구문으로 접근
		
	
	</pre>
	
	<c:forEach var="i" begin="1" end="10">
		반복확인 : ${ i } <br>
	</c:forEach>
	
	<br>
	
	<%-- <% for(int i = 1; i <= 10; i += 2) { %>
		어쩌저쩌
	<%} %>
	
	 --%>
	 
	 
	 
	 <c:forEach var="i" begin="1" end="10" step="2">
	 	반복확인 : ${ i } <br>
	 </c:forEach>
	 
	 <br>
	 
	 
	 <c:forEach var="i" begin="1" end="6">
	 	<h${ i }>태그 안에서도 적용이 가능하다</h${i }>
	 </c:forEach>
	 
	 <br>
	 
	 <!-- 향상된 for문 -->
	 <!-- 테스트를 위한 배열 만들기 -->
	 
	 <c:set var="colors">
	 	red, blue, pink, yellow, green, navy, purple, orange
	 </c:set>
	 <!-- 배열과 같은 역할 -->
	 
	 
	 colors 값 : ${ colors }<br>
	 
	 <ul>
	 	<c:forEach var="c" items="${ colors }">
	 		<li style="color:${ c };">${ c }</li>
	 	</c:forEach>
	 
	 
	 </ul>
	 
	 <!-- ==================================================================================== -->
	 <%@page import="java.util.ArrayList, com.kh.model.vo.Person" %>
	 <%
	 	ArrayList<Person> list = new ArrayList<>();
	 
	 	list.add(new Person("김김김", 20, "여자"));
	 	list.add(new Person("김김이", 10, "여자"));
	 	list.add(new Person("김김박", 100, "여자"));
	 
	 %>
	 
	 <c:set var="pList" value="<%= list %>" scope="request"/>
	 
	 
	 <table border="1">
	 	<thead>
	 		<th></th>
	 		<th>이름</th>
	 		<th>나이</th>
	 		<th>성별</th>
	 	</thead>
	 	<tbody>
			<c:choose>
				<c:when test="${ empty pList }">
					<tr align="center">
						<td colspan="3">조회결과가없습니다</td>
					</tr>
				</c:when>
				<c:otherwise>
																		<!-- var p의 상태속성을 어디에담아둘것인가 -->
					<c:forEach var="p" items="${ requestScope.pList }" varStatus="status">
						<tr align="center">
							<td>${ status.count }</td> <!-- index:0부터 // count : 1부터 -->
							<td>${ p.name }</td>
							<td>${ p.age }</td>
							<td>${ p.gender }</td>
						</tr>
					</c:forEach>
				</c:otherwise>			
			</c:choose>



	 	</tbody>
	 </table>
	 
	 <hr>
	 
	 <h3>5. 반복문 - forTokens</h3>
	 
	 <pre>
	 	[표현법]
	 	&lt; c:forTokens var="각값을보관할변수명" items="분리시키고자하는문자열" delims="구분자" &gt;
	 	
	 	&lt; /c:forTokens &gt;
	 	
	 	- 구분자를 통해서 분리된 각각의 문자열에 순차적으로 접근하면서 반복 수행
	 	- JAVA의 split('구분자') 또는 StringTokenizer와 비슷한 역할
	 </pre>
	 
	 <br>
	 
	 <!-- 테스트할 문자열 변수 만들기 -->
	 <c:set var="device" value="TV, 컴퓨터. 휴대폰, 에어컨/냉장고. 세탁기" />
	 
	 <ul>
	 	<c:forTokens var="d" items="${ device }" delims=",./">
	 		<li>${ d }</li>
	 	</c:forTokens>
	 	
	 </ul>
	 
	 <hr>
	 
	 <h3>6. 쿼리스트링 관련 태그 - url, param</h3>
	 
	 <pre>
	 	[ 표현법 ]
	 	&lt; c:url var="변수명" value="요청할url" &gt;
	 		&lt; c:param name="키값" value="밸류값" / &gt;
	 		&lt; c:param name="키값" value="밸류값" / &gt;
			...
		&lt; /c:url &gt;
		
		- url 경로를 생성하고, 쿼리스트링을 정의할 수 있는 태그
		- 넘겨야 할 쿼리스트링이 길 경우 사용하면 편하다	 		
	 
	 </pre>
	 
	 <a href="list.do?cPage=1&num=2&bWriter=3">기존방식으로 요청</a>
	 
	 <!-- c:url을 이용 -->
	 
	 <c:url var="query" value="list.do">
	 	<c:param name="cpage" value="1"/>
	 	<c:param name="num" value="2"/>
	 	<c:param name="bWriter" value="3"/>
	 </c:url>
	 <!-- 만들어진 요청을 보낼 때 -->
	 <a href="${ query }">c:url방식으로 요청</a>
	 	
	 
	 
	 
	 
</body>
</html>