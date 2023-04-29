package com.friendly.eco.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.friendly.eco.domain.Chatter;
import com.friendly.eco.domain.ChatterComments;
import com.friendly.eco.exception.ChatterCommentsException;
import com.friendly.eco.exception.ChatterException;
import com.friendly.eco.exception.UploadException;
import com.friendly.eco.model.community.ChatterCommentsService;
import com.friendly.eco.model.community.ChatterService;
import com.friendly.eco.util.Message;

@Controller
public class ChatterController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ChatterService chatterService;
	
	@Autowired
	private ChatterCommentsService chatterCommentsService;

	

	// 목록 화면 이동 요청 처리
	// http://localhost:9999/admin/community/chatterList
	@GetMapping("/community/chatterList")
	public ModelAndView moveList() {

		// 4단계
		ModelAndView mav = new ModelAndView("/admin/community/chatterList");
		return mav;
	}

	// ---------------------------------------------------------------------------


}
