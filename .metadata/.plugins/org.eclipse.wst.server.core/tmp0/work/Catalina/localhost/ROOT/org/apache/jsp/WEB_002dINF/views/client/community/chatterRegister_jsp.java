/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-04-29 13:04:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.client.community;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.friendly.eco.domain.Chatter;
import java.util.List;
import com.friendly.eco.util.PageManager;
import com.friendly.eco.model.community.MybatisChatterDAO;
import com.friendly.eco.domain.Mem;

public final class chatterRegister_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(8);
    _jspx_dependants.put("/WEB-INF/views/client/community/../inc/capyright.jsp", Long.valueOf(1679398328000L));
    _jspx_dependants.put("/WEB-INF/views/client/community/../inc/footer.jsp", Long.valueOf(1679398328000L));
    _jspx_dependants.put("/WEB-INF/views/client/community/../inc/footer_link.jsp", Long.valueOf(1680152976000L));
    _jspx_dependants.put("/WEB-INF/views/client/community/../inc/navbar.jsp", Long.valueOf(1682771237873L));
    _jspx_dependants.put("/WEB-INF/views/client/community/../inc/back_to_top.jsp", Long.valueOf(1679398328000L));
    _jspx_dependants.put("/WEB-INF/views/client/community/../inc/header_link.jsp", Long.valueOf(1680152882000L));
    _jspx_dependants.put("/WEB-INF/views/client/community/../inc/spinner.jsp", Long.valueOf(1679398328000L));
    _jspx_dependants.put("/WEB-INF/views/client/community/../inc/topbar.jsp", Long.valueOf(1680176358000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.friendly.eco.model.community.MybatisChatterDAO");
    _jspx_imports_classes.add("com.friendly.eco.domain.Chatter");
    _jspx_imports_classes.add("com.friendly.eco.util.PageManager");
    _jspx_imports_classes.add("com.friendly.eco.domain.Mem");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<title>에코수다</title>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<!-- header_link Start -->\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("    <title>EcoEco</title>\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("    <meta content=\"\" name=\"keywords\">\r\n");
      out.write("    <meta content=\"\" name=\"description\">\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<!-- challenge detail  Start-->\r\n");
      out.write("	<!-- Google Font -->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Cookie&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("	 <!-- Css Styles -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/bootstrap.min.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/font-awesome.min.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/elegant-icons.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/jquery-ui.min.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/magnific-popup.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/owl.carousel.min.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/slicknav.min.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/style.css\" type=\"text/css\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- challenge detail  End-->\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("    <!-- Favicon -->\r\n");
      out.write("    <link href=\"img/favicon.ico\" rel=\"icon\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Google Web Fonts -->\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Libre+Baskerville:wght@700&family=Open+Sans:wght@400;500;600&display=swap\" rel=\"stylesheet\">   \r\n");
      out.write("\r\n");
      out.write("    <!-- Icon Font Stylesheet -->\r\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Libraries Stylesheet -->\r\n");
      out.write("    <link href=\"/resources/client/lib/animate/animate.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"/resources/client/lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"/resources/client/lib/lightbox/css/lightbox.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("    <link href=\"/resources/client/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Template Stylesheet -->\r\n");
      out.write("    <link href=\"/resources/client/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- summernote -->\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"/resources/client/plugins/summernote/summernote-bs4.min.css\">\r\n");
      out.write("	\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<!-- header_link End -->\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled and minified CSS -->\r\n");
      out.write("<!-- 기본 템플릿 설정과 충돌함, 호버 효과는 포기하자!\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\r\n");
      out.write("	 -->\r\n");
      out.write("<!-- jQuery library -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js\"></script>\r\n");
      out.write("<!-- Popper JS -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<!-- Latest compiled JavaScript -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write(".box-style{\r\n");
      out.write("	width:150px;\r\n");
      out.write("	height:150px;\r\n");
      out.write("	border:1px solid #ccc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".box-style img{\r\n");
      out.write("	width:150px;\r\n");
      out.write("	height:150px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- Spinner Start -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("    <!-- Spinner Start -->\r\n");
      out.write("    <div id=\"spinner\" class=\"show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center\">\r\n");
      out.write("        <div class=\"spinner-border text-primary\" role=\"status\" style=\"width: 3rem; height: 3rem;\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Spinner End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- Spinner End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- Topbar Start -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Topbar Start -->\r\n");
      out.write("    <div class=\"container-fluid bg-dark px-0\">\r\n");
      out.write("        <div class=\"row g-0 d-none d-lg-flex\">\r\n");
      out.write("            <div class=\"col-lg-6 ps-5 text-start\">\r\n");
      out.write("                <div class=\"h-100 d-inline-flex align-items-center text-light\">\r\n");
      out.write("                    <span></span>\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("             <div class=\"col-lg-6 text-end\">\r\n");
      out.write("             ");
if(session.getAttribute("mem")==null){
      out.write("\r\n");
      out.write("                <a class=\"btn btn-link text-light\" id=\"a_login\"><i class=\"fab fa-linkedin-in\"></i></a>\r\n");
      out.write("                <div class=\"h-100 bg-secondary d-inline-flex align-items-center text-dark py-2 px-4\">\r\n");
      out.write("                    <a href=\"#\" id=\"bt_goRegist\"><span class=\"me-2 fw-semi-bold\">회원가입</span></a>\r\n");
      out.write("              ");
}else{
      out.write("    \r\n");
      out.write("              ");

                     Mem mem=(Mem)session.getAttribute("mem");
               
      out.write("\r\n");
      out.write("                <a class=\"btn btn-link text-light\" id=\"bt_logout\"><b>Logout</b></i></a>\r\n");
      out.write("                <div class=\"h-100 bg-secondary d-inline-flex align-items-center text-dark py-2 px-4\">\r\n");
      out.write("                    <a href=\"#\" id=\"bt_goMypage\"><span class=\"me-2 fw-semi-bold\">");
      out.print(mem.getMem_id() );
      out.write("님</span></a>\r\n");
      out.write("               ");
} 
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Topbar End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- Topbar End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- Navbar Start -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<!-- Navbar Start -->\r\n");
      out.write("    <nav class=\"navbar navbar-expand-lg bg-white navbar-light sticky-top px-4 px-lg-5\">\r\n");
      out.write("        <a href=\"/\" class=\"navbar-brand d-flex align-items-center\">\r\n");
      out.write("            <img src=\"/resources/client/img/EcoHomeLogo.png\">\r\n");
      out.write("        </a>\r\n");
      out.write("        <button type=\"button\" class=\"navbar-toggler me-0\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarCollapse\">\r\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\r\n");
      out.write("            <div class=\"navbar-nav ms-auto p-4 p-lg-0\">\r\n");
      out.write("             \r\n");
      out.write("                <div class=\"nav-item dropdown\">\r\n");
      out.write("                    <a href=\"#\" class=\"nav-link\" data-bs-toggle=\"dropdown\">소개</a>\r\n");
      out.write("                    <div class=\"dropdown-menu bg-light m-0\">\r\n");
      out.write("                        <a href=\"gallery.html\" class=\"dropdown-item\">회사소개</a>\r\n");
      out.write("                        <a href=\"team_member.jsp\" class=\"dropdown-item\">팀원소개</a>\r\n");
      out.write("                        <a href=\"feature.html\" class=\"dropdown-item\">유관기관</a>\r\n");
      out.write("                        <a href=\"team.html\" class=\"dropdown-item\">기업 후원 안내</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"nav-item dropdown\">\r\n");
      out.write("                    <a href=\"#\" class=\"nav-link\" data-bs-toggle=\"dropdown\">챌린지</a>\r\n");
      out.write("                    <div class=\"dropdown-menu bg-light m-0\">\r\n");
      out.write("                        <a href=\"/challenge/list\" class=\"dropdown-item\">공식 챌린지</a>\r\n");
      out.write("                        <a href=\"team.html\" class=\"dropdown-item\">sns 챌린지</a>\r\n");
      out.write("                        <a href=\"testimonial.html\" class=\"dropdown-item\">콜라보 챌린지</a>\r\n");
      out.write("                        <a href=\"404.html\" class=\"dropdown-item\">유저 챌린지</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"nav-item dropdown\">\r\n");
      out.write("                    <a href=\"#\" class=\"nav-link\" data-bs-toggle=\"dropdown\">후원</a>\r\n");
      out.write("                    <div class=\"dropdown-menu bg-light m-0\">\r\n");
      out.write("                        <a href=\"/donation/donationMain\" class=\"dropdown-item\">기부</a>\r\n");
      out.write("                        <a href=\"/funding/fundingMain\" class=\"dropdown-item\">펀딩</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"nav-item dropdown\">\r\n");
      out.write("                    <a href=\"#\" class=\"nav-link\" data-bs-toggle=\"dropdown\">커뮤니티</a>\r\n");
      out.write("                    <div class=\"dropdown-menu bg-light m-0\">\r\n");
      out.write("                        <a href=\"/community/chatterList\" class=\"dropdown-item\">에코 수다</a>\r\n");
      out.write("                        <a href=\"/community/sharingList\" class=\"dropdown-item\">에코 나눔</a>\r\n");
      out.write("                        <a href=\"404.html\" class=\"dropdown-item\">에코 지도</a>\r\n");
      out.write("                        <a href=\"404.html\" class=\"dropdown-item\">에코 뉴스</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"border-start ps-4 d-none d-lg-block\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-sm p-0\"> <img src=\"/resources/client/img/LikeIcon.png\" width=\"30\"></button>\r\n");
      out.write("               \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("<!-- Navbar End -->");
      out.write("\r\n");
      out.write("	<!-- Navbar End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- Page Header Start -->\r\n");
      out.write("	<div class=\"container-fluid page-header py-5 mb-5 wow fadeIn\"\r\n");
      out.write("		data-wow-delay=\"0.1s\">\r\n");
      out.write("		<div class=\"container text-center py-5\">\r\n");
      out.write("			<h1 class=\"display-3 text-white mb-4 animated slideInDown\">에코수다</h1>\r\n");
      out.write("                        <nav aria-label=\"breadcrumb animated slideInDown\">\r\n");
      out.write("                                <h5 class=\"text-white\">자유롭게 이야기를 나누는 공간입니다.</h5>\r\n");
      out.write("                        </nav>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<!-- Page Header End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<div class=\"container-fluid\">\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<h3 class=\"card-title\" style=\"padding: 50px 0 25px 0\">글등록</h3>\r\n");
      out.write("			<!-- 제목 -->\r\n");
      out.write("			<div class=\"row\" style=\"float: none; margin: 0 auto; padding: 0 0 25px 0\">\r\n");
      out.write("				<div class=\"col-lg-12\" style=\"float: none; margin: 0 auto\">	\r\n");
      out.write("					<div class=\"form-group\">\r\n");
      out.write("	                	<input type=\"text\" class=\"form-control input-default \" placeholder=\"제목을 입력하세요\" name=\"chatter_title\">\r\n");
      out.write("	                </div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<!-- 제목 -->\r\n");
      out.write("			\r\n");
      out.write("			<!-- 써머노트 -->\r\n");
      out.write("				<div class=\"row\">\r\n");
      out.write("			    <div class=\"col-xl-12 col-xxl-12\" style=\"float: none; margin: 0 auto; padding: 0 0 25px 0\">\r\n");
      out.write("			    	<textarea type=\"text\" class=\"form-comtrol\" name=\"chatter_detail\"></textarea> \r\n");
      out.write("			    </div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<!-- 써머노트 -->\r\n");
      out.write("			\r\n");
      out.write("			<!-- 파일탐색기 -->\r\n");
      out.write("			<div class=\"row form-group\" style=\"padding: 0 0 25px 0\">\r\n");
      out.write("					<div class=\"col\">\r\n");
      out.write("						<input type=\"file\" class=\"form-control\" id=\"chatter_flie\" name=\"chatter_flie\">\r\n");
      out.write("						<!-- DTO 파라미터명과 일치해야함 -->\r\n");
      out.write("					</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<!-- 파일탐색기 -->	\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"row\" style=\"padding: 0 0 50px 0\">\r\n");
      out.write("				<!-- 파일미리보기 -->\r\n");
      out.write("				<div class=\"col\" align=\"left\">\r\n");
      out.write("					<div class=\"box-style\">\r\n");
      out.write("						<img id=\"chatter_thumbnail\" name=\"chatter_thumbnail\">\r\n");
      out.write("						<!-- DTO 파라미터명과 일치해야함 -->\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- 파일미리보기 -->\r\n");
      out.write("				\r\n");
      out.write("				<!-- 버튼 -->\r\n");
      out.write("				<div class=\"col \" align=\"right\">	\r\n");
      out.write("					<div class=\"btn-group\" role=\"group\" aria-label=\"기본 예\">\r\n");
      out.write("		            	<button type=\"button\" class=\"btn btn-secondary\" id=\"bt_register\"><font style=\"vertical-align: inherit;\"><font style=\"vertical-align: inherit;\">등록</font></font></button>\r\n");
      out.write("		                <button type=\"button\" class=\"btn btn-secondary\" id=\"bt_list\"><font style=\"vertical-align: inherit;\"><font style=\"vertical-align: inherit;\">목록</font></font></button>\r\n");
      out.write("		             </div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- 버튼 -->\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- Footer Start -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("    <!-- Footer Start -->\r\n");
      out.write("    <div class=\"container-fluid bg-dark footer mt-5 py-5 wow fadeIn\" data-wow-delay=\"0.1s\">\r\n");
      out.write("        <div class=\"container py-5\">\r\n");
      out.write("            <div class=\"row g-5\">\r\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                    <h5 class=\"text-white mb-4\">Our Office</h5>\r\n");
      out.write("                    <p class=\"mb-2\"><i class=\"fa fa-map-marker-alt me-3\"></i>123 Street, New York, USA</p>\r\n");
      out.write("                    <p class=\"mb-2\"><i class=\"fa fa-phone-alt me-3\"></i>+012 345 67890</p>\r\n");
      out.write("                    <p class=\"mb-2\"><i class=\"fa fa-envelope me-3\"></i>info@example.com</p>\r\n");
      out.write("                    <div class=\"d-flex pt-3\">\r\n");
      out.write("                        <a class=\"btn btn-square btn-secondary rounded-circle me-2\" href=\"\"><i class=\"fab fa-twitter\"></i></a>\r\n");
      out.write("                        <a class=\"btn btn-square btn-secondary rounded-circle me-2\" href=\"\"><i class=\"fab fa-facebook-f\"></i></a>\r\n");
      out.write("                        <a class=\"btn btn-square btn-secondary rounded-circle me-2\" href=\"\"><i class=\"fab fa-youtube\"></i></a>\r\n");
      out.write("                        <a class=\"btn btn-square btn-secondary rounded-circle me-2\" href=\"\"><i class=\"fab fa-linkedin-in\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                    <h5 class=\"text-white mb-4\">Quick Links</h5>\r\n");
      out.write("                    <a class=\"btn btn-link\" href=\"\">About Us</a>\r\n");
      out.write("                    <a class=\"btn btn-link\" href=\"\">Contact Us</a>\r\n");
      out.write("                    <a class=\"btn btn-link\" href=\"\">Our Services</a>\r\n");
      out.write("                    <a class=\"btn btn-link\" href=\"\">Terms & Condition</a>\r\n");
      out.write("                    <a class=\"btn btn-link\" href=\"\">Support</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                    <h5 class=\"text-white mb-4\">Business Hours</h5>\r\n");
      out.write("                    <p class=\"mb-1\">Monday - Friday</p>\r\n");
      out.write("                    <h6 class=\"text-light\">09:00 am - 07:00 pm</h6>\r\n");
      out.write("                    <p class=\"mb-1\">Saturday</p>\r\n");
      out.write("                    <h6 class=\"text-light\">09:00 am - 12:00 pm</h6>\r\n");
      out.write("                    <p class=\"mb-1\">Sunday</p>\r\n");
      out.write("                    <h6 class=\"text-light\">Closed</h6>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                    <h5 class=\"text-white mb-4\">Newsletter</h5>\r\n");
      out.write("                    <p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>\r\n");
      out.write("                    <div class=\"position-relative w-100\">\r\n");
      out.write("                        <input class=\"form-control bg-transparent w-100 py-3 ps-4 pe-5\" type=\"text\" placeholder=\"Your email\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary py-2 position-absolute top-0 end-0 mt-2 me-2\">SignUp</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Footer End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- Footer End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- Copyright Start -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("    <!-- Copyright Start -->\r\n");
      out.write("    <div class=\"container-fluid bg-secondary text-body copyright py-4\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-6 text-center text-md-start mb-3 mb-md-0\">\r\n");
      out.write("                    &copy; <a class=\"fw-semi-bold\" href=\"#\">Your Site Name</a>, All Right Reserved.\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6 text-center text-md-end\">\r\n");
      out.write("                    <!--/*** This template is free as long as you keep the footer authorâs credit link/attribution link/backlink. If you'd like to use the template without the footer authorâs credit link/attribution link/backlink, you can purchase the Credit Removal License from \"https://htmlcodex.com/credit-removal\". Thank you for your support. ***/-->\r\n");
      out.write("                    Designed By <a class=\"fw-semi-bold\" href=\"https://htmlcodex.com\">HTML Codex</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Copyright End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- Copyright End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- Back to Start -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("    <!-- Back to Top -->\r\n");
      out.write("    <a href=\"#\" class=\"btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top\"><i class=\"bi bi-arrow-up\"></i></a>\r\n");
      out.write("\r\n");
      out.write("	<!-- Back to End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- Footer link Start -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- challenge Detail Start -->\r\n");
      out.write("	 <!-- Js Plugins -->\r\n");
      out.write("    <script src=\"/resources/shop/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("    <script src=\"/resources/shop/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"/resources/shop/js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("    <script src=\"/resources/shop/js/jquery-ui.min.js\"></script>\r\n");
      out.write("    <script src=\"/resources/shop/js/mixitup.min.js\"></script>\r\n");
      out.write("    <script src=\"/resources/shop/js/jquery.countdown.min.js\"></script>\r\n");
      out.write("    <script src=\"/resources/shop/js/jquery.slicknav.js\"></script>\r\n");
      out.write("    <script src=\"/resources/shop/js/owl.carousel.min.js\"></script>\r\n");
      out.write("    <script src=\"/resources/shop/js/jquery.nicescroll.min.js\"></script>\r\n");
      out.write("    <script src=\"/resources/shop/js/main.js\"></script>\r\n");
      out.write("   	<!-- challenge Detail End -->\r\n");
      out.write("   	\r\n");
      out.write("	<!-- JavaScript Libraries -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    <script href=\"/resources/client/lib/wow/wow.min.js\"></script>\r\n");
      out.write("    <script href=\"/resources/client/lib/easing/easing.min.js\"></script>\r\n");
      out.write("    <script href=\"/resources/client/lib/waypoints/waypoints.min.js\"></script>\r\n");
      out.write("    <script href=\"/resources/client/lib/owlcarousel/owl.carousel.min.js\"></script>\r\n");
      out.write("    <script href=\"/resources/client/lib/counterup/counterup.min.js\"></script>\r\n");
      out.write("    <script href=\"/resources/client/lib/parallax/parallax.min.js\"></script>\r\n");
      out.write("    <script href=\"/resources/client/lib/lightbox/js/lightbox.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Template Javascript -->\r\n");
      out.write("    <script src=\"/resources/client/js/main.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- Summernote -->\r\n");
      out.write("	<script src=\"/resources/client/plugins/summernote/summernote-bs4.min.js\"></script>\r\n");
      out.write("	\r\n");
      out.write("	<!-- Vue -->\r\n");
      out.write("	<script src=\"https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!-- Footer link End -->\r\n");
      out.write("	\r\n");
      out.write("	<!-- -------------------------------------------------------------------------------- -->\r\n");
      out.write("\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("	\r\n");
      out.write("	let fileObj;\r\n");
      out.write("	let key=0;\r\n");
      out.write("	\r\n");
      out.write("	//썸네일 미리보기\r\n");
      out.write("	function preview(file){\r\n");
      out.write("		\r\n");
      out.write("		//선택한 첫번째 파일[0]을 file로 끌어옴\r\n");
      out.write("		fileObj = file;\r\n");
      out.write("		console.log(\"fileObj 정보 : \",fileObj); //[object File]\r\n");
      out.write("		\r\n");
      out.write("		let reader = new FileReader(); //스트림 생성\r\n");
      out.write("		//로드되면 가동됨\r\n");
      out.write("		reader.onload=(e)=>{\r\n");
      out.write("			console.log(\"선택한 파일의 바이너리 정보 : \", e.target.result); \r\n");
      out.write("			\r\n");
      out.write("			//file=e.target.result;\r\n");
      out.write("			//attr : 속성값을 가져옴 / src는 지어준 이름\r\n");
      out.write("			//$(\"img[name='chatter_thumbnail']\").attr(\"src\",file);\r\n");
      out.write("			//-> chatterList에서 썸네일을 띄우기 위해 file 대신 json으로 받기로 함\r\n");
      out.write("			\r\n");
      out.write("			key++;\r\n");
      out.write("			\r\n");
      out.write("			let json=[];\r\n");
      out.write("			json['key']=key; //기준값(다른 예제에서 이미지 삭제할 때 썼던 값인데 일단 넣어놓음)\r\n");
      out.write("			json['binary']=e.target.result; //바이너리 정보\r\n");
      out.write("			json['file']=file;\r\n");
      out.write("			$(\"img[name='chatter_thumbnail']\").attr(\"src\",json.binary);\r\n");
      out.write("			\r\n");
      out.write("			console.log(\"넘겨받은 json : \", json);\r\n");
      out.write("		}\r\n");
      out.write("		reader.readAsDataURL(file);  //URL로 파일 읽어서 미리보여줌\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	//등록하기\r\n");
      out.write("	function register(){\r\n");
      out.write("		\r\n");
      out.write("		//입력값 formData로 담기(전송 대상에 이미지가 포함되기 때문)\r\n");
      out.write("		let formData = new FormData();\r\n");
      out.write("		//formData.append(\"mem.mem_idx\", 1); //로그인시확인되는아이디로 수정해줘야해~~~~~~~~~~~~~\r\n");
      out.write("		formData.append(\"chatter_title\", $(\"input[name='chatter_title']\").val());\r\n");
      out.write("		formData.append(\"chatter_detail\", $(\"textarea[name='chatter_detail']\").val());\r\n");
      out.write("		formData.append(\"chatter_flie\", fileObj); //파일 자체\r\n");
      out.write("		formData.append(\"chatter_thumbnail\", $(\"img[name='chatter_thumbnail']\").val()); //파일 이름\r\n");
      out.write("		\r\n");
      out.write("		//controller로 전송하기\r\n");
      out.write("		//processData:false, contentType:false 반드시 false여야 전송됨\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url:\"/rest/community/chatter\", \r\n");
      out.write("			type:\"POST\",\r\n");
      out.write("			data:formData,\r\n");
      out.write("			processData:false,\r\n");
      out.write("			contentType:false,\r\n");
      out.write("			success:function(result, status, xhr){\r\n");
      out.write("				console.log(\"입력정보\", result.msg);\r\n");
      out.write("				alert(\"등록 완료 :)\");\r\n");
      out.write("				location.href=\"/community/chatterList\" //목록으로 돌아가기\r\n");
      out.write("			},\r\n");
      out.write("			error:function(xhr, status, result){\r\n");
      out.write("				console.log(\"xhr : \", xhr);\r\n");
      out.write("				console.log(\"status : \", status);\r\n");
      out.write("				console.log(\"result : \", result);\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	//init\r\n");
      out.write("	$(function(){\r\n");
      out.write("		\r\n");
      out.write("		//서머노트 적용\r\n");
      out.write(" 		$(\"textarea[name='chatter_detail']\").summernote({\r\n");
      out.write(" 			placeholder: '내용을 입력하세요',\r\n");
      out.write("			height: 300\r\n");
      out.write("		}); \r\n");
      out.write("		\r\n");
      out.write("		//파일편집기에 이벤트 연결\r\n");
      out.write("		$(\"input[name='chatter_flie']\").change(function(){\r\n");
      out.write("			//alert(\"파일 선택했어!\");\r\n");
      out.write("			console.log(\"선택한 파일 정보 : \"+this.files); //[object FileList]\r\n");
      out.write("			preview(this.files[0]); //썸네일 미리보기\r\n");
      out.write("			//배열로 나오는 결과물 중 첫번째 파일 하나만 필요하니 순서를 [0]으로 명시함\r\n");
      out.write("		});\r\n");
      out.write("\r\n");
      out.write("		\r\n");
      out.write(" 		//등록버튼 이벤트 연결\r\n");
      out.write("		$(\"#bt_register\").click(function(){\r\n");
      out.write("			register();\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		//목록버튼 이벤트 연결\r\n");
      out.write("		$(\"#bt_list\").click(function(){\r\n");
      out.write("			location.href=\"/community/chatterList\"\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
