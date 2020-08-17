package com.georgidinov.cloudgateway.controller;

import com.georgidinov.cloudgateway.util.Messages;
import com.georgidinov.cloudgateway.util.RequestMappings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    //== public methods ==
    @HystrixCommand
    @RequestMapping(RequestMappings.ORDER_FALL_BACK)
    public Mono<String> orderServiceFallBack() {
        return Mono.just(Messages.ORDER_SERVICE_FAILURE_MESSAGE);
    }

    @HystrixCommand
    @RequestMapping(RequestMappings.PAYMENT_FALL_BACK)
    public Mono<String> paymentServiceFallBack() {
        return Mono.just(Messages.PAYMENT_SERVICE_FAILURE_MESSAGE);
    }

}//end of class FallbackController
