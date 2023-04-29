
<%@ page contentType="text/html; charset=UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<title>에코나눔</title>
<!-- header_link Start -->
<%@ include file="../inc/header_link.jsp"%>
<!-- header_link End -->

<!-- Latest compiled and minified CSS -->
<!-- 기본 템플릿 설정과 충돌함, 호버 효과는 포기하자!
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	 -->
<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
body {
	background-color: #FFA366;
}
</style>

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

	<!-- -------------------------------------------------------------------------------- -->

	<!-- Page Header Start -->
				<h1 class="display-3 mb-4 animated slideInDown text-center" style="margin: 200px 0px 50px 0px;">♡♥당첨♥♡</h1>
				<div align="center" style="margin: 60px 0px 60px 0px;">
				<h5 >에코나눔 당첨을 축하드립니다!</h5>
				<h5>원활한 나눔 활동을 위해 회원님의 닉네임과 아이디가 나눔글 작성자에게 전달됩니다.</h5>
				<h5>개인정보 이용에 동의하십니까?</h5>
	</div >
	<!-- Page Header End -->

	<div class="container-xxl py-5">
		<div class="container">
			<!-- 버튼 -->
			<div class="
 -01" align="center" style="padding: 0px 0px 100px 0px;">
				<button id="bt_agree" class="btn  btn-light btn-lg" style="margin: 0px 10px 0px 0px;">동의</button>
				<button id="bt_disagree" class="btn  btn-dark btn-lg" style="margin: 0px 0px 0px 10px;">비동의</button>
			</div>
			<!-- 버튼 -->
		</div>
	</div>

	<!-- -------------------------------------------------------------------------------- -->

	<!-- Footer Start -->
	<%@ include file="../inc/footer.jsp"%>
	<!-- Footer End -->


	<!-- Copyright Start -->
	<%@ include file="../inc/capyright.jsp"%>
	<!-- Copyright End -->


	<!-- Back to Start -->
	<%@ include file="../inc/back_to_top.jsp"%>
	<!-- Back to End -->


	<!-- Footer link Start -->
	<%@ include file="../inc/footer_link.jsp"%>
	<!-- Footer link End -->

	<!-- -------------------------------------------------------------------------------- -->

	<script type="text/javascript">
	
	


		
		$(function(){
			//동의버튼 이벤트 연결
			$("#bt_agree").click(function() {
				alert("전달완료 :)");
				location.href = "/community/sharingList"
			});
			
			//비동의버튼 이벤트 연결
			$("#bt_disagree").click(function() {
				confirm("'비동의'를 누르시면 당첨이 취소됩니다. 계속 진행하시겠습니까?");
				location.href = "/community/sharingList"
			});
	});
		
	</script>
</body>
</html>