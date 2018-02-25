package com.prorg.dao.impl;

import com.prorg.dao.DeliveryDetailsDao;
import com.prorg.helper.result.Response;
import com.prorg.model.DeliveryDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryDetailsDaoImpl extends BaseDaoImpl implements DeliveryDetailsDao {

    @Autowired
    public DeliveryDetailsDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Response<Integer> save(DeliveryDetails deliveryDetails) {
        return super.save(deliveryDetails);
    }

    @Override
    public Response<DeliveryDetails> findById(int id) {
        return Response.Success(getCurrentSession().get(DeliveryDetails.class, id));
    }

    @Override
    public Response deleteById(int id) throws Exception {
        return super.delete(findById(id).data());
    }
}
