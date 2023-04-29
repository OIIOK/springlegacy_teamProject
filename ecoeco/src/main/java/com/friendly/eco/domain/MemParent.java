package com.friendly.eco.domain;

import lombok.Data;

@Data
public class MemParent {
	private int mem_parent_idx;
	private Mem mem;
	private String mem_parent_relation;
	private String mem_parent_name;
	private String mem_parent_phone;
}
