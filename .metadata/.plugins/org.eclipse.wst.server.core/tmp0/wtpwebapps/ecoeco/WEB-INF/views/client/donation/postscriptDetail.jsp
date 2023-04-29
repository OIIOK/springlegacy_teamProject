<%@page import="com.friendly.eco.domain.Dpostscript"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Dpostscript dpostscript=(Dpostscript)request.getAttribute("dpostscript");
%>
<!DOCTYPE html>
<html lang="en">
<title>기부후기 등록</title>

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
			<form id="form1">
				<section class="content" >
					<div class="container-fluid">
			
						<!-- Main row -->
						
							<div class="col">
								<h5 class="card-title mb-0">기부후기 등록</h5>
								<input type="hidden" class="form-control" id="dpostscript_idx" name="dpostscript_idx" value=<%=dpostscript.getDpostscript_idx()%>>
								<!--제목-->	
								<div class="form-group row">
									<div class="col">
										<label class="col-sm-2 col-form-label">제목</label>
										<input type="text" class="form-control" id="dpostscript_title" name="dpostscript_title" value=<%=dpostscript.getDpostscript_title()%>>								
									</div>
								</div>		
								
								<!--작성자 : 나중에는 불러와서 자동 채우기-->
								<div class="form-group row">
									<div class="col">
										<label class="col-sm-2 col-form-label">작성자</label>
										<input type="text" class="form-control" name="dpostscript_writer" value=<%=dpostscript.getDpostscript_writer()%>>
									</div>
								</div>	
																																											
								<p></p>													
						
								<!--상세내용-->
								<!--써머노트 적용하기-->
								<div class="form-group row">
									<div class="col">
										<label class="col-sm-3 col-form-label">후기글</label>
										<!--써머노트 안되는거 수정하기-->
										<textarea id="summernote" name="dpostscript_detail" id="dpostscript_detail">
											<%=dpostscript.getDpostscript_detail()%>
										</textarea>
									</div>
								</div>
																							
								<div class="form-group row">
									<div class="col" align="right">
										<button type="button" class="btn btn-primary" id="bt_edit">수정</button>								
										<button type="button" class="btn btn-primary" id="bt_list">목록</button>								
									</div>
								</div>							
								
								<!--modal-->
	
								<!--/.modal  -->
								
							</div>
						</div>
						<!-- /.row (main row) -->
					</div>
					
					<!-- /.container-fluid -->
				
				</section>
			</form>	
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">

//등록하기
function edit(){
	$("#form1").attr({
		action:"/postscript/edit",
		method:"post"	
	});
	$("#form1").submit();
	
}

//서머노트 적용하기 
$(function(){
	//써머노트 적용하기
	$("#summernote").summernote({
		  placeholder: '내용을 입력하세요',
		  tabsize: 2,
		  height: 100
	});
	

	//목록 버튼에 이벤트 연결
	$("#bt_list").click(function(){
		location.href="/postscript/list";
	});
	
	$("#bt_edit").click(function(){
		edit();
	});
	

});
</script>
</body>

</html>