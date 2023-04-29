package com.friendly.eco.client.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.friendly.eco.domain.Chatter;
import com.friendly.eco.domain.Dcontents;
import com.friendly.eco.exception.ChatterException;
import com.friendly.eco.exception.DcontentsException;
import com.friendly.eco.exception.DpostscriptException;
import com.friendly.eco.exception.UploadException;
import com.friendly.eco.model.donation.DcontentsService;
import com.friendly.eco.model.donation.DpostscriptService;
import com.friendly.eco.util.Message;


@RestController
@RequestMapping("/rest")
public class RestDpostscriptController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DpostscriptService dpostscriptService;
	
	//기부글 등록 요청처리
	//@RequestMapping(value="/dcontents", method=RequestMethod.POST)
	//public ResponseEntity<Message> regist(Dcontents dcontents, HttpServletRequest request){
		//섬네일 저장하기
		//ServletContext application = request.getSession().getServletContext();
		//String path = application.getRealPath("/resources/data/donation/");
		//logger.info("섬네일이 저장될 실제 경로 : " + path);

		//logger.info("dcontents_title : " + dcontents.getDcontents_title());

		// 3단계
		//dcontentsService.regist(dcontents, path);
		
		// 4단계
		// util에 Message 만들어줬음(code, msg)
		//Message message = new Message();
		//message.setMsg("기부글 등록 완료");

		//ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		//return entity;
	//}
	
	
	//비동기 회원등록 기부 후기리스트 가져오기-전체/환경단체가 보는거 같이 쓰는중  나중에 수정
	@GetMapping("/postscriptList")
	public List getPostscriptList() {
		return dpostscriptService.selectAll();
	}
	
	//@GetMapping("/endDcontents")
	//public List getList() {
		//return dcontentsService.selectAll();
	//}

	
	
	//예외 처리
	@ExceptionHandler(DpostscriptException.class)
	public ResponseEntity<Message> handle(DpostscriptException e) {
		Message message = new Message();
		message.setMsg(e.getMessage());

		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}

	//@ExceptionHandler(UploadException.class)
	public ResponseEntity<Message> handle(UploadException e) {
		Message message = new Message();
		message.setMsg(e.getMessage());

		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}

}
