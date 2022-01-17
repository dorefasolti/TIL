<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member" %>
<%
	String contextPath = request.getContextPath();
	Member loginUser = (Member)session.getAttribute("loginUser");

	String alertMsg = (String)session.getAttribute("alertMsg");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
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
	
	var msg = "<%= alertMsg %>";
	
	if(msg != "null"){
		alert(msg);
		<% session.removeAttribute("alertMsg");%>
	}
	
	
	</script>
	
	<h1 align="center">마이퍼스트웹</h1>
    <div class="login-area">
        <% if(loginUser == null) { %>
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
                        location.href="<%= contextPath %>/views/member/memberEnrollForm.jsp";
                        location.href="<%=contextPath%>/enrollForm.me"
                    }
                </script>

        <% } else { %>
            <div id="user-info">
                <b><%= loginUser.getUserName()%> 님 </b> 환영합니다. <br><br>
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