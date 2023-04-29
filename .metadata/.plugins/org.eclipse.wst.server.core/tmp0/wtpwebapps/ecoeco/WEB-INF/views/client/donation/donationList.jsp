<%@page import="com.friendly.eco.util.DateManager"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="java.util.Date"%>
<%@page import="com.friendly.eco.domain.Dcontents"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<title>진행중인 기부</title>

<head>
<!-- header_link Start -->
<%@ include file="../inc/header_link.jsp"%>
<!-- header_link End -->
	<!-- include libraries(jQuery, bootstrap) -->
<!-- <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">  -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> -->

<style>
#thumimg {
	width: 300px;
	height: 200px;
}

#sort {
	/* float: left; */
	float: right;
	width: 140px;
}

#contents {
	/* float: left; */
	margin: 10px;
	width: 300px;
	height: 300px;
}


</style>

</head>

<body>
	<!-- Spinner Start -->
	<%@ include file="../inc/spinner.jsp"%>
	<!-- Spinner End -->


	<!-- Topbar Start -->
	<%@ include file="../inc/topbar.jsp"%>
	<!-- Topbar End -->


	<!-- Navbar Start -->
	<%@ include file="../inc/navbar.jsp"%>
	<!-- Navbar End -->



	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1 class="display-3 text-white mb-4 animated slideInDown">기부</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center mb-0">
					<li class="breadcrumb-item"><a href="/donation/donationMain">진행중인
							기부</a></li>
					<li class="breadcrumb-item"><a href="/donation/postscriptMain">기부
							후기</a></li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->

	<!-- 진행중인 후원 -->
	<div class="container-xxl py-5">
		<div class="container">
			<!--검색하기-->
			<div class="row gx-4">
				<div align="right">
					<select id="sort" name="sort">
						<option value="0">최신 순</option>
						<option value="1">모집 금액 순</option>
						<option value="2">기부 참여자 순</option>
						<option value="3">종료 임박 순</option>
					</select>
				</div>
			</div>

			<p></p>

			<div class="row gx-4" >
				<form id="app1">
					<!-- 레코드 한 줄 -->
					<!-- RestChatterController에서 chatterServiceList에 담긴 만큼 반복-->
					<div class="row">
					<template v-for="(dcontents, i) in currentList">
						<donation :key="dcontents.dcontents_idx" :num="num-i"
							:obj="dcontents" />
					</template>
					</div>
					<!-- 레코드 한 줄 -->
				</form>
			</div>

			<div class="row gx-4" align="right">
				<!-- 페이징 처리 -->
				<div class="col-lg-11 grid-margin stretch-card" >
					<div class="dataTables_paginate paging_simple_numbers"
						id="zero_config_paginate" >
						<ul class="pagination" style="float: none; margin: 0 auto" >
							<li class="paginate_button page-item active" id="paging-area" >
								<!--넘버링들어올곳-->
							</li>
						</ul>
					</div>
				</div>
				<!-- 페이징 처리 -->
			</div>
		</div>
	</div>

	<!-- 진행중인 후원 -->



	<!-- Footer Start -->
	<%@ include file="../inc/footer.jsp"%>
	<!-- Footer End -->


	<!-- Copyright Start -->
	<%@ include file="../inc/capyright.jsp"%>
	<!-- Copyright End -->


	<!-- Back to Start -->
	<%@ include file="../inc/back_to_top.jsp"%>
	<!-- Back to End -->


	<!-- Footer link Start -->
	<%@ include file="../inc/footer_link.jsp"%>
	<!-- Footer link End -->

	<!-- -------------------------------------------------------------------------------- -->

	<script type="text/javascript" src="/resources/js/Pager.js"></script>
	<script type="text/javascript">

let pager = new Pager(); //인스턴스 생성
let currentPage=1;//현재 보고 있는 페이지

let dDay;

let app1;
let key=0;

