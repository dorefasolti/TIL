<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.readme.admin.model.vo.Answer, com.readme.admin.model.vo.PageInfo" %>
<%
	ArrayList<Answer> list = (ArrayList<Answer>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
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

    <title>관리자 - 1:1 상담관리</title>
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
        #admin_answer_wrap{
            width: 100%;
        }
        #admin_fqa_1{
            height: 100px;
        }
        #admin_answer_2{
            height: 50px;

        }
        #admin_answer_2>form>select{
            width: 150px;
            height: 35px;
            display: inline-block;
            float: left;
            margin-left: 50px;
            margin-right: 20px;
            
        }
        #admin_answer_2>form>div{
            width: 300px;
        }
        #admin_answer_2>form{
            clear: both;
        }
        #admin_answer_3{
            height: 50px;
        }
        #admin_answer_3 button{
            background-color: rgb(120, 150, 50);
            color: white;
        }
        #admin_answer_all{
            margin-left: 50px;
        }
        #admin_answer_4>table{
            width: 96.5%;
            margin-left: 50px;
            text-align: center;
        }
        #admin_answer_4 th{
            background-color: rgb(120, 150, 50);
            color: white;
        }
        #admin_answer_4 td:hover{
            cursor: pointer;
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
 
	<div id="admin_answer_wrap">
		       
		<div id="admin_answer_1">
			<h2 style="margin-left: 30px;">1:1상담 관리</h1>
			<hr>
		</div>
		
		<div id="admin_answer_2">
            <form action="<%= contextPath %>/inquirySearch.ad?currentPage=1" method="post">
                <select name="searchAnswerCategory" id="" >
                    <!-- <option value="">전체</option> -->
                    <option value="searchQStatus">처리여부</option>
                    <option value="searchQTitle">제목</option>
                    <option value="searchQWriter">작성자</option>
                </select>
                <div class="input-group">
                  <input type="text" name="searchAnswerKeyword" class="form-control" placeholder="Search">
                  <div class="input-group-btn">
                    <button class="btn btn-default" type="submit">
                      ENTER
                    </button>
                  </div>
                </div>
              </form>
		</div>
        <div id="admin_answer_3">
            <div class="d-flex">
                <div class="p-2" id="admin_answer_all">총 게시글 10개</div>

                <div class="p-2 ml-auto ">
                    <button>선택삭제</button>
                </div>
              </div>
            
        </div>
        <div id="admin_answer_4">
            <table border="1">
            	<thead>
	                <tr>
	                    <th><input type="checkbox" id="all" class="batch"></th>
	                    <th>번호</th>
	                    <th style="width: 600px;">제목</th>
	                    <th>작성자</th>
	                    <th>작성시간</th>
	                    <th>처리여부</th> 
	                    <th class="qcontent">문의내용</th>
	                    <th class="qanswer">답변내용</th>
	                </tr>
                </thead>
                <tbody>
                	
                	<!--조회된 리스트 출력하기 -->
                	
                	<% if(list.isEmpty()) {%>
                		<tr>
                			<td colspan="6">등록된 문의가 없습니다.</td>
                		</tr>
                		
                	<%} else { %>
                		<%for(Answer a : list) {%>
                			<tr>
                				<td><input type="checkbox" class="batch"></td>
                				<td name="qnum" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getQno() %></td>
                				<td name="qtitle" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getqTitle() %></td>
                				<td name="qid" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getUserId() %></td>
                				<td name="qdate" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getqDate() %></td>
                				<td name="qstat" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getqStatus() %></td>
                 				<td name="qcontent" class="qcontent" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getqContent() %></td>
                				<td name="qanswer" class="qanswer" data-toggle="modal" data-target="#admin_inquire_answer"><%= a.getqAnswer() %></td>
                				<!-- 마지막 #qcontent는 숨김처리 : 화면에서 보여줄 필요가 없는데, 내용 가져와야 함 -->
<%--                 				<input type="hidden" name="qcontent" id="qcontent" value="<%= a.getqContent() %>">
                				<input type="hidden" name="qanswer" value="<%= a.getqAnswer() %>"> --%>
                				
                			</tr>
                		<%} %>

                	
                	<%} %>
                </tbody>

              
               
            </table>
    <!-- 페이징바 -->
    <div class="paging-area" align="center">
        <% if(currentPage != 1) {%>
        	<button onclick="location.href='<%= contextPath %>/inquirySearch.ad?currentPage=<%= currentPage -1 %>'">&lt;</button>
    	<% } %>
    
    	<% for(int i = startPage; i <= endPage; i++) {%>
    		<% if(i != currentPage) {%>
    		
    			<button class="btn-outline-light" onclick="location.href='<%= contextPath %>/inquirySearch.ad?currentPage=<%= i %>'"><%= i %></button>
    		<%} else { %>
    			<button class="btn-outline-info disabled"><%= i %></button>
    		<% } %>
    	<% } %>
    	
    	<% if(currentPage != maxPage){ %>
    		<button onclick="location.href='<%= contextPath %>/inquirySearch.ad?currentPage=<%= currentPage + 1%>'">&gt;</button>
    	<% } %>
    </div>
        
           
        </div>
		        
		
        <!-- answer등록 -->
        <div class="modal" id="admin_inquire_answer">
            <div class="modal-dialog">
            <div class="modal-content">
        
                <!-- Modal Header -->
                <div class="modal-header">
                <h4 class="modal-title">1:1상담 답변 등록</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

            <form action="<%= contextPath %>/inquiryAnswer.ad" method="post">
                <!-- Modal body -->
                <div class="modal-body">
                <input type="hidden" name="qno">
                <input type="hidden" name="qstat">
                <!-- 쿼리문 날릴 때 필요한 qno를 넘기기 위해 숨겨둠  -->
                    <table>
                        <tr>
                            <td>제목</td>
                            <td><input type="text" name="qtitle" readonly style="width:380px"></td>
                        </tr>
                        <tr>
                            <td>작성자</td>
                            <td><input type="text" name="qwriter" readonly style="width:380px"></td>
                        </tr>
                        <tr>
                            <td>문의내용</td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea name="qcontent" id="" cols="60" rows="5" readonly></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>답변내용</td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea name="qanswer" id="" cols="60" rows="5" placeholder="내용을 입력하세요"></textarea>
                            </td>
                        </tr>
                    </table>
                </div>
        
                <!-- Modal footer -->
                <div class="modal-footer">
                 <button type="submit" class="btn btn-primary">등록</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
                </div>
            </form>

            </div>
            </div>
        </div>
            <!-- answer등록 끝-->
	</div>
