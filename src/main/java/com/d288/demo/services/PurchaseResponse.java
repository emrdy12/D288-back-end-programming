package com.d288.demo.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseResponse {
    private final String orderTrackingNumber;

    public PurchaseResponse (String orderTrackingNumber){
        this.orderTrackingNumber = orderTrackingNumber;
    }
}
