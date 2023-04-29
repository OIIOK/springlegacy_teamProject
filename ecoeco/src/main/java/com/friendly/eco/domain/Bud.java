package com.friendly.eco.domain;

import lombok.Data;

@Data
public class Bud {
	private int bud_idx;
	private int bud_exp;
	private int bud_regd;
	private BudType budType;
}
