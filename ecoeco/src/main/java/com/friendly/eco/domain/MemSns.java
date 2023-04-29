package com.friendly.eco.domain;

import lombok.Data;

@Data
public class MemSns {
	private int mem_sns_idx;
	private Mem mem;
	private String mem_sns_pass;
	private String mem_sns_nickname;
}
