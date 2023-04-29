package com.friendly.eco.domain;

import lombok.Data;

@Data
//펀딩 리워드
public class Freward {
	private int freward_idx;
	private Fcontents fcontents;
	private String freward_name;
	private int freward_price;
}