function day(){
	let yy=(json.dcontents_endday).subString(0, 4);
	let mm=(json.dcontents_endday).subString(5, 6);
	let dd=(json.dcontents_endday).subString(7, 8);
	dDay=dateManager.dDay(2023, 03, 30);
}

const donation={
	template:`
        <div class="wow fadeInUp" data-wow-delay="0.1s" id="contents">
        <div class="product-item">
        <div class="position-relative">
        	<img class="img-fluid" :src="'/resources/data/donation/'+json.dcontents_thumimg" id="thumimg">
        <div class="product-overlay" id="product-overlay">
            <a href="#"><img src="/resources/client/img/LikeIcon.png" width="30" href="" ></a>
        </div>
	    </div>
	    <div class="text-center p-4">
	        <span class="text-primary me-1">17% 달성</span><span>모집된 금액</span><span id="dday"></span>
	        <a class="d-block h5" v-on:click="getDetail(json.dcontents_idx)">{{json.dcontents_title}}</a>
	        <span class="text">{{json.dcontents_writer}}</span>
	    </div>
	    </div>
	    </div>
	`,
	props:["obj", "num"], //props 오직 외부에서 전달되는 데이터 받기 위함
	data(){ //자바로 비유하면 인스턴스 변수영역 
		return{
			json:this.obj,
			n:this.num
		};
	},
	methods:{
		getDetail(idx){
			location.href="/donation/donationContent?dcontents_idx="+idx
		}
	}
};

app1=new Vue({
	el:"#app1",
	components:{
		donation
	},
	data:{
		count:5,
		dcontentsList:[], //전체배열
		currentList:[], //페이지당 보여질 배열
		num:0//페이지당 시작 번호를 뷰 컴포넌트에서 접근할 수 있도록...
	}
});

function pageLink(n){//원하는 페이지만 넘겨받기
	//서버에서 가져온 데이터를 대상으로 페이징 로직을 적용해보기
	pager.init(app1.dcontentsList, n);
	
	app1.num=pager.num;
	//넘겨받은 페이지 번호를 이용하여, 해당 페이지에 보여질 배열을 생성
	//currentList에 대입 (Vue의 변수인 currentList만 제어하면 디자인은 자동으로 변경)
	
	app1.currentList.splice(0, app1.currentList.length);//싹 비우고
	
	//채워넣기
	for(let i=pager.curPos; i<pager.curPos+pager.pageSize;i++){	
		//num이 1보다 작아지면 멈춤
		if(pager.num<1) break;
		pager.num--;
		
		//전체 배열에서, 일부 배열로 옮겨심기
		app1.currentList.push(app1.dcontentsList[i]);
		console.log("currentList는", app1.currentList);
	}
}

//서버에서 상품목록 가져오기
function getList(){
	$.ajax({
		url:"/rest/donationList?option_idx="+($('select[name=sort] option:selected').val()), 
		type:"get",
		success:function(result, status, xhr){
			//서버에서 가져온 json배열을 뷰의 템블릿이 바라보고 있는 productList에 대입하면 
			//디자인은 알아서 변경된다.(개발자는 데이터 제어에만 집중하면 된다, 디자인 신경 X)
			app1.dcontentsList=result;
			console.log(result);
			
			//pageLink(현재페이지); //페이징 처리 계산 수행
			pageLink(currentPage); //페이징 처리 계산 수행
			//프로그램 가동하자마자 현재 페이지는 ? currentPage
					
			//넘버링 출력(1~10, 11~20)
			
			for(let i=pager.firstPage;i<pager.lastPage;i++){
				if(i>pager.totalPage) break;//내가 가진 페이지수를 넘어서면 반복문 빠져나오기
				$("#paging-area").append("<a href='javascript:pageLink("+i+")' aria-controls='zero_config' data-dt-idx='1' tabindex='0' class='page-link'>"+i+"</a>")

			}
		}
		

		
	});
}

$(function(){
	//기부 리스트 가져오기
	getList();
	

});


</script>
</body>

</html>