package com.georgidinov.paymentservice.api.service;

import com.georgidinov.paymentservice.api.entity.Payment;
import com.georgidinov.paymentservice.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    //== fields ==
    private final PaymentRepository repository;


    //== constructors ==
    @Autowired
    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }//end of constructor


    //== public methods ==
    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(this.paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return this.repository.save(payment);
    }

    public String paymentProcessing() {
        //api should be 3rd party payment gateway(paypal, paytm)
        return new Random().nextBoolean() ? "success" : "false";
    }


    public Payment findPaymentHistoryByOrderId(int orderId) {
        return this.repository.findByOrderId(orderId);
    }

}//end of class PaymentService
