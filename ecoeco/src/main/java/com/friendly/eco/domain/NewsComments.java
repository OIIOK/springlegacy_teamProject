package com.friendly.eco.domain;

import lombok.Data;

@Data
public class NewsComments {
	private int newscomments_idx;
	private News news; // association
	private Mem mem; // association
	private String newscomments_detail;
	private String newscomments_regdate;
}
