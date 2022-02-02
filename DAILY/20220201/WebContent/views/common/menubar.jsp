<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.readme.member.model.vo.Member" %>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	String alertMsg = (String)session.getAttribute("alertMsg");
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- slick slider 사용 -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <!-- ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ -->


<title>메뉴바</title>
<style>
    div{
        box-sizing: border-box;
        /*border: 1px solid red;*/
    }
    .outer{
        text-align: center;
        /*전체를 감싸는 div*/
    }

    #header{
        width: 100%;
        height: 155px;
        display: inline-block;
        padding:0;
        margin-bottom: -7px;
    }
    #header>div{
        /* display: inline-block; */
        height: 100%;
        float: left;

    }
    #header_1{
        width: 25%;
        margin: 0px;
        padding-top: 45px;
        padding-left: 58px;
    
    }
    #header_2{
        width: 50%;
        padding-top: 45px;
        padding-right: 20px;
        padding-left: 20px;
    }
    #header_3{
        width: 25%;
        padding-top: 20px;
        padding-left: 40px;
    }


    #header_1 a{
        text-decoration: none;
        color :rgb(255, 255, 255);
    
    }
    #header_1_README{
        font-size: 27px;
        font-weight:900;
    }
    #header_1_read{
        font-size: 20px;
        font-weight:700;
    }


    .login-btn{
        height: 40px;
        width: 90px;
        font-size: 14px;
        line-height: 2.4em;
        border-radius: 4px;
        border-width: 1px;
        border-style: solid;
        border-color: rgb(255, 255, 255);
        font-weight: 800;
    }
    #login_btn{
        color: rgb(255, 255, 255);
        background-color: rgb(120, 150, 50);
        height: 40px;
        width: 90px;
    }
    #join_btn{
        color: rgb(120, 150, 50);
        background-color: rgb(255, 255, 255);
        height: 40px;
        width: 90px;

    }
    .login-area{
        margin: 0px auto;
    }
    .wrap{
        background-color: rgb(120, 150, 50);
    }
    #navigator{
        width: 100%;
        height : 60px;
        background-color: rgb(120,150,50);
        display: inline-block;
        padding-left: 320px;
        
    }
    #navi{
        list-style: none;
        margin: 0px; /* ul요소는 기본적으로 위 아래로 margin이 있다*/ 
        padding: 0px; /* 심지어 padding도 있다*/
        height:100%;
        
        
    }
    #navi>li{
        float:left;
        width : 12%;
        text-align: center;
        height : 100%;
        margin-top: 0px;
        
        
    }
    #navi a{
        text-decoration: none;
        color: white;
        font-weight: 800;
        width: 100%;
        height: 100%; /* a태그는 인라인요소기 때문에 width, height 속성이 적용X*/
        display : block; /* 인라인 요소를 블럭요소로 바꿔줌 */
        /* vertical-align : middle;*/ /* vertical-align : middle은 블럭요소에서 죽었다께나도 X*/
        line-height : 60px; /* 줄간격 속성 px/ % / em*/
        transform: scale(1); 
    }
    #navi li:hover{
        font-size: 19px;
        font-weight: 900;
        color: white;
        background-color: rgb(62,76,28);
        
        
    }

    #navi>li>ul{
        list-style-type : none;

        padding: 0px;
        display: none; /* 평소에는 안보여지다가 마우스가 올라가는 순간 펼쳐지는 효과 1단계*/
        
    }
    #navi>li>a:hover+ul{
        display:block; /* 평소에는 안보여지다가 마우스가 올라가는 순간 펼쳐지는 효과 2단계*/
    }
    #navi>li>ul:hover{
        display:block; /* 평소에는 안보여지다가 마우스가 올라가는 순간 펼쳐지는 효과 3단계*/
    }
    #navi>li>ul a{font-size : 13px; background-color: rgb(62, 76, 28);}
    #navi>li>ul a:hover{font-size : 14px; background-color: rgb(62, 76, 28);}

    #user-info{
        border-radius : 10px;
        border : 2px solid white;

        padding-top:10px;
        color:white;
        font-size:19px;
        margin-top: -10px;
    }
    #user-info b{
        color : rgb(62, 76, 28);
        font-size : 25px;
    }
    #user-info a{
        text-decoration:none;
        color : rgba(255, 255, 255, 0.911);
        font-size : 18px;
        padding-right: 30px;
        padding-left: 35px;
    
    }
    #user-info a:hover{
        text-decoration:none;
        color : rgb(62, 76, 28);
        font-size : 18px;
        
    }
    #user-info div{
    border-radius : 10px;
        border : 1px solid white;
        margin-top: 10px;
    }
    #user-info-event{
        height: 50px;
        border-radius : 10px;
        border : 2px solid white;
        padding-top: 10px;
    }
    #user-info-event a{
        font-size: 19px;
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
    <div class="outer">
    <div id="header" class="wrap">
        <div id="header_1">
            <a href="<%= contextPath %>" id="header_1_README">README|</a>
            <a href="<%= contextPath %>" id="header_1_read">나를 read해조</a>
        </div>
        
        <div id="header_2" align="left">
            <form action="<%= contextPath %>/search.bo">
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">🔍</span>
                    </div>
                    <input type="text" class="form-control" placeholder="제목, 저자, 출판사 검색">
                    <input type="submit" value="" style="display: none;">
            </div>
        </form>
        </div>
        
        <div id="header_3"  align="center">
            <% if(loginUser == null) { %>
                <div class="login-area">
                    <button type="button" id="login_btn" class="login-btn" onclick="enrollPage();">회원가입</button>
                    <button type="button" id="join_btn" class="login-btn" onclick="login();">로그인</button>
                </div>
            <% } else { %>
                
                <div id="user-info">
                    <b><%= loginUser.getUserName() %></b> 님 환영합니다.
                    <div>
                    <% if(loginUser.getUserNo() == 1) { %>
                        <a href="<%= contextPath %>/myPage.ad">관리자페이지 </a>|
                    <% } else { %>
                        <a href="<%= contextPath %>/myPage.me">마이페이지 </a>|
                    <% } %>
                        <a href="<%= contextPath %>/logout.me"> 로그아웃</a>
                    </div>
                </div>
                <div id="user-info-event">
                    <a href="<%= contextPath %>/present.me">🎊포인트  <b><!-- + 적립금값! + --> 50000</b> 쓰고 선물 받자!!🎊 </a>
                </div>
            <% } %>
        </div>
    </div>
    
    <script>
    	function login(){
    		// 로그인페이지로 이동
    		location.href="<%= contextPath %>/loginForm.me";
    	}
    	function enrollPage(){
    		// 회원가입 페이지로 이동 => get방식
    		location.href="<%= contextPath %>/enrollForm.me";
    	}
    </script>

