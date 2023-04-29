<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	
<head>
	<!-- header Start -->
	<%@ include file="../inc/header_link.jsp" %>
	<!-- header End -->
</head>

<body>
    <!-- Spinner Start -->
    <%@ include file="../inc/spinner.jsp" %>
    <!-- Spinner End -->


    <!-- Topbar Start -->
    <%@ include file="../inc/topbar.jsp" %>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <%@ include file="../inc/navbar.jsp" %>
    <!-- Navbar End -->

	<!-- Main Start -->
	
    <!-- Banner Start -->
    <div class="container-fluid px-0 mb-5">
        <div id="header-carousel" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="w-100" src="../resources/client/img/carousel-1.jpg" alt="Image">
                    <div class="carousel-caption">
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-lg-8 text-start">
                                    <p class="fs-4 text-white">Welcome to our dairy farm</p>
                                    <h1 class="display-1 text-white mb-5 animated slideInRight">The Farm of Dairy products</h1>
                                    <a href="" class="btn btn-secondary rounded-pill py-3 px-5 animated slideInRight">Explore More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="w-100" src="../resources/client/img/carousel-2.jpg" alt="Image">
                    <div class="carousel-caption">
                        <div class="container">
                            <div class="row justify-content-end">
                                <div class="col-lg-8 text-end">
                                    <p class="fs-4 text-white">Welcome to our dairy farm</p>
                                    <h1 class="display-1 text-white mb-5 animated slideInRight">Best Organic Dairy Products</h1>
                                    <a href="" class="btn btn-secondary rounded-pill py-3 px-5 animated slideInLeft">Explore More</a>
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
    <!-- Banner End -->
    
    <!-- Main Start -->
	<div class="container-xxl py-5"  id="app1">
		<div class="container">
			<div class="text-center mx-auto pb-4 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 500px;">
				<p class="section-title bg-white text-center text-primary px-3">ECOECO</p>
				<a href="#"><h1 class="mb-5">진행중인 챌린지</a></h1>
			</div>
			
			<div class="row gx-4">
			
			<template v-for="json in challengeList">
				<card :key="json.challenge_idx" :obj="json"/>
			</template>  
			
			</div>
		</div>
	</div>
	<!-- Main End -->
	

    <!-- Footer Start -->
    <%@ include file="../inc/footer.jsp" %>
    <!-- Footer End -->


    <!-- Copyright Start -->
    <%@ include file="../inc/capyright.jsp" %>
    <!-- Copyright End -->


    <!-- Back to Top -->
    <%@ include file="../inc/back_to_top.jsp" %>

    <!-- Footer link Start -->
    <%@ include file="../inc/footer_link.jsp" %>
	<!-- Footer link Start -->
</body>
<script type="text/javascript">
	let app1;
	
	const card={
			template:`
				<div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.1s">
				<div class="product-item">
					<div class="position-relative">
						<img class="img-fluid" :src="'/resources/data/challenge/'+challenge.challenge_thumb">
						<div class="product-overlay">
							<a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href=""></a>
						</div>
					</div>
					<div class="text-center p-4" @click="getDetail(challenge)"><a href="#">
						<div><h6><span class="badge badge-pill badge-secondary">{{challenge.challengeType.challenge_type}}</span></h6></div>
						<div class="d-block h5" >{{challenge.challenge_title}}</div>
						<div><span class="text-primary me-1">{{challenge.challenge_startdate}} ~ {{challenge.challenge_enddate}}</span></div>
						</a>
					</div>	
				</div>
			</div>
			`,
			props:['obj'],
			data(){
				return{
					challenge:this.obj
				};
			},
			methods:{
				getDetail:function(challenge){
					//상세화면으로 이동
					location.href="/challenge/detail?challenge_idx="+challenge.challenge_idx;
				}
			}
	}
	
	app1=new Vue({
		el:"#app1",
		components:{
			card
		},
		data:{
			count:5,
			challengeList:[]
		}
	});
	
	/*--------------------------------------------------
		챌린지 목록 불러오기
	---------------------------------------------------*/
	function getList(){
		$.ajax({
			url:"/rest/challenge",
			type:"get",
			success:function(result, status, xhr){
				console.log("result is ", result.length);
				app1.challengeList=result;
			}
		});
	}
	
	$(function(){
		//챌린지 목록 불러오기
		getList();
		
	});
</script>
</html>