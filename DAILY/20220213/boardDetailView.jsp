<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kh.board.model.vo.*" %>    
<%
	Board b = (Board)request.getAttribute("b"); // : Object
	// b => board객체 - 게시글번호, 카테고리명, 제목, 내용, 작성자 아이디, 작성일
			
	Attachment at = (Attachment)request.getAttribute("at"); // : Object
	// at => attachment객체 - 파일번호, 원본명, 수정명, 저장경로

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반게시글</title>
<style>
    .outer{
        background-color: skyblue;
        color: white;
        width: 1000px;
        margin : auto;
        margin-top : 50px;
    }

    table{ border: 1px solid white;}
</style>
</head>
<body>

	<%@ include file = "../common/menubar.jsp" %>

    <div class="outer">
        <br>
        <h2 align="center">일반게시판 상세보기</h2>
        <br>

        <table id="detail-area" align="center" border="1">

            <tr>
                <th width="70">카테고리</th>
                <td width="70"><%= b.getCategory() %></td>
                <th width="70">제목</th>
                <td width="350"><%= b.getBoardTitle() %></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><%= b.getBoardWriter() %></td>
                <th>작성일</th>
                <td><%= b.getCreateDate() %></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    <p style="height:200px;"><%= b.getBoardContent() %></p>
                </td>
            </tr>
            <tr>
                <th></th>
                <td colspan="3">
                    <!-- 첨부파일이 없을경우 -->
                    	<% if(at == null) { %>
                    		첨부파일이 없어~
						<%} else{ %>
		                    <!-- 첨부파일이 있을경우 -->
		                    <a download="<%= at.getOriginName() %>" href="<%=contextPath %>/<%=at.getFilePath()+at.getChangeName()%>">
		                    	<%= at.getOriginName() %>
		                    </a>
                    	<% } %>
                </td>
            </tr>
        </table>

        <br>

        <div align="center">
            <a href="<%= contextPath %>/list.bo?currentPage=1" class="btn btn-secondary btn-sm">목록가기</a>
            
            <!-- 작성자만 보이게끔! -->
        	<!-- 로그인이 되어있고 현재 로그인된 사용자가 작성자와 동일할 경우에만 -->
        	<% if(loginUser != null && loginUser.getUserId().equals(b.getBoardWriter())) { %>
        		<a href="<%= contextPath%>/updateForm.bo?bno=<%= b.getBoardNo() %>" class="btn btn-sm btn-warning">수정하기</a>
        		<a href="<%= contextPath%>/delete.bo?bno=<%= b.getBoardNo() %>" class="btn btn-sm btn-danger">삭제하기</a>
        	<% } %>
        </div>
        <br>
    </div>

    <!-- 댓글창 !!! AJAX가 끝났ㄸ!-->

    <div id="reply-area" style="background-color: pink;">

        <table border="1" align="center">
            <thead>
                <!-- 댓글 작성 영역 -->
                <!-- 로그인이 되어있을 경우 : 댓글 작성 가능 -->
				<% if(loginUser != null) {%>
	                <tr>
	                    <th>댓글작성</th>
	                    <td>
	                        <textarea id="replyContent" cols="50" rows="3" style="resize:none"></textarea>
	                    </td>
	                    <td><button class="btn btn-sm btn-info">댓글등록</button></td>
	                </tr>
				<%} else { %>
	                <!-- 로그인이 안되어있을 경우 : 불가능 -->
	                <tr>
	                    <th>댓글작성</th>
	                    <td>
	                        <textarea id="" readonly cols="50" rows="3" style="resize:none">로그인해 임마~</textarea>
	                    </td>
	                    <td><button class="btn btn-sm btn-danger">댓글등록</button></td>
	                </tr>
				<% } %>
            </thead>
            <tbody>

            </tbody>
        </table>
        <br><br><br>

    </div>
    <script>
        function selectReplyList(){
            $.ajax({
                url : "rlist.do",
                data : {bno : <%= b.getBoardNo() %>},
                success : function(list){
                	// 댓글갯수만큼 반복 => 누적(문자열)
                	var result = "";
                	for(var i in list){ // for in
                		result += "<tr>"
                			   + "<td>" + list[i].replyWriter + "</td>"
                			   + "<td>" + list[i].replyContent + "</td>"
                			   + "<td>" + list[i].createDate + "</td>"
                			   + "</tr>";
                	}
                	
					$("#reply-area tbody").html(result);
                },
                error : function(){
                    console.log("댓글목록 읽어오기 실패");
                }
            })
        }
        
        // 댓글은 화면이 로딩되었을 때 곧바로 뿌려줘야함 => window.onload => $(function)
        $(function(){
        	selectReplyList();
        })



    </script>

</body>
</html>