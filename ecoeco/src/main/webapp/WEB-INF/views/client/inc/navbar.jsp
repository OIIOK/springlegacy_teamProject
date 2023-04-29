<%@ page contentType="text/html; charset=UTF-8"%>
<!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light sticky-top px-4 px-lg-5">
        <a href="/" class="navbar-brand d-flex align-items-center">
            <img src="/resources/client/img/EcoHomeLogo.png">
        </a>
        <button type="button" class="navbar-toggler me-0" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
             
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link" data-bs-toggle="dropdown">소개</a>
                    <div class="dropdown-menu bg-light m-0">
                        <a href="gallery.html" class="dropdown-item">회사소개</a>
                        <a href="team_member.jsp" class="dropdown-item">팀원소개</a>
                        <a href="feature.html" class="dropdown-item">유관기관</a>
                        <a href="team.html" class="dropdown-item">기업 후원 안내</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link" data-bs-toggle="dropdown">챌린지</a>
                    <div class="dropdown-menu bg-light m-0">
                        <a href="/challenge/list" class="dropdown-item">공식 챌린지</a>
                        <a href="team.html" class="dropdown-item">sns 챌린지</a>
                        <a href="testimonial.html" class="dropdown-item">콜라보 챌린지</a>
                        <a href="404.html" class="dropdown-item">유저 챌린지</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link" data-bs-toggle="dropdown">후원</a>
                    <div class="dropdown-menu bg-light m-0">
                        <a href="/donation/donationMain" class="dropdown-item">기부</a>
                        <a href="/funding/fundingMain" class="dropdown-item">펀딩</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link" data-bs-toggle="dropdown">커뮤니티</a>
                    <div class="dropdown-menu bg-light m-0">
                        <a href="/community/chatterList" class="dropdown-item">에코 수다</a>
                        <a href="/community/sharingList" class="dropdown-item">에코 나눔</a>
                        <a href="404.html" class="dropdown-item">에코 지도</a>
                        <a href="404.html" class="dropdown-item">에코 뉴스</a>
                    </div>
                </div>
            </div>
            <div class="border-start ps-4 d-none d-lg-block">
                <button type="button" class="btn btn-sm p-0"> <img src="/resources/client/img/LikeIcon.png" width="30"></button>
               
            </div>
        </div>
    </nav>
<!-- Navbar End -->