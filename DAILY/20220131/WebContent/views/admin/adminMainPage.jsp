<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.readme.admin.model.vo.Answer" %>
<%
	ArrayList<Answer> answerList = (ArrayList<Answer>)request.getAttribute("answerList");

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

    #admin_content>div{
        height: 400px;
        margin-top: 30px;
    }
    #admin_content table{
        width: 95%;
        height: 200px;
        text-align: center;
        margin-left: auto;
        margin-right: auto;
    }
    #admin_no_answer_book th, #admin_no_answer_question th{
        background:rgb(120, 150, 50);
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

 
         <div id="admin_no_answer_book" style="width:100%;">
             <h2 style="margin-left: 30px;">최근 미답변 요청 책</h1>
             <hr>
             <table border="1">
                 <tr>
                     <th>번호</th>
                     <th>작성일자</th>
                     <th>아이디</th>
                     <th>책 이름</th>
                     <th style="width: 500px;">요청내역</th>
                 </tr>
                 <tr>
                     <td>5</td>
                     <td>2022.01.01</td>
                     <td>sooosdfd</td>
                     <td>책과 삶</td>
                     <td>책이 없어요</td>
                 </tr>
                 
             </table>
            
         </div>


         <div id="admin_no_answer_question" style="width:100%;">
             <h2 style="margin-left: 30px;">최근 미답변 1:1 문의</h1>
             <hr>
	         <table border="1">
             	<thead>
	                <tr>
						<th>번호</th>
						<th style="width: 500px;">제목</th>
						<th>작성자</th>
						<th>작성시간</th>
						<th>처리여부</th> 

	                 </tr>
                 </thead>
                 <tbody>
					<% if(answerList.isEmpty()) {%>
		         		<tr>
		         			<td colspan="6">등록된 문의가 없습니다.</td>
		         		</tr>
	         		
         			<%} else { %>
		         		<%for(Answer a : answerList) {%>
		         			<tr>

		         				<td name="qnum" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getQno() %></td>
		         				<td name="qtitle" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getqTitle() %></td>
		         				<td name="qid" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getUserId() %></td>
		         				<td name="qdate" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getqDate() %></td>
		         				<td name="qstat" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getqStatus() %></td>

		         			</tr>
		         		<%} %>
		         	<%} %>
		          </tbody>
                 
                 
             </table>
            
         </div>

 
     </div>
    


</body>
</html>