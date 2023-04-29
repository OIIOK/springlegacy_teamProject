package com.friendly.eco.domain;

import lombok.Data;

//회원분류
@Data
public class Mem {
	private int mem_idx;
	private MemType memType;
	private String mem_id;
	
	//ERD와 상관없이 필요에 의해 mybatis에 association을 수행
	//닉네일 말고도 다른 정보를 여기다 담으면 편함
	/*로그인양식*/
	private MemPass memPass;
	/*회원가입양식*/
	private MemName memName;
	private MemBirth memBirth;
	private MemPhone memPhone;
	private MemEmail memEmail;
	private MemNickname memNickname;
	
}
