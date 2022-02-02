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
    
        <title>이벤트 응모</title>
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
            width: 10%;
            
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
    
            #point_btn{
                width: fit-content;
                margin-left: auto;
                margin-right: auto;
            }
            #point_btn> button{
                background-color: rgb(120, 150, 50);
                color: white;
                width: 200px;
                height: 40px;
                margin: 20px;
                display: inline-block;
            }
    
            #point_text{
                text-align: center;
                height: 230px;
            }
            #myPage_point_content{
                margin-top: 100px;
            }
            #myPage_point_content>form{
                width: 60%;
                margin-left: auto;
                margin-right: auto;
            }

            #eventNotice{
                color: grey;
                font-size: 12px;
            }
            
        
        </style>
    </head>
    <body>
        <%@ include file="../common/menubar.jsp" %>
            
            <div id="content">
                <div id="content_3">
                </div>
                <div id="content_1">
                </div>
                <div id="content_2">  
                
                
                  <!-- 복사시작 -->
                                                            <!-- content따로 나눌거면 100% 사이드랑 바로 합칠거면 65%로 조정 -->
                    <div id="wrap_myPage_point" style="height: 1000px; width:100%;">
                        <h2 style="margin-left: 30px;">이벤트 응모</h1>
                        <hr>
                        
                        <div id="myPage_point_content">
                            <form action="<%= contextPath %>/presentgive.me" method="post">
                                <div id="point_text">
                                    
                                    <h2>🎊포인트  <b><!-- + 적립금값! + --> 50000</b> 쓰고 선물 받자!!🎊</h2>
                                    <hr>
                                    ReadMe 사이트를 열심히 이용해주신 여러분들을 위한 선물을 준비했습니다 <br><br>
                                    
                                    
                                    본인 확인을 위해 비밀번호를 입력해주세요. <br><br>
                                    
                                    <div>
                                        
                                    </div>
                                    
                                    <input type="password" name="userPwd" id="pwdChk" placeholder="비밀번호" required>
                                    
                                </div>
                                <div id="point_btn">
                                <button type="submit">문화상품권 받기</button>
                                </div>
                                
                                
                            </form>
                            
                            <div id="eventNotice">
                            
                                <br><br><br><br><br><br><br><br><br><br><br><br>

                                <hr>
                                	이벤트 참여 유의사항<br><br>
                                * 이벤트 경품은 신청일 익월 3일에 개인정보에 등록된 이메일로 일괄 발송됩니다.<br>
                                * 이벤트 경품은 당사의 사정에 따라 변경될 수 있습니다.<br>
                                * 부정확한 이메일 주소 정보로 인한 경품의 오배송/반송/분실/훼손 등 어떠한 경우에도 재발송은 불가합니다.<br>
                                * 경품은 배송 정보 취합을 위해 당첨된 고객님께 개별 연락 후 지급해 드립니다.<br>
                                * 개인정보를 허위로 표기하거나 부정한 방법으로 이벤트 참여 시 당첨에서 제외될 수 있습니다.<br>
                                * 본 이벤트는 당사의 사정에 의해 예고없이 조기 종료 될 수 있으며, 당첨자 조건이 상이할 경우 당첨자 수가 변동될 수 있습니다.<br>
                                * 이벤트 C/S처리는 이벤트 기간 포함 3개월 간 진행되며, 이후에는 답변이 불가능합니다.<br> 
                                * 경품은 교환, 환불, 재판매가 불가합니다.<br>
                                * 이벤트 문의 : 고객센터 123-4567<br>
                            </div>
        
                        </div>
                    </div>
                    <!-- 복사끝 -->
                </div>
            </div>
    
                    <%@ include file="../common/footer.jsp" %>
            
        <script>
            $(function(){
                $('#pwdChk').blur(function(){
                    var userPwd = "<%=loginUser.getUserPwd() %>"
                    var $pwdChk = $('#pwdChk').val();

                    
                
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