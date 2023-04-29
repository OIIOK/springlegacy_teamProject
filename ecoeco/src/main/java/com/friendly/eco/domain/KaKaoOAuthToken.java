package com.friendly.eco.domain;

public class KaKaoOAuthToken {

	private String access_token;
	private String token_type;
	private String refresh_token; //재발급 필요한 정보
	private int expires_in; //유효기간
	private String scope;
	private String refresh_token_expires_in;
	
}
