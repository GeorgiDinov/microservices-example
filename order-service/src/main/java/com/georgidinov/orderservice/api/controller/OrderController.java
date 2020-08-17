package com.georgidinov.orderservice.api.controller;

import com.georgidinov.orderservice.api.common.TransactionRequest;
import com.georgidinov.orderservice.api.common.TransactionResponse;
import com.georgidinov.orderservice.api.service.OrderService;
import com.georgidinov.orderservice.api.util.RequestMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RequestMappings.ORDER)
public class OrderController {


    //== fields ==
    private final OrderService orderService;


    //== constructors ==
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }//end of constructor


    //== public methods ==
    @PostMapping(RequestMappings.BOOK_ORDER)
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        return this.orderService.saveOrder(request);
    }



}//end of class OrderController
