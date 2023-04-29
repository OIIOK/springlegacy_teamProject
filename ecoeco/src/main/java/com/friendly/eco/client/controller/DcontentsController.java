package com.friendly.eco.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.friendly.eco.domain.Challenge;
import com.friendly.eco.domain.Dcontents;
import com.friendly.eco.domain.Dpostscript;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.model.donation.DcontentsService;
import com.friendly.eco.util.DateManager;

@Controller
//기부글 관련 컨트롤러
public class DcontentsController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DcontentsService dcontentsService;
	
	@Autowired
	private DateManager dateManager;
	//모든 사람이 볼 수 있음
	//1.모든 진행중인 기부글 리스트
	/*
	 * @GetMapping("/donation/donationMain") public ModelAndView getDonationList() {
	 * //3단계 List dcontentsList=dcontentsService.selectAll();
	 * 
	 * //4단계 저장하기 ModelAndView mav= new
	 * ModelAndView("client/donation/donationList"); mav.addObject("dcontentsList",
	 * dcontentsList); logger.info("dcontentsList"+dcontentsList); return mav; }
	 */
	
	//1.모든 진행중인 기부글 리스트
	@GetMapping("/donation/donationMain")
	public ModelAndView getDonationList() {
		
		ModelAndView mav= new ModelAndView("client/donation/donationList");

		return mav;
	}
	
	//2. 진행중인 기부글 상세내용
	@GetMapping("/donation/donationContent")
	public ModelAndView getDonationDetail(int dcontents_idx) {
		
		
		//3단계
		Dcontents dcontents=dcontentsService.select(dcontents_idx);
		
		//d-Day 계산
		String ed=dcontents.getDcontents_startday();
		
		int yy=Integer.parseInt(ed.substring(0, 4));
		System.out.println("yy는"+ yy);
		int mm=Integer.parseInt(ed.substring(4, 6));
		System.out.println("mm는"+ mm);
		int dd=Integer.parseInt(ed.substring(6, 8));
		System.out.println("dd는"+ dd);
		long dDay=dateManager.getResult(yy, mm, dd);
		System.out.println("dDay는"+ dDay);
		
		//4단계 저장하기
		ModelAndView mav= new ModelAndView("client/donation/donationDetail");
		mav.addObject("dcontents", dcontents);
		mav.addObject("dDay", dDay);
		logger.info("dcontents"+dcontents);
		return mav;
	}
	
	//3. 기부 참여폼
	@GetMapping("/donation/donate")
	public ModelAndView getRegistForm(HttpServletRequest request, int dcontents_idx) {
		//logger.info("registform 호출됨");
		
		//회원 예치금 가라데이터
		//Mem mem=new Mem();
		//mem.setMem_idx(22);
		//int mem_deposit=20000;  //회원의 총 예치금
		
		//로그인했다는 가정 하에 session에 담기
		HttpSession session=request.getSession();
		//Mem mem_idx=(Mem)session.getAttribute("mem_idx");
		
		//session.setAttribute("mem", mem);
		
		Dcontents dcontents=dcontentsService.select(dcontents_idx);
		
		ModelAndView mav=new ModelAndView("client/donation/regist");
		//mav.addObject("mem_deposit", mem_deposit);
		mav.addObject("dcontents", dcontents);
		
		return mav;
	}
	
	
	//환경 단체만 볼 수 있음
	//1. 기부글 등록 폼 요청
	@GetMapping("/donation/registForm")
	public ModelAndView getContentsform() {
		
		return new ModelAndView("client/donation/contentsform");
	}
	
	//2. 기부신청 리스트 요청
	@GetMapping("/donation/list")
	public ModelAndView getContentsList() {
		return new ModelAndView("client/donation/contentsList");
	}
	
	//3. 기부신청글 상세 요청
	@GetMapping("/donation/detail")
	public ModelAndView getContentsDetail(HttpServletRequest request, int dcontents_idx) {
		HttpSession session=request.getSession();
		Mem mem=(Mem)session.getAttribute("mem");
		System.out.println("mem??"+mem);
		//3단계
		Dcontents dcontents=dcontentsService.select(dcontents_idx);
		
		//4단계 저장하기
		ModelAndView mav= new ModelAndView("client/donation/contentsDetail");
		mav.addObject("dcontents", dcontents);
		logger.info("dcontents"+dcontents);
		return mav;
	}
	

}
