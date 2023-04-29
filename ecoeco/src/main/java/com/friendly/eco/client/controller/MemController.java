package com.friendly.eco.client.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendly.eco.domain.GoogleLogin;
import com.friendly.eco.domain.GoogleOAuthToken;
import com.friendly.eco.domain.KaKaoLogin;
import com.friendly.eco.domain.Mem;
import com.friendly.eco.domain.MemBirth;
import com.friendly.eco.domain.MemEmail;
import com.friendly.eco.domain.MemName;
import com.friendly.eco.domain.MemNickname;
import com.friendly.eco.domain.MemPass;
import com.friendly.eco.domain.MemPhone;
import com.friendly.eco.domain.MemType;
import com.friendly.eco.domain.NaverLogin;
import com.friendly.eco.domain.SocietyMem;
import com.friendly.eco.model.mem.MemService;
import com.friendly.eco.model.mem.MemTypeService;
import com.friendly.eco.model.mem.SocietyMemService;

//동기방식
@Controller
@RequestMapping("/member")
public class MemController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MemTypeService memTypeService;
	@Autowired
	private MemService memService;
	@Autowired
	private SocietyMemService societyMemService;
	
	@Autowired
	private GoogleLogin googleLogin;
	@Autowired
	private KaKaoLogin kakaoLogin;
	@Autowired
	private NaverLogin naverLogin;

	
	/*******************************************************
	 * 페이지 이동
	 *******************************************************/
	// 페이지 이동 (index -> loginMain)
	@GetMapping("/login")
	public ModelAndView getLoginMain(HttpServletRequest request) {
		
	
		return new ModelAndView("client/member/loginMain");
	}

	// test 페이지
	@GetMapping("/joinform")
	public ModelAndView doTest(HttpServletRequest request) {
		return new ModelAndView("client/member/registforGen");
	}

	// 페이지 이동 (loginMain -> registforGen)
	@GetMapping("/registforGen")
	public ModelAndView getJoinForm(HttpServletRequest request) {
		return new ModelAndView("client/member/registforGen");
	}

	// 페이지 이동 (loginMain -> findidbyPhone)
	@GetMapping("/findIdByPhone")
	public ModelAndView findidbyPhone(HttpServletRequest request) {
		return new ModelAndView("client/member/findidbyPhone");
	}

	// 페이지 이동 (loginMain -> findidbyEmail)
	@GetMapping("/findIdByEmail")
	public ModelAndView findidbyEmail(HttpServletRequest request) {
		return new ModelAndView("client/member/findidbyEmail");
	}

	// 페이지 이동 ( findpassbyPhone)
	@GetMapping("/findPassByPhone")
	public ModelAndView findpassbyPhone(HttpServletRequest request) {
		return new ModelAndView("client/member/findpassbyPhone");
	}

	// 페이지 이동 (findidbyEmail)
	@GetMapping("/findPassByEmail")
	public ModelAndView findpassbyEmail(HttpServletRequest request) {
		return new ModelAndView("client/member/findpassbyEmail");
	}

	// 페이지 이동 (registforSociety.)
	@GetMapping("/registForSociety")
	public ModelAndView registforSociety(HttpServletRequest request) {
		return new ModelAndView("client/member/registforSoc");
	}

	
	/*******************************************************
	 * 로그인
	 *******************************************************/
	// 로그인 처리(loginMain -> main 화면)
	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request, Mem mem) {

		// 파라미터 넘어오는지 확인
		// String mem_id = request.getParameter("mem_id");
		// String mem_pass = request.getParameter("memPass.mem_pass");
		// System.out.println("넘어오는 mem_id와 mem_pass는 : " + mem_id + mem_pass);

		ModelAndView mav = new ModelAndView();
		Mem obj = memService.login(mem);
		String mem_id=obj.getMem_id();
		System.out.println("obj 값은 : " + obj);
		// System.out.println(obj.getMem_id());
		// System.out.println(obj.getMemPass().getMem_pass()); //null이 뜸, 근데 그렇다고 해서
		// login쿼리가 작동 하지 않는 것은 x -> 아이디와 비밀번호가 일치할 때만 넘어옴

		if (obj != null) { // 쿼리문이 수행되면
			Mem member =memService.select(mem_id); 
			System.out.println("memController의 member값은 : " + member);
			
			HttpSession session = request.getSession(); // 세션 생성 //default 가 true
			session.setAttribute("mem", member); // 세션에 값 저장, name/value //세션이 유지되는 동안 저장 //로그인 성공 회원을 대상으로 세션 정보를 생성
			System.out.println("session은 " + session);
			// 로그인 성공 시 main화면으로 이동
			//int mem_idx = (Integer)session.getAttribute("mem_idx");
            //System.out.println("mem_idx가 나오니? " + mem_idx);
			mav.setViewName("client/index");
		} else {
			// 로그인 실패 시 로그인 페이지로 다시 이동
			mav.setViewName("redirect:/member/login");
		}
		return mav;
	}

	/*******************************************************
	 * 회원가입 (일반)
	 *******************************************************/
	// 회원가입 처리 (registfroGen -> main 화면) (개인용)
	@PostMapping("/register")
	public ModelAndView register(HttpServletRequest request, Mem mem, HttpSession session) {

		// 파라미터 값 넘겨받기 (name, not id)
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		String mem_pass_check = request.getParameter("mem_pass_check");
		String mem_name = request.getParameter("mem_name");
		String mem_birth = request.getParameter("mem_birth");
		String mem_phone = request.getParameter("mem_phone");
		String mem_email = request.getParameter("mem_email");
		String mem_nickname = request.getParameter("mem_nickname");

		System.out.println(
				mem_id + mem_pass + mem_pass_check + mem_name + mem_birth + mem_phone + mem_email + mem_nickname); // ok

		System.out.println("mem은" + mem); // id빼고는 다 null값

		// 넘어온 값을 데이터를 각각의 테이블에 넣어주자
		MemType memType = new MemType();
		memType.setMem_type_idx(1); // 개인회원

		MemPass memPass = new MemPass();
		memPass.setMem_pass(mem_pass);
		MemName memName = new MemName();
		memName.setMem_name(mem_name);
		MemBirth memBirth = new MemBirth();
		memBirth.setMem_birth(mem_birth);
		MemPhone memPhone = new MemPhone();
		memPhone.setMem_phone(mem_phone);
		MemEmail memEmail = new MemEmail();
		memEmail.setMem_email(mem_email);
		MemNickname memNickname = new MemNickname();
		memNickname.setMem_nickname(mem_nickname);

		// 정보 담기
		// mem.setMem_id(mem_id); //이렇게 안 해도 되는 이유가, 그냥 자동 매핑되기 때문
		mem.setMemType(memType);
		mem.setMemPass(memPass);
		mem.setMemName(memName);
		mem.setMemBirth(memBirth);
		mem.setMemPhone(memPhone);
		mem.setMemEmail(memEmail);
		mem.setMemNickname(memNickname);

		System.out.println("memType이 담긴 mem은" + mem);

		// mem.setMemPass(memPass);
		logger.info("mem 정보는 = " +  mem);

		// 정보를 다 담았으니까 이제 서비스에게 일을 시키자 -> 여길 지나면 mem_idx가 생성됨
		memService.regist(mem);
		logger.info("mem 정보는 = " +  mem); // regist 다음에 왜 값이 안 나오는 거지? //근데 테이블 생성은 됨
		
		ModelAndView mav=new ModelAndView();
		
		if(mem != null) {
		 //세션에 담기
			//session.setAttribute("mem", mem);
			//System.out.println(session);

			mav.setViewName("client/index");
		}

		return mav;
	}

	/*******************************************************
	 * 회원가입(단체)
	 *******************************************************/
	// 회원가입 처리 (registforSoc -> main 화면) (단체용)
	@PostMapping("/registerForSoc")
	public ModelAndView registForSoc(HttpServletRequest request, SocietyMem societyMem, HttpSession session) {

		// 파라미터 값 넘겨받기
		String society_mem_name = request.getParameter("society_mem_name");
		String society_mem_registration = request.getParameter("society_mem_registration");
		String society_mem_clerk_name = request.getParameter("society_mem_clerk_name");
		String society_mem_clerk_phone = request.getParameter("society_mem_clerk_phone");
		String society_mem_clerk_email = request.getParameter("society_mem_clerk_email");
		String mem_id = request.getParameter("mem_id");
		String society_mem_pass = request.getParameter("society_mem_pass");

		System.out.println(society_mem_name + society_mem_registration + society_mem_clerk_name
				+ society_mem_clerk_phone + society_mem_clerk_email + mem_id + society_mem_pass);
		System.out.println("controller : 그 전의 mem값은 : " + societyMem); // 여기에 이미 모든 값이 들어있음 -> 필요한 정보 : mem_id,
																		// mem_type_idx (이거는 insert문에서 해결 가능?)

		// 넘어온 값을 데이터를 각각의 테이블에 넣어주자
		MemType memType = new MemType();
		memType.setMem_type_idx(2); // 단체회원

		Mem mem = new Mem();
		mem.setMemType(memType);
		mem.setMem_id(mem_id);
		societyMem.setMem(mem);
		 
		// 정보 담기
		societyMem.setMem(mem);
		System.out.println("controller : society mem : " + societyMem); //값이 다 들어감
		
		societyMemService.regist(societyMem, mem);

		return null;
	}
	
	/*******************************************************
	 * sns 로그인 및 회원가입
	 * (1) 구글 로그인 
	 * id, email, name 제공
	 *******************************************************/
	@GetMapping("/sns/google/callback")
	public ModelAndView googleCallback(HttpServletRequest request, HttpSession session) {
		String code = request.getParameter("code");
		logger.info("구글에서 발급된 코드는 " + code);
		
		//구글이 넘겨준 code와 내 계정이 보유한  client_id  및 client_secret 를 조합하여 
		//구글 서버측에 token 발급을 요청해야 한다.. (POST)  head+body를 구성하여 요청을 시도
		//이때 우리 스프링 서버는 상대적으로 클라이언트가 된다..
		//token은 회원정보에 접근할 수 잇는 증명서 개념임..
		
		/*-----------------------------------------------------------------
		 1) 토큰 취득을 위한 POST 헤더와 바디 구성하기 
		-----------------------------------------------------------------*/
		String url = googleLogin.getToken_request_url();
		
		//body의 파라미터 구성하기 <파라미터명, 파라미터값>
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("code", code);
		params.add("client_id", googleLogin.getClient_id());
		params.add("client_secret", googleLogin.getClient_secret());
		params.add("redirect_uri", googleLogin.getRedirect_uri());
		params.add("grant_type", googleLogin.getGrant_type());
		
		//post 방식의 헤더 (application/x-www-form-urlencoded)
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		
		//머리와 몸 합치기
		HttpEntity httpEntity = new HttpEntity(params, headers);
		
		//요청시도를 위한 객체 생성, 비동기 방식의 요청을 위한 객체
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(url,  HttpMethod.POST, httpEntity, String.class); 
		
		/*-----------------------------------------------------------------
		 2) 토큰 요청후  ResponseEntity로부터 토큰 꺼내기 (String에 불과하므로..)
		-----------------------------------------------------------------*/
		String body = responseEntity.getBody();
		logger.info("구글에서 넘겨받은 응답정보" + body);
		
		//json으로 되어있는 문자열을 파싱하여, 자바의 객체로 옮겨담자
		ObjectMapper objectMapper = new ObjectMapper();
		GoogleOAuthToken oAuthToken = null; //우선 생성해주자
		
		try {
			oAuthToken = objectMapper.readValue(body,  GoogleOAuthToken.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		/*-----------------------------------------------------------------
		 3) 토큰을 이용하여 회원정보에 접근
		-----------------------------------------------------------------*/
		String userinfo_url = googleLogin.getUserinfo_url();
		
		//GET방식요청 구성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer " + oAuthToken.getAccess_token());
		HttpEntity entity = new HttpEntity(headers2);
		
		//비동기객체를 이용한 GET 요청
		RestTemplate restTemplate2 = new RestTemplate();
		ResponseEntity<String> userEntity = restTemplate2.exchange(userinfo_url, HttpMethod.GET, entity, String.class);
		
		String userBody = userEntity.getBody();
		logger.info(userBody);
		HashMap<String, Object> userMap = new HashMap<String, Object>();
		
		//사용자 정보 추출하기
		ObjectMapper objectMapper2 = new ObjectMapper();
		try {
			userMap = objectMapper2.readValue(userBody, HashMap.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		String mem_id = (String)userMap.get("id");
		String mem_email = (String)userMap.get("email");
		boolean verified_email = (Boolean)userMap.get("verified_email");
		String mem_name = (String)userMap.get("name");
		
		logger.info("mem_id = " + mem_id);
		logger.info("mem_email = " + mem_email);
		logger.info("verified_email = " + verified_email);
		logger.info("mem_name = " + mem_name); //ok
		
		Mem mem = new Mem();
		mem.setMem_id(mem_id);

		//회원가입이 안 되어 있는 경우
		//if(memService.select(mem)==null) { //회원가입 안 되어 있는 건 성공함
			//sns정보 + name, email을 심어놓아야 서비스가 일한다
			
			/*MemType memType = new MemType();
			memType.setMem_type_name("google"); //서비스에서 해줄까?
			mem.setMemType(memType);
			MemName memName = new MemName();
			memName.setMem_name(mem_name);
			MemEmail memEmail = new MemEmail();
			memEmail.setMem_email(mem_email);
			
			mem.setMemName(memName);
			mem.setMemEmail(memEmail);
			
			System.out.println("mem안에 뭐가 있을까? "+ mem);

			//다른 페이지의 값과 합쳐야 하는데
			memService.insertBysns(mem); 
			*/
		//}else { //이미 회원가입이 되어 있다면
			//mem = memService.select(mem);
		//}
		
		//자동 로그인 처리(세션에 담아주자)
		session.setAttribute("mem", mem);
		ModelAndView mav = new ModelAndView("/client/index");
		
		return mav;
	}
	
	
}















