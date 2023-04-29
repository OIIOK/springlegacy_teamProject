package com.friendly.eco.client.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	//client 메인 요청처리
	@GetMapping("/")
	public ModelAndView getMain(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/client/index");
		
		return mav;
	}
}
