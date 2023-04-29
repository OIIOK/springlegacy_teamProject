package com.friendly.eco.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

//챌린지
@Data
public class Challenge {
	private int challenge_idx;
	private ManagementType managementType;  //fk 
	private ChallengeType challengeType;  //fk 챌린지 유형
	private ChallengeState challengeState;  //fk 챌린지 상태
	private String challenge_title;
	private MultipartFile file;  //html에서 전송되는 파라미터명과 일치
	private String challenge_thumb;  //파일명
	private String challenge_startdate;
	private String challenge_enddate;
	private int challenge_req;
	private String challenge_detail;
	private int challenge_point;
	private int challenge_fee_min;
	private int challenge_fee_max;
	private String challenge_regdate;
}
