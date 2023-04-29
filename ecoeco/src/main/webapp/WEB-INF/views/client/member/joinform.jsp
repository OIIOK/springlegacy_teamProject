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
								기업명
							 ----------------------------------------------------------------------------------------------------------------------->
							    <div class="form-group mb-5 oveflow-hidden" >
							      <label for="pswd">기업/단체명:</label>
							      <input type="password" class="form-control" id="mem_pass" placeholder="기업/단체명 입력" name="mem_pass" required>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback" id="pass_valid">Please fill out this field.</div>
							    </div>
							
							<!--------------------------------------------------------------------------------------------------------------------- 
								사업자등록번호
							 ----------------------------------------------------------------------------------------------------------------------->
								<div class="form-group mb-5 overflow-hidden" id="selectcon">
							    	<div>
							    		<label for="uname">사업자 등록 번호:</label>
							    	</div>
							    	<div id="div-input-email">    	
										<input type="text" class="form-control" placeholder="사업자 등록 번호 입력" name="mem_id" required>							    	
							    	</div>
							    	<div id="div-bt-certific">
										<button type="button" class="btn btn-outline-success" id="id_check">기업확인</button>							      						    	
							    	</div>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback" id="id_valid">Please fill out this field.</div>
							    </div>
							
							<!--------------------------------------------------------------------------------------------------------------------- 
								담당자 이름
							 ----------------------------------------------------------------------------------------------------------------------->
							    <div class="form-group mb-5 oveflow-hidden">
							      <label for="pswd">성명:</label>
							      <input type="text" class="form-control" id="mem_name" placeholder="성명 입력" name="mem_name" required>
							      <div class="valid-feedback">Valid.</div>
							      <div class="invalid-feedback" id="name_valid">Please fill out this field.</div>
							    </div>
							    
							<!--------------------------------------------------------------------------------------------------------------------- 
								담당자 휴대폰번호
							 ----------------------------------------------------------------------------------------------------------------------->    
							    <div class="form-group oveflow-hidden">	
							    	<div>
							    		<label for="uname">휴대폰번호:</label>
							    	</div>
							    	<div id="div-input-email">    	
										<input type="text" class="form-control" placeholder="휴대폰번호 입력 ('-'제외)" name="mem_phone" required>							    	
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
								담당자 이메일
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
								아이디
							 ----------------------------------------------------------------------------------------------------------------------->
								<div class="form-group mb-5 overflow-hidden" id="selectcon">
							    	<div>
							    		<label for="uname">아이디:</label>
							    	</div>
							    	<div id="div-input-email">    	
										<input type="text" class="form-control" placeholder="8-16자의 영문 소문자, 숫자, (-)(_)" name="mem_id" required>							    	
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
		등록버튼을 눌렀을 때
		**********************************/
		function regist() {
			let formData = $("#form1").serialize(); //쿼리 스트링으로 변환

			//미입력시 focus on
			if($.trim($('#mem_id').val())==''){
				alert("아이디를 입력해주세요");
				$('#mem_id').focus();				
				return;
			}else if($.trim($('#mem_pass')).val()==''){
				alert("비밀번호를 입력해주세요");
				$('#mem_pass').focus;
				return;
			}
			//비밀번호 확인
			else if($('#mem_pass').val() != $('#mem_pass_check').val()){
				alert("입력하신 비밀번호가 일치하지 않습니다.");
				$('#mem_pass_check').focus();
				return;
			}
			
			//중복체크 확인
			if(checkId==false) {
				alert("아이디 중복체크를 해주세요");
				return;
			}else{
				$('#form1').submit();
			}
		}
			
		/**********************************
		중복체크 버튼을 눌렀을 때
		**********************************/
		//아이디 중복 체크
		function checkId(){
			$.ajax({
				url : "/rest/member",
				type : "get",
				data : {"mem_id":$('#mem_id').val()},
				success : function(data) {
					if(data==0 && $.trim($('#mem_id').val()) != ''){
						checkId=true;
						$('#mem_id').attr("readonly", true);
						//사용가능하다는 문구
						//$("#container").html('Hi there!'); //div 안의 내용 바꾸는 쿼리 //이전 내용을 지우고, 새로운 내용을 넣음
					}else{
						//사용불가하다는 문구
					}
				},
				error : function(xhr, status, err) {
					let json = JSON.parse(xhr.responseText);
					alert(json.msg);
				}
			});
		}
		

		$(function() {
			//등록버튼 클릭시
			$("#bt_regist").click(function() {
				regist();
			});
			
			//아이디 중복 체크
			$("#id_check").click(function(){
				checkId();
			});
		});
	</script>
</body>

</html>