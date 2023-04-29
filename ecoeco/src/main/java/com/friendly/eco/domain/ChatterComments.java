package com.friendly.eco.domain;

import lombok.Data;

@Data
public class ChatterComments {
	private int chattercomments_idx;
	private Chatter chatter; // association
	private Mem mem; // association
	private String chattercomments_detail;
	private String chattercomments_regdate;
}
