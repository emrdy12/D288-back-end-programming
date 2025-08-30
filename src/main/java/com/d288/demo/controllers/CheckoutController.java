package com.d288.demo.controllers;

import com.d288.demo.services.CheckoutService;
import com.d288.demo.services.Purchase;
import com.d288.demo.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse checkout(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.checkout(purchase);
        return purchaseResponse;
    }


}