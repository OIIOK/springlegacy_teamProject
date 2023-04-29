<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="../inc/header_link.jsp"%>
</head>
<style>
#search_icon{
	width: 20px;
	height: 20px;
}


</style>
<body>
	<div class="wrapper">
		<%@include file="../inc/navbar_final.jsp"%>

		<div class="main">
			<!-- navbar Start -->
			<%@include file="../inc/navbar.jsp"%>
			<!-- navbar End -->

			<!-- main Start -->
			<main class="content">
			
					<!-- 표  -->
					<div class="container">
						<div class="row" style="padding: 0 0 25px 0">
							<div class="input-group mb-1" id="div_id_input">
								<div class="input-group-prepend">
									<span class="input-group-text">
										<img src="/resources/client/img/search.png" id="search_icon">
									</span>
								</div>
								<input type="text" class="form-control" id="search" placeholder="검색어를 입력해주세요" name="search" required>
							</div>
						</div>

						<div class="row" style="padding: 0 0 25px 0">
							<form id="form1">
								<div class="col-lg-12 grid-margin stretch-card">
									<div class="card">
										<div class="card-body">
											<div class="table-responsive">
												<table class="table table-hover"
													style="vertical-align: middle">
													<thead>
														<tr>
															<th>No.</th>
															<th>섬네일</th>
															<th>제목</th>
															<th>작성자</th>
															<th>등록일</th>
															<th>승인여부</th>
														</tr>
													</thead>
													<tbody>
														<!-- 레코드 한 줄 -->
														<!-- RestChatterController에서 chatterServiceList에 담긴 만큼 반복-->
														<template v-for="json in chatterList">
															<row :key="json.chatter_idx" :obj="json" />
														</template>
														<!-- 레코드 한 줄 -->
													</tbody>
													
													
												</table>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
			</main>
			<!-- main End -->

			<!-- footer Start -->
			<%@include file="../inc/footer.jsp"%>
			<!-- footer End -->
		</div>
	</div>

	<!-- footer_link Start -->
	<%@include file="../inc/footer_link.jsp"%>
	<!-- footer_link End -->
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
        <div class="col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.1s" id="contents" align="center">
        <div class="product-item">
        <div class="position-relative">
        	<img class="img-fluid" :src="'/resources/data/donation/'+json.dcontents_thumimg" id="thumimg">
        <div class="product-overlay">
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
</body>


</html>