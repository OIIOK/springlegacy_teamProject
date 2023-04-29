package com.friendly.eco.domain;

import lombok.Data;

//챌린저 명단
@Data
public class Challenger {
	private int challenger_idx;
	private Challenge challenge;  //fk 챌린지
	private int challenge_fee;  //참여금
	private Mem mem;  //fk 회원분류
	private ChallConf challConf;  //fk 챌린지 승인여부
}
