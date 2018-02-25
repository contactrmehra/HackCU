package com.prorg.dao.impl;

import com.prorg.dao.CourierDetailsDao;
import com.prorg.helper.result.Response;
import com.prorg.model.CourierDetails;
import com.prorg.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourierDetailsDaoImpl extends BaseDaoImpl implements CourierDetailsDao{

    @Autowired
    public CourierDetailsDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Response<Integer> saveCourierDetails(CourierDetails courierDetails) {
        return super.save(courierDetails);
    }

    @Override
    public Response<List<CourierDetails>> getCourierDetails(String userId) {
        Query query = getCurrentSession().createQuery("from CourierDetails where id = :userId");
        query.setParameter("id", userId);
        try {
            return Response.Success((List<CourierDetails>) query.getResultList());
        } catch (Exception exception) {
            return Response.Failure(exception.getMessage());
        }
    }
}
