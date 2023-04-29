package com.friendly.eco.domain;

import lombok.Data;

@Data
//펀딩후기
public class Fpostscript {
	private int fpostscript_idx;
	//member_match_idx
	private Mem mem;
	private Fcontents fcontents;
	private String fpostscript_detail;
}
