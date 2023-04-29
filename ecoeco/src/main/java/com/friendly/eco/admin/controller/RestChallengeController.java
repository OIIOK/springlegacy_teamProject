package com.friendly.eco.admin.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendly.eco.domain.ChallPhoto;
import com.friendly.eco.domain.Challenge;
import com.friendly.eco.domain.Challenger;
import com.friendly.eco.domain.ManagementType;
import com.friendly.eco.exception.ChallengeException;
import com.friendly.eco.exception.ChallengerException;
import com.friendly.eco.exception.UploadException;
import com.friendly.eco.model.challenge.ChallPhotoService;
import com.friendly.eco.model.challenge.ChallengeService;
import com.friendly.eco.model.challenge.ChallengerService;
import com.friendly.eco.util.Message;

@RestController
@RequestMapping("/rest")
public class RestChallengeController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ChallengeService challengeService;
	
	@Autowired
	private ChallengerService challengerService;
	
	@Autowired
	private ChallPhotoService challPhotoService;
	
	
	//챌린지 등록 요청처리
	@PostMapping("/challenge")
	public ResponseEntity<Message> regist(Challenge challenge, HttpServletRequest request){
		
		ServletContext application=request.getSession().getServletContext();
		String path=application.getRealPath("/resources/data/challenge/");  //실제 저장될 경로
		
		logger.info("저장될 실제 경로는"+path);
		
		logger.info("challenge_type_idx is "+challenge.getChallengeType().getChallenge_type_idx());
		
		//챌린지 dto에 현재 회원의 유형을 대입해줘야 함 세션에서 구해와야 함
		//현재 가라데이터임 나중에 수정 필요
		ManagementType managementType=new ManagementType();
		managementType.setManagement_type_idx(1);
		challenge.setManagementType(managementType);
		
		//3단계
		challengeService.regist(challenge, path);
		
		//logger.info("넘겨받은 challenge_fee_min is "+challenge.getChallenge_fee_min());
		//logger.info("넘겨받은 challenge_fee_max is "+challenge.getChallenge_fee_max());
		
		Message message=new Message();
		message.setMsg("챌린지 등록 성공");
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}
	
	//한건 가져오기
	@GetMapping("/challenge/{challenge_idx}")
	public ResponseEntity<Message> getDetail(@PathVariable int challenge_idx) {
		logger.info("challenge_idx"+challenge_idx);
		
		return null;
	}
	
	//관리자 등록용 챌린지 목록내용 요청처리 : 직접 접근하여 challengeList가 json 배열인지 확인
	@GetMapping("/challenge")
	public List<Challenge> getList(HttpServletRequest request){
		
		List challengeList=challengeService.selectAll();
		
		return challengeList;
	}
	
	
	//챌린지 참여자 목록 요청처리 : 직접 접근하여 challengeList가 json 배열인지 확인
	@GetMapping("/challenger/{challenge_idx}")
	public List<Challenger> getList(@PathVariable int challenge_idx){
		logger.info("challenge_idx is "+challenge_idx);
		List challengeList=challengerService.selectByChallengerIdx(challenge_idx);
		return challengeList;
	}
	
	//첼린지 참여자의 사진 목록 가져오기 
	@GetMapping("/challenger/photo")
	public List<ChallPhoto> getChallPhotoList(int challenger_idx){
		List photoList = challPhotoService.selectByChallenger(challenger_idx);
		return photoList;
	}
	
	@ExceptionHandler(ChallengeException.class)
	public ResponseEntity<Message> handle(ChallengeException e){
		Message message = new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
	@ExceptionHandler(ChallengerException.class)
	public ResponseEntity<Message> handle(ChallengerException e){
		Message message = new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
	@ExceptionHandler(UploadException.class)
	public ResponseEntity<Message> handle(UploadException e){
		Message message = new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
