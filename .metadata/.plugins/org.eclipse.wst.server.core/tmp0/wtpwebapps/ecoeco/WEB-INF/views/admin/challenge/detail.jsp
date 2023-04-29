<%@page import="java.util.List"%>
<%@page import="com.friendly.eco.util.FormatCurrency"%>
<%@page import="com.friendly.eco.domain.Challenge"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Challenge challenge=(Challenge)request.getAttribute("challenge");
	int mem_deposit=(Integer)request.getAttribute("mem_deposit");
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
								<button type="button" class="btn btn-primary" id="bt_del">삭제</button>
								<button type="button" class="btn btn-primary" id="bt_edit">수정</button>
								<button type="button" class="btn btn-primary" id="bt_list">목록</button>
							</div>
						</div>	
						<h5 class="card-title mb-0">챌린지 등록</h5>
						
						<!-- 챌린지 상세보기 -->
						<input type="hidden" name="challenge_idx" value="<%=challenge.getChallenge_idx() %>">
						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">챌린지 제목</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" name="challenge_title" value="<%=challenge.getChallenge_title()%>">
									</div>
								</div>
							</div>
						</div>
						
						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">챌린지 종류 선택</label>
									<div class="col-sm-4">
										<div class="form-check">
											<label class="form-check-label">
											<input type="radio" class="form-check-input" name="chanllenge_type" checked></label>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">썸네일 등록</label>
									<div class="col-sm-9">
									<input type="file" class="form-control" id="file" name="file">
									</div>
								</div>
							</div>
						</div>
						
						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">썸네일 미리보기</label>
									<div class="col-sm-9">
										<div class="box-style">
											<img id="file" name="file" src="/resources/data/challenge/<%=challenge.getChallenge_thumb() %>">
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">챌린지 시작날짜</label>
									<div class="col-sm-9">
										<div class="input-group date">
											<input type="text" class="form-control"  id="challenge_startdate" name="challenge_startdate" value="<%=challenge.getChallenge_startdate()%>"/> 
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">챌린지 종료날짜</label>
									<div class="col-sm-9">
										<div class="input-group date">
											<input type="text" class="form-control"  id="challenge_enddate" name="challenge_enddate" value="<%=challenge.getChallenge_enddate()%>"/> 
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">인증 횟수</label>
									<div class="col-sm-2">
						            	<input class="form-check-input" type="radio" name="challenge_req" value="<%=challenge.getChallenge_req() %>" checked>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">챌린지 소개</label>
									<div class="col-sm-9">
										<textarea class="form-control" name="challenge_detail"><%=challenge.getChallenge_detail() %></textarea>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">챌린지 예산</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" value="<%=FormatCurrency.getCurrency(mem_deposit)%>" disabled>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">챌린지 지급 포인트</label>
									<div class="col-sm-9">
										<input type="number" class="form-control" name="challenge_point" value="<%=challenge.getChallenge_point() %>"/>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">참가비</label>
										<div class="col-sm-3">
											<input type="number" class="form-control"  id="challenge_fee_min" name="challenge_fee_min" value="<%=challenge.getChallenge_fee_min() %>"/> 
										</div>
										<div class="col-sm-3">
											<input type="number" class="form-control"  id="challenge_fee_max" name="challenge_fee_max" value="<%=challenge.getChallenge_fee_max() %>"/> 
										</div>
									</div>
								</div>
							</div>
							
						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">참여자 명단</label>
										<div class="col-sm-9">
										 <table class="table table-hover" id="app1">
										    <thead>
										      <tr>
										        <th>No</th>
										        <th>참여자</th>
										        <th>참여비</th>
										        <th>인증여부</th>
										      </tr>
										    </thead>
										    <tbody>
										    
										     	<template v-for="json in challengerList">
										     		<auth_table :key="json.challenger_idx" :obj="json"/>
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
	
	const auth_table={
			template:`
			 <tr>
		        <td>1</td>
		        <td @click="getDetail(challenger)"><a href="#">{{challenger.mem.mem_id}}</a></td>
		        <td>{{challenger.challenge_fee}}</td>
		        <td>{{challenger.challConf.chall_conf}}</td>
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
					location.href="/admin/challenger/challConf?challenger_idx="+challenger.challenger_idx;
				}
			}
	}
	
	app1=new Vue({
		el:"#app1",
		components:{
			auth_table
		},
		data:{
			count:5,
			challengerList:[]
		}
	});
	

	/*------------------------------------------
	달력 날짜 제한
	------------------------------------------*/
	function limitDate(){
		var start_date = $("#challenge_startdate").val();
		
		
		var now_utc = Date.now()
	    var timeOff = new Date().getTimezoneOffset()*60000;
		var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
		var selected = new Date().toISOString().split("T")[0];
		var now= new Date();
	 	var last = new Date(2023,now.getMonth()+1, 0);
	    var lastDate= last.toISOString().split("T")[0];
	
		document.getElementById("challenge_startdate").setAttribute("min", today);
	    document.getElementById("challenge_enddate").setAttribute("min", selected);
	    
	}
	
	/*------------------------------------------
		달력 유효성 검증
	------------------------------------------*/
	function calendarValidation() {
	   var start_date = $("#challenge_startdate").val();
	   var end_date = $("#challenge_enddate").val();
	   
	   console.log("start_date is ", start_date);
		
	   //내용 입력 여부 확인
	   if (start_date == "" || end_date == "") {
		   alert("날짜를 입력하세요.");
	   } else if (new Date(end_date) - new Date(start_date) < 0) {
		   alert("종료일이 시작일보다 먼저입니다.");
	   } 
	}

	/*------------------------------------------
		썸네일 미리보기
	------------------------------------------*/
	function preview(file){
		fileObj=file;  //파일을 전역변수에 대입, 다른 함수에서 사용하기 위해
		let reader=new FileReader();  //스트림 생성
		reader.onload=(e)=> {
			console.log(e.target.result);
			//file=e.target.result;  //src에 대입할 바이너리 정보
			
			key++;
			
			let json=[];
			json['key']=key;  //기준값
			json['binary']=e.target.result;  //src에 대입할 바이너리 정보
			json['file']=file;  //전송할 때 파라미터에 심을 파일
			
			console.log("json is ", json);
			
			$("#challenge_thumb").attr("src", json.binary);
		}
		reader.readAsDataURL(file);  //파일 읽기
	}
	
	
	/*------------------------------------------
		삭제 요청 - 동기 방식
	------------------------------------------*/
	function del(){
		//삭제 확인하기
		if (!confirm("삭제하시겠습니까?")) {
			return; 
		}
		location.href="/admin/challenge/delete/"+$("input[name='challenge_idx']").val();
	}
	
	/*------------------------------------------
		수정 요청 - 비동기 방식
	------------------------------------------*/
	function edit(){
		//수정 확인하기
		if (!confirm("수정하시겠습니까?")) {
			return; 
		}
		
		//전송데이터를 ajax 형식으로 전송
		let json={};
		json['challenge_idx']=$("input[name='challenge_idx']").val();
		
		$.ajax({
			url:"/admin/rest/challenge",
			type:"PUT",
			success:function(result, status, xhr){
				console.log(result);
			}
		});
	}
	
	/*------------------------------------------
		참여자 명단 가져오기
	------------------------------------------*/
	function getList(){
		$.ajax({
			url:"/admin/rest/challenger/<%=challenge.getChallenge_idx()%>",
			type:"get",
			success:function(result, status, xhr){
				console.log("challengerList is ", result);
				app1.challengerList=result;
			}
		});
		
	}
	
	$(function(){
		getList();  //참여자 명단 가져오기
		
		//달력 불러오기
		//$("#challenge_startdate").datepicker();
		//$("#challenge_enddate").datepicker();
		limitDate();  //달력 날짜 제한
		
		//파일편집기에 이벤트 연결
		$("#file").change(function(){
			console.log(this.files);
			preview(this.files[0]);  //썸네일 미리보기
		});
		
		
		//삭제 버튼에 이벤트 연결
		$("#bt_del").click(function(){
			del();
		});
		
		//수정 버튼에 이벤트 연결
		$("#bt_edit").click(function(){
			edit();
		});
		
		//목록 버튼에 이벤트 연결
		$("#bt_list").click(function(){
			location.href="/admin/challenge/list";
		});
		
		//써머노트 적용하기
		$("textarea[name='challenge_detail']").summernote({
			  placeholder: '예) 매일 텀블러 사용하고 환경 지키기! 오늘부터 같이 해봐요! :)',
			  tabsize: 2,
			  height: 100
		});
	});
</script>