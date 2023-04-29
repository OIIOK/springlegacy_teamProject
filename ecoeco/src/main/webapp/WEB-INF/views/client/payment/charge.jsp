<%@page import="com.friendly.eco.domain.DpMem"%>
<%@page import="com.friendly.eco.domain.Dpsit"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//결제금액 리스트로 뽑기(비동기)
	List<Dpsit> dpsitList=(List)request.getAttribute("dpsitList");
%>
<!DOCTYPE html>
<html lang="en">
<!-- jQuery library -->
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

<div class="container" id="main_table">
  <h2 style="text-align: center;">예치금 충전하기</h2>
  <br>현재 보유 충전금</br>            
  <p style="font-size:30pt;"><input type="hidden" name="dpsit_sum" >원</p>      

<hr class="hr_dotted"/>
<form id="form1">
  <table class="table table-borderless">
    <thead>
      <tr>
        <th></th>
        <th>충전금</th>
        <th>적립률</th>
        <th>포인트 적립</th>
      </tr>
    </thead>
    <tbody>
    <%for(int i=0;i<dpsitList.size();i++){ %>
    <%Dpsit dpsit=dpsitList.get(i);%>
      <tr>
        <td><input type="radio" name="radio" value="<%=dpsit.getDpsit_amount() %>"></td>
        <td><%=dpsit.getDpsit_amount() %>원</td>
        <td><%=dpsit.getDpsit_per()%>%</td>
        <td><%=dpsit.getDpsit_bonus() %>원</td>
      </tr>
     <%} %>
    </tbody>
  </table>
</form>
  <div>
		<button type="button" class="btn btn-secondary" id="bt_charge">충전</button>
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

  <script src="https://js.tosspayments.com/v1/payment"></script>

<script type="text/javascript">
let clientKey = 'test_ck_D5GePWvyJnrK0W0k6q8gLzN97Eoq'
let tossPayments = TossPayments(clientKey); // 클라이언트 키로 초기화하기
let amount=0;

function requestPayment() {
	const random = new Date().getTime() + Math.random();
	const randomId = btoa(random);
	
	tossPayments.requestPayment('가상계좌', { // 결제 수단 파라미터
		  // 결제 정보 파라미터
		  amount: amount,
		  orderId: randomId,
		  orderName: '충전금',
		  customerName: '소정님',
		  successUrl: 'http://localhost:8888/payment/callback/success',	//결제요청성공(결제성공x)
		  failUrl: 'http://localhost:8080/fail',
		  validHours: 24,
		  cashReceipt: {
		    type: '소득공제',
		  },
		})
		.catch(function (error) {
		  if (error.code === 'USER_CANCEL') {
		    // 결제 고객이 결제창을 닫았을 때 에러 처리
		  } else if (error.code === 'INVALID_CARD_COMPANY') {
		    // 유효하지 않은 카드 코드에 대한 에러 처리
		  }
		})
}
</script>

<script type="text/javascript">
function getList(){
	$.ajax({
		url:"/rest/mypage/charge",
		type:"get",
		success:function(result, status, xhr){
		}	
	
	});
}
//비동기로 가져와야, 라디오 박스 선택시 선택 index에 해당하는 객체를 가져올수 있다... 
$(function(){
	getList(); //서버에서 제이슨 목록으로 가져올것임. 왜 제이슨? 제이슨은 객체를 표현할수 있으므로.,.  [제이슨1, 제이슨2,제이슨3...]
    $("#bt_charge").click(function() {
    	
        if ($("input[type=radio][name=radio]:checked").is(':checked')) {
        	//먼저 선택한 충전금이 얼마인지 알아내자
        	let radio=$("input[type=radio][name=radio]:checked");
        	console.log( $(radio).val());
        	amount = $(radio).val();
        	
        	requestPayment(); //결제요청창 호출
        }else {
            alert('충전하실 금액을 선택해주세요!');
        }
    })
	
});
</script>
</body>
</html>