package com.friendly.eco.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TossPayment {
    private String orderName;
    private String method;
    private String totalAmount;
    private VirtualAccount virtualAccount;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class VirtualAccount{
    	private String accountNumber;
    	private String bankCode = "국민";
    }
}
