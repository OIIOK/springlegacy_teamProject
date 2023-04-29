<%@page import="com.friendly.eco.domain.Dcontents"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//회원과 연결된 리스트 가져오기-수정예정
//List<Dcontents> dcontentsList = (List)request.getAttribute("dcontentsList");
%>
<!DOCTYPE html>
<html lang="en">
<title>기부글 리스트</title>

<head>
<link href="/resources/client/css/app.css" rel="stylesheet">
<link href="/resources/client/css/app.css.map" rel="stylesheet">

<!-- header_link Start -->
<%@ include file="../inc/header_link.jsp"%>
<!-- header_link End -->

</head>

<style>
#container {
	display: flex;
	font-family: Georgia, "맑은 고딕", serif;
}

#mincon {
	display: flex;
	text-align: center;
	font-size: 10px;
}

#con2 {
	width: 400px;
	height: 200px;
}

#con3 {
	width: 200px;
	height: 200px;
}

#titlecon {
	height: 200px;
	text-align: center;
}

#bigcon {
	display: flex;
}

#img {
	width: 85px;
}

#challengebox {
	width: 750px;
	height: 200px;
}

#background {
	background-color: #5B8C51;
}

#button css {
	display: flex;
	justify-content: space-between;
}

h2, h3, h5, p {
	font-family: "open sans";
}

#paging-area {
	text-align: center;
	float: none;
}

#title {
	margin: 10px;
}
</style>

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

	<div class="container" id="container">
		<div class="row">

			<div class="col-3">
				<!-- mypage_sidebar Start -->
				<%@ include file="../inc/mypage_sidebar.jsp"%>
				<!-- mypage_sidebar End -->
			</div>

			<div class="col-9">
				<div class="row" style="padding: 0 0 25px 0">
					<form id="app1">
						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
								<h5 id="title">기부글 리스트</h5>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-hover"
											style="vertical-align: center">
											<thead>
												<tr>
													<th>No.</th>
													<th>제목</th>
													<th>작성일</th>
													<th>기부 시작일</th>
													<th>기부 종료일</th>
													<th>승인여부</th>
												</tr>
											</thead>
											<tbody>
												<!-- 레코드 한 줄 -->
												<!-- RestChatterController에서 chatterServiceList에 담긴 만큼 반복-->
												<template v-for="(dcontents, i) in currentList">
													<dcontents :key="dcontents.dcontents_idx" :num="num-i"
														:obj="dcontents" />
												</template>
												<!-- 레코드 한 줄 -->
											</tbody>
										</table>
										<!--페이징-->
										<div class="row">
											<div class="col-1" id="paging-area" align="center"></div>
										</div>

									</div>
									<div class="row">
										<div class="col-md-12" align="right">
											<button type="button" class="btn btn-secondary"
												id="bt_regist">등록</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>

			</div>
			<!-- 표 -->

			<!-- 마지막 줄 -->
			<div class="container" style="padding: 0 0 50px 0">
				<div class="row"></div>
			</div>
			<!-- 마지막 줄 -->
		</div>
	</div>
	<!-- main end -->
	</div>
	</div>


	<!-- Footer Start -->
	<%@ include file="../inc/footer.jsp"%>
	<!-- Footer End -->


	<!-- Copyright Start -->
	<%@ include file="../inc/capyright.jsp"%>
	<!-- Copyright End -->


	<!-- Back to Top -->
	<%@ include file="../inc/back_to_top.jsp"%>

	<!-- Footer link Start -->
	<%@ include file="../inc/footer_link.jsp"%>
	<!-- include libraries(jQuery, bootstrap) -->
	<link
		href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
		rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	<!-- include summernote css/js -->
	<link
		href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
		rel="stylesheet">
	<script
		src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

	<!-- Footer link Start -->
	<script type="text/javascript" src="/resources/js/Pager.js"></script>
	<script type="text/javascript">
let pager = new Pager(); //인스턴스 생성
pager.pageSize=20;
let currentPage=1;//현재 보고 있는 페이지
let app1;
let key=0;

const dcontents={
	template:`
        <tr>
            <td>{{n}}</td>
            <td v-on:click="getDetail(json.dcontents_idx)">{{json.dcontents_title}}</td>
            <td>{{(json.dcontents_date).substring(0, 10)}}</td>
            <td>{{json.dcontents_startday}}</td>
            <td>{{json.dcontents_endday}}</td>
            <td>{{json.dcontents_app}}</td>
    	</tr>
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
			location.href="/donation/detail?dcontents_idx="+idx
		}
	}
};
app1=new Vue({
	el:"#app1",
	components:{
		dcontents
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
		url:"/rest/contentsList",
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
				$("#paging-area").append("<a href='javascript:pageLink("+i+")' style='margin:3px'>"+i+"</a>")
			}
		}
	});
}
$(function(){
	//등록 이벤트 연결 
	$("#bt_regist").click(function(){
		location.href="/donation/registForm";
	});
	
	getList();
	
});
</script>
</body>

</html>