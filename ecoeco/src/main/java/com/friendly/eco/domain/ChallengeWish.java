package com.friendly.eco.domain;

import lombok.Data;

//마이페이지 챌린지 관심
@Data
public class ChallengeWish {
	private int challenge_wish_idx;
	private boolean challenge_wish;
	private Mem mem;  //fk 회원분류
	private Challenge challenge;  //fk 
}
