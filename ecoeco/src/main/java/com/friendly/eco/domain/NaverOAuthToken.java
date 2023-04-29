package com.friendly.eco.domain;

public class NaverOAuthToken {
	private String access_token;
	private String refresh_token; //재발급 필요한 정보
	private String token_type;
	private int expires_in; //유효기간
}
