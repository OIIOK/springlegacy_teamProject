<%@page import="com.friendly.eco.domain.Dcontents"%>
<%@page import="com.friendly.eco.util.FormatCurrency"%>
<%@page import="com.friendly.eco.domain.Challenge"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
<<<<<<< HEAD
	int mem_deposit=(Integer)request.getAttribute("mem_deposit");
	Dcontents dcontents=(Dcontents)request.getAttribute("dcontents");
%>
=======
>>>>>>> eb10d2587fbcec7d402187e5a3e66555e3ce670c
<!DOCTYPE html>
<html lang="en">

<head>
	<!-- header Start -->
	<%@ include file="../inc/header_link.jsp" %>
	<!-- header End -->
</head>

<body>
    <!-- Spinner Start -->
    <%@ include file="../inc/spinner.jsp" %>
    <!-- Spinner End -->


    <!-- Topbar Start -->
    <%@ include file="../inc/topbar.jsp" %>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <%@ include file="../inc/navbar.jsp" %>
    <!-- Navbar End -->
<!-- 	<div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <a href="#">Women’s </a>
                        <span>Essential structured blazer</span>
                    </div>
                </div>
            </div>
        </div>
    </div> -->

	<!-- Main Start -->
	<section class="product-details spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="product__details__pic">
						<div class="product__details__slider__content">
							<div class="product__details__pic__slider owl-carousel">
								<img data-hash="product-1" class="product__big__img" src=""
									alt="">
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-6">
					<div class="product__details__text">
						<div class="row">
							<div class="col-sm-6">
								<p>충전금 잔액</p>
							</div>
							<div class="col-sm-6"></div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<p>참여비</p>
							</div>
							<div class="col-sm-6"></div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<p>시작일자</p>
							</div>
							<div class="col-sm-6"></div>
						</div>
					</div>
				</div>

				<form class="checkout__form" id="app1">
					<h5></h5>
					<div>
						<div class="col-lg-12">
							<div class="checkout__form__input">
								<p>
									예치금 <span>*</span>
								</p>
								<input type="number" v-model="amount" v-on:keyup="getSum()">
							</div>
						</div>

						<div class="col-lg-12">
							<div class="checkout__order">
								<h5>예치금 충전 및 결제</h5>
								<div class="checkout__order__product">
									<ul>
										<li><span class="top__text">예치금</span><span
											class="top__text__right">Total</span></li>
										<li>총 보유 예치금 <span id="mem_deposit"><%=FormatCurrency.getCurrency(mem_deposit)%></span></li>
										<li>참가 예치금 <span id="deposit"></span></li>
										<li>필요 금액 <span id="total_deposit"></span></li>
									</ul>
								</div>

								<div class="checkout__order__product">
									<ul>
										<li><span class="top__text"></span></li>
										<li><span class="top__text">충전할 금액</span></li>
										<li>Total <span style="color: red;" id="total"></span></li>
									</ul>
								</div>

								<div class="checkout__order__widget">
									<p>결제 조건 및 서버스 약관에 동의합니다</p>
									<label for="check-payment"> 챌린지 취소 규정 <input
										type="checkbox" id="check-payment"> <span
										class="checkmark"></span>
									</label> <label for="paypal"> 참가규칙 <input type="checkbox"
										id="paypal"> <span class="checkmark"></span></label> <label
										for="tos"> 이용약관 <input type="checkbox" id="tos"><span
										class="checkmark"></span></label> <label for="full-check"
										class="font-weight-bold"> 약관 전체동의 <input
										type="checkbox" id="full-check"><span
										class="checkmark"></span></label>
								</div>

								<div class="text-center">
									<button type="button"
										class="btn btn-secondary rounded-pill py-1 px-5 text-center"
										id="bt_regist">참여하기</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<!-- Main End -->


    <!-- Footer Start -->
    <%@ include file="../inc/footer.jsp" %>
    <!-- Footer End -->


    <!-- Copyright Start -->
    <%@ include file="../inc/capyright.jsp" %>
    <!-- Copyright End -->


    <!-- Back to Top -->
    <%@ include file="../inc/back_to_top.jsp" %>

	<!-- Footer link Start -->
    <%@ include file="../inc/footer_link.jsp" %>
	<!-- Footer link Start -->
</body>
<script type="text/javascript">
let app1;
let paymentObj;//뷰 

app1=new Vue({
	el:"#app1",
	data:{
		amount:12000
	},
	methods:{
		getSum(){
			let mem_deposit=<%=mem_deposit%>//회원 총 예치금
			//let deposit=parseInt($("#deposit").text);  //챌린지 참여금
			let total_deposit=parseInt($("#total_deposit").text);  //필요 금액
			
			//키보드 입력 시 마다 참가 예치금에 대입
			$("#deposit").text(app1.amount);
			$("#total_deposit").text(mem_deposit-app1.amount);
			
			let total=mem_deposit-app1.amount;
			if(total<0){
				total=-total;
			}
			$("#total").text(total);
		}
	}
});

$(function() {
	$("#bt_regist").click(function() {
		location.href = "/challenge/regist";
	});

});
</script>
</html>