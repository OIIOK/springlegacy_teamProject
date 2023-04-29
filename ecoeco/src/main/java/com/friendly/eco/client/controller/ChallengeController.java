package com.friendly.eco.client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.friendly.eco.domain.ChallConf;
import com.friendly.eco.domain.Challenge;
import com.friendly.eco.domain.Challenger;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.model.challenge.ChallengeService;
import com.friendly.eco.model.challenge.ChallengerService;

@Controller
public class ChallengeController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ChallengeService challengeService;
	
	@Autowired
	private ChallengerService challengerService;
	
	/*------------------------------------------
		챌린지 목록 요청
	------------------------------------------*/
	@GetMapping("/challenge/list")
	public ModelAndView getList(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("client/challenge/list");
		
		return mav;
	}
	
	/*------------------------------------------
		챌린지 상세화면 요청처리
	------------------------------------------*/
	@GetMapping("/challenge/detail")
	public ModelAndView getDetail(HttpServletRequest request, int challenge_idx) {
		//챌린지 1건 가져오기
		Challenge challenge=challengeService.select(challenge_idx);
		
		ModelAndView mav=new ModelAndView("client/challenge/detail");
		mav.addObject("challenge", challenge);
		
		return mav;
	}
	
	/*------------------------------------------
		챌린지 참여폼 요청처리
	------------------------------------------*/
	@GetMapping("/challenge/registform")
	public ModelAndView getRegistForm(HttpServletRequest request, int challenge_idx) {
		//logger.info("registform 호출됨");
		
		//회원 예치금 가라데이터
		Mem mem=new Mem();
		mem.setMem_idx(2);
		
		int mem_deposit=20000;  //회원의 총 예치금
		
		//로그인했다는 가정 하에 session에 담기
		HttpSession session=request.getSession();
		session.setAttribute("mem", mem);
		
		Challenge challenge=challengeService.select(challenge_idx);
		
		ModelAndView mav=new ModelAndView("client/challenge/regist");
		mav.addObject("mem_deposit", mem_deposit);
		mav.addObject("challenge", challenge);
		
		return mav;
	}
	
	/*------------------------------------------
		챌린지 참여하기 요청차리
	------------------------------------------*/	
	@PostMapping("/challenge/regist")
	public ModelAndView regist(HttpServletRequest request, Challenger challenger) {
		logger.info("regist 호출됨");
		
		//회원관련
		Mem mem=new Mem();
		mem.setMem_idx(2);
		
		//로그인했다는 가정 하에 session에 담기
		HttpSession session=request.getSession();
		session.setAttribute("mem", mem);
		challenger.setMem(mem);
		
		//등록 요청
		challengerService.insert(challenger);
		
		//redirect : 컨트롤러의 매핑주소일뿐 실제 파일명이 아님
		ModelAndView mav=new ModelAndView("redirect:/challenge/list");
		
		return mav;
	}
}
