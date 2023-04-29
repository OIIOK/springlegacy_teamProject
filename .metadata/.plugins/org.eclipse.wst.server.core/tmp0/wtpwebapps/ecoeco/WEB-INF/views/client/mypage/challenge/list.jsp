<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<link href="/resources/admin/main/css/app.css" rel="stylesheet">
<link href="/resources/admin/main/css/app.css.map" rel="stylesheet">

<!-- header_link Start -->
<%@ include file="../../inc/header_link.jsp"%>
<!-- header_link End -->

</head>
<style type="text/css">
body{
	margin:80px !important;
}
.box-style img{
	width:150px;
	height:100px;
}

</style>

<body>
	<!-- Spinner Start -->
	<%@ include file="../../inc/spinner.jsp"%>
	<!-- Spinner End -->


	<!-- Topbar Start -->
	<%@ include file="../../inc/topbar.jsp"%>
	<!-- Topbar End -->


	<!-- Navbar Start -->
	<%@ include file="../../inc/navbar.jsp"%>
	<!-- Navbar End -->

	<div class="container" id="container">
		<div class="col-3">
			<!-- mypage_sidebar Start -->
			<%@ include file="../../inc/mypage_sidebar.jsp"%>
			<!-- mypage_sidebar End -->
		</div>

	<!-- main start -->
	<main class="content">
		<div class="col-12 grid-margin">
			<div class="card">
				<div class="card-body">
					<form id="form1">
						<h5 class="card-title mb-0">챌린지 목록</h5>

							<div class="row form-group m-3">
								<div class="col-md-12">
									<div class="col-sm-12">
										<table class="table table-hover" id="app1">
											<thead>
												<tr>
													<th>No</th>
													<th>썸네일</th>
													<th>제목</th>
													<th>인증횟수</th>
													<th>참여기간</th>
													<th>챌린지 현황</th>
												</tr>
											</thead>
											<tbody>

												<template v-for="json in challengerList">
													<challenger_list :key="json.challenger_idx" :obj="json"/>
												</template>

											</tbody>
										</table>
									</div>
								</div>
							</div>

						</form>
				</div>
			</div>
		</div>
	</main>
	</div>
	<!-- main end -->


	<!-- Footer Start -->
	<%@ include file="../../inc/footer.jsp"%>
	<!-- Footer End -->


	<!-- Copyright Start -->
	<%@ include file="../../inc/capyright.jsp"%>
	<!-- Copyright End -->


	<!-- Back to Top -->
	<%@ include file="../../inc/back_to_top.jsp"%>

	<!-- Footer link Start -->
    <%@ include file="../../inc/footer_link.jsp" %>
	<!-- Footer link Start -->
</body>
<script type="text/javascript">
	let app1;
	
	const challenger_list={
			template:`
			 <tr>
		        <td>1</td>
		        <td class="box-style"><img :src="'/resources/data/challenge/'+challenger.challenge.challenge_thumb"></td>
		        <td @click="getDetail(challenger)"><a href="#">{{challenger.challenge.challenge_title}}</a></td>
		        <td>{{challenger.challenge.challenge_req}}</td>
		        <td>{{challenger.challenge.challenge_startdate}} ~ {{challenger.challenge.challenge_enddate}}</td>
		        <td>{{challenger.challenge.challengeState.challenge_state}}</td>
		      </tr>
			`,
			props:['obj'],
			data(){
				return{
					challenger:this.obj
				}
			},
			methods:{
				getDetail:function(challenger){
					//상세 화면으로 이동
					location.href="/mypage/challenge/detail?challenger_idx="+challenger.challenger_idx;
				}
			}
	}
	
	app1=new Vue({
		el:"#app1",
		components:{
			challenger_list
		},
		data:{
			count:5,
			challengerList:[]
		}
	});
	
	
	//참여한 챌린지 목록 보여주기
	function getList(){
		$.ajax({
			url:"/rest/mypage/challenge",
			type:"get",
			success:function(result, status, xhr){
				console.log(result);
				app1.challengerList=result;
			}
		});
	}
	
	$(function(){
		//성공 버튼에 이벤트 연결
		$("#bt_success").click(function(){
			setAuth("success");
		});
		
		//실패 버튼에 이벤트 연결
		$("#bt_fail").click(function(){
			setAuth("fail");
		});
		
		//목록 버튼에 이벤트 연결
		$("#bt_list").click(function(){
			location.href="/admin/challenge/list";
		});
		
		getList();  //참여한 챌린지 목록 보여주기
	});
</script>

</html>