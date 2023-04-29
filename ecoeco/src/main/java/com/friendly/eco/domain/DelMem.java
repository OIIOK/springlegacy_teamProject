package com.friendly.eco.domain;

import lombok.Data;

@Data
public class DelMem {
	private int del_mem_idx;
	private MemStatus memStatus;
	private String del_mem_regdate;
	private String del_mem_type;
}
