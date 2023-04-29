package com.friendly.eco.util;

import lombok.Data;

//응답으로 보낼 메세지 객체
@Data
public class Message {
	private int code; // 응답코드
	private String msg; // 응답메세지
}
