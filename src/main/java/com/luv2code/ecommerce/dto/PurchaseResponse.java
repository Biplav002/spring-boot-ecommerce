package com.luv2code.ecommerce.dto;

import com.luv2code.ecommerce.entity.Address;
import com.luv2code.ecommerce.entity.Customer;
import lombok.Data;

@Data
public class PurchaseResponse {

    private final String orderTrackingNumber;
    private final Customer customer;
    private final Address shippingAddress;
}
