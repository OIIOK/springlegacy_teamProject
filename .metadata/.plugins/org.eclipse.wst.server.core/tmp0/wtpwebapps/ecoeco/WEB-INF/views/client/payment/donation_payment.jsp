<%@page import="com.friendly.eco.domain.Dcontents"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//List<Dcontents> dcontentsList=(List)request.getAttribute("dcontentsList");
%>
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
					<%//for(Dcontents dcontents : dcontentsList){ %>
					<%//Dcontents dContents=dContents.getClass(); %>
					<div
						style="float: left; width: 50%; padding: 10px;">
						<!-- <img class="img1" src="<%//=dcontents.getDcontents_file() %>"
							style="float: left;"> -->
							dcontents_file
					</div>
					
					<div
						style="float: left; width: 50%; padding: 10px; padding-bottom: 10px;">
						<label>[기부]</label><br /> <label>상세명</label><%=//dcontents.getDcontents_title() %><br /> <label>모집금액</label><%=//dcontents.getDcontents_amount() %><br /><hr />
					</div>

					<!-- 포인트/예치금 사용입력 -->
					<div>
						<hr />
						<span style="font-size: 20px"><b>[결제 할 금액]</b></span><br />
						<b>[포인트]</b> <input type="checkbox" value="">모두사용<br /> 
						내가 가진 포인트　()원<br />
						사용 <input id="usePoint" onchange="printUsePoint()" onfocus="this.value='';" value="금액을 입력해주세요"/>원<br />
						<b>[예치금]</b> <input type="checkbox">모두사용<br />
						내가 가진 예치금　　　　　　원&nbsp&nbsp<button type="button" class="btn btn-secondary" id="bt_charge">충전</button><br />
						사용 <input id="useDeposit" onchange="printUseDeposit()" onfocus="this.value='';"  value="금액을 입력해주세요"/>원<br />
					</div>
					<hr />
					<!-- 결제금액상세(고정) -->
					<div>
						<span style="font-size: 20px"><b>[결제상세]</b></span><br /> <b>[포인트]</b> <br /> 사용 <span id="result1"></span>원&nbsp&nbsp<br /> 
						<b>[예치금]</b> <br /> 사용 <span id="result2"></span>원<br />
					</div>
					<hr />
					<!-- 최종후원금액 -->
					<div>최종후원금액</div>
				</div>
				<!-- main end -->
			</div>
<script type="text/javascript">
function getDonaList(){
	$.ajax({
		url:"/rest/payment/donation",
		type:"get",
		success:function(result, status, xhr){
		}
	});
}

$(function(){
	getDonaList();
	
	$("#bt_charge").click(function(){
		location.href="/mypage/charge";
	})
});

function printUsePoint(){
	let usePoint=document.getElementById('usePoint').value;
	document.getElementById("result1").innerText=usePoint;
}

function printUseDeposit(){
	let useDeposit=document.getElementById('useDeposit').value;
	document.getElementById("result2").innerText=useDeposit;
}
</script>

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
</body>

</html>