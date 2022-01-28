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
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <title>회원탈퇴</title>
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


   		 #pageCategory_bar{
            width: 100%;
            height: 70px;  
            padding: 15px 10px 10px 53px;
            font-size: 17px; 
            box-sizing: border-box;
   		 }

        #withdraw_btn{
            width: fit-content;
            margin-left: auto;
            margin-right: auto;
        }
        #withdraw_btn> button{
            background-color: rgb(120, 150, 50);
            color: white;
            width: 80px;
            height: 40px;
            margin: 20px;
            display: inline-block;
        }

        #withdraw_text{
            text-align: center;
            height: 230px;
        }
        #myPage_withdraw_content{
            margin-top: 100px;
        }
        #myPage_withdraw_content>form{
            width: 60%;
            margin-left: auto;
            margin-right: auto;
        }
		
    
    </style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<%
		String userPwd = loginUser.getUserPwd();
	%>
        
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
            
            
              <!-- 복사시작 -->
                                                        <!-- content따로 나눌거면 100% 사이드랑 바로 합칠거면 65%로 조정 -->
                <div id="wrap_myPage_withdraw" style="height: 1000px; width:100%;">
                    <h2 style="margin-left: 30px;">회원 탈퇴</h1>
                    <hr>
                    
                    <div id="myPage_withdraw_content">
                        <form action="<%= contextPath %>/delete.me" method="post">
                            <div id="withdraw_text">
                                
                                <h2>본인 확인</h2>
                                <hr>
                                	개인정보 수정을 위해서는 본인 확인이 필요합니다. <br><br>
                               		로그인 비밀번호를 다시 입력해주세요. <br><br>
                                <input type="password" name="userPwd" id="pwdChk" placeholder="비밀번호" required>
                                
                            </div>
                            <div id="withdraw_btn">
                            <button type="submit">확인</button>
                            </div>
                            
                            
                        </form>
    
                    </div>
                </div>
                <!-- 복사끝 -->
            </div>
        </div>

<%@ include file="../common/footer.jsp" %>


<script>
	$(function(){
		$('#pwdChk').blur(function(){
			var userPwd = "<%=userPwd%>"
			var $pwdChk = $('#pwdChk').val();

			
			
			/* 널이 아닌걸 어떻게 검사하는데~~~~ㅠㅠ */
			if(userPwd != $pwdChk){
				alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				$('#pwdChk').val('');
				return false;
			}
		}) 
	})

</script>

</body>
</html>