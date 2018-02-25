package com.prorg.service;

import com.prorg.helper.result.Response;
import com.prorg.model.CourierDetails;

import java.util.List;

public interface CourierService {
    
    Response<List<CourierDetails>> getCourierDetails(String userId) throws Exception;;

    Response saveCourierDetails(Integer length, Integer width, Integer height, Integer weight, String content, Boolean isInflamable, Boolean isBreakable, Boolean isTobacco, Double estimatedPrice, Boolean isInsurance, byte[] billPhoto);

}
