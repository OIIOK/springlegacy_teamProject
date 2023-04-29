package com.friendly.eco.client.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.friendly.eco.domain.Dcontents;
import com.friendly.eco.domain.Dpostscript;
import com.friendly.eco.model.donation.DcontentsService;
import com.friendly.eco.model.donation.DpostscriptService;
import com.friendly.eco.util.DateManager;

@Controller
//기부후기 관련 컨트롤러
public class DpostscriptController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DpostscriptService dpostscriptService;
	
	@Autowired
	private DateManager dateManager;
	
	//환경단체만 볼 수 있음
	//수정해야함
	//1. 기부 후기 폼 요청
	@GetMapping("/postscript/registForm")
	public ModelAndView getPostscriptForm() {
		return new ModelAndView("client/donation/postscriptForm");
	}
	
	//2.기부후기 등록 요청
	@PostMapping("/postscript/regist")
	public ModelAndView regist(Dpostscript dpostscript) {
		//등록
		dpostscriptService.insert(dpostscript);
		
		return new ModelAndView("redirect:/postscript/registForm");
	}
	
	//3. 기부후기 리스트 요청
	@GetMapping("/postscript/list")
	public ModelAndView getPostscriptList() {
		//3단계
		List dpostscriptList=dpostscriptService.selectAll();
		
		//4단계 저장하기
		ModelAndView mav= new ModelAndView("client/donation/postscriptList");
		mav.addObject("dPostscriptList", dpostscriptList);
		logger.info("dPostscriptList"+dpostscriptList);
		return mav;
	}
	
	//4. 기부후기 상세 요청
	@GetMapping("/postscript/detail")
	public ModelAndView getContentsDetail(int dpostscript_idx) {
		//3단계
		Dpostscript dpostscript=dpostscriptService.select(dpostscript_idx);
		
		//4단계 저장하기
		ModelAndView mav= new ModelAndView("client/donation/postscriptDetail");
		mav.addObject("dpostscript", dpostscript);
		logger.info("dpostscript"+dpostscript);
		return mav;
	}
	
	//5. 기부 후기 수정 요청
	@PostMapping("/postscript/edit")
	public ModelAndView edit(Dpostscript dpostscript) {
		//등록
		dpostscriptService.update(dpostscript);
		
		return new ModelAndView("redirect:/postscript/detail");
	}
	
	//-------------------------------------------------------------
	
		//2. 진행중인 기부후기 상세내용 (모든 사람들한테 보이는 용도)
		@GetMapping("/donation/postscriptContent")
		public ModelAndView getDonationDetail(int dpostscript_idx) {
			//3단계
			Dpostscript dpostscript=dpostscriptService.select(dpostscript_idx);
			
			//d-Day 계산
			String ed=dpostscript.getDcontents().getDcontents_startday();
			
			int yy=Integer.parseInt(ed.substring(0, 4));
			System.out.println("yy는"+ yy);
			int mm=Integer.parseInt(ed.substring(4, 6));
			System.out.println("mm는"+ mm);
			int dd=Integer.parseInt(ed.substring(6, 8));
			System.out.println("dd는"+ dd);
			long dDay=dateManager.getResult(yy, mm, dd);
			System.out.println("dDay는"+ dDay);
			
			//4단계 저장하기
			ModelAndView mav= new ModelAndView("client/donation/postscriptDetail");
			mav.addObject("dpostscript", dpostscript);
			mav.addObject("dDay", dDay);
			logger.info("dpostscript"+dpostscript);
			return mav;
		}
	
}
