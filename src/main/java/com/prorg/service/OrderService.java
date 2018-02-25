package com.prorg.service;

import com.prorg.helper.result.Response;
import com.prorg.model.Order;

import java.util.List;

public interface OrderService {
    
    Response<List<Order>> getOrderByMaskedId(int maskedOrderId);
    Response saveOrder(Order newOrder);
    Response updateOrder(Order order);
}
