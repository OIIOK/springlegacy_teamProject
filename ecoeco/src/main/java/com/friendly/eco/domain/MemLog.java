package com.friendly.eco.domain;

import lombok.Data;

@Data
public class MemLog {
	private int mem_log_idx;
	private Mem mem;
	private String mem_log_regdate;
}
