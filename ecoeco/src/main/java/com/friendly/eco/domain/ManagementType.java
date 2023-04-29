package com.friendly.eco.domain;

import lombok.Data;

//챌린지 등록자 구분
@Data
public class ManagementType {
	private int management_type_idx;
	private Mem mem;  //fk 회원분류
	private String management_type_name;  //등록자 구분용
}
