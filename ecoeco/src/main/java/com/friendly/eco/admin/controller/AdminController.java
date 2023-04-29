package com.friendly.eco.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	//admin main 요청처리
	@GetMapping("/main")
	public ModelAndView getMain(HttpServletRequest request) {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/index");
		
		return mav;
	}
	
	//모든 기부글 조회 
	@GetMapping("/main/donationMain")
	public ModelAndView getDonation(HttpServletRequest request) {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/donation/donationList");
		
		return mav;
	}
}
