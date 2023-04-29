package com.friendly.eco.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.friendly.eco.domain.Challenge;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.model.challenge.ChallengeService;
import com.friendly.eco.model.challenge.ChallengeTypeService;
import com.friendly.eco.model.challenge.ChallengerService;

@Controller
public class ChallengeController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ChallengeService challengeService;
	
	@Autowired
	private ChallengeTypeService challengeTypeService;
	
	@Autowired
	private ChallengerService challengerService;
	
	/*------------------------------------------
		챌린지 등록폼 요청처리
	------------------------------------------*/
	@GetMapping("/challenge/registform")
	public ModelAndView getRegistForm(HttpServletRequest request) {
		
		//챌린지 타입 가져오기
		List challengeTypeList=challengeTypeService.selectAll();
		
		//회원정보, 예치금 정보 가라데이터
		Mem mem=new Mem();
		mem.setMem_idx(2);
		int mem_deposit=20000;  //회원의 총 예치금
		
		//로그인했다는 가정 하에 session에 담기
		HttpSession session=request.getSession();
		session.setAttribute("mem", mem);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("challengeTypeList", challengeTypeList);
		mav.addObject("mem_deposit", mem_deposit);
		mav.setViewName("admin/challenge/regist");
		
		return mav;
	}
	
	/*------------------------------------------
		챌린지 목록화면 요청처리
	------------------------------------------*/
	@GetMapping("/challenge/list")
	public ModelAndView getList(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("admin/challenge/list");
		
		return mav;
	}
	
	/*------------------------------------------
		챌린지 상세화면 요청처리
	------------------------------------------*/
	@GetMapping("/challenge/detail")
	public ModelAndView getDetail(HttpServletRequest request, int challenge_idx) {
		//챌린지 1건 가져오기
		Challenge challenge=challengeService.select(challenge_idx);
		
		//회원정보, 예치금 정보 가라데이터
		Mem mem=new Mem();
		mem.setMem_idx(2);
		int mem_deposit=20000;  //회원의 총 예치금
		
		//챌린저 관련 정보
		List challengerList=challengerService.selectAll();
		
		//logger.info("challenge_fee_min"+challenge.getChallenge_fee_min());
		//logger.info("challenge_fee_max"+challenge.getChallenge_fee_max());
		
		//로그인했다는 가정 하에 session에 담기
		HttpSession session=request.getSession();
		session.setAttribute("mem", mem);
		
		ModelAndView mav=new ModelAndView("admin/challenge/detail");
		mav.addObject("challenge", challenge);  //챌린지 정보
		mav.addObject("mem_deposit", mem_deposit);  //총 예치금 정보
		mav.addObject("challengerList", challengerList);  //챌린저 정보
		
		return mav;
	}
	
	/*------------------------------------------
		챌린지 삭제 요청처리
		@PathVariable : URL경로에 변수가 포함되어 있음을 의미하며 변수의 자료형과 이름 값을 파라미터로 추출함
	------------------------------------------*/
	@GetMapping("/challenge/delete/{challenge_idx}")
	public ModelAndView delete(@PathVariable int challenge_idx, HttpServletRequest request) {
		logger.info("삭제될 챌린지 번호는 "+challenge_idx);
		
		//3단계) 삭제하기
		challengeService.delete(challenge_idx);
		
		ModelAndView mav=new ModelAndView("redirect:/admin/challenge/list");
		
		return mav;
	}
	
	/*------------------------------------------
		챌린저 인증사진 목록 요청처리 
	------------------------------------------*/
	@GetMapping("/challenger/challConf")
	public ModelAndView getList(HttpServletRequest request, int challenger_idx) {
		
		
		ModelAndView mav=new ModelAndView("admin/challenge/challConf");
		mav.addObject("challenger_idx", challenger_idx );
		return mav;
	}
	
	/*------------------------------------------
		챌린저 인증사진 승인 요청처리
	------------------------------------------*/
	@PostMapping("/challenger/auth")
	public ModelAndView setAuth() {
		
		return null;
	}
	
}
