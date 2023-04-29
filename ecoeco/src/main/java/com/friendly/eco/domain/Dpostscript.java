package com.friendly.eco.domain;

import lombok.Data;

@Data
//기부후기
public class Dpostscript {
	private int dpostscript_idx;
	//member_match_idx
	private Mem mem;
	private Dcontents dcontents;
	private String dpostscript_title;
	private String dpostscript_writer;
	private String dpostscript_detail;
	private String dpostscript_date;

	
}
