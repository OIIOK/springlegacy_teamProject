package com.friendly.eco.client.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {
	//mypage main 요청처리
	@GetMapping("/mypage")
	public ModelAndView getMyPage() {
		
		ModelAndView mav=new ModelAndView("client/mypage/main");
		
		return mav;
	}
	
	//마이페이지 > 챌린지 화면 요청처리
	@GetMapping("/mypage/challenge")
	public ModelAndView getMyPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("client/mypage/challenge/list");
		return mav;
	}
	

	//마이페이지 > 챌린지 > 상세 화면 화면 요청처리
	@GetMapping("/mypage/challenge/detail")
	public ModelAndView getDetail(HttpServletRequest request, int challenger_idx) {
		ModelAndView mav = new ModelAndView("client/mypage/challenge/detail");
		
		return mav;
	}
	
}
