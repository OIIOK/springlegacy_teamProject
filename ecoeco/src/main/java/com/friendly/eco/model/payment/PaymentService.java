package com.friendly.eco.model.payment;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.friendly.eco.domain.Payment;
import com.friendly.eco.domain.PaymentParams;
import com.friendly.eco.domain.TossPayment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PaymentService {
	
    public Payment getConfirmPayment(String paymentKey, String orderId, int amount) {
    	String url = "https://api.tosspayments.com/v1/payments/confirm";
		String auth = "dGVzdF9za19kMjZEbGJYQWFWMHpNSjlkTzA4cVk1MFE5UkJLOg==";
		
		PaymentParams paymentParams = new PaymentParams();
		paymentParams.setAmount(amount);
		paymentParams.setOrderId(orderId);
		paymentParams.setPaymentKey(paymentKey);
        
        RestTemplate rt = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + auth);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        
        HttpEntity<PaymentParams> paymentRequest = new HttpEntity(paymentParams, headers);
        
        log.debug("요청Url:: " + url);
        TossPayment tossPayment = rt.postForObject(url, paymentRequest, TossPayment.class);
        log.debug("응답받은 tossPayment:: " + tossPayment.getMethod());
        log.debug("응답받은 tossPayment:: " + tossPayment.getOrderName());
        
        log.debug("------ API 응답 반환 -------");
        return getPaymentInfo(tossPayment, paymentParams);
    }
    
    public Payment getPaymentInfo(TossPayment tossPayment, PaymentParams params) {
        // Empty 객체 생성 및 데이터 세팅
        Payment payment = new Payment();
        payment.setPayMethod(tossPayment.getMethod());
        payment.setPayaccountNumber(tossPayment.getVirtualAccount().getAccountNumber());
        payment.setPayBank(tossPayment.getVirtualAccount().getBankCode());
        payment.setPayName(tossPayment.getOrderName());
        payment.setPayAmount(tossPayment.getTotalAmount());
        
        return payment;
    }
    
    
}
