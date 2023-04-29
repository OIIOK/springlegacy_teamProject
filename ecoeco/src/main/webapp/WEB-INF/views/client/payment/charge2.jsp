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
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("#bt_charge").click(function() {
        if ($("input[type=radio][name=radio]:checked").is(':checked')) {
        	location.href="/mypage/charge_payment";
        }
        else {
            alert('충전하실 금액을 선택해주세요!');
        }
    })
});
</script>
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
    <%
    	for(int i=0;i<dpsitList.size();i++){
    %>
    <%
    	Dpsit dpsit=dpsitList.get(i);
    %>
      <tr>
        <td><input type="radio" name="radio""></td>
        <td><%=dpsit.getDpsit_amount() %>원</td>
        <td><%=dpsit.getDpsit_per()%>%</td>
        <td><%=dpsit.getDpsit_bonus() %>원</td>
      </tr>
     <%} %>
    </tbody>
  </table>
</form>
  <div>
		<button type="submit" class="btn btn-secondary" id="bt_charge">충전</button>
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
		
	});
	</script>
</body>
</html>