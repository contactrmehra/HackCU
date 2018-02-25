package com.prorg.service.impl;

import com.prorg.dao.CourierDetailsDao;
import com.prorg.helper.result.Response;
import com.prorg.helper.result.ValidationResponse;
import com.prorg.helper.validator.ModelValidator;
import com.prorg.model.CourierDetails;
import com.prorg.model.User;
import com.prorg.service.CourierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourierServiceImpl implements CourierService {

    private CourierDetailsDao courierDetailsDao;
    private final ModelValidator modelValidator;

    public CourierServiceImpl(CourierDetailsDao courierDetailsDao, ModelValidator modelValidator){
        this.modelValidator = modelValidator;
        this.courierDetailsDao = courierDetailsDao;
    }

    @Override
    public Response<List<CourierDetails>> getCourierDetails(String userId) throws Exception {
        return null;
    }

    @Override
    public Response saveCourierDetails(Integer length, Integer width, Integer height, Integer weight, String content, Boolean isInflamable, Boolean isBreakable, Boolean isTobacco, Double estimatedPrice, Boolean isInsurance, byte[] billPhoto) {
        CourierDetails courierDetails = new CourierDetails();
        courierDetails.setLength(length);
        courierDetails.setWidth(width);
        courierDetails.setHeight(height);
        courierDetails.setWeight(weight);
        courierDetails.setContent(content);
        courierDetails.setInflamable(isInflamable);
        courierDetails.setBreakable(isBreakable);
        courierDetails.setTobacco(isTobacco);
        courierDetails.setEstimatedPrice(estimatedPrice);
        courierDetails.setInsurance(isInsurance);
        courierDetails.setBillPhoto(billPhoto);
        ValidationResponse userValidationResponse = modelValidator.validate(courierDetails);
        if (!userValidationResponse.isValid())
            return Response.Failure(userValidationResponse.errors());
        return courierDetailsDao.saveCourierDetails(courierDetails);
    }

}
