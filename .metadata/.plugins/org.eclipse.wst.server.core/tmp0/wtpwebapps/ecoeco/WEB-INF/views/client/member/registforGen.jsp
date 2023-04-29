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
.oveflow-hidden{ /*over-flow를 위한 클래스명, 바꾸면 안 됨!*/ 
	overflow: hidden;
}

#bigcon {
	width: 800px;
}

.jumbotron{
	margin-bottom: 150px; 	/*회원가입과 아이디 간격*/
}

#bt-find-id, #bt-find-pass{
	width:305px;
	border:none;
}

#bt-phone-certific, #bt-email-certific{
	width:305px;
}

#div-input-email{
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
  <div class="jumbotron overflow-hidden">
    <h1><b>회원가입</b></h1>      
    <p>Home > 회원가입 > <b>정보입력</b></p>
  </div>   
</div>
	<!-- 양식 start -->
	<section>
		<div class="container" id="bigcon">
			<div class="row m-5">
				<div class="col">
					<form id="form1">

							<form action="/action_page.php" class="was-validated">
							
							<!--------------------------------------------------------------------------------------------------------------------- 
								아이디
							 ----------------------------------------------------------------------------------------------------------------------->
								<div class="form-group mb-5 overflow-hidden" id="selectcon">
							    	<div>
							    		<label for="uname">아이디:</label>
							    	</div>
							    	<div id="div-input-email">    	
										<input type="text" class="form-control" placeholder="8-16자의 영문 소문자, 숫자, (-)(_)" name="mem_id" id="mem_id" required>							    	
							    	</div>
							    	<div id="div-bt-certific">
										<button type="button" class="btn btn-outline-success" id="id_check">중복확인</button>							      						    	
							    	</div>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback" id="id_valid">Please fill out this field.</div>
							    </div>
							
							<!--------------------------------------------------------------------------------------------------------------------- 
								비밀번호
							 ----------------------------------------------------------------------------------------------------------------------->
							    <div class="form-group mb-5 oveflow-hidden" >
							      <label for="pswd">비밀번호:</label>
							      <input type="password" class="form-control" id="mem_pass" placeholder="8-16자의 영문 및 숫자, 특수문자를 모두 포함" name="mem_pass" required>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback" id="pass_valid">Please fill out this field.</div>
							    </div>
							    <div class="form-group mb-5 oveflow-hidden">
							      <label for="pswd">비밀번호 확인:</label>
							      <input type="password" class="form-control" id="mem_pass_check" placeholder="8-16자의 영문 및 숫자, 특수문자를 모두 포함" name="mem_pass_check" required>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback" id="pass_valid_check">Please fill out this field.</div>
							    </div>
							 <!--------------------------------------------------------------------------------------------------------------------- 
								성명, 생년월일
							 ----------------------------------------------------------------------------------------------------------------------->   
							    <div class="form-group mb-5 oveflow-hidden">
							      <label for="pswd">성명:</label>
							      <input type="text" class="form-control" id="mem_name" placeholder="성명 입력" name="mem_name" required>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback" id="name_valid">Please fill out this field.</div>
							    </div>
							    <div class="form-group mb-5 oveflow-hidden">
							      <label for="text">생년월일:</label>
							      <input type="number" class="form-control" id="mem_birth" placeholder="생년월일 6자리 입력  ex) 980213" name="mem_birth" required>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback" id="birth_valid">Please fill out this field.</div>
							      <div class="mt-1">
							    	<h6><small>법령에 따라 만 14세 미만 아동 여부를 확인하기 위해 가입자 본인의 생년월일을 입력해주세요</small></h6>
							     </div>
							    </div>
							    
							    
							<!--------------------------------------------------------------------------------------------------------------------- 
								휴대폰번호
							 ----------------------------------------------------------------------------------------------------------------------->    
							    <div class="form-group oveflow-hidden">	
							    	<div>
							    		<label for="uname">휴대폰번호:</label>
							    	</div>
							    	<div id="div-input-email">    	
										<input type="text" class="form-control" placeholder="휴대폰번호 입력 ('-'제외)" name="mem_phone" id="mem_phone" required>							    	
							    	</div>
							    	<div id="div-bt-certific">
										<button type="button" class="btn btn-outline-success" id="phone_check">중복확인</button>							      						    	
							    	</div>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback" id="phone_valid">Please fill out this field.</div>
							    </div>
							    <div class="mb-5">
							    	<a href="#"><u>휴대폰이 없으신가요?</u></a>						    
							    </div>
							    
							<!--------------------------------------------------------------------------------------------------------------------- 
								이메일
							 ----------------------------------------------------------------------------------------------------------------------->   
								<div class="form-group mb-3 oveflow-hidden">	
							    	<div>
							    		<label for="uname">이메일:</label>
							    	</div>
							    	<div id="div-input-email">    	
										<input type="text" class="form-control" id="mem_email" placeholder="이메일주소 입력" name="mem_email" required>							    	
							    	</div>
							    	<div id="div-bt-certific">
										<button type="button" class="btn btn-outline-success" id="email_check">본인인증</button>							      						    	
							    	</div>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback" id="email_valid">Please fill out this field.</div>
							    </div>
							    
							 <!--------------------------------------------------------------------------------------------------------------------- 
								닉네임
							 ----------------------------------------------------------------------------------------------------------------------->  
							     <div class="form-group oveflow-hidden">	
							    	<div>
							    		<label for="uname">닉네임:</label>
							    	</div>
							    	<div id="div-input-email">    	
										<input type="text" class="form-control" placeholder="닉네임 입력 (한글 2자, 영문 4자 이상)" name="mem_nickname" id="mem_nickname"required>							    	
							    	</div>
							    	<div id="div-bt-certific">
										<button type="button" class="btn btn-outline-success" id="nickname_check">중복확인</button>							      						    	
							    	</div>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback" id="nickname_valid">Please fill out this field.</div>
							    </div>
							    <div class="mb-5">
							    	<h6><small>사이트 내에 사용할 닉네임을 입력해주세요</small></h6>
							     </div>
							    
							    <!--  
									<div class="form-group form-check mb-3">
										<div class="valid-feedback">Valid.</div>
										<div class="invalid-feedback">Check this checkbox to
											continue.></div>
									</div>
								-->
									<div class="mt-4 mb-5">
										<button type="button" class="btn btn-primary btn-block" id="bt_regist">가입하기</button>																		
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
		let checkId=false; //아이디 중복체크 확인
		let checkPass=false; //아이디 중복체크 확인
		let checkPhone=false; //아이디 중복체크 확인
		let checkEmail=false; //아이디 중복체크 확인
		let checkNickname=false; //아이디 중복체크 확인
		

		/**********************************
		아이디 중복 검사
		-> 올바른 아이디 입력 형식인지 파악하여, 유효하지 않다면, 중복확인 불필요
		**********************************/
		function idValidator(){
			let mem_id=$('[name=mem_id]');			
		}
		
		function regist() {
			//alert("가입할거야?");
			$("#form1").attr({
				action:"/member/register", //컨트롤러를 찾아 떠난다 
				method:"post"
			});
			$("#form1").submit();
		}
			
		/**********************************
		중복체크 버튼을 눌렀을 때
		**********************************/
		//아이디 중복 체크
		function idValidator(){
			let mem_id = $('[name=id]');
			if(mem_id.hasClass('chked')) return; //mem_id 요소가 chked 함수를 가지고 있는지
			console.log('go check');
			
			let data = join.tag
		}
		

		$(function() {
			//등록버튼 클릭시
			$("#bt_regist").click(function() {
				regist();
			});
			
			//아이디 중복 체크
			$("#id_check").click(function(){
				idValidator();
			});
			
			//핸드폰 번호 중복 체크
			$("#phone_check").click(function(){
				phoneValidator();
			});
			
			//이메일 중복 체크
			$("#email_check").click(function(){
				emailValidator();
			});
			
			//닉네임 중복 체크
			$("#nickname_check").click(function(){
				nicknameValidator();
			});
			
			
		});
	</script>
</body>

</html>