package com.ems.estatemanagementsystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.estatemanagementsystem.dto.payment.CreatePayment;
import com.ems.estatemanagementsystem.dto.payment.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@RestController
public class PaymentBuilder {

    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody CreatePayment createPayment) throws StripeException {

      Long amount = createPayment.getAmount();

      PaymentIntentCreateParams params =
        PaymentIntentCreateParams.builder()
          .setAmount(amount)
          .setCurrency("myr")
          .build();

      PaymentIntent paymentIntent = PaymentIntent.create(params);
      CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
      return paymentResponse;
    }
}