<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
     <!-- ☆☆☆☆없으면 안돌아감 필수☆☆☆☆☆ -->
    <!-- 부트스트랩 사용 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <title>회원탈퇴성공</title>
    <style>
        body { margin: 0;}
        div{
        
        box-sizing : border-box;
	    }
	    .wrap{
	        min-width: 1190px;
	    }
	    .wrap>div{width:100%;}
	
	    #content{
	        width: 1300px;
	        padding: 20px 30px;
	        margin: 0 auto;
	        
	    }
	
	    #content_1{
	        width: 17%;
	        
	       float: left;
	    }
	    #content_2{
	        width: 82%;
	        clear: both;
	    }
	    #content_1, #content_2{
	        display: inline-block;
	        height: 1000px;
	        /* display: flex; */
	    }
	    #content_3{
	        height: 70px;
	        width: 99%;
	    
	    }
	
	
	
		#myPage_withdraw_content{
            margin-top: 100px;
        }
        #withdraw_success_text{
            line-height: 30px;
            text-align: center;
            height: 350px;
            border:1px solid black;
            width: 800px;
            margin-left: auto;
            margin-right: auto;
        }
        #myPage_withdraw_btn{
           
            text-align: center;
            /* 버튼 가운데정렬 */
            
        }
        #myPage_withdraw_btn> button{
            background-color: rgb(120, 150, 50);
            color: white;
            width: 200px;
            height: 40px;
            margin: 20px;
            /* display: inline-block; */
            border-style: solid;
            border-color: rgb(120, 150, 50);
        }
        #myPage_withdraw_btn a{
        	text-decoration : none;
        	color : white;
        }
    
    </style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
        
        <div id="content">
            <div id="content_3">
			     <div id="pageCategory_bar">
			        <a href="">🏠︎ HOME </a> > 마이페이지 > 회원탈퇴
			    </div>
            		<%-- <%@ include file="../common/side_test1.jsp" %> --%>
            </div>
            <div id="content_1">
            	<%@ include file="../common/myPageSidebar.jsp" %>
            </div>
            <div id="content_2">    
            	 <div id="wrap_myPage_withdraw_success" style="height: 1000px; width:100%;">
                    <h2 style="margin-left: 30px;">회원 탈퇴</h1>
                    <hr>
                    
                    <div id="myPage_withdraw_success_content">
                        <form action="test.no" method="post">

                            <div id="withdraw_success_text">
                                
                                <br>
                                항상 고객님의 손과 발이 되어 최상의 서비스를 제공하도록 노력하겠습니다. <br>
                                불편했던 부분이나 문제점이 있으셨다면 Read Me에 꼭 연락을 주세요
                                <br><br>
                                Read Me는 언제든 고객님을 기다리겠습니다.
                                <br><br>
                                더욱 나아지는 서비스로 보답 드리겠습니다.
                                <br><br><br>
                                <b style="color: rgb(120, 150, 50); font-size: 20px;">그간 저희 Read Me를 사랑해주셔서 고맙습니다.</b>
                                <br><br>
                            
                            </div>
                            
                            <div id="myPage_withdraw_btn">
                            <form>
                                <button type="submit"><a href="<%=contextPath%>">메인화면으로 돌아가기</a></button>
                             
                            </form>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

            	<%@ include file="../common/footer.jsp" %>


</body>
</html>