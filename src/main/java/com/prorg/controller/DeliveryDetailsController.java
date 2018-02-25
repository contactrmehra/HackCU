package com.prorg.controller;

import com.prorg.service.DeliveryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DeliveryDetailsController {
    private final DeliveryDetailsService deliveryDetailsService;

    @Autowired
    public DeliveryDetailsController(DeliveryDetailsService deliveryDetailsService) {
        this.deliveryDetailsService = deliveryDetailsService;
    }
}
