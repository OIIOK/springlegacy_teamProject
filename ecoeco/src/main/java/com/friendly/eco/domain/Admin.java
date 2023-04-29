package com.friendly.eco.domain;

import lombok.Data;

@Data
public class Admin {
	private int admin_idx;
	private String admin_id;
	private String admin_pass;
	private String admin_name;
	private String admin_phone;
	private String admin_email;
}
