<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
    <title>Document</title>
    <style>
    div{
        box-sizing : border-box;
    }
    #admin_side{
       width: 100%;
       background: lightgrey;
       /* height: 900px; */
    }
        #admin_sidebar a{
        color: black;
        text-decoration: none;
    }
    #admin_side{
        padding-top: 30px;
        padding-bottom:100px
        
    }
    #admin_side h3{
        font-weight:bold;        
    }
   
    </style>
</head>
<body>


    <div id="admin_side">
        <ul><h3><a href="">게시판 관리</a></h3>
<%--             <li><a href="<%= request.getContextPath() %>/category.ad">카테고리관리</a></li>       삭제      --%>
            <li><a href="<%= request.getContextPath() %>/">회원글관리</a></li>            
            <li><a href="<%= request.getContextPath() %>/editorList.ad">금주의 에디터픽</a></li>
            <li><a href="<%= request.getContextPath() %>/ugree.ad">이용약관</a></li>
            
        </ul>
        <br>
        <ul><h3><a href="">회원현황</a></h3>
            <li><a href="<%= request.getContextPath() %>/userList.ad?currentPage=1">회원관리</a></li>
        </ul>
        <br>
        <br>
        <ul><h3><a href="">문의관리</a></h3>
            <li><a href="<%= request.getContextPath() %>/inquiryList.ad?currentPage=1">1:1상담관리</a></li>
            <li><a href="<%= request.getContextPath() %>/noticeList.ad?currentPage=1">공지사항 관리</a></li>
            <li><a href="<%= request.getContextPath() %>/requestList.ad">요청게시판 관리</a></li>
        </ul>
        <br>
        <ul><h3><a href="">도서관리</a></h3>
            <li><a href="<%= request.getContextPath() %>/bookList.ad">책관리</a></li>
        </ul>
        
    </div>
    <!-- 여기까지 삭제하기~~ -->
</body>
</html>