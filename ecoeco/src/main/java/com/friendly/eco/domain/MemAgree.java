package com.friendly.eco.domain;

import lombok.Data;

@Data
public class MemAgree {
	private int mem_agree_idx;
	private Mem mem;
	private String mem_agree_email;
	private String mem_agree_sns;
	private String mem_agree_person;
}
