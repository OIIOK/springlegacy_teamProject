package com.friendly.eco.domain;

import lombok.Data;

@Data
//펀딩 관심
public class Fwish {
	private int fwish_idx;
	//member_match_idx int
	private Mem mem;
	private String fwish;
}
