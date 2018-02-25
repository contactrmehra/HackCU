package com.prorg.service.impl;

import com.prorg.dao.DeliveryDetailsDao;
import com.prorg.helper.result.Response;
import com.prorg.model.DeliveryDetails;
import com.prorg.service.DeliveryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeliveryDetailsDetailsServiceImpl implements DeliveryDetailsService {
    private final DeliveryDetailsDao deliveryDao;

    @Autowired
    public DeliveryDetailsDetailsServiceImpl(DeliveryDetailsDao deliveryDao) {
        this.deliveryDao = deliveryDao;
    }

    @Override
    public Response save() {
        return null;
    }

    @Override
    public Response delete(DeliveryDetails delivery) throws Exception {
        return deliveryDao.deleteById(delivery.getId());
    }
}
