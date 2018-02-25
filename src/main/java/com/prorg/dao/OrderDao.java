package com.prorg.dao;

import com.prorg.helper.result.Response;
import com.prorg.model.Order;

import java.util.List;

public interface OrderDao {
    Response<Integer> save(Order order);
    Response<List<Order>> findById(int orderId);
    Response update(Order order);
}
