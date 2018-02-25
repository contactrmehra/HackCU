package com.prorg.service;

import com.prorg.helper.result.Response;
import com.prorg.model.DeliveryDetails;

public interface DeliveryDetailsService {
    Response save();
    Response delete(DeliveryDetails delivery) throws Exception;
}
