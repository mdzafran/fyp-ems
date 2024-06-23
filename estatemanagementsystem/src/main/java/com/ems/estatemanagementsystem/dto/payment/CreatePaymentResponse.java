package com.ems.estatemanagementsystem.dto.payment;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatePaymentResponse {
    
    private String clientSecret;
    
    public CreatePaymentResponse(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
