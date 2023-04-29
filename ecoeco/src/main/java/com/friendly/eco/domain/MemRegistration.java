package com.friendly.eco.domain;

import lombok.Data;

@Data
public class MemRegistration {
	private int mem_registration_idx;
	private Mem mem;
	private String mem_registration_front;
	private String mem_registration_back;
}
