package com.friendly.eco.domain;

import lombok.Data;

@Data
//펀딩글
public class Fcontents {
	private int fcontents_idx;
	//member_match들어올곳
	private Mem mem;
	private String  fcontents_title;
	private String  fcontents_writer;
	private String  fcontents_summary;
	private String  fcontents_thumimg;
	private String  fcontents_representative_img;
	private String  fcontents_amount;
	private String  fcontents_detail;
	private String  fcontents_date;
	private String  fcontents_startday;
	private String  fcontents_endday;
}
