<%@page import="com.friendly.eco.util.FormatCurrency"%>
<%@page import="java.util.List"%>
<%@page import="com.friendly.eco.domain.ChallengeType"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<ChallengeType> challengeTypeList=(List)request.getAttribute("challengeTypeList");
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
										<button type="button" class="btn btn-primary" id="bt_regist">등록</button>
										<button type="button" class="btn btn-primary" id="bt_list">목록</button>
										<button type="button" class="btn btn-primary" id="bt_save">임시저장</button>
									</div>
								</div>	
								<h5 class="card-title mb-0">챌린지 등록</h5>
								
								<div class="row m-3">
									<div class="col-md-12">
										<div class="row form-group">
											<label class="col-sm-3 col-form-label">챌린지 제목</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="challenge_title" placeholder="예) 텀블러 사용하기">
											</div>
										</div>
									</div>
								</div>
								
								<div class="row m-3">
									<div class="col-md-12">
										<div class="row form-group">
											<label class="col-sm-3 col-form-label">챌린지 종류 선택</label>
											<%for(ChallengeType challengeType : challengeTypeList){ %>
											<div class="col-sm-2">
												<div class="form-check">
													<label class="form-check-label">
													<input type="radio" class="form-check-input" name="challengeType.challenge_type_idx" value="<%=challengeType.getChallenge_type_idx() %>"> <%=challengeType.getChallenge_type()%></label>
												</div>
											</div>
											<%} %>
										</div>
									</div>
								</div>

								<div class="row m-3">
									<div class="col-md-12">
										<div class="row form-group">
											<label class="col-sm-3 col-form-label">썸네일 등록</label>
											<div class="col-sm-9">
												<input type="file" class="form-control" name="file" id="file">
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
													<img name="challenge_thumb" id="challenge_thumb"/>
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
													<input type="date" class="form-control"  id="challenge_startdate" name="challenge_startdate"/> 
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
													<input type="date" class="form-control"  id="challenge_enddate" name="challenge_enddate"/> 
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="row m-3">
									<div class="col-md-12">
										<div class="row form-group">
											<label class="col-sm-3 col-form-label">인증 횟수</label>
											<%for(int i=1;i<=6;i++){ %>
											<div class="col-sm-2">
												<label class="form-check form-check-inline">
								            	<input class="form-check-input" type="radio" name="challenge_req" value="<%=i %>">
								            	<span class="form-check-label">주 <%=i %>회</span></label>
											</div>
											<%} %>
											<div class="col-sm-2">
												<label class="form-check form-check-inline">
								            	<input class="form-check-input" type="radio" name="challenge_req" value="7">
								            	<span class="form-check-label">매일</span></label>
											</div>
										</div>
									</div>
								</div>
								
								<div class="row m-3">
									<div class="col-md-12">
										<div class="row form-group">
											<label class="col-sm-3 col-form-label">챌린지 소개</label>
											<div class="col-sm-9">
												<textarea type="text" class="form-control" name="challenge_detail"></textarea>
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
												<input type="number" class="form-control" name="challenge_point">
											</div>
										</div>
									</div>
								</div>
								
								<div class="row m-3">
									<div class="col-md-12">
										<div class="row form-group">
											<label class="col-sm-3 col-form-label">참가비</label>
												<div class="col-sm-3">
													<input type="number" class="form-control"  id="challenge_fee_min" name="challenge_fee_min" placeholder="0부터"/> 
												</div>
												<div class="col-sm-3">
													<input type="number" class="form-control"  id="challenge_fee_max" name="challenge_fee_max" placeholder="~까지"/> 
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
	let key=0;
	
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
		등록하기
	------------------------------------------*/
	function regist() {
		let formData = new FormData();
		
		formData.append("challenge_title", $("input[name='challenge_title']").val());
		formData.append("challengeType.challenge_type_idx", $("input[name='challengeType.challenge_type_idx']:checked").val());  //체크된 값 넘기기
		formData.append("file", fileObj);  //파일 자체 전송
		formData.append("challenge_thumb", $("input[name='challenge_thumb']").val());  //파일  이름
		formData.append("challenge_startdate", $("input[name='challenge_startdate']").val());
		formData.append("challenge_enddate", $("input[name='challenge_enddate']").val());
		formData.append("challenge_req", $("input[name='challenge_req']").val());
		formData.append("challenge_detail", $("textarea[name='challenge_detail']").val());
		formData.append("challenge_point", $("input[name='challenge_point']").val());
		formData.append("challenge_fee_min", $("input[name='challenge_fee_min']").val());
		formData.append("challenge_fee_max", $("input[name='challenge_fee_max']").val());
		
		  
		$.ajax({
			url:"/admin/rest/challenge",
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			success:function(result, status, xhr) {
				console.log(result.msg);
			}
		});
		location.href="/admin/challenge/list";
	}
	
	$(function(){
		//달력 불러오기
		//$("#challenge_startdate").datepicker();
		//$("#challenge_enddate").datepicker();
		limitDate();  //달력 날짜 제한
		
		//파일편집기에 이벤트 연결
		$("#file").change(function(){
			//alert("");
			console.log(this.files);
			preview(this.files[0]);  //썸네일 미리보기
		});
		
		//등록버튼에 이벤트 연결
		$("#bt_regist").click(function(){
			calendarValidation();
			regist();
		});
		
		//목록 버튼에 이벤트 연결
		$("#bt_list").click(function(){
			location.href="/admin/challenge/list";
		});
		
		//써머노트 적용하기
		$("textarea[name='challenge_detail']").summernote({
			  placeholder: '예) 매일 텀블러 사용하고 환경 지키기! 오늘부터 같이 해봐요! :)',
			  tabsize: 2,
			  height: 300
		});
	});
</script>