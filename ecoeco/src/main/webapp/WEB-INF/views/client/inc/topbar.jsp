<%@page import="com.friendly.eco.domain.Mem"%>
<%@ page contentType="text/html; charset=UTF-8"%>
    <!-- Topbar Start -->
    <div class="container-fluid bg-dark px-0">
        <div class="row g-0 d-none d-lg-flex">
            <div class="col-lg-6 ps-5 text-start">
                <div class="h-100 d-inline-flex align-items-center text-light">
                    <span></span>
                    
                </div>
            </div>
             <div class="col-lg-6 text-end">
             <%if(session.getAttribute("mem")==null){%>
                <a class="btn btn-link text-light" id="a_login"><i class="fab fa-linkedin-in"></i></a>
                <div class="h-100 bg-secondary d-inline-flex align-items-center text-dark py-2 px-4">
                    <a href="#" id="bt_goRegist"><span class="me-2 fw-semi-bold">회원가입</span></a>
              <%}else{%>    
              <%
                     Mem mem=(Mem)session.getAttribute("mem");
               %>
                <a class="btn btn-link text-light" id="bt_logout"><b>Logout</b></i></a>
                <div class="h-100 bg-secondary d-inline-flex align-items-center text-dark py-2 px-4">
                    <a href="#" id="bt_goMypage"><span class="me-2 fw-semi-bold"><%=mem.getMem_id() %>님</span></a>
               <%} %>
                </div>

            </div>
        </div>
    </div>
    <!-- Topbar End -->
