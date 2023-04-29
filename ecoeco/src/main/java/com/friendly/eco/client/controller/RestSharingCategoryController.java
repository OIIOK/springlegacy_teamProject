package com.friendly.eco.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendly.eco.domain.SharingCategory;
import com.friendly.eco.model.community.SharingCategoryService;

@RestController
@RequestMapping("/rest")
public class RestSharingCategoryController {

	private Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	private SharingCategoryService sharingCategoryService;

	// 목록 요청 처리
	@GetMapping("/community/sharingCategory")
	public List<SharingCategory> list(HttpServletRequest request, SharingCategory sharingCategory) {

		// 3단계
		List<SharingCategory> sharingCategoriesList = sharingCategoryService.selectAll();

		// 4단계
		return sharingCategoriesList;
	}
}
