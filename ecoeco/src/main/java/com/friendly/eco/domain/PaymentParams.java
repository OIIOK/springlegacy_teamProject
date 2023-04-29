package com.friendly.eco.domain;

import lombok.Data;

@Data
public class PaymentParams {
	private String paymentKey;
	private String orderId;
 	private int amount;
}
