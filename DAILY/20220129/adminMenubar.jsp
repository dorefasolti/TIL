<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.readme.admin.model.vo.Member" %>
<%
	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <!-- ☆☆☆☆없으면 안돌아감 필수☆☆☆☆☆ -->
    <!-- 부트스트랩 사용 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    
    <title>관리자페이지</title>
    <style>
	   #admin_header_content{
	        height: 150px;
	        width: 100%;
	        background: lightgrey;
	    
	    }
	  #admin_header_Lt,  #admin_header_Rt{
	        height: 100%;
	        display:inline-block;
	        width: fit-content;
	        float: left;
	        
	    }
	    #admin_header_Lt{
	        width: 15%;
	        text-align: center;
	        line-height: 130px;
	        font-size: 40px;
	    }
	    #admin_header_Rt{
	        width: 85%;
	        display: flex;
	
	    }
	    #admin_header_Rt>div{
	        text-align: center;
	        line-height: 130px;
	        padding: 10px;
	        margin-left: 20px;
	        margin-right: 10px;
	    }
	    #admin_header a{
	        color: black;
	        text-decoration: none;
	    }   
    </style>
</head>
<body>
	<script>
		var msg = "<%= alertMsg %>";
		
		if(msg!="null"){
			alert(msg);
			
			<% session.removeAttribute("alertMsg"); %>
		}
	</script>
    <div id="admin_header_content">

        <div id="admin_header_Lt" class="float-left">
            <a href="<%= contextPath %>/myPage.ad">Home</a>
        </div>

        <div id="admin_header_Rt">

            <div><a href="">관리자</a></div>
            <div><a href="<%= contextPath %>/logout.me">로그아웃</a></div>
            <div><a href="<%= contextPath %>">홈페이지</a></div>
        </div>
                
    </div>
</body>
</html>