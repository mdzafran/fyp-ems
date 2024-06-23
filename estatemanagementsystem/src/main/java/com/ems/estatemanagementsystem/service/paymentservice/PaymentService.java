package com.ems.estatemanagementsystem.service.paymentservice;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentMethodCreateParams;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentIntent createPaymentIntent(Long amount, String paymentMethodId) throws StripeException {
        PaymentIntentCreateParams params =
            PaymentIntentCreateParams.builder()
                .setAmount(amount)
                .setCurrency("myr")
                .setPaymentMethod(paymentMethodId)
                .setConfirm(true)
                .build();

        return PaymentIntent.create(params);
    }

    public String createPaymentMethod(String cardNumber, Long expMonth, Long expYear, String cvc) throws StripeException {
        PaymentMethodCreateParams.CardDetails card =
            PaymentMethodCreateParams.CardDetails.builder()
                .setNumber(cardNumber)
                .setExpMonth(expMonth)
                .setExpYear(expYear)
                .setCvc(cvc)
                .build();

        PaymentMethodCreateParams params =
            PaymentMethodCreateParams.builder()
                .setCard(card)
                .setType(PaymentMethodCreateParams.Type.CARD)
                .build();

        return com.stripe.model.PaymentMethod.create(params).getId();
    }
}