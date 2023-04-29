package com.friendly.eco.domain;

import lombok.Data;

@Data
public class Sponsor {
	private int sponsor_idx;
	private String sponsor_company;
	private int sponsor_amount;
	private String sponsor_bank;
	private String sponsor_account;
	private String sponsor_manager;
	private String sponsor_tel;
	private String sponsor_date;
}
