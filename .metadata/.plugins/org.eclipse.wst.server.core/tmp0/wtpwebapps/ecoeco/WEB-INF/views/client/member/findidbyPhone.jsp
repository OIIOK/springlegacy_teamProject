<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
/*#아이디{}, .클래스명{}*/


#bigcon {
	width: 800px; height: 800px;
}

#midcon{
	margin-top: 50px; 	/*아이디/비밀번호 찾기와 아이디 간격*/
}

#bt-find-id, #bt-find-pass{
	width:305px;
	border:none;
}

#bt-phone-certific, #bt-email-certific{
	width:305px;
}

#div-input-phone{
	float:left; /*가로 정렬, 퍼센트 줘서 위치 정하기*/
	width:75%;
}

#bt-certific{
	padding:8px;
	width: 140px;
}

#div-bt-certific{
	float:right; /*가로 정렬, 퍼센트 줘서 위치 정하기*/	
}

#div-bt-login, #div-bt-id{
	float:left; /*가로 정렬, 퍼센트 줘서 위치 정하기*/
	width:50%;
}

#bt-login, #bt-id{
	width : 306px;
}

input[type=text]{
	padding:20px; /*input박스 크기 조절*/
}

button[type=button]{
	padding:15px;
}


button.img{
	width : 20px; height : 20px;
}


</style>

<head>
<!-- header_link Start -->
<%@ include file="../inc/header_link.jsp"%>
<!-- header_link End -->
</head>

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


<!-- jumbotron -->
<div class="container">
  <div class="jumbotron">
    <h1><b>아이디/비밀번호 찾기</b></h1>      
    <p>Home > 로그인 > <b>아이디/비밀번호 찾기</b></p>
  </div>   
</div>
	<!-- 양식 start -->
	<section>
		<div class="container" id="bigcon">
			<div class="row m-5">
				<div class="col">
					<form id="form1">

						<div class="container">
							 <div class="btn-group btn-group-lg">
							    <button type="button" class="btn btn-success" id="bt-find-id">아이디 찾기</button>
							    <button type="button" class="btn btn-outline-success" id="bt-find-pass">비밀번호 찾기</button>
							  </div>
								<hr/>
							<div class="mt-5 mb-5">
								<p><b>※ SNS 간편 회원가입 하신 경우, 아이디/비밀번호 찾기 기능을 이용할 수 없습니다.</b></p>
							</div>
							
							<a><b>인증방법 선택</b></a>
							<div class="mb-3">
								<div class="btn-group btn-group-lg mt-1">
									  <button type="button" class="btn btn-success" id="bt-phone-certific">휴대폰 인증</button>
									  <button type="button" class="btn btn-outline-success" id="bt-email-certific">이메일 인증</button>
									</div>
							</div>
							
							<form action="/action_page.php" class="was-validated">
							    <div class="form-group">
							      <label for="uname">성명:</label>
							      <input type="text" class="form-control" id="uname" placeholder="성명 입력" name="uname" required>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback">Please fill out this field.</div>
							    </div>
							    <div class="form-group mb-5">
							    	<div id="div-input-phone">
										<input type="text" class="form-control" id="pwd" placeholder="휴대폰번호 입력('-'제외)" name="pswd" required readonly>							    	
							    	</div>
							    	<div id="div-bt-certific">
										<button type="button" class="btn btn-outline-success" id="bt-certific">본인인증</button>							      						    	
							    	</div>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback">Please fill out this field.</div>
							    </div>
									<div class="form-group form-check mb-3">
										<div class="valid-feedback">Valid.</div>
										<div class="invalid-feedback">Check this checkbox to
											continue.></div>
									</div>
									<div class="mt-4 mb-5">
										<div id="div-bt-login">
											<button type="button" class="btn btn-outline-success" id="bt-login">로그인 화면으로</button>							      
										</div>
										<div id="div-bt-id">
											<button type="button" class="btn btn-success" id="bt-id">아이디 찾기</button>									
										</div>
									</div>
									
			
							</form>
						</div>

					</form>
				</div>
			</div>
		</div>
	</section>


	<!-- 양식 end -->

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
	<!-- Footer link Start -->


	<script type="text/javascript">
		function regist() {
			let formData = $("#form1").serialize(); //쿼리 스트링으로 변환

			//비동기요청
			$.ajax({
				url : "/rest/member",
				type : "GET",
				data : formData,
				success : function(result, status, xhr) {
					alert(result.msg);
				},
				error : function(xhr, status, err) {
					let json = JSON.parse(xhr.responseText);
					alert(json.msg);
				}
			});

		}

		$(function() {
			//$("#bt-find-id").trigger("click"); //그냥 버튼success 주면 됨
			$("#bt_regist").click(function() {
				regist();
			});
			$("#bt-email-certific").click(function() {
				location.href = "/member/findIdByEmail"; //controller에 입력되어 있는 값 주입
		});
	});	
	</script>
</body>

</html>