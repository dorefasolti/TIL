<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member" %>
<%

	String contextPath = request.getContextPath();
	Member loginUser = (Member)session.getAttribute("loginUser"); //반환형이 object
	//로그인 전 : menubar.jsp가 로딩될 떄 null
	//로그인 후 : menubar.jsp가 로딩될 때 로그인한 회원의 정보가 담겨있음
	
	String alertMsg = (String)session.getAttribute("alertMsg");
	//서비스 요청 전 : alertMsg = null
	//서비스 요청 후 성공 시 : alertMsg = 메시지문구

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
    .login-area, #user-info{float:right;}
    h1{color:yellowgreen;}
    .nav-area{background-color: skyblue;}
    .menu{
        display:table-cell; 
        /* 인라인요소처럼 배치 가능 */
        height: 50px;
        width: 150px;
    }
    .menu a{
        text-decoration: none;
        color:white;
        font-size: 20px;
        font-weight: bold;
        display: block;
        width : 100%;
        height: 100%;
        line-height: 50px;
    }
    .menu a:hover {background-color: orangered;}
</style>
</head>
<body>

	<script>
	// script태그 내에서도 스크립틀릿과 같은 jsp 요소를 쓸 수 있다
		var msg = "<%= alertMsg%>"; 
		// "메시지문구" / "null" 
		
		if(msg != "null"){ //즉, 성공 / 경고 메시지 문구가 담겨있을 경우
			alert(msg);
		// menubar.jsp가 로딩 될 때마다 매 번 alert가 떠버림
		// session에 들어있는 alertMsg 키값에 대한 밸류를 지워주면 됨
		// => XX.removeAttribute("키값")
		<% session.removeAttribute("alertMsg"); %> 
		
		}
	</script>

	<h1 align="center">마이퍼스트웹</h1>
    <div class="login-area">
    <% if(loginUser == null) {%>
    	<!-- 로그인 전에 보여지는 로그인 form -->
        <form action="<%=contextPath %>/login.me" method="POST">
            <table>
                <tr>
                    <th>아이디</th>
                    <td><input type="text" name="userId" required></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="userPwd" required></td>
                </tr>
                <tr>
                    <th colspan="2">
                        <button type="submit">로그인</button>
                        <button type="button" onclick="enrollPage();">회원가입</button>
                    </th>
                </tr>

            </table>

        </form>
        
        <script>
        	function enrollPage(){
        		//역할 : 페이지 이동
        		//location.href = "<%= contextPath %>/views/member/memberEnrollForm.jsp" 
        		//웹 어플리케이션의 디렉토리 구조가 url에 노출된다 => 취약점이 생김
        		//이렇게 쓰면 주소창에 주소 자체가 노출되어버림
        		//직링따는것처럼 좃댈수가잇다...공격당할수잇다..sql인젝션가튼거생기나..
        		//localhost:8001/jsp/views/member/memberEnrollForm.jsp
        		
        		//단순한 정적인 페이지 요청이라고 하더라도 Servlet을 거쳐서 화면을 띄워주자!!!
        		//=> url에 서블릿 매핑값만 노출되겠지?
        		// localhost:8001/jsp/매핑값
        		location.href = "<%= contextPath %>/enrollForm.me"
        		
        	}
        
        </script>
        
        
        
        <% } else { %>
       <div id="user-info">
            <b><%= loginUser.getUserName() %> 님</b>환영합니다.<br><br>
            <div>							
                <a href="<%=contextPath %>/myPage.me">마이페이지</a>
                <a href="<%=contextPath %>/logout.me">로그아웃</a>
            </div>
        </div>
		<% } %>
    
    </div>
    <br clear="both">
    <br>




    <div class="nav-area" align="center">
        <div class="menu"><a href="">HOME</a></div>
        <div class="menu"><a href="">공지사항</a></div>
        <div class="menu"><a href="">일반게시판</a></div>
        <div class="menu"><a href="">사진게시판</a></div>
    </div>
</body>
</html>