package com.friendly.eco.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.friendly.eco.domain.Challenge;
import com.friendly.eco.domain.Challenger;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.model.challenge.ChallengerService;

@RestController
@RequestMapping("/rest")
public class RestMypageController {
	@Autowired
	private ChallengerService challengerService;
	
	//마이페이지 > 챌린지 > 참여한 챌린지 목록 요청
	@GetMapping("/mypage/challenge")
	public List<Challenge> getList(HttpServletRequest request, Challenger challenger){
		
		//회원정보 가라데이터
		Mem mem=new Mem();
		mem.setMem_idx(2);
		challenger.setMem(mem);
		
		List challengerList=challengerService.selectByMem(challenger);
		
		return challengerList;
	}
}
