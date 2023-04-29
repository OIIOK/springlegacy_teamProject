package com.friendly.eco.domain;

import lombok.Data;

@Data
public class MemStatus {
	private int mem_status_idx;
	private Mem mem;
	private String mem_status;
}
