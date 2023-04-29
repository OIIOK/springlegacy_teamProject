package com.friendly.eco.domain;

import lombok.Data;

@Data
//기부 관심
public class Dwish {
	private int dwish_idx;
	//member_match올곳
	private Mem mem;
	private Dcontents dcontents;
	private String dwish;
}
