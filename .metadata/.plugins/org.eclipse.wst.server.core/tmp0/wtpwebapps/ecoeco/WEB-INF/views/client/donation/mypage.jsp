<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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

			<div class="container mt-5">
				<div class="row">
					<div class="col-sm-10">
						<!-- 총 메인 컨테이너 -->
						<div class="container p-3" id="titlecon">
							<!-- 총 컨테이너1 -->
							<div class="container border p-3">
								<h2>나의 보유금액 : 10000원</h2>
							</div>
							<div class="container border p-3">
								<h5>충전금:_________원</h5>
								<h5>포인트:_________원</h5>
							</div>
						</div>

						<div class="container p-3" id="mincon">
							<!-- 총 컨테이너2 -->
							<div id="con2">
								<!-- con2 -->
								<div class="border p-3" id="background">
									<h3>총 후원금액</h3>
								</div>
								<div class="border p-3">
									<h5>기부금 :_________원</h5>
									<h5>펀 딩 :_________원</h5>
								</div>

							</div>

							<div id="con3">
								<!-- con3 -->
								<div class="border p-3 ">
									<h3>현재 참가 중인 챌린지</h3>
								</div>
								<div class="border p-3">
									<h5>성공 챌린지 : " "</h5>
									<h5>진행 중인 챌린지 : " "</h5>
								</div>
							</div>
						</div>
						<!-- mincon end -->

						<div class="container p-3" id="">
							<!-- 총 컨테이너1 -->
							<div class="container border p-3">
								<div id="button css">
									<h2>챌린지</h2>
									<button class="btn btn-outline-info">전체보기</button>
								</div>
							</div>
							<div class="container border p-3">
								<h5>충전금:_________원</h5>
								<h5>포인트:_________원</h5>
							</div>
						</div>


					</div>
				</div>
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
</body>

</html>