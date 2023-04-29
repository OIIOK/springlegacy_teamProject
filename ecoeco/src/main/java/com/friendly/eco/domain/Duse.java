package com.friendly.eco.domain;

import lombok.Data;

@Data
//기부금사용
public class Duse {
	private int duse_idx;
	//member_match올곳
	private Mem mem;
	private Dcontents dcontents;
	private String duse_type;
	private String duse_detail;
	private int duse_amount;
	
}
