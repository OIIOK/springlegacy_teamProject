package com.friendly.eco.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

//챌린지 참여사진
@Data
public class ChallPhoto {
	private int chall_photo_idx;
	private MultipartFile file; 
	private String chall_filename;  //파일명
	
	private Challenger challenger; //association
	private PhotoStatus photoStatus;  //fk 인증상태 association
}
