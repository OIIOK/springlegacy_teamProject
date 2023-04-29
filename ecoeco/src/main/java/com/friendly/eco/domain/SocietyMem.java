package com.friendly.eco.domain;

import lombok.Data;

@Data
public class SocietyMem {
	private int society_mem_idx;
	private Mem mem;
	private String society_mem_pass;
	private String society_mem_name;
	private String society_mem_registration;
	private String society_mem_clerk_name;
	private String society_mem_clerk_phone;
	private String society_mem_clerk_email;
}
