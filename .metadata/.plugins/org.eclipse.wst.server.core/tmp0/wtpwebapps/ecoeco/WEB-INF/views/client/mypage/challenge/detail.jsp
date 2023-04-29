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
.box-style{
	width:200px;
	height:150px;
	display:inline-block;
	margin:5px;
}
.box-style img{
	width:200px;
	height:150px;
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
		<main class="content" id="app1">
			<div class="card">
				<div class="card-body">
					<form id="form1">
					
					<div class="row">
						<div class="col-md-12" align="right">
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">인증사진 등록</button>
						</div>
					</div>

						<!-- Modal Start-->
						<div class="modal fade" id="myModal">
							<div class="modal-dialog">
								<div class="modal-content">

									<!-- Modal Header -->
									<div class="modal-header">
										<h4 class="modal-title">인증사진 등록하기</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>

									<!-- Modal body -->
									<div class="modal-body">

										<div class="row m-3">
											<div class="col-md-12">
												<div class="row form-group">
													<label class="col-sm-3 col-form-label">인증사진 첨부</label>
													<div class="col-sm-9">
														<input type="file" class="form-control" name="file" id="file">
													</div>
												</div>
											</div>
										</div>

										<div class="row m-3">
											<div class="col-md-12">
												<div class="row form-group">
													<label class="col-sm-3 col-form-label">인증사진 미리보기</label>
													<div class="col-sm-9">
														<div class="box-style">
															<img name="chall_filename" id="chall_filename" />
														</div>
													</div>
												</div>
											</div>
										</div>

									</div>

									<!-- Modal footer -->
									<div class="modal-footer">
										<button type="button" class="btn btn-primary"
											data-dismiss="modal" id="bt_regist">등록</button>
									</div>

								</div>
							</div>
						</div>
						<!-- Modal End -->


						<h5 class="card-title mb-0">챌린지 상세</h5>

						<h5 class="card-title mb-0">내 인증샷</h5>
						<div class="row m-3">
							<div class="col-md-12">
								<div class="row form-group">
									<label class="col-sm-3 col-form-label">인증사진 미리보기</label>
									<div class="col-sm-9">
										<div class="box-style">
											<img name="chall_filename" id="chall_filename"/>
										</div>
									</div>
								</div>
							</div>
						</div>
								
					</form>
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
	let fileObj;  //등록 시 전송할 파일 
	let key=0;
		
	/*------------------------------------------
		인증사진 미리보기
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
			
			$("#chall_filename").attr("src", json.binary);
		}
		reader.readAsDataURL(file);  //파일 읽기
	}
	
	/*------------------------------------------
		인증사진 등록
	------------------------------------------*/
	function regist(){
		let formData=new FormData();
		
		formData.append("file", fileObj);  //파일 자체 전송
		formData.append("chall_filename", $("input[name='chall_filename']").val());  //파일  이름
		
		$.ajax({
			url:"/mypage/challenge/challPhoto",
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			success:function(result, status, xhr) {
				console.log(result.msg);
			}
		});
	}

	$(function() {
		//파일편집기에 이벤트 연결
		$("#file").change(function(){
			//alert("");
			console.log(this.files);
			preview(this.files[0]);  //썸네일 미리보기
		});
		
		//등록 버튼에 이벤트 연결
		$("#bt_regist").click(function(){
			//regist();
		});
	});
</script>

</html>