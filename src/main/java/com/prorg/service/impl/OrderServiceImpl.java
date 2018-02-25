package com.prorg.service.impl;

import com.prorg.dao.OrderDao;
import com.prorg.helper.result.Response;
import com.prorg.helper.result.ValidationResponse;
import com.prorg.helper.validator.ModelValidator;
import com.prorg.model.Order;
import com.prorg.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private final ModelValidator modelValidator;

    public OrderServiceImpl(OrderDao orderDao, ModelValidator modelValidator){
        this.modelValidator = modelValidator;
        this.orderDao = orderDao;
    }

    @Override
    public Response<List<Order>> getOrderByMaskedId(int maskedOrderId) {
        int orderId = Order.unMaskId(maskedOrderId);
        return orderDao.findById(orderId);
    }

    @Override
    public Response saveOrder(Order order) {
        ValidationResponse userValidationResponse = modelValidator.validate(order);
        if (!userValidationResponse.isValid())
            return Response.Failure(userValidationResponse.errors());
        return orderDao.save(order);
    }

    @Override
    public Response updateOrder(Order order) {
        ValidationResponse userValidationResponse = modelValidator.validate(order);
        if (!userValidationResponse.isValid())
            return Response.Failure(userValidationResponse.errors());
        return orderDao.update(order);
    }
}
