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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.friendly.eco.domain.Chatter;
import com.friendly.eco.domain.ChatterComments;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.domain.Sharing;
import com.friendly.eco.domain.SharingApplicant;
import com.friendly.eco.exception.SharingException;
import com.friendly.eco.exception.UploadException;
import com.friendly.eco.model.community.SharingApplicantService;
import com.friendly.eco.model.community.SharingService;
import com.friendly.eco.util.Message;

import oracle.jdbc.proxy.annotation.Post;

@RestController
@RequestMapping("/rest")
public class RestSharingController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private SharingService sharingService;
	@Autowired
	private SharingApplicantService sharingApplicantService;

	// 등록 요청 처리
	@PostMapping("/community/sharing")
	public ResponseEntity<Message> register(Sharing sharing, HttpServletRequest request) {

		// 섬네일 저장하기
		ServletContext application = request.getSession().getServletContext();
		String path = application.getRealPath("/resources/data/community/sharing/");
		logger.info("섬네일이 저장될 실제 경로 : " + path);

		logger.info("sharingcategory_idx : " + sharing.getSharingCategory().getSharingcategory_idx());
		// logger.info("mem_idx : " + sharing.getMem().getMem_idx());
		logger.info("sharing_productname : " + sharing.getSharing_productname());
		logger.info("sharing_detail : " + sharing.getSharing_detail());
		logger.info("sharing_random_range : " + sharing.getSharing_random_range());
		logger.info("sharing_flie : " + sharing.getSharing_flie()); // 여기 안나와도 저장은 됨
		logger.info("sharing_thumbnail : " + sharing.getSharing_thumbnail());

		// 3단계
		sharingService.upgInsert(sharing, path);

		// 4단계
		Message message = new Message();
		message.setMsg("등록 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
	}

	// 목록 요청 처리
	@GetMapping("/community/sharing")
	public List<Sharing> list(HttpServletRequest request, Sharing sharing) {

		// 3단계
		List<Sharing> sharingList = sharingService.selectAll();

		// 4단계
		return sharingList;
	}
	
	// 수정 요청 처리
	@PostMapping("/community/sharing/edit")
	public ResponseEntity<Message> edit(HttpServletRequest request, Sharing sharing) {

		// 섬네일 저장하기
		ServletContext application = request.getSession().getServletContext();
		String path = application.getRealPath("/resources/data/community/sharing/");
		logger.info("섬네일이 저장될 실제 경로 : " + path);

		logger.info("sharing : " + sharing);
		logger.info("sharingcategory_idx : " + sharing.getSharingCategory().getSharingcategory_idx());
		logger.info("sharing_productname : " + sharing.getSharing_productname());
		logger.info("sharing_detail : " + sharing.getSharing_detail());
		logger.info("sharing_flie : " + sharing.getSharing_flie()); // 여기 안나와도 저장은 됨
		logger.info("sharing_thumbnail : " + sharing.getSharing_thumbnail());

		// 3단계
		sharingService.upgUpdate(sharing, path);

		// 4단계
		Message message = new Message();
		message.setMsg("수정 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}
	

	// ---------------------------------------------------------------------------
	
	// 인덱스 수정 요청 처리
	@PostMapping("/community/sharing/index")
	@ResponseBody
	public ResponseEntity<Message> updateIndex(@RequestBody Sharing sharing, Mem mem, HttpServletRequest request) {
		//1) 인덱스(=신청자 수) 증가시키기
		//2) 레코드 한 줄 가져와 랜덤범위와 인덱스(=신청자 수) 비교하기
		//3) 신청 정보 등록하기
		/*
		 * mem = new Mem(); mem.setMem_idx(1); request.getSession().setAttribute("mem",
		 * mem);
		 */
		
		logger.info("컨트롤러 진입 시점 : " + sharing.getSharing_random_index());
		//sharing.getSharing_idx()); 안가져와짐!!!------------------------------------------------------------------------??

		// 3단계
		int result = sharingService.upgUpdateIndex(sharing, mem);
		
		logger.info("서비스 완료 시점 : " + sharing.getSharing_random_index());

		// 4단계
		Message message = new Message();
		if (result < 1) {
			message.setCode(0);
			message.setMsg("낙첨되었습니다 :(");
		} else {
			message.setMsg("당첨되었습니다니다 :D");
			message.setCode(1);
		}

		//message.setCode(sharing.getSharing_random_index());
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		return entity;
	}

	// 신청 요청 처리
	@PostMapping("/community/sharing/{sharing_idx}")
	public ResponseEntity<Message> saRegister(SharingApplicant sharingApplicant, @PathVariable int sharing_idx,
			HttpServletRequest request) {

		// logger.info("sharing_idx : ", sharing_idx); //? 안나오는데 등록을 된다
		// logger.info("mem_idx : ", sharingApplicant.getMem().getMem_idx()); //? 안나오는데
		// 등록을 된다
		// logger.info("applicant_win : ", sharingApplicant.getApplicant_win()); //?
		// 안나오는데 등록을 된다

		// 3단계
		sharingApplicantService.insert(sharingApplicant);
		logger.info("selectKey로 가져온 sharingApplicant_idx : " + sharingApplicant.getApplicant_idx());

		// 4단계
		Message message = new Message();
		message.setMsg("등록 성공");
		message.setCode(sharingApplicant.getApplicant_idx());
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
	}

	// 신청목록 요청 처리
	@GetMapping("/community/sharing/{sharing_idx}")
	public List<SharingApplicant> ccList(HttpServletRequest request, @PathVariable int sharing_idx,
			SharingApplicant sharingApplicant) { // Mem 때문에 chatterComments 넣어줌

		logger.info("신청자를 가져올 글번호 : " + sharing_idx);

		// 3단계
		List<SharingApplicant> sharingApplicantList = sharingApplicantService.selectBySharingPK(sharing_idx);
		logger.info("sharingApplicantList 갯수 : " + sharingApplicantList.size());

		// 4단계
		return sharingApplicantList;
	}

	// ---------------------------------------------------------------------------

	// 예외 처리
	@ExceptionHandler(SharingException.class)
	public ResponseEntity<Message> handle(SharingException e) {
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
