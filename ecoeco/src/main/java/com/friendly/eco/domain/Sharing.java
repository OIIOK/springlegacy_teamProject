package com.friendly.eco.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Sharing {
    private int sharing_idx;
    private SharingCategory sharingCategory; // association
    private Mem mem; // association
    private String sharing_productname;
    private String sharing_detail;
    private MultipartFile sharing_flie; //파일 자체
    private String sharing_thumbnail; //파일 이름
    private String sharing_regdate;
    private int sharing_hits;
    private int sharing_random_range;
    private int sharing_random_index;
    private List<SharingWish> sharingWishList; // collection용으로 추가
    private List<SharingApplicant> sharingApplicantList; // collection용으로 추가
}