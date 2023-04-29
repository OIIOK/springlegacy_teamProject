package com.friendly.eco.domain;

import lombok.Data;

/*
 *	결제내역 객체
 *	-payIdx : 결제 PK
 *	-payMethod : 결제수단(카드, 가상계좌)
 *	-payName : 결제명(ex: 000외 1건)
 *	-payAmount : 결제금액
 *	-payApproval : 결제승인번호(api로부터 받아오는 승인번호를 보유하여 조회, 취소 시 사용)
 *	-payDate : 결제일(실제 결제 승인이 이루어진 일자로 기입)
 */

@Data
public class Payment {
	private String payMethod;
	private String payName;
	private String payAmount;
	private String payBank;
	private String payaccountNumber;
}