package com.friendly.eco.client.controller;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.friendly.eco.domain.Chatter;
import com.friendly.eco.domain.ChatterComments;
import com.friendly.eco.exception.ChatterCommentsException;
import com.friendly.eco.exception.ChatterException;
import com.friendly.eco.exception.UploadException;
import com.friendly.eco.model.community.ChatterCommentsService;
import com.friendly.eco.model.community.ChatterService;
import com.friendly.eco.util.Message;


@RestController
@RequestMapping("/rest")
public class RestChatterController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private ChatterService chatterService;

	@Autowired
	private ChatterCommentsService chatterCommentsService;

	// 등록 요청 처리
	// 클라이언트와 서버간 Http 메소드(Get/Post)가 일치해야 함
	@PostMapping("/community/chatter")
	public ResponseEntity<Message> register(Chatter chatter, HttpServletRequest request) {

		// 섬네일 저장하기
		ServletContext application = request.getSession().getServletContext();
		String path = application.getRealPath("/resources/data/community/chatter/");
		logger.info("섬네일이 저장될 실제 경로 : " + path);

		logger.info("chatter_title : " + chatter.getChatter_title());
		logger.info("chatter_detail : " + chatter.getChatter_detail());
		logger.info("chatter_flie : " + chatter.getChatter_flie()); // 여기 안나와도 저장은 됨
		logger.info("chatter_thumbnail : " + chatter.getChatter_thumbnail());

		// 3단계
		chatterService.upgInsert(chatter, path);

		// 4단계
		// util에 Message 만들어줬음(code, msg)
		Message message = new Message();
		message.setMsg("등록 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
	}

	// 목록 요청 처리
	@GetMapping("/community/chatter")
	public List<Chatter> list(HttpServletRequest request, Chatter chatter) { // Mem 때문에 chatter 넣어줌

		// 3단계
		List<Chatter> chatterList = chatterService.selectAll();

		// 4단계
		return chatterList;
	}
	
	// 수정 요청 처리
	@PostMapping("/community/chatter/edit")
	public ResponseEntity<Message> upgUpdate(Chatter chatter, HttpServletRequest request) {
	// @RequestBody : JSON 데이터를 자바객체로 바인딩 처리함

		// 섬네일 저장하기
		ServletContext application = request.getSession().getServletContext();
		String path = application.getRealPath("/resources/data/community/chatter/");
		
		logger.info("수정될 글내용 : " + chatter);

		// 3단계
		chatterService.upgUpdate(chatter, path);
		//chatterService.update(chatter);

		// 4단계
		Message message = new Message();
		message.setMsg("수정 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
	}

	// ---------------------------------------------------------------------------

	// 댓글등록 요청 처리
	@PostMapping("/community/chatter/{chatter_idx}")
	public ResponseEntity<Message> ccRegister(ChatterComments chatterComments, @PathVariable int chatter_idx,
			HttpServletRequest request) {

		logger.info("chatter_idx : ", chatter_idx);
		// logger.info("mem_idx : ", chatterComments.getMem().getMem_idx());
		logger.info("chattercomments_detail : ", chatterComments.getChattercomments_detail());

		// 3단계
		chatterCommentsService.insert(chatterComments);

		// 4단계
		Message message = new Message();
		message.setMsg("등록 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
	}

	// 댓글목록 요청 처리
	@GetMapping("/community/chatter/{chatter_idx}")
	public List<ChatterComments> ccList(HttpServletRequest request, @PathVariable int chatter_idx,
			ChatterComments chatterComments) { // Mem 때문에 chatterComments 넣어줌

		logger.info("댓글을 가져올 글번호 : " + chatter_idx);

		// 3단계
		List<ChatterComments> chatterCommentsList = chatterCommentsService.selectByChatterPK(chatter_idx);
		logger.info("chatterCommentsList 갯수 : " + chatterCommentsList.size());

		// 4단계
		return chatterCommentsList;
	}

	// 댓글삭제 요청 처리
	@DeleteMapping("/community/chatter/{chattercomments_idx}")
	public ResponseEntity<Message> ccDel(@PathVariable int chattercomments_idx) {
		// @PathVariable : URL경로에 변수가 포함되어 있음을 의미하며 변수의 자료형과 이름 값을 파라미터로 추출함
		// URL경로/{변수}로 경로에서 변수를 인식할 수 있도록 표기해야 함

		logger.info("삭제될 댓글번호 : " + chattercomments_idx);

		// 3단계
		chatterCommentsService.deleteOne(chattercomments_idx);

		// 4단계
		Message message = new Message();
		message.setMsg("삭제 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
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

	@ExceptionHandler(UploadException.class)
	public ResponseEntity<Message> handle(UploadException e) {
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
