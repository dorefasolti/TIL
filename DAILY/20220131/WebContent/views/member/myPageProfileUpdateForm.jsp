<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
			String userPwd = loginUser.getUserPwd();
			
			String userName = loginUser.getUserName();
			String email = loginUser.getEmail();
			String gender = loginUser.getGender();
			String birth = loginUser.getBirth();
			String eventAssent = loginUser.getEventAssent();
			String infoAssent = loginUser.getInfoAssent();
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
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소중한 고객정보 제공에 대해 감사드립니다 <br><br><br>
                   
                    <form action="<%= contextPath %>/update.me" method="post">
                        <table id="mypage_profile_update_tb" border="1">
                            <tr>
                                <th>아이디</th>
                                <td> <input type="text" name="userId" maxlength="12" readonly value="<%= userId %>" > </td>
                            </tr>
                            <tr>
                                <th>이름</th>
                                <td>
                                    <input type="text" name="userName" value="<%= userName %>" style="width: 300px;">
                                </td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                                <td>
                                	<input type="email" name="email" value="<%= email %>" style="width: 300px;">
                                	<p class="check-area" id="emailCheck-area"></p>
                                </td>
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
                                    <input type="text" id="birth" class="birth" name="birth" value="<%= birth %>" style="width: 300px;">
                                    	<br>입력양식 : 1990-01-01
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
                                    <input type="radio" id="infoAssent" name="infoAssent" value="Y"> <label for="infoAssent">동의</label>
                                    <input type="radio" id="infoAssentX" name="infoAssent" value="N"> <label for="infoAssentX">미동의</label>
                                </td>
                            </tr>
                        </table>
                        <div id="profile_update_btn">
                           <button type="button" data-toggle="modal" data-target="#pwdChange" style="width:120px;">비밀번호변경</button> <button type="submit">수정하기</button> <button type="reset">취소</button>
                        </div>
                    </form>
                </div>
            
            </div>
        </div>

<%@ include file="../common/footer.jsp" %>
            	

<!-- The Modal -->
<div class="modal" id="pwdChange">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">비밀번호 변경</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <form action="<%= contextPath %>/updatePwd.me" method="post">
	      <div class="modal-body">
			  <input type="hidden" name="userId" value="<%= userId %>">
	          <table id="pwdForm">
	                <tr>
	                    <td>현재 비밀번호</td>
	                    <td>
	                        <input type="password" name="userPwd" required>
	                    </td>
	                </tr>
	                <tr>
	                    <td>변경할 비밀번호</td>
	                    <td>
	                        <input type="password" name="updatePwd" required>
	                    </td>
	                </tr>
	                <tr>
	                    <td>비밀번호 재입력</td>
	                    <td>
	                        <input type="password" name="pwdchk" required>
	                    </td>
	                </tr>
	            </table>
	      </div>

            <!-- Modal footer -->   
          <div class="modal-footer">
              <button type="submit" class="btn btn-primary" onclick="return pwdDoubleCheck()">비밀번호변경</button>
              <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
          </div>
      </form>

    </div>
  </div>
</div>




<script>
	window.onload = $(function(){

		var eventAssent = "<%=eventAssent%>";
		var infoAssent = "<%=infoAssent%>";
		
		/* 로그인유저의 정보제공동의상태가 Y일경우 동의, N일경우 미동의에 체크되도록 함 */
		
		if(eventAssent == "Y"){
			$('#eventAgreement').attr("checked", true);
		}
		else if(eventAssent =="N"){
			$('#eventAgreementX').attr("checked", true);
		}
		
		
		if(infoAssent == "Y"){
			$('#infoAssent').attr("checked", true);
		}
		else if(infoAssent == "N"){
			$('#infoAssentX').attr("checked", true);
		}

        var gender = "<%=gender%>";

        if(gender == "M"){
            $('#M').attr("checked", true);
        }
        else {
            $('#F').attr("checked", true);
        }
		

	})

    function pwdDoubleCheck(){

/* 		영문 대문자/소문자/숫자/특수문자 중 3가지 이상 조합, 8~32자 */
 		 var pw = $("input[name=updatePwd]").val();
		 var num = pw.search(/[0-9]/g);
		 var eng = pw.search(/[a-z]/ig);
		 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

		 /* 빨간줄이 뜰 수도 있는데 혼자 사라지고 잘 돌아갑니다 */
		 if(pw.length < 8||pw.length > 32){

		  alert("8자리 ~ 32자리 이내로 입력해주세요.");
		  return false;
		 }else if(pw.search(/\s/) != -1){
		  alert("비밀번호는 공백 없이 입력해주세요.");
		  return false;
		 }else if(num < 0 || eng < 0 || spe < 0 ){
		  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
		  return false;
		 }
		

		 
		 /* 변경할 비밀번호, 확인용 비밀번호가 일치하는지 확인 */
        if($("input[name=updatePwd]").val() != $("input[name=pwdchk]").val()){
        		alert("입력하신 비밀번호가 일치하지 않습니다.");
                return false;
            }
        return true;
    }
		
	$("#mypage_profile_update_tb input[name=email]").on("change", function(){
        var $email = $(this).val();
        //console.log($email);
        //ajax로 컨트롤러에 요청하기
        $.ajax({
           url : "emailCheck.me",
           data : { email : $email },
           success : function(result){
              //result : NN(이메일 사용 불가능) YY(이메일 사용 가능)
              console.log(result);
              if(result == "NNN" ){
                 $("#emailCheck-area").text("사용 불가능한 이메일입니다.")
              }else{
                 //$("#emailCheck-area").text("사용 가능한 이메일입니다.")
              }
              
           },
           error : function(){
              console.log("이메일 중복체크 실패");
           }
           
        })
             
     })
     
     
			/* 입력창을 벗어나면 양식에 맞는지 검사하고, 맞지 않으면 알림창 출력 */
     $(function(){
		$('#birth').blur(function(){

			var $birth = $('#birth').val();
			var regExp =  /^(19[0-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;

			console.log($birth);
			
		
			if(!regExp.test($birth)){
				alert("생년월일 작성 형식이 일치하지 않습니다 확인하시고 다시 입력해주세요.");
				$('#birth').val('');
				return false;
			}
		}) 
	})
	
	
	
	
	
</script>

</body>
</html>