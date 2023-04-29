<%@ page contentType="text/html; charset=UTF-8"%>
<%//기부후기글 등록 %>

<!DOCTYPE html>
<html lang="en">

<head>
<link href="/resources/client/css/app.css" rel="stylesheet">
<link href="/resources/client/css/app.css.map" rel="stylesheet">

<!-- header_link Start -->
<%@ include file="../inc/header_link.jsp"%>
<!-- header_link End -->

</head>
<script src="/js/summernote/summernote-lite.js"></script>
<script src="/js/summernote/lang/summernote-ko-KR.js"></script>

<link rel="stylesheet" href="/css/summernote/summernote-lite.css">
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
	width: 400px;
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
					<div class="row">
						<div class="col">
									
							<!--제목-->	
							<div class="form-group row">
								<div class="col">
									<input type="text" class="form-control" name="donation_contents_title" placeholder="제목">
								</div>
							</div>		
							
							<!--작성자 : 나중에는 불러와서 자동 채우기-->
							<div class="form-group row">
								<div class="col">
									<input type="text" class="form-control" name="donation_contents_writer " placeholder="작성자">
								</div>
							</div>	
										
						<!--요약글-->						
							<div class="form-group row">
								<div class="col">
									<input type="text" class="form-control" name="donation_contents_summary " placeholder="요약글을 작성해주세요">
								</div>
							</div>		
							
							
						<!--썸네일 이미지-->			
							<div class="form-group row">
								<div class="col">
									<input type="file" class="form-control" name="donation_contents_thumimg">
								</div>
							</div>
									
						<!--대표 이미지-->			
							<div class="form-group row">
								<div class="col">
									<input type="file" class="form-control" name="donation_contents_representative_img ">
								</div>
							</div>		
							
						<!--모집금액-->					
							<div class="form-group row">
								<div class="col">
									<input type="number" class="form-control" name="donation_contents_amount" placeholder="모집금액을 입력해주세요">
								</div>
							</div>					
							
							<!--상세내용-->
							<!--써머노트 적용하기-->
							<div class="form-group row">
								<div class="col">
									<textarea id="summernote" name="donation_contents_detail"></textarea>
								</div>
							</div>
							
							<!--일정등록, 구글 api 달력 사용 예정-->
							<div class="form-group row">
								<div class="col">
									<input type="text" class="form-control" name="donation_contents_startday" placeholder="시작일">
								</div>
								<div class="col">
									<input type="text" class="form-control" name="donation_contents_endday" placeholder="종료일">
								</div>
							</div>	
												
																									
							<div class="form-group row">
								<div class="col">
									<button type="button" class="btn btn-danger" id="bt_edit">수정</button>
									<button type="button" class="btn btn-danger" id="bt_regist">저장</button>
									<button type="button" class="btn btn-danger" id="bt_submit">제출</button>									
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
	<!-- include libraries(jQuery, bootstrap) -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<!-- include summernote css/js -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

	<!-- Footer link Start -->
<script type="text/javascript">

	$(function(){
		//써머노트 적용
		$("#summernote").summernote({
			  height: 450,
			  lang: "ko-KR"
		});
		
	});

</script>
</body>

</html>