<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="../inc/header_link.jsp" %>
<style type="text/css">
body{
	margin:80px !important;
}
.box-style img{
	width:150px;
	height:100px;
}

</style>

</head>

<body>
	<div class="wrapper">
		<%@include file="../inc/navbar_final.jsp" %>

		<div class="main">
			<!-- navbar Start -->
			<%@include file="../inc/navbar.jsp" %>
			<!-- navbar End -->
			
			<!-- main Start -->
			<main class="content">
				<div class="col-12 grid-margin">
					<div class="card">
						<div class="card-body">
							<form id="app1">
							<div class="row">
									<div class="col-md-12" align="right">
										<button type="button" class="btn btn-primary" id="bt_regist">등록</button>
									</div>
								</div>	
								<h5 class="card-title mb-0">챌린지 등록</h5>
								<div class="row m-3">
									<div class="col-md-12">
										<table class="table table-hover">
											<thead>
												<tr>
													<th>No</th>
													<th>썸네일</th>
													<th>제목</th>
													<th>작성자</th>
													<th>작성일</th>
													<th>시작일 ~ 종료일</th>
													<th>상태</th>
												</tr>
											</thead>
											<tbody>

												<template v-for="json in challengeList">
													<row :key="json.challenge_idx" :obj="json"/>
												</template>

											</tbody>
										</table>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</main>
			<!-- main End -->
			
			<!-- footer Start -->
			<%@include file="../inc/footer.jsp" %>
			<!-- footer End -->
		</div>
	</div>
	
	<!-- footer_link Start -->
	<%@include file="../inc/footer_link.jsp" %>
	<!-- footer_link End -->
</body>
<script type="text/javascript">
	let app1;
	
	const row={
			template:`
				<tr>
		        	<td></td>
		        	<td class="box-style"><img :src="'/resources/data/challenge/'+challenge.challenge_thumb"></td>
		        	<td @click="getDetail(challenge)"><a href="#">{{challenge.challenge_title}}</a></td>
		        	<td>작성자</td>
		        	<td>{{challenge.challenge_regdate}}</td>
		        	<td>{{challenge.challenge_startdate}}~{{challenge.challenge_enddate}}</td>
		        	<td>{{challenge.challengeState.challenge_state}}</td>
		      	</tr>
			`,
			props:['obj'],
			data(){
				return{
					challenge:this.obj
				};
			},
			methods:{
				getDetail:function(challenge){
					//상세 화면으로 이동
					location.href="/admin/challenge/detail?challenge_idx="+challenge.challenge_idx;
				}
			}
	}
	
	app1=new Vue({
		el:"#app1",
		components:{
			row
		},
		data:{
			count:5,
			challengeList:[]
		}
	});
	
	/*----------------------------------------------------------
	문서가 로드되면
	[1] 서버로부터 게시물 목록을 가져온다 
	[2] 가져온 게시물 목록을 Vue의 data에  담아놓는다 
	[3] Vue의 data에 담겨진 게시물 목록 수만큼 반복을 돌면서 뷰의 컴포넌트(tr에 대한 사용자 정의 컴포넌트)를 생성한다
	     이때 컴포넌트에 하나의 게시물 정보가 들어있는 json 전달하고 key값도 결정해야 한다. 	     
	----------------------------------------------------------*/
	function getList(){
		$.ajax({
			url:"/admin/rest/challenge",
			type:"get",
			success:function(result, status, xhr){
				console.log(result);
				app1.challengeList=result;
			}
		});
	}
	
	$(function(){
		//목록 불러오기
		getList();
		
		//등록버튼에 이벤트 연결
		$("#bt_regist").click(function(){
			location.href="/admin/challenge/registform";
		});
	});
</script>
</html>