</div>
		    
	<script>
		window.onload = function(){
			$('.qcontent').attr('style', "display:none;");
			$('.qanswer').attr('style', "display:none;");
			/* 클래스가 qcontent, qanswer인 td들을 숨기기 위한 코드
			(아래 tr 클릭 함수에서 내용 가져오기 위해 필요한데, 화면에서 보여줄 필요가 없기 때문) */

		}		
	
		
		/* 체크 전체선택 관련*/
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
        


        //tr을 클릭했을 때 1:1답변 등록하는 모달이 뜸, 해당 모달에 정보를 전달해주기 위한 코드 
        $(function(){
         	$("#admin_answer_4>table tbody>tr").click(function(){
				//클릭하면 val이 모달 val에 넣어져야한다

            	/* 클릭한 tr의 정보 가지고오기 */
            	 var qno = $(this).children().eq(1).text(); 
            	 var qtitle =  $(this).children().eq(2).text(); 
            	 var qwriter =  $(this).children().eq(3).text(); 
            	 var qdate =  $(this).children().eq(4).text(); 
            	 var qstat = $(this).children().eq(5).text(); 
            	 var qcontent = $(this).children().eq(6).text(); 
            	 var qanswer = $(this).children().eq(7).text(); 
            	 
            	 /* 모달바디 안 태그들에 값 넣어주기 */
                 $('input[name=qno]').attr('value', qno);
                 $('input[name=qstat]').attr('value', qstat);
                 $('input[name=qtitle]').attr('value', qtitle);
                 $('input[name=qwriter]').attr('value', qwriter);
                 $('textarea[name=qcontent]').text(qcontent);
                 $('textarea[name=qanswer]').text(qanswer);

            }) 
        })

    </script>
    
    




</body>
</html>