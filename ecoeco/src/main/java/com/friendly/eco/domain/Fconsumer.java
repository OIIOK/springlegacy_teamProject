package com.friendly.eco.domain;

import lombok.Data;

@Data
//펀딩구매자
public class Fconsumer {
	private int fconsumer_idx ;
	//member_match올곳
	private Mem mem;
	private Fcontents fcontents;
	private int fconsumer_point_sum;
	private int fconsumer_deposit_sum;
	private String fconsumer_date ;
	
	//리워드 테이블 추가해야할듯?
}
