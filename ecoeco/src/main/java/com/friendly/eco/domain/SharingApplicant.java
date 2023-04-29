package com.friendly.eco.domain;

import lombok.Data;

@Data
public class SharingApplicant {
	private int applicant_idx;
	private Sharing sharing; // association
	private Mem mem; // association
	private int applicant_win;
}