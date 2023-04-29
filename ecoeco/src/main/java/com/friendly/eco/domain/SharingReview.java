package com.friendly.eco.domain;

import lombok.Data;

@Data
public class SharingReview {
	private int review_idx;
	private Sharing sharing; // association
	private Mem mem; // association
	private String review_detail;
	private String review_filename;
	private String review_regdate;
}