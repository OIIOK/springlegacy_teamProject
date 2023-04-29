package com.friendly.eco.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.friendly.eco.domain.Chatter;
import com.friendly.eco.domain.Sharing;
import com.friendly.eco.domain.SharingApplicant;
import com.friendly.eco.model.community.SharingApplicantService;
import com.friendly.eco.model.community.SharingService;
import com.friendly.eco.util.Message;

@Controller
public class SharingController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SharingService sharingService;
	@Autowired
	private SharingApplicantService sharingApplicantService;
	
	//등록 화면 이동 요청 처리
	@GetMapping("/community/sharingRegisterForm")
	public ModelAndView moveRegister(HttpServletRequest request) {
		
		//4단계
		ModelAndView mav = new ModelAndView("client/community/sharingRegister");
		return mav;
	}
	
	//목록 화면 이동 요청 처리
	@GetMapping("/community/sharingList")
	public ModelAndView moveList() {
		
		//4단계
		ModelAndView mav = new ModelAndView("client/community/sharingList");
		return mav;
	}
	
	//상세 화면 이동 요청 처리
	@GetMapping("/community/sharingDetail")
	public ModelAndView moveDetail(HttpServletRequest request, int sharing_idx) {

		// 3단계
		Sharing sharing = sharingService.selectByPK(sharing_idx);

		// 4단계
		ModelAndView mav = new ModelAndView("client/community/sharingDetail");
		mav.addObject("sharing", sharing);
		return mav;
	}
	
	// 수정 화면 이동 요청 처리
		@GetMapping("/community/sharingEdit")
		public ModelAndView moveEdit(HttpServletRequest request, int sharing_idx) {

			// 3단계
			Sharing sharing = sharingService.selectByPK(sharing_idx);

			// 4단계
			ModelAndView mav = new ModelAndView("client/community/sharingEdit");
			mav.addObject("sharing", sharing);
			return mav;
		}
		
		//당첨 화면 이동 요청 처리
		@GetMapping("/community/sharingWinning")
		public ModelAndView movesharingWinning(HttpServletRequest request) {
			
			//4단계
			ModelAndView mav = new ModelAndView("client/community/sharingWinning");
			return mav;
		}
	
	// ---------------------------------------------------------------------------

	// 삭제 요청 처리(원래 RestSharingController에서 작업했으나 거기서 신청자 삭제 기능을 사용하기 위해 옮겨옴)

		@PostMapping("/community/sharing/del/{sharing_idx}")
		public ModelAndView del(@PathVariable int sharing_idx) {
			// @PathVariable : URL경로에 변수가 포함되어 있음을 의미하며 변수의 자료형과 이름 값을 파라미터로 추출함
			// URL경로/{변수}로 경로에서 변수를 인식할 수 있도록 표기해야 함

			logger.info("삭제될 글번호 : " + sharing_idx);

			// 3단계
			// 순서중요 : chatterComments가 PK에 묶여있기 때문에 관심과 신청자가 있는 경우 먼저 지워야 그 다음에 지워짐
			
			//관심 삭제
			
			//신청자 삭제
			List<SharingApplicant> sharingApplicantList = sharingApplicantService.selectBySharingPK(sharing_idx);
			logger.info("함께 삭제될 chatterCommentsList 갯수 : " + sharingApplicantList.size());
			if(sharingApplicantList.size()>0) {
				sharingApplicantService.deleteBySharingPK(sharing_idx);
			}
			
			sharingService.delete(sharing_idx);

			// 4단계
			ModelAndView mav = new ModelAndView();
			mav.setViewName("client/community/sharingList");
			return mav;
		}
	
	


}
