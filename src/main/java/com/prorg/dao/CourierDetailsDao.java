package com.prorg.dao;

import com.prorg.helper.result.Response;
import com.prorg.model.CourierDetails;

import java.util.List;

public interface CourierDetailsDao {
    Response<Integer> saveCourierDetails(CourierDetails courierDetails);
    Response<List<CourierDetails>> getCourierDetails(String userId);
}
