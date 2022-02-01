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

    <!-- slick slider 사용 -->
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <!-- ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ -->


    <title>최근 본 책</title>
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
        
        

        #recentView_text{
            line-height: 30px;
            text-align: center;
            height: 350px;
            border:1px solid black;
            width: 800px;
            margin-left: auto;
            margin-right: auto;
        }

        .myPage_recentView_carousel{
            margin-left: 100px;
            /* 기준점으로 잡아줌 */
            position:relative;
        }

        /* 좌/우 버튼 => 가운데로 내리고 좌-우 로 붙이기 */
        .slick-arrow{
            position:absolute;
            z-index: 10;
            top:50%;
            transform: translate(-50%);
            background-color: rgb(120, 150, 50);
            color: white;
            width: 80px;
            height: 40px;
            border-radius: 30px;
            border-style: solid;
            border-color: rgb(120, 150, 50);
        }
        /* 좌-우 양끝으로 붙이는 코드, 합쳤을때 문제 생기면 비율 조정하면 됨 -붙이면 더 왼쪽, 더 오른쪽  */
        .myPage_recentView_carousel button.slick-prev{
             left: 0px;
        }
        .myPage_recentView_carousel button.slick-next {
            right: -105px; 
        }


        /* 페이지바 관련 속성 */
        .slick-dots{
            margin-top: 20px;
            position: absolute;
            left: 50%;
            transform: translateX(-50%);
            /* 가로를 기준으로 가운데 넣기 */
        }
        .slick-dots li{
            float:left;
            list-style: none;
        }

        /* 총 페이지 수 만큼 보이는 버튼 */
        .slick-dots li button{
            background: url(/resources/emptycircle1212.png) no-repeat 0 0;
            text-indent: -9999px;
            overflow: hidden;
            border: none;
            width: 12px;
            height: 12px;
        }
        /* 현재 보여지는 페이지가 검은색 버튼으로 표현되게 하는 코드 */
        .slick-dots .slick-active button{
            background: url(/resources/fullcircle1212.png) no-repeat 0 0;
        }
        




        #wrap_myPage_recentView{
            width: 100%;

        }
        #myPage_recentView_content{
            margin-top: 100px;
        }


        /* 별표/책표지/제목 가운데정렬 */
        .book-img{
            width: 150px;
            height: 300px;
            padding: 10px;
            margin-left: auto;
            margin-right: auto;
        }
        .book-star{
            margin-left: auto;
            margin-right: auto;
        }
        .slide_recent_book{
            text-align: center;
        }



    
    </style>
    
    <!-- slick slide(옆으로 넘겨보기) 스크립트 코드 -->
    <script>
        $(function(){
            $('.myPage_recentView_carousel').slick({
                dots: true,
                infinite: false,
                speed: 300,
                slidesToShow: 4,
                slidesToScroll: 4,
                responsive: [
                    {
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3,
                        infinite: true,
                        dots: true
                    }
                    },
                    {
                    breakpoint: 600,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2
                    }
                    },
                    {
                    breakpoint: 480,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1
                    }
                    }
                    // You can unslick at a given breakpoint now by adding:
                    // settings: "unslick"
                    // instead of a settings object
                ]
            });
        })
    </script>
  
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
        
        <div id="content">
            <div id="content_3">
			     <div id="pageCategory_bar">
			        <a href="">🏠︎ HOME </a> > 마이페이지 > 최근 본 책
			    </div>
            		<%-- <%@ include file="../common/side_test1.jsp" %> --%>
            </div>
            <div id="content_1">
            	<%@ include file="../common/myPageSidebar.jsp" %>
            </div>
            <div id="content_2">    
 				               <div id="myPage_recent_view">


        <!-- 복사~~~~ -->
                                                                <!-- content따로 나눌거면 85% 사이드랑 바로 합칠거면 65%로 조정 -->
        <div id="wrap_myPage_recentView" style="height: 1000px; width:95%;">
            <h2 style="margin-left: 30px;">최근 본 책</h1>
            <hr>
            <div class="input-group mb-3 float-sm-right"  style="width: 300px;"> <!-- 부트스트랩 이용 검색창&우측정렬 -->
                <input type="text" class="form-control" placeholder="책 제목을 입력해주세요">
                <div class="input-group-append" >
                  <button class="btn" type="submit" style="background-color: rgb(120, 150, 50); color: white;">Go</button>
                </div>
              </div>
            <div id="myPage_recentView_content">
                <form action="" method="post">
                    
                    <div class="myPage_recentView_carousel"><!-- slick-slide 감싸는 div -->
              
                        <div class="slide_recent_book">
                            <img class="book-star" src="/resources/image/star-full.png" alt="">
                            <br>
                            <img class="book-img" src="/resources/image/bono.jpg" alt="" class="bookimg"><br>
                            모빌리티의 미래
                        </div>
                        <div class="slide_recent_book">
                            <img class="book-star" src="/resources/image/star-half.png" alt="">
                            <br>
                            <img class="book-img" src="/resources/image/bono.jpg" alt=""><br>
                            모빌리티의 미래
                        </div>
                        <div class="slide_recent_book">
                            <img class="book-star" src="/resources/image/star-empty.png" alt="">
                            <br>
                            <img class="book-img" src="/resources/image/bono.jpg" alt=""><br>
                            모빌리티의 미래
                        </div>
                        <div class="slide_recent_book">
                            <img class="book-star" src="/resources/image/star-full.png" alt="">
                            <br>
                            <img class="book-img" src="/resources/image/bono.jpg" alt=""><br>
                            모빌리티의 미래
                        </div>
                        <div class="slide_recent_book">
                            <img class="book-star" src="/resources/image/star-full.png" alt="">
                            <br>
                            <img class="book-img" src="/resources/image/bono.jpg" alt=""><br>
                            모빌리티의 미래
                        </div>

                    </div><!-- slick-slide 감싸는 div -->
    
                </form>

            </div>
        </div>
        <!-- 복사끝 -->


        
    </div> <!-- id="myPage_recent_view끝 -->        

            </div>
        </div>

</body>
</html>