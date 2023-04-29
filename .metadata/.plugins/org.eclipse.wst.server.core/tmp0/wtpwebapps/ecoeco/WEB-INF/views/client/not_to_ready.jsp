<%@page import="com.friendly.eco.domain.Dpsit"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!-- jQuery library -->
<head>
<link href="/resources/client/css/app.css" rel="stylesheet">
<link href="/resources/client/css/app.css.map" rel="stylesheet">

<!-- header_link Start -->
<%@ include file="./inc/header_link.jsp"%>
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
#main_table{
	padding-top: 50px;
	text-align: center;
}
.hr_dotted {
    border: none;
    border-top: 1px dotted blue;
    color: #fff;
    background-color: #fff;
    height: 2px;
    width: 100%;
}
.warning{
display: block; 
margin: 0 auto;
padding-top: 100px;
}

</style>

<body>
	<!-- Spinner Start -->
	<%@ include file="./inc/spinner.jsp"%>
	<!-- Spinner End -->


	<!-- Topbar Start -->
	<%@ include file="./inc/topbar.jsp"%>
	<!-- Topbar End -->


	<!-- Navbar Start -->
	<%@ include file="./inc/navbar.jsp"%>
	<!-- Navbar End -->

	<!-- main start -->
	<div class="container" id="container">
		<div class="col-3">
			<!-- mypage_sidebar Start -->
			<%@ include file="./inc/mypage_sidebar.jsp"%>
			<!-- mypage_sidebar End -->
			아
		</div>
	</div>
	<!-- main end -->
	<!-- Footer Start -->
	<%@ include file="./inc/footer.jsp"%>
	<!-- Footer End -->
	<!-- Copyright Start -->
	<%@ include file="./inc/capyright.jsp"%>
	<!-- Copyright End -->
	<!-- Back to Top -->
	<%@ include file="./inc/back_to_top.jsp"%>
	<!-- Footer link Start -->
    <%@ include file="./inc/footer_link.jsp" %>
	<!-- Footer link Start -->

</body>
</html>