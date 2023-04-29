package com.friendly.eco.domain;

import lombok.Data;

//챌린지 인증사진 승인상태
@Data
public class PhotoStatus {
	private int photo_status_idx;
	private String photo_status;  //인증상태
}
