<%@page import="com.friendly.eco.domain.Challenge"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	int challenger_idx = (Integer)request.getAttribute("challenger_idx");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="../inc/header_link.jsp"%>

<style type="text/css">
.input-group-append {
	cursor: pointer;
}

body{
	margin:80px !important;
}

.box-style{
	width:200px;
	height:200px;
	border:1px solid #ccc;
	display:inline-block;
	margin:5px;
}
.box-style img{
	width:200px;
	height:200px;
}
</style>
</head>

<body>
<div class="wrapper">
	<%@include file="../inc/navbar_final.jsp"%>

	<div class="main">
	<!-- navbar Start -->
	<%@include file="../inc/navbar.jsp"%>
	<!-- navbar End -->

	<!-- main Start -->
	<main class="content">
		<div class="col-12 grid-margin">
			<div class="card">
				<div class="card-body">
					<form id="form1">
						<div class="row m-3">
							<div class="col-md-12" align="right">
								<button type="button" class="btn btn-primary" id="bt_list">목록</button>
								<button type="button" class="btn btn-primary" id="bt_success">성공</button>
								<button type="button" class="btn btn-primary" id="bt_fail">실패</button>
							</div>
						</div>	
						<h5 class="card-title mb-0">챌린지 인증사진</h5>
												
						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-2 col-form-label">인증사진</label>
										<div class="col-sm-10">
										 <table class="table table-hover" id="app1">
										    <thead>
										      <tr>
										        <th><input type="checkbox"></th>
										        <th>No</th>
										        <th>인증사진</th>
										        <th>등록일</th>
										        <th>인증상태</th>
										      </tr>
										    </thead>
										    <tbody>
										    
										     	<template v-for="i in count">
										     		<photo_table/>
										     	</template>
										     	
										    </tbody>
										  </table>
										</div>
									</div>
								</div>
							</div>
							
					</form>
				</div>
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
</body>

<script type="text/javascript">
	let fileObj;  //등록 시 전송할 파일 
	let app1;
	
	const photo_table={
			template:`
			 <tr>
				<td><input type="checkbox" name="photo_status_idx" value=""></td>
		        <td>1</td>
		        <td>인증사진</td>
		        <td>2023-03-30</td>
		        <td>인증대기</td>
		      </tr>
			`,
			props:['obj'],
			data(){
				return{
					photo_status:this.obj
				}
			}
	}
	
	app1=new Vue({
		el:"#app1",
		components:{
			photo_table
		},
		data:{
			count:5,
			photoList:[]
		}
	});
	

	/*------------------------------------------
	인증처리 함수 정의
	------------------------------------------*/
	function setAuth(flag){
		if(confirm("선택하신 첼린지에 대한 인증상태를 변경하시겠어요?")){
			//서버로 요청 
			$("#form1").attr({
				action:"/admin/challenger/auth",
				method:"post"				
			});
		}
	}
	
	//선택한 챌린저 참여자의 사진 및 정보가져오기  
	function getList(){
		$.ajax({
			url:"/admin/rest/challenger/photo?challenger_idx=<%=challenger_idx%>",
			type:"GET", 
			success:function(result, status, xhr){
				console.log("result is ",result);
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
		
		getList(); //첼린저 참여사진 리스트 
	});
</script>