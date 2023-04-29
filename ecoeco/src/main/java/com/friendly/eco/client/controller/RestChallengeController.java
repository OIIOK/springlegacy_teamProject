package com.friendly.eco.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.friendly.eco.domain.Challenge;
import com.friendly.eco.model.challenge.ChallengeService;
import com.friendly.eco.model.challenge.ChallengeTypeService;
import com.friendly.eco.util.Message;

@RestController
@RequestMapping("/rest")
public class RestChallengeController {
	@Autowired
	private ChallengeService challengeService;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	//챌린지 목록 요청처리
	@GetMapping("/challenge")
	public List<Challenge> getList(HttpServletRequest request){
		List challengeList=challengeService.selectAll();
		//logger.info("호출됨");
		
		return challengeList;
	}
	
	//한건 가져오기
	@GetMapping("/challenge/{challenge_idx}")
	public Challenge getDetail(@PathVariable int challenge_idx, HttpServletRequest request) {
		logger.info("challenge_idx is "+challenge_idx);
		
		return null;
	}
}
