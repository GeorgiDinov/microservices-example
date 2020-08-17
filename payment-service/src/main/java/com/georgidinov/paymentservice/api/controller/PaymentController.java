package com.georgidinov.paymentservice.api.controller;


import com.georgidinov.paymentservice.api.entity.Payment;
import com.georgidinov.paymentservice.api.service.PaymentService;
import com.georgidinov.paymentservice.api.util.RequestMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RequestMappings.PAYMENT)
public class PaymentController {


    //== fields ==
    private final PaymentService paymentService;


    //== constructors ==
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }//end of constructor


    //== public methods ==
    @PostMapping(RequestMappings.DO_PAYMENT)
    public Payment doPayment(@RequestBody Payment payment) {
        return this.paymentService.doPayment(payment);
    }


    @GetMapping(RequestMappings.ORDER_ID)
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) {
        return this.paymentService.findPaymentHistoryByOrderId(orderId);
    }


}//end of class PaymentController
