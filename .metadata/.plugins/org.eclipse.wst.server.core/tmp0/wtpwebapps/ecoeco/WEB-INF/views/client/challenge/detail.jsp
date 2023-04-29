<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.friendly.eco.domain.Challenge"%>
<%
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
        <div class="container">
            <div class="row">

				<div class="col-lg-6">
					<div class="product__details__pic">
						<div class="product__details__slider__content">
							<div class="product__details__pic__slider owl-carousel">
								<img data-hash="product-1" class="product__big__img" src="/resources/data/challenge/<%=challenge.getChallenge_thumb()%>">
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-6">
					<div class="product__details__text">
						<%
							if (challenge.getChallenge_point() > 0) {
						%>
						<h3>[특별상금
							<%=challenge.getChallenge_point()%>]
							<%=challenge.getChallenge_title()%></span></h3>
						<%} else {%>
						<h3><%=challenge.getChallenge_title()%></span></h3>
						<%}%>
						<div class="row">
							<div class="col-sm-6">
								<p>인증빈도수</p>
							</div>
							<div class="col-sm-6">
								<p><%=challenge.getChallenge_req()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<p>참여기간</p>
							</div>
							<div class="col-sm-6">
								<p><%=challenge.getChallenge_startdate()%>
									~
									<%=challenge.getChallenge_enddate()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<p>시작일자</p>
							</div>
							<div class="col-sm-6">
								<p><%=challenge.getChallenge_startdate()%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="d-flex justify-content-center">
									<button type="button" class="btn btn-secondary rounded-pill py-1 px-5" id="bt_regist">참여하기</button>
									<a class="btn btn-square btn-outline-secondary rounded-circle mx-1" href="">♡</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Description</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Specification</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">Reviews ( 2 )</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <h6>Description</h6>
                                <p><%=challenge.getChallenge_detail() %></p>
                            </div>
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <h6>Specification</h6>
                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed
                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt loret.
                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si. Nemo enim ipsam
                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed quia ipsu
                                    consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Nulla
                                consequat massa quis enim.</p>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
                                    nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
                                quis, sem.</p>
                            </div>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <h6>Reviews ( 2 )</h6>
                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed
                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt loret.
                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si. Nemo enim ipsam
                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed quia ipsu
                                    consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Nulla
                                consequat massa quis enim.</p>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
                                    nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
                                quis, sem.</p>
                            </div>
                        </div>
                    </div>
                </div>
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
	$(function(){
		$("#bt_regist").click(function(){
			location.href="/challenge/registform?challenge_idx=<%=challenge.getChallenge_idx()%>";
		});
	});
</script>
</html>