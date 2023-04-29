package com.friendly.eco.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
//기부글
public class Dcontents {
	private int dcontents_idx;
	//member_match들어올곳
	private Mem mem;
	private String  dcontents_title;
	private String  dcontents_writer;
	private MultipartFile dcontents_file; //파일 자체
	private String  dcontents_thumimg;
	private String  dcontents_amount;
	private String  dcontents_detail;
	private String  dcontents_date;
	private String  dcontents_startday;
	private String  dcontents_endday;
	private String  dcontents_app;
	
	private List<Donator> donatorList;
	/*
	 * private List<Dpostscript> dpostscriptList;
	 * private List<Duse> duseList; private List<Dwish> dwishList;
	 */
}