<div id ="navigator">
    <ul id = "navi">
        <li>
            <a href="<%= contextPath %>">🏠︎ 홈</a></li>
        <li><a href="<%= contextPath %>/list.ev">🎊 이벤트</a></li>
        <li>
            <a href="<%= contextPath %>/original.be">👍︎ 베스트셀러</a>
        <ul>
            <li><a href="<%= contextPath %>/original.be">오리지널</a></li>
            <li><a href="<%= contextPath %>/userPick.be">유저선정</a></li>
            <li><a href="<%= contextPath %>/editorPick.be">금주의에디터픽</a></li>
            <li><a href="<%= contextPath %>/userVote.be?currentPage=1">투표</a></li>
        </ul>
    </li>

    <li>
        <a href="<%= contextPath %>/listCategory.bo?gno=1">📚 장르별</a>
    </li>

    <li>
        <a href="<%= contextPath %>/sellBook.fl?currentPage=1">🛒 중고장터</a>
        <ul>
            <li><a href="<%= contextPath %>/sellBook.fl?currentPage=1">중고책판매</a></li>
            <li><a href="<%= contextPath %>/buyBook.fl?currentPage=1">중고책구매</a></li>
        </ul>
    </li>
    <li>
        <a href="<%= contextPath %>/faq.cs">🎧︎ 고객센터</a>
        <ul>
            <li><a href="<%= contextPath %>/faq.cs">FAQ</a></li>
            <li><a href="<%= contextPath %>/noticeList.cs?currentPage=1">공지사항</a></li>
            <li><a href="<%= contextPath %>/inquiry.cs">1:1상담문의</a></li>
            <li><a href="<%= contextPath %>/request.cs">요청게시판</a></li>
        </ul>
    </li>
    
    </ul>

</div>
<!-- 여기까지가 메뉴바 끝! -->
<!-- 여기서부터 메인페이지나 다른 화면들 추가-->


</div>



</body>
</html>