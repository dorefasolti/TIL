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

    <title>회원정보수정</title>
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

		        #mypage_profile_update_tb{
            margin-left: auto;
            margin-right: auto;
        }

        #mypage_profile_update_tb th{
            background-color:#789632;
            color: white;
            text-align: center;
            height: 70px;
            width: 200px;
        }
        #mypage_profile_update_tb td{
            width: 500px;
            height: 80px;
            padding-left: 30px;
        }

        #profile_update_btn{
            width: fit-content;
            margin-left: auto;
            margin-right: auto;
        }
        #profile_update_btn> button{
            background-color: rgb(120, 150, 50);
            color: white;
            width: 80px;
            height: 40px;
            margin: 20px;
            display: inline-block;
        }
        .birth{
            width: 70px;
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
            width: 80px;
            height: 40px;
            margin: 20px;
            /* display: inline-block; */
            border-style: solid;
            border-color: rgb(120, 150, 50);
       
        }

    
    </style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
		<%
		int userNo = loginUser.getUserNo();
		String userId = loginUser.getUserId();
		String userName = loginUser.getUserName();
		String email = loginUser.getEmail();
		String gender = loginUser.getGender();
		String birth = loginUser.getBirth();
		String eventAssent = loginUser.getEventAssent();
		String infoAssent = loginUser.getInfoAssent();
		
		// 필수 X => ""

/* 		String address = (loginUser.getAddress() == null) ? "" : loginUser.getAddress();
		// "운동, 등산 ..."
		String interest = (loginUser.getInterest() == null) ? "" : loginUser.getInterest();	 */
	%>
	

        
        <div id="content">
            <div id="content_3">
			     <div id="pageCategory_bar">
			        <a href="">🏠︎ HOME </a> > 마이페이지 > 회원정보수정
			    </div>
            		<%-- <%@ include file="../common/side_test1.jsp" %> --%>
            </div>
            <div id="content_1">
            	<%@ include file="../common/myPageSidebar.jsp" %>
            </div>
            <div id="content_2">    
 				                                                        <!-- content따로 나눌거면 100% 사이드랑 바로 합칠거면 65%로 조정 -->
                <div id="wrap_profile_update" style="height: 1000px; width:100%;">
                    <h2 style="margin-left: 30px;">회원정보 수정</h1>
                    <hr>
                    소중한 고객정보 제공에 대해 감사드립니다 <br><br><br>
                    <form action="<%= contextPath %>/update.me" method="post">
                    
                    
                    <!--수정 내용 :  컬럼순서에 맞게 순서 조정, 이름/성별 분리, 생년월일입력방식 input태그 number->text로 변경, 인라인으로 가로길이줌  -->
                        <table id="mypage_profile_update_tb" border="1">
                            <tr>
                                <th>아이디</th>
                                <td> <input type="text" name="userId" maxlength="12" readonly value="<%= userId %>" > </td>
                            </tr>
                            
                            <tr>
                            <tr>
                                <th>비밀번호</th>
                                <td><input type="password" id="userPwd" name="userPwd" value="" placeholder="새로운 비밀번호를 입력해주세요." style="width: 300px;"></td>
                
                            </tr>
                            <tr>
                                <th>비밀번호 재입력</th>
                                <td><input type="password" id="pwdchk" name="pwdchk" placeholder="비밀번호를 다시 입력해주세요." style="width: 300px;"></td>
                
                            </tr>
                                <th>이름</th>
                                <td>
                                    <input type="text" name="userName" value="<%= userName %>" style="width: 300px;">
                                </td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                                <td><input type="text" name="email" value="<%= email %>" style="width: 300px;"></td>
                            </tr>
                            </tr>
                                <th>성별</th>
                                <td>
                                    <input type="radio" name="gender" id="M" value="M" checked><label for="M">남</label> &nbsp;&nbsp;
                                    <input type="radio" name="gender" id="F" value="F"><label for="F">여</label>  
                                </td>
                            </tr>
                            <tr>
                                <th>생년월일</th>
                                <td>
                                    <input type="text" class="birth" name="birth" value="<%= birth %>" style="width: 300px;">
                                </td>
                            </tr>
                            <tr>
                                <th>이벤트, 혜택 알림 수신</th>
                                <td>
                                    <input type="radio" id="eventAgreement" name="eventAssent" value="Y"> <label for="eventAgreement">동의</label>
                                    <input type="radio" id="eventAgreementX" name="eventAssent" value="N"> <label for="eventAgreementX">미동의</label>
                                </td> 
                            </tr>
                            <tr>
                                <th>성별, 생년 정보 제공</th>
                                <td>
                                    <input type="radio" id="birthAgreememt" name="infoAssent" value="Y"> <label for="birthAgreememt">동의</label>
                                    <input type="radio" id="birthAgreememtX" name="infoAssent" value="N"> <label for="birthAgreememtX">미동의</label>
                                </td>
                            </tr>
                        </table>
                        <div id="profile_update_btn">
                            <button type="submit">수정</button> <button type="reset">취소</button>
                        </div>
                    </form>
                </div>
            
            </div>
        </div>

            	<%@ include file="../common/footer.jsp" %>
<script>

</script>

</body>
</html>