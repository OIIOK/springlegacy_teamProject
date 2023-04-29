package com.friendly.eco.domain;

import lombok.Data;

@Data
//기부자
public class Donator {
	private int donator_idx;
	//member_match올곳
	private Mem mem;
	private Dcontents dcontents;
	private int donator_point_sum;
	private int donator_deposit_sum;
	private String donator_date ;

}
