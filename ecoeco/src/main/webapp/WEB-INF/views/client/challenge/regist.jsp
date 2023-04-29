<%@page import="com.friendly.eco.util.FormatCurrency"%>
<%@page import="com.friendly.eco.domain.Challenge"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	int mem_deposit=(Integer)request.getAttribute("mem_deposit");
	Challenge challenge=(Challenge)request.getAttribute("challenge");
%>
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
	<div class="breadcrumb-option">
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
    </div>

	<!-- Main Start -->
	<section class="product-details spad">
		<div class="container" id="app1">
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

				<form class="checkout__form" id="form1">
					<h5></h5>
					<div>
						<input type="hidden" name="challenge.challenge_idx" value="<%=challenge.getChallenge_idx() %>">
						<div class="col-lg-12">
							<div class="checkout__form__input">
								<p>참여 예치금 <span>*</span></p>
								<input type="number" name="challenge_fee" v-model="amount" v-on:keyup="getSum()">
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
										<li>참여 예치금 <span id="deposit"></span></li>
										<li>잔액 <span id="balance"></span></li>
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
									<label> 챌린지 취소 규정 <span style="color:#ca1515">*</span><input type="checkbox" name="chk"><span class="checkmark"></span></label> 
									<div class="col m-2" style="height: 100px; overflow: scroll; background-color:white; color: gray;">
										<div style="height: 50px;">
											챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정 챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정
											챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정 챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정
											챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정 챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정
											챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정 챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정챌린지 취소 규정
										</div>
									</div>
									<label> 참가규칙 <span style="color:#ca1515">*</span><input type="checkbox" name="chk"><span class="checkmark"></span></label> 
									<div class="col m-2" style="height: 100px; overflow: scroll; background-color:white; color: gray;">
										<div style="height: 50px;">
											참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 
											참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 
											참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 
											참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 참가규칙 
										</div>
									</div>
									<label> 이용약관 <span style="color:#ca1515">*</span><input type="checkbox" name="chk"><span class="checkmark"></span></label> 
									<div class="col m-2" style="height: 100px; overflow: scroll; background-color:white; color: gray;">
										<div style="height: 50px;">
											이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 
											이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 
											이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 
											이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 이용약관 
										</div>
									</div>
									<label class="font-weight-bold"> 약관 전체동의 <input type="checkbox" name="full-check"><span class="checkmark"></span></label>
								</div>
								
								<div class="text-center">
									<button type="button" class="btn btn-secondary rounded-pill py-1 px-5 text-center" id="bt_regist">참여하기</button>
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
				
				//키보드 입력 시 마다 참여 예치금에 대입
				$("#deposit").text(app1.amount);
				$("#balance").text(mem_deposit-app1.amount);
				
				let balance=mem_deposit-app1.amount;
				if(balance<0){  //충전이 필요한 경우
					balance=-balance;
					$("#total").text(balance);
					$("#bt_regist").html("충전하기");
					$("#bt_regist").click(function(){
						challengeCharge();
					});
				}else{  //충전이 필요하지 않은 경우
					$("#total").text(0);
					$("#bt_regist").html("참여하기");
					$("#bt_regist").click(function(){
						regist();
					});
				}
			}
		}
	});
	
	/*--------------------------------------------------
		유효성 검사
	---------------------------------------------------*/
	function validation(){
		
	}
	
	
	/*--------------------------------------------------
		약관동의 전체 체크 or 체크 해제
	---------------------------------------------------*/
	function check(){
		let checked=$("input[name='full-check']");
		
		$("input[name='full-check']").click(function(){  //체크되었을 경우
			if($("input[name='full-check']").is(":checked")==true){
				$($("input[name='chk']")).prop("checked", true);  // chk라는 name을 가진 input태그를 찾아 checked를 true로 정의
			}else{  //체크되지 않았을 경우
				$($("input[name='chk']")).prop("checked", false);  //chk라는 name을 가진 input태그를 찾아 checked를 false로 정의
			}
		});
	}
	
	/*--------------------------------------------------
		챌린지 충전하기
	---------------------------------------------------*/
	function challengeCharge(){
	}
	
	
	/*--------------------------------------------------
		챌린지 참여하기 - 동기방식
	---------------------------------------------------*/
	function regist(){
		$("#form1").attr({
			action:"/challenge/regist",
			method:"post"
		});
		$("#form1").submit();
	}
	
	
	$(function() {
		check();
		$("#bt_regist").click(function() {
			regist();
			validation();
		});
		
		 $(window).keydown(function(event){
		    if(event.keyCode == 13) {
		      event.preventDefault();
		      return false;
		    }
		});	
	});
</script>
</html>