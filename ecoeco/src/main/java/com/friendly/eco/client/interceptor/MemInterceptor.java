package com.friendly.eco.client.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
							throws Exception{
		//session 객체를 가져옴
		HttpSession session = request.getSession();
		//login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
		Object obj = session.getAttribute("mem");
		
		if(obj==null) {
			//로그인이 안 되어있으므로 로그인 폼으로 다시 돌려보냄
			response.sendRedirect("/client/member/loginMain");
			return false;
		}
		//preHandle의 return은 컨트롤러 요청 uri로 가도되는지를 허가하는 의미
		//따라서 true로 설정할 경우, 컨트롤러 uri으로 가게 됨
		return true;
	}
	
	//controller의 메서드가 수행이 완료되고, view를 호출하기 전에 호출됨
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
					  ModelAndView mav) throws Exception{
		super.postHandle(request, response, handler, mav);
	}
	
}
