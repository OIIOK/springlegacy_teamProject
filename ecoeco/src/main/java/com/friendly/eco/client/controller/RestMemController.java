package com.friendly.eco.client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.friendly.eco.domain.GoogleLogin;
import com.friendly.eco.domain.KaKaoLogin;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.domain.NaverLogin;
import com.friendly.eco.model.mem.MemPassService;
import com.friendly.eco.model.mem.MemService;
import com.friendly.eco.util.Message;

//회원과 관련된 요청을 처리하는 하위 컨트롤러
@RestController
@RequestMapping("/rest/member")
public class RestMemController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MemService memService;

	@Autowired
	private MemPassService memPassService;

	@Autowired
	private GoogleLogin googleLogin;
	@Autowired
	private NaverLogin naverLogin;
	@Autowired
	private KaKaoLogin kakaoLogin;
	
	// 로그아웃
	@PostMapping("/logout")
	public ResponseEntity<Message> getLogout(HttpSession session) {
		session.invalidate(); // 세션 전체를 날려버림
		// session.removeAttribute("obj"); //하나씩 하려면 이렇게 해야 함

		Message message = new Message();
		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}

	//지금 사용 안 하고 있음
	@RequestMapping(value = "/success")
	public ModelAndView success(HttpSession session) {
		return new ModelAndView("member/success");
	}

	
	// 로그인폼에서 사용할 SNS 인증화면의 링크 주소 요청을 처리
	@GetMapping("/authform/google") //rest/member.authform/google
	public ResponseEntity<Message> getGoogleUrl(HttpServletRequest request, Mem mem) {
		// 사용자가 보게될 인증화면에 대한 주소 구하기
		String url = googleLogin.getGrantUrl();// 인증화면으로 가기위한 링크주소 얻기
		//logger.info("restcontroller의 url은?" + url);

		Message message = new Message();
		message.setMsg(url);

		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		return entity;
	}

	// 로그인폼에서 사용할 SNS 인증화면의 링크 주소 요청을 처리
	@GetMapping("/authform/kakao")
	public ResponseEntity<Message> getKaKaoUrl(HttpServletRequest request, Mem mem) {
		// 사용자가 보게될 인증화면에 대한 주소 구하기
		//String url = kakaoLogin.getGrantUrl();// 인증화면으로 가기위한 링크주소 얻기

		Message message = new Message();
		//message.setMsg(url);

		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		return entity;
	}

	@GetMapping("/member/authform/naver")
	public ResponseEntity<Message> getNaverUrl(HttpServletRequest request, Mem mem) {
		// 사용자가 보게될 인증화면에 대한 주소 구하기
		//String url = naverLogin.getGrantUrl();// 인증화면으로 가기위한 링크주소 얻기

		Message message = new Message();
		//message.setMsg(url);

		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		return entity;
	}

}
