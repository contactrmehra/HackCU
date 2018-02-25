package com.prorg.dao;

import com.prorg.helper.result.Response;
import com.prorg.model.DeliveryDetails;

public interface DeliveryDetailsDao {
    Response<Integer> save(DeliveryDetails deliveryDetails);
    Response<DeliveryDetails> findById(int id);
    Response deleteById(int id) throws Exception;
}
