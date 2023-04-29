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
	position: relative;
}

#mincon {
	display: flex;
	text-align: center;
	font-size: 10px;
}

#con1 {
	width: 200px;
	height: 200px;
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

.inner-div {
	display: table-cell;
	vertical-align: middle;
	position: absolute;
	top: 10%;
	left: 50%;
	margin: -25px 0 0 -25px;
}

.img1 {
	max-width: 180px;
	max-height: 180px;
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

		<div>
			<!-- main start -->
			<!-- 썸네일, 상품 상세명 -->
			<div class="inner-div">
				<div>
					<div style="float: left; width: 50%; padding: 10px;">
						<img class="img1" src="../resources/client/img/animal.png"
							style="float: left;">
					</div>
					<div
						style="float: left; width: 50%; padding: 10px; padding-bottom: 10px;">
						<label>[펀딩]</label><br /> <label>펀딩이름</label><br /> <label>상세정보</label><br />
						<label>가격</label><br /> <label>수량</label><br /> <label>배송비</label><br />
						<label>최종금액</label><br />
					</div>

					<hr />

					<!-- 후원자 정보(고정, 수정 둘다) -->
					<div>
						<div>
							<label>[후원자 정보]</label><br /> <label>이름</label><br /> <label>메일</label><br />
							<label>주소</label><br /> <label>휴대폰 번호</label><br />
						</div>
						<div>받는사람 이름, 주소, 휴대폰 번호 적어라</div>
					</div>
					<hr />

					<!-- 포인트/예치금 사용입력 -->
					<div>
						<hr />
						[포인트] <input type="checkbox">모두사용<br /> 사용 <input
							type="text">원<br /> [예치금] <input type="checkbox">모두사용<br />
						사용 <input type="text">원<br />
					</div>
					<hr />
					<!-- 결제금액상세(고정) -->
					<div></div>

					<!-- 최종결제금액 -->
					<div></div>
				</div>
				<!-- main end -->
			</div>


			<!-- Footer Start -->
			<%
				//@ include file="../inc/footer.jsp"
			%>
			<!-- Footer End -->


			<!-- Copyright Start -->
			<%
				//@ include file="../inc/capyright.jsp"
			%>
			<!-- Copyright End -->


			<!-- Back to Top -->
			<%@ include file="../inc/back_to_top.jsp"%>

			<!-- Footer link Start -->
			<%@ include file="../inc/footer_link.jsp"%>
			<!-- Footer link Start -->
</body>

</html>