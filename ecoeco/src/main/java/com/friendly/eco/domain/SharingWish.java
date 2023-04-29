package com.friendly.eco.domain;

import lombok.Data;

@Data
public class SharingWish {
	private int sharing_wish_idx;
	private Sharing sharing; // association
	private Mem mem; // association
	private char sharing_wish;
}
