<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<!-- header_link Start -->
	<%@ include file="../inc/header_link.jsp" %>
	<!-- header_link End -->
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

	<!-- 양식 start -->
	<section>
    	<div class="container">
    		<div class="row m-5">
    			<div class="col">
				    <form id="form1">
				        <div class="form-group">
				            <input type="text" class="form-control" placeholder="Enter id" name="id">
				        </div>
				        <div class="form-group">
				            <input type="text" class="form-control" placeholder="Enter pass" name="pass">
				        </div>
				        <div class="form-group">
				            <input type="text" class="form-control" placeholder="Enter name" name="name">
				        </div>
				        <div class="form-group">
				            <input type="text" class="form-control" placeholder="Enter email" name="email">
				        </div>
				        <button type="button" class="btn btn-primary" id="bt_registasync">가입</button>
				    </form>
    			
    			</div>
    		</div>
    	</div>
    </section>
    
	
	<!-- 양식 end -->

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
	
	
	<script type="text/javascript">
	function regist(){
		let formData=$("#form1").serialize(); //쿼리 스트링으로 변환
		
		//비동기요청
		$.ajax({
			url: "/rest/member",
			type: "GET",
			data: formData,
			success: function(result, status, xhr){
				alert(result.msg);
			},
			error:function(xhr, status, err){
				let json=JSON.parse(xhr.responseText);
				alert(json.msg);
			}
		});
		
	}

	$(function(){
		$("#bt_regist").click(function(){
			regist();
		});
	});
	
</script>
</body>

</html>