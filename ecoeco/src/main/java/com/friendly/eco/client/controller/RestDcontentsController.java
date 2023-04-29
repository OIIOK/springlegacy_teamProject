package com.friendly.eco.client.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.friendly.eco.domain.Chatter;
import com.friendly.eco.domain.Dcontents;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.exception.ChatterException;
import com.friendly.eco.exception.DcontentsException;
import com.friendly.eco.exception.UploadException;
import com.friendly.eco.model.donation.DcontentsService;
import com.friendly.eco.model.donation.DpostscriptService;
import com.friendly.eco.util.Message;


@RestController
@RequestMapping("/rest")
public class RestDcontentsController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DcontentsService dcontentsService;
	
	//기부글 등록 요청처리
	 @RequestMapping(value="/dcontentsRegist", method=RequestMethod.POST) 
	  public ResponseEntity<Message> regist(Dcontents dcontents, HttpServletRequest request){ 
		 //섬네일 저장하기
		ServletContext application =request.getSession().getServletContext(); 
		String path = application.getRealPath("/resources/data/donation/");
		logger.info("섬네일이 저장될 실제 경로 : " + path);
	 
		logger.info("dcontents_title : " + dcontents.getDcontents_title());
	 
		// 3단계 
		dcontentsService.regist(dcontents, path);
	 
		// 4단계 
		// util에 Message 만들어줬음(code, msg) 
		Message message = new Message();
		message.setMsg("기부글 등록 완료");
	 
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
	 
		return entity; 
	 }
	 
	 //기부글 수정 처리
	 @RequestMapping(value="/dcontentsEdit", method=RequestMethod.POST) 
	  public ResponseEntity<Message> edit(Dcontents dcontents, HttpServletRequest request){ 
		 //섬네일 저장하기
		ServletContext application =request.getSession().getServletContext(); 
		String path = application.getRealPath("/resources/data/donation/");
		logger.info("섬네일이 저장될 실제 경로 : " + path);
	 
		logger.info("dcontents_title : " + dcontents.getDcontents_title());
	 
		// 3단계 
		dcontentsService.update(dcontents, path);
	 
		// 4단계 
		// util에 Message 만들어줬음(code, msg) 
		Message message = new Message();
		message.setMsg("기부글 수정 완료");
	 
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
	 
		return entity; 
	 }
	
	
	//비동기 회원등록 기부리스트 가져오기-전체/환경단체가 보는거 같이 쓰는중  나중에 수정
	//@GetMapping("/donationList")
	//public List getNewestList() {
	//	return dcontentsService.selectAll();
	//}
	
	//비동기 회원등록 기부리스트 가져오기-전체/환경단체가 보는거 같이 쓰는중  나중에 수정
	
	@GetMapping("/donationList") 
	 public List getList(@RequestParam(defaultValue = "0") int option_idx) { 
		logger.info("option_idx는 ", option_idx );
		 return dcontentsService.selectOfChoice(option_idx); 
		 }
	
	//메인페이지용
	@GetMapping("/mainList") 
	public List getList() { 
		return dcontentsService.selectAll(); 
	}
	 
	//개인회원목록
	 @GetMapping("/contentsList") 
	 public List getContentsList(HttpServletRequest request) { 
		 
		 //HttpSession session=request.getSession();
		// Mem mem=(Mem)session.getAttribute("Mem");
		 //int mem_idx=mem.getMem_idx();
		 //System.out.println("mem_idx는???"+ mem_idx);
		 
		// return  dcontentsService.selectOfMem(mem_idx);
		 return dcontentsService.selectAll();
	 }
	 
	
	// 예외 처리
	@ExceptionHandler(DcontentsException.class)
	public ResponseEntity<Message> handle(DcontentsException e) {
		Message message = new Message();
		message.setMsg(e.getMessage());

		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}

	@ExceptionHandler(UploadException.class)
	public ResponseEntity<Message> handle(UploadException e) {
		Message message = new Message();
		message.setMsg(e.getMessage());

		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}

}
