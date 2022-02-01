<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.ArrayList, com.readme.member.model.vo.Member, com.readme.admin.model.vo.PageInfo" %>
<%
ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int listCount = pi.getListCount();
	
	int qWriter = 0;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>관리자페이지</title>
    <style>
    body { margin: 0;}
    div{
        box-sizing : border-box;
    }

    .admin_wrap>div{width:100%;}

    #admin{
        width: 100%;
        padding: 20px 30px;
        margin: 0 auto;
        
    }

	#admin_sidebar{
        width: 15%;
        float:left;

    }
    #admin_content{
        display: inline-block;
        height: 1000px;
    }
    #admin_content{
        width: 84%;
        clear: both;

    }
    /* --------------------------------------레이아웃------------------------------------ */

              #admin_user_wrap{
            width: 100%;
        }
        #admin_user_1{
            height: 100px;
        }
        #admin_user_2{
            height: 50px;

        }
        #admin_user_2>form>select{
            width: 100px;
            height: 35px;
            display: inline-block;
            float: left;
            margin-left: 50px;
            margin-right: 20px;
            
        }
        #admin_user_2>form>div{
            width: 300px;
        }
        #admin_user_2>form{
            clear: both;
        }
        #admin_user_3{
            height: 50px;
        }
        #admin_user_3 button{
            background-color: rgb(120, 150, 50);
            color: white;
        }
        #admin_user_all{
            margin-left: 50px;
        }
        #admin_user_4>table{
            width: 96.5%;
            margin-left: 50px;
            text-align: center;
        }
        #admin_user_4 th{
            background-color: rgb(120, 150, 50);
            color: white;
            
        }
        /* 모달 */
        .modal-body table{
            text-align: center;
            width: 100%;
        }
        .modal-body table input{
            width: 100%;
        }
        
        /* 페이징 */
        .paging-area>button{
            margin: 5px;
            height: 38px;
            border-radius: 5px;
            color: white;
            background-color: rgb(130, 150, 50);
            border : white;
	    }
	    .paging-area>button:hover{
	        background-color: rgb(233, 233, 233);
	        color: rgb(130, 150, 50);
	    }

        

    
    </style>
</head>
<body>


<div id="admin_header">
    <%@ include file="../common/adminMenubar.jsp" %>
</div>
<div id="admin_sidebar">
<%@ include file="../common/adminSidebar.jsp" %>
</div>
<div id="admin_content">
  
     
<div id="admin_user_wrap">
      
       <div id="admin_user_1">
           <h2 style="margin-left: 30px;">회원관리</h1>
           <hr>
       </div>

       <div id="admin_user_2">
           <form action="<%= contextPath %>/userSearch.ad?currentPage=1" method="post">
               <select name="searchUserCategory">
                   <option value="searchUserId">아이디</option>
                   <option value="searchUserName">이름</option>
                   <option value="searchUserStatus">회원상태</option>
               </select>
               <div class="input-group">
                 <input type="text" name="searchUserKeyword" class="form-control" placeholder="Search">
                 <div class="input-group-btn">
                   <button class="btn btn-default" type="submit">
                     ENTER
                   </button>
                 </div>
               </div>
             </form>
       </div>
       
       
       
   <form action="<%= contextPath %>/userDelete.ad" method="post">
       <div id="admin_user_3">
           <div class="d-flex">
               <div class="p-2" id="admin_user_all">회원 수 <%= listCount %>명</div>

               <div class="p-2 ml-auto ">
               	
                   	<button>선택삭제</button>
               	
               </div>
             </div>
       </div>
       
       
       <div id="admin_user_4">
           <table border="1">
           	<thead>
                <tr>
                    <th><input type="checkbox" id="all" class="batch"></th>
                    <th>회원번호</th>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>성별</th>
                    <th>생년월일</th>
                    <th>가입일</th>
                    <th>회원상태</th>
                    <th>이벤트동의</th>
                    <th>정보제공동의</th>
                    <th>출석체크</th>
                    <th>리뷰수</th>
                    <th>포인트</th>
                </tr>
               </thead>
               <tbody>

				<% if(list.isEmpty()) {%>
               		<tr>
               			<td colspan="14">회원 정보가 없습니다.</td>
               		</tr>
            		
               	<%} else { %>
               		<%for(Member m : list) {%>
               			<tr>

		                    <td><input type="checkbox" class="batch" name="checkList" value="<%= m.getUserNo() %>"></td>
		                    <td><%= m.getUserNo() %></td>
		                    <td><%= m.getUserId() %></td>
		                    <td><%= m.getUserName() %></td>
		                    <td><%= m.getEmail() %></td>
		                    <td><%= m.getGender() %></td>
		                    <td><%= m.getBirth() %></td>
		                    <td><%= m.getEnrollDate() %></td>
		                    <td><%= m.getStatus() %></td>
		                    <td><%= m.getEventAssent() %></td>
		                    <td><%= m.getInfoAssent() %></td>
		                    <td><%= m.getCheckCount() %>회</td>
		                    <td><%= m.getReviewCount() %></td>
		                    <td><%= m.getPoint() %></td>
               				
               			</tr>
               		<%} %>
               	<%} %>
		        </tbody>
           </table>
  	</form>
			   
			   
    <!-- 페이징바 -->
	    <div class="paging-area" align="center">
	        <% if(currentPage != 1) {%>
	        	<button onclick="location.href='<%= contextPath %>//userList.ad?currentPage=<%= currentPage -1 %>'">&lt;</button>
	    	<% } %>
	    
	    	<% for(int i = startPage; i <= endPage; i++) {%>
	    		<% if(i != currentPage) {%>
	    		
	    			<button class="btn-outline-light" onclick="location.href='<%= contextPath %>//userList.ad?currentPage=<%= i %>'"><%= i %></button>
	    		<%} else { %>
	    			<button class="btn-outline-info disabled"><%= i %></button>
	    		<% } %>
	    	<% } %>
	    	
	    	<% if(currentPage != maxPage){ %>
	    		<button onclick="location.href='<%= contextPath %>//userList.ad?currentPage=<%= currentPage + 1%>'">&gt;</button>
	    	<% } %>
	    </div>

			
			  
			
			        
			
	</div>
</div>
	
	
    	<!-- 체크박스 전체선택 관련 -->
	<script>
        $(function(){
            $('#all').on('change', function(){
                var $all = $('#all').prop('checked');
                if($all){
                    $('.batch').prop('checked', true); 
                }
                else{
                    $('.batch').prop('checked', false);
                }
            })
        })
        

        /* 체크박스 선택 시  값이 잘 넘어가는지 확인*/
        $(function(){
        	$("input:checkbox[name=checkList]").on('click', function(){
            	var uno = $(this).val();
/*             	console.log(uno); */
        	})
        })
    </script>




</body>
</html>