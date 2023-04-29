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
	width: 800px;
	height: 800px;
}

#midcon {
	margin-top: 100px; /*login과 아이디, 비번 입력 칸 간격*/
}

#mail_icon, #lock_icon {
	width: 20px;
	height: 20px;
}

#google_icon, #naver_icon, #kakao_icon {
	width: 30px;
	height: 30px;
}

#div_status {
	float: left; /*가로 정렬, 퍼센트 줘서 위치 정하기*/
	width: 70%;
}

#div_find {
	float: left;
	width: 30%;
}

#div_bt_google, #div_bt_naver, #div_bt_kakao {
	float: left; /*가로 정렬, 퍼센트 줘서 위치 정하기*/
	width: 33%;
}

#bt_google, #bt_naver, #bt_kakao {
	width: 195px;
}

#bt_find {
	padding: 0px;
}

h1 {
	text-align: center;
}

input[type=text], input[type=password] {
	padding: 20px; /*input박스 크기 조절*/
}

button[type=button] {
	padding: 15px;
}

button.img {
	width: 20px;
	height: 20px;
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

	<!-- 양식 start -->
	<section>
		<div class="container" id="bigcon">
			<div class="row m-5">
				<div class="col">
					<form id="form1">

						<div class="container">

							<div class="container p-10">
								<h1>Login</h1>
							</div>
							<form action="/action_page.php" class="needs-validation"
								novalidate>

								<div class="container" id="midcon">
									<div class="input-group mb-3" id="div_id_input">
										<div class="input-group-prepend">
											<span class="input-group-text"><img
												src="/resources/client/img/emailIcon.png" id="mail_icon"></span>
										</div>
										<input type="text" class="form-control" id="mem_id"
											placeholder="아이디를 입력하세요" name="mem_id" required>
										<div class="valid-feedback">Valid.</div>
										<div class="invalid-feedback">Please fill out this
											field.</div>
									</div>

									<div class="input-group mb-3" id="div_pass_input">
										<div class="input-group-prepend">
											<span class="input-group-text"><img
												src="/resources/client/img/lockIcon.png" id="lock_icon"></span>
										</div>
										<input type="password" class="form-control" id="mem_pass"
											placeholder="비밀번호를 입력하세요" name="memPass.mem_pass" required>
										<div class="valid-feedback">Valid.</div>
										<div class="invalid-feedback">Please fill out this
											field.</div>
									</div>
									<div class="form-group form-check mb-3">
										<div id="div_status">
											<label class="form-check-label"> <input
												class="form-check-input" type="checkbox"
												 id="save_id" id="save_id"> 로그인 상태 유지하기 
										</div>
										<div id="div_find">
											<button type="button" class="btn btn-link" id="bt_find">아이디/비밀번호
												찾기</button>
										</div>
										<div class="valid-feedback">Valid.</div>
										<div class="invalid-feedback">Check this checkbox to
											continue.></div>
										</label>
									</div>
									<div class="mt-4 mb-5">
										<div class="mb-3">
											<button type="button" class="btn btn-primary btn-block"
												id="bt_login">로그인</button>
										</div>
										<div>
											<button type="button"
												class="btn btn-outline-success btn-block" id="bt_regist">회원가입</button>
										</div>
									</div>
									<hr />

									<div class="mt-5">
										<small><b>sns계정으로 간편 로그인하기</b></small>
									</div>
									<div class="btn-group btn-group-lg mt-1">
										<button type="button" class="btn btn-outline-success"
											id="bt_google">
											<img src="/resources/client/img/googleLogo.png"
												id="google_icon">Google
										</button>
										<button type="button" class="btn btn-outline-success"
											id="bt_naver">
											<img src="/resources/client/img/naverLogo.png"
												id="naver_icon">Naver
										</button>
										<button type="button" class="btn btn-outline-success"
											id="bt_kakao">
											<img src="/resources/client/img/kakaoLogo.png"
												id="kakao_icon">Kakao
										</button>
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

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script type="text/javascript">	
	
		function loginform() {
			
			//입력 값 체크
			if($.trim($('#mem_id').val())==''){
				alert("아이디를 입력해주세요");
				$('#mem_id').focus();
				return;

			}else if($.trim($('#mem_pass').val())==''){
				alert('비밀번호를 입력해주세요');
				$('#memPass.mem_pass').focus();
				return;
			}
			
			//자동 로그인 여부
			
			$("#form1").attr({
				action:"/member/login", //컨트롤러를 찾아 떠난다 
				method:"post"
			});
			$("#form1").submit();
			alert("로그인 되었습니다."); //이게 어느 시점에 나타나는지 알아야 함
		}

		function gotoAuthForm(sns) { //sns이름을 가지고 와야 대입하면 그 곳으로 가지
			$.ajax({
				url:"/rest/member/authform/" + sns,
				type:"get",
				success:function(result, status, xhr){
					console.log("인증주소는 ", result.msg);
					location.href=result.msg; //각각의 주소로 이동
				}
			});
		}

	$(function() {
		//로그인
		$("#bt_login").click(function() {
			loginform();
		});

		//sns연동
		$("#bt_google").click(function() {
			//SNS 사업자가 미리 만들어놓은 인증화면 주소를 요청해야 한다.
			//따라서 주소 및, 파라미터명이 이미 정해져 있다..
			//(어디에서 조사해야 하나? 구글 개발자 사이트에 공시되어 있다..)
			console.log("버튼 작동함?");
			gotoAuthForm("google");
		});
		$("#bt_naver").click(function() {
			gotoAuthForm("naver");
		});
		$("#bt_kakao").click(function() {
			gotoAuthForm("kakao");
		});

		//아이디/비밀번호 찾기 페이지 이동
		$("#bt_find").click(function() {
			location.href = "/member/findIdByPhone"; //controller에 입력되어 있는 값 주입
		});
		//회원가입 페이지 이동
		$("#bt_regist").click(function() {
			location.href = "/member/registforGen"; //registerForSoc  registforGen
		});
	});
		
	</script>
</body>

</html>