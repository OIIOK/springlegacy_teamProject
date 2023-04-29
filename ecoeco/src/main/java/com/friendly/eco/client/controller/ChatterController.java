package com.friendly.eco.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.friendly.eco.domain.Chatter;
import com.friendly.eco.domain.ChatterComments;
import com.friendly.eco.exception.ChatterCommentsException;
import com.friendly.eco.exception.ChatterException;
import com.friendly.eco.exception.UploadException;
import com.friendly.eco.model.community.ChatterCommentsService;
import com.friendly.eco.model.community.ChatterService;
import com.friendly.eco.util.Message;

@Controller
public class ChatterController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ChatterService chatterService;
	
	@Autowired
	private ChatterCommentsService chatterCommentsService;

	// 등록 화면 이동 요청 처리
	// http://localhost:9999/community/chatterRegisterForm
	// chatterRegisterForm을 거쳐서 RestController의 입력, 수정, 삭제가 진행됨
	@GetMapping("/community/chatterRegisterForm")
	public ModelAndView moveRegister(HttpServletRequest request) {

		// 4단계
		ModelAndView mav = new ModelAndView("client/community/chatterRegister");
		return mav;
	}

	// 목록 화면 이동 요청 처리
	/// http://localhost:9999/community/chatterList
	@GetMapping("/community/chatterList")
	public ModelAndView moveList() {

		// 4단계
		ModelAndView mav = new ModelAndView("client/community/chatterList");
		return mav;
	}

	// 상세 화면 이동 요청 처리
	// http://localhost:9999/community/chatterDetail
	@GetMapping("/community/chatterDetail")
	public ModelAndView moveDetail(HttpServletRequest request, int chatter_idx) {

		// 3단계
		Chatter chatter = chatterService.selectByPK(chatter_idx);

		// 4단계
		ModelAndView mav = new ModelAndView("client/community/chatterDetail");
		mav.addObject("chatter", chatter);
		return mav;
	}

	// 수정 화면 이동 요청 처리
	// http://localhost:9999/community/chatterEdit
	@GetMapping("/community/chatterEdit")
	public ModelAndView moveEdit(HttpServletRequest request, int chatter_idx) {

		// 3단계
		Chatter chatter = chatterService.selectByPK(chatter_idx);

		// 4단계
		ModelAndView mav = new ModelAndView("client/community/chatterEdit");
		mav.addObject("chatter", chatter);
		return mav;
	}
	
	// 마이페이지 화면 이동 요청 처리
	// http://localhost:9999/community/chatterEdit
	@GetMapping("/community/mypageCommunity")
	public ModelAndView moveMypage(HttpServletRequest request) {

		// 4단계
		ModelAndView mav = new ModelAndView("client/community/mypageCommunity");
		return mav;
	}

	// ---------------------------------------------------------------------------

	// 삭제 요청 처리(원래 RestChatterController에서 작업했으나 거기서 댓글 삭제 기능을 사용하기 위해 옮겨옴)
	@PostMapping("/community/chatter/del/{chatter_idx}")
	public ModelAndView del(@PathVariable int chatter_idx) {
		// @PathVariable : URL경로에 변수가 포함되어 있음을 의미하며 변수의 자료형과 이름 값을 파라미터로 추출함
		// URL경로/{변수}로 경로에서 변수를 인식할 수 있도록 표기해야 함

		logger.info("삭제될 글번호 : " + chatter_idx);

		// 3단계
		// 순서중요 : chatterComments가 PK에 묶여있기 때문에 댓글이 있는 경우 먼저 지워야 그 다음에 지워짐
		List<ChatterComments> chatterCommentsList = chatterCommentsService.selectByChatterPK(chatter_idx);
		logger.info("함께 삭제될 chatterCommentsList 갯수 : " + chatterCommentsList.size());
		if(chatterCommentsList.size()>0) {
			chatterCommentsService.deleteByChatterPK(chatter_idx);
		}
		chatterService.delete(chatter_idx);

		// 4단계
		ModelAndView mav = new ModelAndView();
		mav.setViewName("client/community/chatterList");
		return mav;
	}

	// ---------------------------------------------------------------------------

	// 예외 처리
	@ExceptionHandler(ChatterException.class)
	public ResponseEntity<Message> handle(ChatterException e) {
		Message message = new Message();
		message.setMsg(e.getMessage());

		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}

	@ExceptionHandler(ChatterCommentsException.class)
	public ResponseEntity<Message> handle(ChatterCommentsException e) {
		Message message = new Message();
		message.setMsg(e.getMessage());

		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
