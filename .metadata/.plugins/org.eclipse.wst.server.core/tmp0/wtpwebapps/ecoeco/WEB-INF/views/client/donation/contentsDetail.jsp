<%@page import="java.time.LocalDate"%>
<%@page import="com.friendly.eco.util.DateManager"%>
<%@page import="com.friendly.eco.domain.Dcontents"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Dcontents dcontents=(Dcontents)request.getAttribute("dcontents");
%>
<!DOCTYPE html>
<html lang="en">
<title>기부글 상세보기</title>
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
.box-style{
	width:150px;
	height:150px;
	border:1px solid #ccc;
}

.box-style img{
	width:150px;
	height:150px;
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
			<!-- main start -->
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">

				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<section class="content" id="app1">
				<div class="container-fluid">
		
					<!-- Main row -->
					
						<div class="col">
							<h5 class="card-title mb-0">기부글 등록</h5>
							
							<input type="hidden" class="form-control" name="mem_idx" placeholder="제목을 입력하세요" value="<%=dcontents.getDcontents_idx()%>">
							<input type="hidden" class="form-control" name="dcontents_idx" placeholder="제목을 입력하세요" value="<%=dcontents.getDcontents_idx()%>">
							
							<!--제목-->	
							<div class="form-group row">
								<div class="col">
									<label class="col-sm-2 col-form-label">제목</label>
									<input type="text" class="form-control" name="dcontents_title" placeholder="제목을 입력하세요" value="<%=dcontents.getDcontents_title()%>">
								</div>
							</div>		
							
							<!--작성자 : 나중에는 불러와서 자동 채우기-->
							<div class="form-group row">
								<div class="col">
									<label class="col-sm-2 col-form-label">작성자</label>
									<input type="text" class="form-control" name="dcontents_writer" placeholder="작성자 자동 세팅 예정">
								</div>
							</div>	
																
						<!--썸네일 이미지-->			
							<div class="form-group row">
								<div class="col">
									<label class="col-sm-2 col-form-label">썸네일 이미지</label>
									<input type="file" class="form-control" id="dcontents_file" name="dcontents_file" >
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col">
									<label class="col-sm-2 col-form-label">미리보기</label>
									<div class="box-style" id="style-box">
										<img id="dcontents_thumimg" name="dcontents_thumimg" src="/resources/data/donation/<%=dcontents.getDcontents_thumimg()%>"/>
									</div>
								</div>
							</div>
																						
						<!--모집금액-->					
							<div class="form-group row">
								<div class="col">
									<label class="col-sm-2 col-form-label">모집금액</label>
									<input type="number" class="form-control" name="dcontents_amount" placeholder="ex) 100000" value="<%=dcontents.getDcontents_amount()%>">
								</div>
							</div>					
							<p></p>													
							<div class="form-group row">
								<div class="col input-group date">
									<label class="col-sm-2 col-form-label">시작일</label>
									<input type="text" class="form-control" name="dcontents_startday" id="dcontents_startday" style=width:550px placeholder="ex) 20230327" value="<%=dcontents.getDcontents_startday()%>">
								</div>
								<p></p>	
								<div class="col input-group date">
									<label class="col-sm-2 col-form-label">종료일</label>
									<input type="text" class="form-control" name="dcontents_endday" id="dcontents_endday" style=width:550px placeholder="ex) 20230427" value="<%=dcontents.getDcontents_endday()%>">
								</div>
							</div>	
							<p></p>						
							<!--상세내용-->
							<!--써머노트 적용하기-->
							<div class="form-group row">
								<div class="col">
									<label class="col-sm-3 col-form-label">소개글</label>
									<textarea id="summernote" name="dcontents_detail" id="dcontents_detail">
									<%=dcontents.getDcontents_detail()%>
									</textarea>
								</div>
							</div>
																						
							<div class="form-group row">
							
								<div class="col" align="left">
									<button type="button" class="btn btn-primary" id="bt_dpostscript">기부후기</button>
									<button type="button" class="btn btn-primary" id="bt_duse">기부내역</button>
								</div>
								
								<div class="col" align="right">
													
									<button type="button" class="btn btn-primary" id="bt_edit">수정</button>
																	
									<button type="button" class="btn btn-primary" id="bt_list">목록</button>								
								</div>
							</div>							
							
						</div>
					</div>
					<!-- /.row (main row) -->
				</div>
				
				<!-- /.container-fluid -->
			
			</section>
			<!-- /.content -->
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
    <%@ include file="../inc/footer_link.jsp" %>

	<!-- Footer link Start -->
<script type="text/javascript">

let fileObj;  //등록 시 전송할 파일 

/*------------------------------------------
	썸네일 미리보기
------------------------------------------*/

function preview(file){
	
	//선택한 첫번째 파일[0]을 file로 끌어옴
	fileObj = file;
	console.log("fileObj 정보 : ",fileObj); //[object File]
	
	let reader = new FileReader(); //스트림 생성
	//로드되면 가동됨
	reader.onload=(e)=>{
		console.log("선택한 파일의 바이너리 정보 : "+e.target.result); 
		file=e.target.result;
		//attr : 속성값을 가져옴 / src는 지어준 이름
		console.log("preview에서 dcontents_thumimg : "+$("img[name='dcontents_thumimg']"));
		$("img[name='dcontents_thumimg']").attr("src",file);
	}
	reader.readAsDataURL(file);  //URL로 파일 읽어서 미리보여줌
}

//등록하기
function regist(){
	let formData = new FormData();
	//입력값 받기
	//전송 대상에 이미지가 포함되니 formData 사용해야 함
	//formData.append("mem.mem_idx", $("로그인시확인되는아이디").val());
	//formData.append("mem.mem_idx", 1);
	formData.append("dcontents_title", $("input[name='dcontents_title']").val());
	formData.append("dcontents_writer", $("input[name='dcontents_writer']").val());
	formData.append("dcontents_file", fileObj);  //파일 자체 전송
	formData.append("dcontents_thumimg", $("img[name='dcontents_thumimg']").val());
	formData.append("dcontents_amount", $("input[name='dcontents_amount']").val());
	formData.append("dcontents_startday", $("input[name='dcontents_startday']").val());
	formData.append("dcontents_endday", $("input[name='dcontents_endday']").val());
	formData.append("dcontents_detail", $("textarea[name='dcontents_detail']").val());
	
	console.log("regist()에서 dcontents_thumimg : " + $("img[name='dcontents_thumimg']").val());
	
	//비동기방식
	//입력값 보내
	
	$.ajax({
		url:"/rest/dcontentsEdit", 
		method:"post",
		data:formData,
		processData:false,
		contentType:false,
		success:function(result, status, xhr){
			console.log(result.msg);
		},
		error:function(xhr, status, result){
			console.log("xhr : ", xhr);
			console.log("status : ", status);
			console.log("result : ", result);
		}
	});
}

//수정하기
function edit(){
	let formData = new FormData();
	//입력값 받기
	//전송 대상에 이미지가 포함되니 formData 사용해야 함
	//formData.append("mem.mem_idx", $("로그인시확인되는아이디").val());
	//formData.append("mem.mem_idx", 1);
	
	formData.append("dcontents_idx", $("input[name='dcontents_idx']").val());
	formData.append("dcontents_title", $("input[name='dcontents_title']").val());
	formData.append("dcontents_writer", $("input[name='dcontents_writer']").val());
	formData.append("dcontents_file", fileObj);  //파일 자체 전송
	formData.append("dcontents_thumimg", $("img[name='dcontents_thumimg']").val());
	formData.append("dcontents_amount", $("input[name='dcontents_amount']").val());
	formData.append("dcontents_startday", $("input[name='dcontents_startday']").val());
	formData.append("dcontents_endday", $("input[name='dcontents_endday']").val());
	formData.append("dcontents_detail", $("textarea[name='dcontents_detail']").val());
	
	console.log("regist()에서 dcontents_thumimg : " + $("img[name='dcontents_thumimg']").val());
	
	//비동기방식
	//입력값 보내
	
	$.ajax({
		url:"/rest/dcontentsEdit", 
		method:"post",
		data:formData,
		processData:false,
		contentType:false,
		success:function(result, status, xhr){
			console.log(result);
			console.log(result.msg);//등록 성공
		},
		error:function(xhr, status, result){
			console.log("xhr : ", xhr);
			console.log("status : ", status);
			console.log("result : ", result);
		}
	});
}

//서머노트 적용하기 
$(function(){
	
	//써머노트 적용하기
	$("#summernote").summernote({
		  placeholder: '내용을 입력하세요',
		  tabsize: 2,
		  height: 100
	});
	
	//파일편집기에 이벤트 연결
	$("input[name='dcontents_file']").change(function(){
		//alert("파일 선택했어!");
		console.log("선택한 파일 정보 : "+this.files); //[object FileList]
		preview(this.files[0]); //썸네일 미리보기
		//배열로 나오는 결과물 중 첫번째 파일 하나만 필요하니 순서를 [0]으로 명시함
	});
	
	//등록버튼에 이벤트 연결
	$("#bt_regist").click(function(){
		//$("#calendarModal").modal("show");
		regist();
	});
	
	//수정 버튼에 이벤트 연결
	$("#bt_edit").click(function(){
		edit();
	});
	
	//목록 버튼에 이벤트 연결
	$("#bt_list").click(function(){
		location.href="/donation/list";
	});
	
	$("#bt_duse").click(function(){
		location.href="/donation/list";
	});
	
	//기부 후기 등록 폼으로 이동
	$("#bt_dpostscript").click(function(){
		location.href="/postscript/registForm";
	});
	

});
</script>
</body>

</html>