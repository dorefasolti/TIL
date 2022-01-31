<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.readme.admin.model.vo.Notice, com.readme.admin.model.vo.PageInfo" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	
	int qWriter = 0;
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

    <title>관리자 - 공지사항</title>
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
        #admin_notice_wrap{
            width: 100%;
        }
        #admin_fqa_1{
            height: 100px;
        }
        #admin_notice_2{
            height: 50px;

        }
        #admin_notice_2>form>select{
            width: 150px;
            height: 35px;
            display: inline-block;
            float: left;
            margin-left: 50px;
            margin-right: 20px;
            
        }
        
        #admin_notice_2>form>div{
            width: 300px;
        }
        #admin_notice_2>form{
            clear: both;
        }
        #admin_notice_3{
            height: 50px;
        }
        #admin_notice_3 button{
            background-color: rgb(120, 150, 50);
            color: white;
        }
        #admin_notice_all{
            margin-left: 50px;
        }
        #admin_notice_4>table{
            width: 96.5%;
            margin-left: 50px;
            text-align: center;
        }
        #admin_notice_4 th{
            background-color: rgb(120, 150, 50);
            color: white;
        } 
        #admin_notice_4 td:hover{
            cursor: pointer;
        }

        /* 모달 */
        .modal-body table{
            width: 100%;
            background-color: rgb(120, 150, 50);
            display: contents;
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
 
		      <div id="admin_notice_wrap">
		       
		        <div id="admin_notice_1">
		            <h2 style="margin-left: 30px;">공지사항 관리</h1>
		            <hr>
		        </div>
		
		        <div id="admin_notice_2">
		            <form action="<%= contextPath %>/noticeSearch.ad?currentPage=1" method="post">
		                <select name="searchNoticeCategory" id="" >
		                    <option value="searchNtitle">제목</option>
		                </select>
		                <div class="input-group">
		                  <input type="text" name="searchNoticeKeyword" class="form-control" placeholder="Search">
		                  <div class="input-group-btn">
		                    <button class="btn btn-default" type="submit">
		                      ENTER
		                    </button>
		                  </div>
		                </div>
		              </form>
		        </div>
		        <div id="admin_notice_3">
		            <div class="d-flex">
		                <div class="p-2" id="admin_notice_all">총 게시글 10개</div>
		
		                <div class="p-2 ml-auto ">
		                    <button id="insertbtn" data-toggle="modal" data-target="#admin_notice_submit">작성하기</button>
		                    <!-- <button>선택수정</button> 클릭하면 수정할 수 있도록 변경-->
		                    <button>선택삭제</button>
		                </div>
		              </div>
		            
		        </div>
		        <div id="admin_notice_4">
		            <table border="1">
		            	<thead>
			                <tr>
			                    <th><input type="checkbox" id="all" class="batch"></th>
			                    <th>번호</th>
			                    <th style="width: 50%;">제목</th>
			                    <th class="nWriter">작성자</th>
			                    <th>작성시간</th>
			                    <th>조회수</th>
			                </tr>
		                </thead>
		                <tbody>	                
                	<% if(list.isEmpty()) {%>
                		<tr>
                			<td colspan="6">등록된 문의가 없습니다.</td>
                		</tr>
                		
                	<%} else { %>
                		<%for(Notice n : list) {%>
                			<tr>
                				<td><input type="checkbox" class="batch"></td>
                				<td name="nno" data-toggle="modal" data-target="#admin_notice"><%= n.getNno() %></td>
                				<td name="nTitle" data-toggle="modal" data-target="#admin_notice"><%= n.getnTitle() %></td>
                				<td name="nWriter" class="nWriter"data-toggle="modal" data-target="#admin_notice"><%= n.getnWriter() %></td>
                				<td name="nDate" data-toggle="modal" data-target="#admin_notice"><%= n.getNoticeEnrollDate() %></td>
                				<td name="nCount" data-toggle="modal" data-target="#admin_notice"><%= n.getnCount() %></td>
                 				<td name="nContent" class="nContent" data-toggle="modal" data-target="#admin_notice"><%= n.getnContent() %></td>
                				<td name="nStatus" class="nStatus" data-toggle="modal" data-target="#admin_notice"><%= n.getnStatus() %></td>
								<td class="tmp"><%= qWriter = n.getnWriter()%></td>

                				<!-- 마지막 #ncontent, nstatus, tmp는 숨김처리 : 화면에서 보여줄 필요가 없는데, 내용 가져와야 함 -->

                				
                			</tr>
                		<%} %>

                	
                	<%} %>
		                </tbody>
		              
		               
		            </table>
    <!-- 페이징바 -->
    <div class="paging-area" align="center">
        <% if(currentPage != 1) {%>
        	<button onclick="location.href='<%= contextPath %>/noticeList.ad?currentPage=<%= currentPage -1 %>'">&lt;</button>
    	<% } %>
    
    	<% for(int i = startPage; i <= endPage; i++) {%>
    		<% if(i != currentPage) {%>
    		
    			<button class="btn-outline-light" onclick="location.href='<%= contextPath %>/noticeList.ad?currentPage=<%= i %>'"><%= i %></button>
    		<%} else { %>
    			<button class="btn-outline-info disabled"><%= i %></button>
    		<% } %>
    	<% } %>
    	
    	<% if(currentPage != maxPage){ %>
    		<button onclick="location.href='<%= contextPath %>/noticeList.ad?currentPage=<%= currentPage + 1%>'">&gt;</button>
    	<% } %>
    </div>
		        
		           
		        </div>
		        
		
		        <!-- 공지수정모달 -->
		        <div class="modal" id="admin_notice">
		            <div class="modal-dialog">
		            <div class="modal-content">
		        
		                <!-- Modal Header -->
		                <div class="modal-header">
		                <h4 class="modal-title">공지사항 수정</h4>
		                <button type="button" class="close" data-dismiss="modal">&times;</button>
		                </div>
		        
		            <form action="<%= contextPath %>/noticeUpdate.ad" method="post">
		                <!-- Modal body -->
		                <div class="modal-body">
		                	<input type="hidden" name="nno">
		                	<!-- 쿼리문 날릴 때 필요한 nno를 넘기기 위해 숨겨둠  -->
		                    <table>
		                        <table>
		                            <tr>
		                                <td>제목</td>
		                                <td><input type="text" name="nTitle" style="width: 100%;"></td>
		                            </tr>
		                            <tr>
		                                <td colspan="2">내용</td>
		                            </tr>
		                            <tr>
		                                <td colspan="2"><textarea name="nContent" cols="55" rows="10"></textarea></td>
		                            </tr>
		                        </table>
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
		        <!-- 공지수정모달 끝-->
		
		
		        <!-- 공지작성모달시작 -->
		        <div class="modal" id="admin_notice_submit">
		            <div class="modal-dialog">
		                <div class="modal-content">
		            
		                    <!-- Modal Header -->
		                    <div class="modal-header">
		                    <h4 class="modal-title">공지사항 작성</h4>
		                    <button type="button" class="close" data-dismiss="modal">&times;</button>
		                    </div>
		                
		                <form action="<%= contextPath %>/noticeInsert.ad" method="post">
		                    <!-- Modal body -->
		                    <input type="hidden" name="nWriter">
		                    <div class="modal-body">
		                        <table>
		                            <tr>
		                                <td>제목</td>
		                                <td><input type="text" name="nTitle" style="width: 100%;"></td>
		                            </tr>
		                            <tr>
		                                <td colspan="2">내용</td>
		                            </tr>
		                            <tr>
		                                <td colspan="2"><textarea name="nContent" id="" cols="55" rows="10"></textarea></td>
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
		        <!-- 공지작성모달끝 -->

		
		    </div>
		  </div>
		    
		    
	<!-- 체크박스 전체선택 관련 -->
	<script>
		window.onload = function(){
			$('.nContent').attr('style', "display:none;");
			$('.nStatus').attr('style', "display:none;");
			$('.tmp').attr('style', "display:none;");
			$('.nWriter').attr('style', "display:none");
			/* 클래스가 ncontent, nanswer tmp인 td들을 숨기기 위한 코드
			(아래 tr 클릭 함수에서 내용 가져오기 위해 필요한데, 화면에서 보여줄 필요가 없기 때문) */
	
		}
	
	
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
         	$("#admin_notice_4>table tbody>tr").click(function(){
				//클릭하면 val이 모달 val에 넣어져야한다

            	/* 클릭한 tr의 정보 가지고오기 */
            	 var nno = $(this).children().eq(1).text(); 
            	 var nTitle =  $(this).children().eq(2).text(); 
            	 var nWriter =  $(this).children().eq(3).text(); 
            	 var nDate =  $(this).children().eq(4).text(); 
            	 var nCount = $(this).children().eq(5).text(); 
            	 var nContent = $(this).children().eq(6).text(); 
            	 var nStatus = $(this).children().eq(7).text(); 
            	 
            	 /* 모달바디 안 태그들에 값 넣어주기 */
                 //$('input[name=nTitle]').attr('value', nTitle);
                 $('input[name=nTitle]').attr('value', nTitle);
                 $('textarea[name=nContent]').text(nContent);
                 $('input[name=nno]').attr('value', nno);
                 
                 console.log(nno);
                 console.log(nTitle);
                 console.log(nContent);

            }) 
        })
        
	
        $(function(){
        	$("#insertbtn").click(function(){
        		var qWriter = <%= qWriter %>
	        	console.log(qWriter);
        		$('input[name=nWriter]').attr('value', qWriter);
        		
        	})        })

    </script>



</body>
</html>