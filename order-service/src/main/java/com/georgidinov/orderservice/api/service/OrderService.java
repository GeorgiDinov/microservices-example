package com.georgidinov.orderservice.api.service;

import com.georgidinov.orderservice.api.common.Payment;
import com.georgidinov.orderservice.api.common.TransactionRequest;
import com.georgidinov.orderservice.api.common.TransactionResponse;
import com.georgidinov.orderservice.api.entity.Order;
import com.georgidinov.orderservice.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {

    //== fields ==
    private final OrderRepository repository;
    @Lazy
    private final RestTemplate restTemplate;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    String PAYMENT_SERVICE_END_POINT_URL;

    //== constructors ==
    @Autowired
    public OrderService(OrderRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }//end of constructor


    //== public methods ==
    public TransactionResponse saveOrder(TransactionRequest request) {

        String response = "";

        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        //== rest call
        Payment paymentResponse =
                this.restTemplate.postForObject(PAYMENT_SERVICE_END_POINT_URL, payment, Payment.class);


        response = paymentResponse.getPaymentStatus().equals("success")
                ? "payment processing successful and order placed"
                : "there is a failure in payment api, order added to cart";

        this.repository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(),
                paymentResponse.getTransactionId(), response);
    }


}//end of class OrderService
