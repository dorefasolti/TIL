<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <style>
        #myPage_sideBar{
            width: 100%;
            height: auto;
            /*padding : 0px 50px 50px 50px;*/
        }
        #myPage{
            font-size: 25px;
        }  
        #myPage-area{
            background-color: rgb(212, 212, 212);
            width:100%;
            height:100%;
            /*padding: 20px;*/
        }
        #myPage_sideBar a{
            text-decoration: none;
            color: black;
        }
    </style>
<title>Insert title here</title>
</head>
<body>
    <div id="myPage_sideBar">
        <div id="myPage-area" style="padding: 20px 20px;">
            <p id="myPage" style="margin: 0;"> 마이페이지<hr style="margin: 10px 0;"></p>
            <div id="myPage_sideBar_info">
                회원정보
                <ul>
                    <li><a href="<%= request.getContextPath() %>/profile.me">회원 정보 수정</a></li>
                    <li><a href="<%= request.getContextPath() %>/withdrawForm.me">회원 탈퇴</a></li>
                </ul>
            </div>
            <div id="myPage_sideBar_act">
                활동내역
                <ul>
                    <li><a href="<%= request.getContextPath() %>/recentList.me">최근 본 책</a></li>
                    <li><a href="<%= request.getContextPath() %>/myBookList.me">마이리스트</a></li>
                    <li><a href="<%= request.getContextPath() %>/reviewList.me">작성한 리뷰</a></li>
                    <li><a href="<%= request.getContextPath() %>/static.me">독서 통계</a></li>
                    <li><a href="<%= request.getContextPath() %>/fleaList.me">중고 장터</a></li>
                </ul>
            </div>
            <div id="myPage_sideBar_center">
                고객센터
                <ul>
                    <li><a href="<%= request.getContextPath() %>/inquiryList.me">1:1 문의 내역</a></li>
                    <li><a href="<%= request.getContextPath() %>/requestList.me">도서 요청 내역</a></li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>