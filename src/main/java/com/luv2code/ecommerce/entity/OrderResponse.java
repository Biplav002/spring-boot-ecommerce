package com.luv2code.ecommerce.entity;

import lombok.Data;

@Data
public class OrderResponse {
    private String applicationFee;
    private String razorpayOrderId;
    private String secretKey;
}
