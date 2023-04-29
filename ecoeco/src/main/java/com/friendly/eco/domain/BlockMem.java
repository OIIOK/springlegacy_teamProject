package com.friendly.eco.domain;

import lombok.Data;

@Data
public class BlockMem {
	private int block_mem_idx;
	private MemStatus memStatus;
	private String block_mem_regdate;
	private String block_mem_reason;
}
