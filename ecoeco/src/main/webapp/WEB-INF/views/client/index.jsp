<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<!-- header_link Start -->
	<%@ include file="./inc/header_link.jsp" %>
	<!-- header_link End -->
</head>
<style>
#zzz {
	width: 800px;
	height: 600px;
}
#work {
	width: 800px;
	height: 600px;
}



</style>
<body>
    <!-- Spinner Start -->
    <%@ include file="./inc/spinner.jsp" %>
    <!-- Spinner End -->


    <!-- Topbar Start -->
    <%@ include file="./inc/topbar.jsp" %>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <%@ include file="./inc/navbar.jsp" %>
    <!-- Navbar End -->


    <!-- Carousel Start -->
    <div class="container-fluid px-0 mb-5">
        <div id="header-carousel" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="w-100" src="/resources/client/img/해양.jpg" alt="Image" id="zzz">
                    <div class="carousel-caption">
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-lg-8 text-start">
                                    <p class="fs-4 text-white">해양환경보호단체</p>
                                    <h1 class="display-1 text-white mb-5 animated slideInRight">위기의 바다를 함께 지켜주세요</h1>
                                    <!-- <a href="" class="btn btn-secondary rounded-pill py-3 px-5 animated slideInRight">Explore More</a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="w-100" src="/resources/client/img/나무.jpg" alt="Image"  id="work">
                    <div class="carousel-caption">
                        <div class="container">
                            <div class="row justify-content-end">
                                <div class="col-lg-8 text-end">
                                    <p class="fs-4 text-white">국제 나무의 날</p>
                                    <h1 class="display-1 text-white mb-5 animated slideInRight">함께하는 나무 심기</h1>
                                    <!-- <a href="" class="btn btn-secondary rounded-pill py-3 px-5 animated slideInLeft">Explore More</a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#header-carousel"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#header-carousel"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
    <!-- Carousel End -->



    <!-- Features Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-5 align-items-center">
                <div class="col-lg-12">
                    <div class="rounded overflow-hidden">
                        <div class="row g-0">
                            <div class="col-sm-3 wow fadeIn" data-wow-delay="0.1s">
                                <div class="text-center bg-primary py-5 px-4">
                                    <h1 class="display-6 text-white" data-toggle="counter-up">25</h1>
                                    <span class="fs-5 fw-semi-bold text-secondary">기부 참여</span>
                                </div>
                            </div>
                            <div class="col-sm-3 wow fadeIn" data-wow-delay="0.3s">
                                <div class="text-center bg-secondary py-5 px-4">
                                    <h1 class="display-6" data-toggle="counter-up">183</h1>
                                    <span class="fs-5 fw-semi-bold text-primary">기부 금액</span>
                                </div>
                            </div>
                            <div class="col-sm-3 wow fadeIn" data-wow-delay="0.7s">
                                <div class="text-center bg-primary py-5 px-4">
                                    <h1 class="display-6 text-white" data-toggle="counter-up">51940</h1>
                                    <span class="fs-5 fw-semi-bold text-secondary">펀딩 참여</span>
                                </div>
                            </div>
                            <div class="col-sm-3 wow fadeIn" data-wow-delay="0.5s">
                                <div class="text-center bg-secondary py-5 px-4">
                                    <h1 class="display-6" data-toggle="counter-up">2619</h1>
                                    <span class="fs-5 fw-semi-bold text-primary">펀딩 금액</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Features End -->



    <!-- 진행중인 후원 -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <p class="section-title bg-white text-center text-primary px-3">ECOECO</p>
                <a href="#"><h1 class="mb-5">진행중인 후원</h1></a>
            </div>
            <div class="row gx-4">
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="product-item">
                        <div class="position-relative" id="box">
                            <img class="img-fluid" src="/resources/client/img/두루미.jpg" alt="">
                            <div class="product-overlay">
                                <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">두루미를 지켜주세요</a>
                            <span class="text-primary me-1">두루미보호단체</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.3s">
                    <div class="product-item">
                        <div class="position-relative">
                            <img class="img-fluid" src="/resources/client/img/나무심기.jpg" alt="">
                            <div class="product-overlay">
                               <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">나무심기 운동</a>
                            <span class="text-primary me-1">한국환경연합</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="product-item">
                        <div class="position-relative">
                            <img class="img-fluid" src="/resources/client/img/야생벌.jpg" alt="">
                            <div class="product-overlay">
                              <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">야생벌을 구해주세요</a>
                            <span class="text-primary me-1">벌지킴이단체</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.7s">
                    <div class="product-item">
                        <div class="position-relative">
                            <img class="img-fluid" src="/resources/client/img/해양오염.jpg" alt="">
                            <div class="product-overlay">
                              <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">해양쓰레기 정리사업</a>
                            <span class="text-primary me-1">해양오염연합</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 진행중인 후원 -->



    <!-- 진행중인 챌린지 -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <p class="section-title bg-white text-center text-primary px-3">ECOECO</p>
                <a href="#"><h1 class="mb-5">진행중인 챌린지</h1></a>
            </div>
            <div class="row gx-4">
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="product-item">
                        <div class="position-relative">
                            <img class="img-fluid" src="/resources/client/img/메일비우기.jpg" alt="">
                            <div class="product-overlay">
                                <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">매일 메일 비우기~!</a>
                            <span class="text-primary me-1">환경지키미전</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.3s">
                    <div class="product-item">
                        <div class="position-relative">
                            <img class="img-fluid" src="/resources/client/img/분리수거.jpg" alt="">
                            <div class="product-overlay">
                               <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">길거리 쓰레기 줍기!</a>
                            <span class="text-primary me-1">줍줍이</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="product-item">
                        <div class="position-relative">
                            <img class="img-fluid" src="/resources/client/img/재활용.jpg" alt="">
                            <div class="product-overlay">
                              <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">재활용 챌린지</a>
                            <span class="text-primary me-1">용용이</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.7s">
                    <div class="product-item">
                        <div class="position-relative">
                            <img class="img-fluid" src="/resources/client/img/컵.jpg" alt="">
                            <div class="product-overlay">
                              <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">컵 사용 챌린지</a>
                            <span class="text-primary me-1">컵컵</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 진행중인 챌린지 -->



    <!-- 진행중인 나눔 -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <p class="section-title bg-white text-center text-primary px-3">ECOECO</p>
                <a href="#"><h1 class="mb-5">진행중인 나눔</h1></a>
            </div>
            <div class="row gx-4">
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="product-item">
                        <div class="position-relative">
                            <img class="img-fluid" src="/resources/client/img/자전거.jpg" alt="">
                            <div class="product-overlay">
                                <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">자전거 나눔</a>
                            <span class="text-primary me-1">따릉따릉이</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.3s">
                    <div class="product-item">
                        <div class="position-relative">
                            <img class="img-fluid" src="/resources/client/img/빨래.jpg" alt="">
                            <div class="product-overlay">
                               <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">친환경 세제 소분</a>
                            <span class="text-primary me-1">맑은날은세탁하는날</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="product-item">
                        <div class="position-relative">
                            <img class="img-fluid" src="/resources/client/img/아이옷.jpg" alt="">
                            <div class="product-overlay">
                              <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">큰애 옷 물려줄게요</a>
                            <span class="text-primary me-1">맑음</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.7s">
                    <div class="product-item">
                        <div class="position-relative">
                            <img class="img-fluid" src="/resources/client/img/책상.jpg" alt="">
                            <div class="product-overlay">
                              <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <a class="d-block h5" href="">책상 가져가세요</a>
                            <span class="text-primary me-1">이사가요</span>
                            <span class="text-decoration-line-through"></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 진행중인 나눔 -->
    
    
    
    <!-- 에코 지도 -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <p class="section-title bg-white text-center text-primary px-3">ECOECO</p>
                <a href="#"><h1 class="mb-5">에코 지도</h1></a>
            </div>
            
            <div class="row g-4" style="padding:10x;">
            	<!-- 목록 -->
	         	<div class="col-lg-6 col-md-6 wow fadeInUp" style="padding:10x" data-wow-delay="0.1s">
					<div class="card">
					<div class="card-header">
					<div class="input-group input-group-sm" style="width: 150px;">
					<input type="text" name="table_search" class="form-control float-right" placeholder="Search">
					<div class="input-group-append">
					<button type="submit" class="btn btn-default">
					<i class="fas fa-search"></i>
					</button>
					</div>
					</div>
					</div>
					<div class="card-body table-responsive p-0" style="height: 300px;">
					<table class="table table-head-fixed text-nowrap">
					<thead>
						<tr>
						<th>No</th>
						<th>상호명</th>
						<th>주소</th>
						<th>별점</th>
						<th>내용</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<td>1</td>
						<td>환경운동 </td>
						<td>서울 용산구 한강대로76길 7</td>
						<td><span class="tag tag-danger">5</span></td>
						<td>환경운동</td>
						</tr>
						<tr>
						<td>2</td>
						<td>용산나눔의집 </td>
						<td>서울 용산구 새마을로 47</td>
						<td><span class="tag tag-danger">4</span></td>
						<td>환경</td>
						</tr>
						<tr>
						<td>3</td>
						<td>용산구재활용센터</td>
						<td>서울 용산구 한강대로67길 22-20</td>
						<td><span class="tag tag-danger">4.5</span></td>
						<td>리사이클링</td>
						</tr>
						<tr>
						<td>4</td>
						<td>중고가전재활용센터 </td>
						<td>서울 용산구 효창원로 99</td>
						<td><span class="tag tag-danger">3</span></td>
						<td>재활용</td>
						</tr>
						<tr>
						<td>5</td>
						<td>(주)메트로리사이클링 </td>
						<td>서울 마포구 새창로 40</td>
						<td><span class="tag tag-danger">4</span></td>
						<td>리사이클링</td>
						</tr>
						<tr>
						<td>6</td>
						<td>원불교환경연대 </td>
						<td>서울 용산구 한강대로40가길 24</td>
						<td><span class="tag tag-danger">4.3</span></td>
						<td>연대</td>
						</tr>
					</tbody>
					</table>
					</div>
					</div>
					</div>
	            <!-- 목록 -->
	            
	            <!-- 지도 -->
	            <div class="col-lg-6 col-md-6 wow fadeInUp" style="padding:10x" data-wow-delay="0.1s">
	            <iframe class="w-100 rounded" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3001156.4288297426!2d-78.01371936852176!3d42.72876761954724!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4ccc4bf0f123a5a9%3A0xddcfc6c1de189567!2sNew%20York%2C%20USA!5e0!3m2!1sen!2sbd!4v1603794290143!5m2!1sen!2sbd" frameborder="0" style="min-height: 350px; border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
	            </div>
	            <!-- 지도 -->
            </div>
        </div>
    </div>
    <!-- 에코 지도 -->



    <!-- Footer Start -->
    <%@ include file="./inc/footer.jsp" %>
    <!-- Footer End -->


    <!-- Copyright Start -->
    <%@ include file="./inc/capyright.jsp" %>
    <!-- Copyright End -->


    <!-- Back to Top -->
    <%@ include file="./inc/back_to_top.jsp" %>

	<!-- JavaScript Libraries -->
    <%@ include file="./inc/footer_link.jsp" %>
    
    <script type="text/javascript">
    	$(function(){
    		$("#a_login").click(function(){
    			location.href = "/member/login";
    		});
    	});
    </script>
</body>

</html>