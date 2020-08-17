package com.georgidinov.paymentservice.api.util;

public final class RequestMappings {

    //== constants ==
    public static final String PAYMENT = "/payment";
    public static final String DO_PAYMENT = "/doPayment";
    public static final String ORDER_ID = "/{orderId}";


    //== constructors ==
    private RequestMappings() {
    }

}//end of class RequestMappings
