package com.friendly.eco.domain;

import lombok.Data;

@Data
public class MemAddr {
	private int mem_addr_idx;
	private Mem mem;
	private String mem_addr_main;
	private String mem_addr_detail;
}
