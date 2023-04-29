package com.friendly.eco.domain;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class Chatter {
	private int chatter_idx;
	private Mem mem; // association
	private String chatter_title;
	private String chatter_detail;
	private MultipartFile chatter_flie; //파일 자체
	private String chatter_thumbnail; //파일 이름
	private String chatter_regdate;
	private int chatter_hits;
	private List<ChatterComments> chatterCommentsList; // collection용으로 추가
}
