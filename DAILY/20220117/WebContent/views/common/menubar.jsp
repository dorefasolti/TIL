<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member" %>
<%

	String contextPath = request.getContextPath();

	Member loginUser = (Member)session.getAttribute("loginUser"); // : Object
	// 로그인 전 : menubar.jsp가 로딩될 때 null
	// 로그인 후 : manubar.jsp가 로딩될 때 로그인한 회원의 정보가 담겨있음

	String alertMsg = (String)session.getAttribute("alertMsg"); // : Object
	// 서비스 요청 전 : alertMsg = null
	// 서비스 요청 후 성공 시 : alertMsg = 메시지문구
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style>
    .login-area, #user-info {float:right;}
    h1 {color : rgb(130, 179, 243)}
    .nav-area{background-color: skyblue;}
    .menu{
        display: table-cell; /* 인라인 요소처럼 배치 가능 */
        height : 50px;
        width : 150px;
    }
    .menu a{
        text-decoration: none;
        color: white;
        font-size:20px;
        font-weight: bold;
        display: block;
        width : 100%;
        height: 100%;
        line-height: 50px;
    }
    .menu a:hover {background-color: rgb(99, 197, 236);}

    th, td{
        padding-top: 10px;
        padding-bottom: 10px;
    }

</style>
</head>
<body>
<script>
		
		// script태그 내에서도 스크립틀릿과 같은 jsp요소를 쓸 수 있다.
	
		var msg = "<%= alertMsg %>"; 
		// "메시지 문구" / "null"
		
		if(msg != "null"){ // 즉, 성공 / 경고 메시지 문구가 담겨있을 경우
			alert(msg);
		
			// menubar.jsp가 로딩 될때마다 매 번 alert가 떠버림
			// session에 들어있는 alertMsg키값에 대한 밸류를 지워주면됨
			// => XX.removeAttribute("키값")
			<% session.removeAttribute("alertMsg"); %>
			
		}
	</script>

	<h1 align="center">★☆My First Web☆★</h1>

    <div class="login-area">
    
    <% if(loginUser == null) { %>
    	<!-- 로그인 전에 보여지는 로그인 form -->
        <form action="<%= contextPath %>/login.me" method="post">
            <table>
                <tr>
                    <th>아이디 </th>
                    <td><input type="text" name="userId" required></td>
                </tr>
                <tr>
                    <th>비밀번호 </th>
                    <td><input type="password" name="userPwd" required></td>
                </tr>
                <tr>
                    <th colspan="2">
                        <button type="submit" class="btn btn-sm btn-primary">로그인</button>
                        <button type="button" class="btn btn-sm btn-secondary" onclick="enrollPage();">회원가입</button>
                    </th>
                </tr>
            </table>
        </form>
        
        <script>
        	function enrollPage(){
        		
        		// 페이지이동
        		// location.href = "<%= contextPath %>/views/member/memberEnrollForm.jsp";
        		// 웹 어플리케이션의 디렉토리 구조가 url에 노출된다 => 취약점이 생김
        		// localhost:8001/jsp/views/member/memberEnrollForm.jsp
        		
        		// 단순한 정적인 페이지 요청이라고 하더라도 Servlet을 거쳐서 화면을 띄워주자!!!!!!
        		// => url에 서블릿 매핑값만 노출되겠지???
        		// localhost:8001/jsp/매핑값
        		location.href = "<%= contextPath %>/enrollForm.me"
        	}
        </script>

		<% } else { %>
		
        <div id="user-info">
            <b><%= loginUser.getUserName() %> 님</b> 환영합니다. <br><br>
            <div>
                <a href="<%= contextPath %>/myPage.me">마이페이지</a>
                <a href="<%= contextPath %>/logout.me">로그아웃</a>
            </div>
        </div>
        <% } %>

    </div>

    <br clear="both">
    <br>

    <div class="nav-area" align="center">
        <div class="menu"><a href="<%= contextPath %>">HOME</a></div>
        <div class="menu"><a href="<%= contextPath %>/list.no">공지사항</a></div>
        <div class="menu"><a href="<%= contextPath %>/list.bo?currentPage=1">일반게시판</a></div>
        <div class="menu"><a href="<%= contextPath %>/list.th">사진게시판</a></div>
    </div>

</body>
</html>