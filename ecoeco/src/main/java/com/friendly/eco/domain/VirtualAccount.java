package com.friendly.eco.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VirtualAccount {
	private String accountNumber;
	private String customerName;
	private String dueDate;
	private String refundStatus;
}
