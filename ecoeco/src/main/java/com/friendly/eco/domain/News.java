package com.friendly.eco.domain;

import java.util.List;

import lombok.Data;

@Data
public class News {
	private int news_idx;
	private String news_agency;
	private String news_title;
	private String news_detail;
	private String news_regdate;
	private int news_hits;
	private List<NewsComments> newsCommentsList; // collection용으로 추가
}
