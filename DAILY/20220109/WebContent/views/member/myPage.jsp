<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
<style>
	.outer{
		background : skyblue;
		color : white;
		width : 500px;
		margin : auto;
		margin-top : 50px;
	}
	table {margin : auto;}
	input {margin : 5px;}
</style>
</head>
<body>
	<%@include file="../common/menubar.jsp" %>
	<%
	
		String userId = loginUser.getUserId();
		String userName = loginUser.getUserName();
		//아이디, 네임은 필수입력사항이었음
		//그 이하는 필수가 아니었다
		//전부 필드 스트링으로 주긴 했음
		//관심분야는 배열
		//스트링이던, 배열이던 뭐가 들어가지 않으면 기본값 null이 들어감
		//저 상태로 데이터를 가지고 왔는데, 사용자가 입력하지 않은 항목 ? => (마이페이지 회원정보 텍스트박스에)null이 출력되어버린다
		//null일 경우 빈 문자열이 나오게 해야 한다!
		
		//필수X => ""

		//조건문을 사용해보자
		//String phone = "";
		//if(loginUser.getPhone() == null){
		//	...	
		//} 전부 이렇게 쓰기엔 너무 불편해!
		
		String phone = (loginUser.getPhone() == null ) ? "" : loginUser.getPhone();
		//삼항연산자를 이용해보자
		//조건이 참일 경우, 물음표 뒤 앞의 값이 대입  || 거짓일 경우 물음표 이후 뒤의 값이 대입 
		
		String email = (loginUser.getEmail() == null ) ? "" : loginUser.getEmail();
		
		String address = (loginUser.getAddress() == null) ? "" : loginUser.getAddress();
	
		//운동, 등산...
		String interest = (loginUser.getInterest() == null) ? "" : loginUser.getInterest();
	
	%>

    <div class="outer">
        <br>
        <h2 align="center">마이페이지</h2>

        <form action="<%= contextPath %>/update.me" method="POST">
            <!-- 아이디, 비밀번호, 이름, 전화번호, 이메일주소, 주소, 취미 -->

            <table>
                <tr>
                    <td>* 아이디</td>
                    <td><input type="text" value=<%= userId %> name="userId" maxlength="12" readonly></td>
                    <td><button class="btn btn-secondary btn-sm">중복확인</button></td>
                    <!-- 중복확인은 나중에 ajax배우고 나서 할 것 -->
                </tr>

                <tr>
                    <td>* 이름</td>
                    <td><input type="text" value=<%= userName %> name="userName" maxlength="6" required></td>
                    <td></td>
                </tr>
                
                
                <!-- 주의 : value 들어가는 순서도 중요하다 중간에 넣으면 안됨 맨 끝으로 몰아줘야함 -->
                
                
                <tr>
                    <td>&nbsp;&nbsp;전화번호</td>
                    <td><input type="text"  name="phone" placeholder="포함해서 입력" value=<%= phone %>></td>
                    <td></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;이메일</td>
                    <td><input type="email"  name="email" value=<%= email %>></td>
                    <td></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;주소</td>
                    <td><input type="text"  name="address" value=<%= address %>></td>
                    <td></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;관심분야</td>
                    <td colspan="2">
                        <input type="checkbox" name="interest" value="운동" id="sports"><label for="sports">운동</label>
                        <input type="checkbox" name="interest" value="등산" id="hiking"><label for="hiking">등산</label>
                        <input type="checkbox" name="interest" value="낚시" id="fishing"><label for="fishing">낚시</label>

                        <br>

                        <input type="checkbox" name="interest" value="요리" id="cooking"><label for="cooking">요리</label>
                        <input type="checkbox" name="interest" value="게임" id="game"><label for="game">게임</label>
                        <input type="checkbox" name="interest" value="영화" id="movie"><label for="movie">영화</label>
                    </td>
                </tr>

            </table>
            
            <script>
            	$(function(){
            		var interest = "<%= interest %>";
            		
            		//모든 체크박스를 선택해보자
            		$("input[type=checkbox]").each(function(){
            			// 순차적으로 접근한 checkbox의 value속성값이 interest에 포함되어 있을 경우에만 체크하겠다
            			// => checked 속성을 부여 => attr(속성명, 속성값);
            			
            			//자바스크립트의 indexOf => 찾고자 하는 문자가 없을 경우는 -1을 리턴 == 제이쿼리의 search()메소드
            			//제이쿼리에서 value 속성값을 return 해주는 메소드 : va()
            			// 제이쿼리에서 현재 접근한 요소 지칭 : $(this)
            			
            			if(interest.search($(this).val()) != -1){ //포함되어 있을 경우 => checked 속성 부여
							$(this).attr("checked", true);            				
            			}
            		})
            	})
            
            
            
            </script>
            
            
            <br><br>
            <div align="center">
                <button type="submit" class="btn btn-secondary btn-sm">정보변경</button> 
                <!-- 폼 태그 내부의 서브밋 버튼 -> 이걸 누르면 정보를 변경해달라는 요청을 컨트롤러애게 전송한다 -->
                <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#updatePwdForm">비밀번호변경</button>
                <button type="button" class="btn btn-danger btn-sm">회원탈퇴</button>
            </div>

            <br><br><br>

        </form>




    </div>

  
  <!-- The Modal -->
  <div class="modal" id="updatePwdForm">
    <div class="modal-dialog">
      <div class="modal-content">
  
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">비밀번호 변경</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
  
        <!-- Modal body -->
        <div class="modal-body">
          
            <form action="<%= contextPath %>/updatePwd.me" method="POST">
                <!-- 현재 비밀번호, 변경할 비밀번호, 변경할 비밀번호 확인(재입력) -->
                
                
                <!-- 확실하게 비밀번호의 주인을 판별할 수 있는 ID도 같이 넘겨주자-->
                <input type="hidden" name="userId" value="<%= userId%>">
                <!-- 이건 사실 .. 위에 <%%> 안에 ㅇ해놨음 -->
                <!-- type을 hidden으로 설정하면 사요자의 눈에 보이지 않느낟! -->
                <table>
                    <tr>
                        <td>현재 비밀번호 </td>
                        <td><input type="password" name="userPwd" required></td>
                    </tr>
                    <tr>
                        <td>변경할 비밀번호 </td>
                        <td><input type="password" name="updatePwd" required></td>
                    </tr>
                    <tr>
                        <td>비밀번호 재입력 </td>
                        <td><input type="password" name="checkPwd" required></td>
                    </tr>
                </table>
                <br>
                <button type="submit" class="btn btn-info btn-sm">비밀번호 변경</button>

            </form>
        </div>
  
  
      </div>
    </div>
  </div>

</body>
</html>