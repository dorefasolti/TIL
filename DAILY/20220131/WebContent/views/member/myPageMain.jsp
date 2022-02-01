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

    <title>마이페이지</title>
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
	
	
	
	    #info_all{
            width: 755px; 
            height: 206px; 
            background-color: #e0e0e0;
            margin-left: auto;
            margin-right: auto;
        }
        .info_profile{
            /* display: inline-block; */
            float: left;
        }
        h1{
            clear: both;
        }
        #info_left{
            width: 40%;
        }
        #info_right{
            width: 60%;
        }

        #info_left, #info_right{
            /* width: 50%; */
            height: 100%;
            display: inline-block;
            float: left;
        }
        #info_left_up, #info_left_down{
            width: 100%;
            height: 50%;
            padding: 10px;
            /* padding-left: 0px; */
        }
        #info_right>div{
            height: 35%;
            width: 35%;
            display:inline-block;
            margin-top: 20px;
            margin-left: 35px;
            background-color: white;
        }
        .info_btn{
            border-radius: 25%;
            background-color: rgb(224, 224, 224);
            width: 166px;
            height: 60px;
            border-color: white;
            border-style: solid;
            
            
        }
        #info_button{
            width: 755px;
            margin-left: auto;
            margin-right: auto;

        }
        #info_button>div{
            width: 23%;
            display: inline-block;
            margin-left: 9.5px;
            margin-top: 10px;

        }
                #pageCategory_bar{
            width: 100%;
            height: 70px;  
            padding: 15px 10px 10px 53px;
            font-size: 17px; 
            box-sizing: border-box;
        }


        #info_all{
            width: 755px; 
            height: 206px; 
            background-color: #e0e0e0;
            margin-left: auto;
            margin-right: auto;
        }
        .info_profile{
            /* display: inline-block; */
            float: left;
        }
        h1{
            clear: both;
        }
        #info_left{
            width: 40%;
        }
        #info_right{
            width: 60%;
        }

        #info_left, #info_right{
            /* width: 50%; */
            height: 100%;
            display: inline-block;
            float: left;
        }
        #info_left_up, #info_left_down{
            width: 100%;
            height: 50%;
            padding: 10px;
            /* padding-left: 0px; */
        }
        #info_right>div{
            height: 35%;
            width: 35%;
            display:inline-block;
            margin-top: 20px;
            margin-left: 35px;
            background-color: white;
        }
        .info_btn{
            border-radius: 25%;
            background-color: rgb(224, 224, 224);
            width: 166px;
            height: 60px;
            border-color: white;
            border-style: solid;
            
            
        }
        #info_button{
            width: 755px;
            margin-left: auto;
            margin-right: auto;

        }
        #info_button>div{
            width: 23%;
            display: inline-block;
            margin-left: 9.5px;
            margin-top: 10px;

        }
		
    
    </style>
    
    

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<%
	
		int wishCount = (int)request.getAttribute("wishCount");	
	
		int userNo = loginUser.getUserNo();
		String userId = loginUser.getUserId();
		String userName = loginUser.getUserName();
		String email = loginUser.getEmail();
		String gender = loginUser.getGender();
		String birth = loginUser.getBirth();
		String eventAssent = loginUser.getEventAssent();
		String infoAssent = loginUser.getInfoAssent();
		int reviewCount = loginUser.getReviewCount();
		int point = loginUser.getPoint();

	%>
	
        
        <div id="content">
            <div id="content_3">
			     <div id="pageCategory_bar">
			        <a href="">🏠︎ HOME </a> > 마이페이지 
			    </div>
            		<%-- <%@ include file="../common/side_test1.jsp" %> --%>
            </div>
            <div id="content_1">
            	<%@ include file="../common/myPageSidebar.jsp" %>
            </div>
            <div id="content_2">                                                           <!-- content따로 나눌거면 100% 사이드랑 바로 합칠거면 65%로 조정 -->
                              <div id="wrap_myMain" style="height: 500px;">
                    <h2 style="margin-left: 30px;">회원 정보</h1>
                    <div id="info_all">

                        <div id="info_left">
                            <div id="info_left_up">
                                <img src="<%= contextPath %>/resources/view_img/사람얼굴.png" alt="" class="info_profile" width="60px">
                                <div style="width: 100px; text-align:center;" class="info_profile" >
                                   	<%=userName%> <br>
                                    <%=userId %>
                                </div>
                            </div>
                            <div id="info_left_down">
                                <%=birth %> <br>
                                <%=email %> <br>
                            </div>
                        </div>

                        <div id="info_right">
                            <div id="info_right_first">리뷰 수 <br> 
                            	<input type="text" value="<%=reviewCount %>" style="text-align: center; width: 150px; border: none;" readonly >
                            </div>
                            <div id="info_right_second">적립금<br>
                           		 <input type="text" value="<%=point %>" style="text-align: center; width: 150px; border: none;" readonly>
                            </div>
                            <div id="info_right_third">찜한 책
                           		 <input type="text" id="wish" value="<%= wishCount %>" style="text-align: center; width: 150px; border: none;" readonly>                            
                            </div>
                            <div id="info_right_fourth">참여중인이벤트
                            	<input type="text" value="2" style="text-align: center; width: 150px; border: none;" readonly>
                            </div>
                        </div>

                        <div id="info_button">
                            <div><a href="<%= contextPath %>/profile.me"><button class="info_btn">회원정보수정</button></a></div>
                            <div><a href="<%= contextPath %>/static.me"><button class="info_btn">독서통계</button></a></div>
                            <div><a href="<%= contextPath %>/inquiryList.me"><button class="info_btn">문의내역</button></a></div>
                            <div><a href="<%= contextPath %>/requestList.me"><button class="info_btn">요청책</button></a></div>
                        
                        </div>

                    </div>
                </div>
              
              </div>
        </div>

            	<%@ include file="../common/footer.jsp" %>

    <script>
    	
    // 에이작스 아직~~
    
    </script>
</body>
</html>