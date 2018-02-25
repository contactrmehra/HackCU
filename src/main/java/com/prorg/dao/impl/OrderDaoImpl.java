package com.prorg.dao.impl;

import com.prorg.dao.OrderDao;
import com.prorg.helper.result.Response;
import com.prorg.model.Order;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Response<Integer> save(Order order) {
        return super.save(order);
    }

    @Override
    public Response<List<Order>> findById(int orderId) {
        Query query = getCurrentSession().createQuery("from order_details where id = :orderId");
        query.setParameter("orderId", orderId);
        try {
            return Response.Success((List<Order>) query.getResultList());
        } catch (Exception exception) {
            return Response.Failure(exception.getMessage());
        }
    }

    @Override
    public Response update(Order order) {
        return super.update(order);
    }
}
