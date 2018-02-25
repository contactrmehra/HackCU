package com.prorg.controller;

import com.prorg.helper.Constants;
import com.prorg.helper.result.Response;
import com.prorg.model.CourierDetails;
import com.prorg.service.CourierService;
import com.prorg.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CourierController {

    @Autowired
    private CourierService courierService;

    @RequestMapping(value = Constants.Courier.SAVE_COURIER_DETAILS, method = RequestMethod.POST)
    public String saveCourierDetails(HttpServletRequest request, HttpSession session, Model model, @RequestParam CourierDetails courierDetails, @RequestParam CommonsMultipartFile fileUpload) throws Exception {
        Integer length = Integer.parseInt(request.getParameter("length"));
        Integer width = Integer.parseInt(request.getParameter("width"));
        Integer height = Integer.parseInt(request.getParameter("height"));
        Integer weight = Integer.parseInt(request.getParameter("weight"));
        String content = request.getParameter("content");
        Boolean isInflamable = Boolean.parseBoolean(request.getParameter("isInflamable"));
        Boolean isBreakable = Boolean.parseBoolean(request.getParameter("isBreakable"));
        Boolean isTobacco = Boolean.parseBoolean(request.getParameter("isTobacco"));
        Double estimatedPrice = Double.parseDouble(request.getParameter("estimatedPrice"));
        Boolean isInsurance = Boolean.parseBoolean(request.getParameter("isInsurance"));
        byte[] billPhoto = fileUpload.getBytes();
        Response save = courierService.saveCourierDetails(length, width, height, weight, content, isInflamable, isBreakable, isTobacco, estimatedPrice, isInsurance, billPhoto);
        String redirectMessage = "Failed";
        if (save.isSuccessful()) {
            session.setAttribute(Constants.SessionKeys.LOGGED_IN_USER, save.data());
            redirectMessage = "Success";
        }

        model.addAttribute(Constants.ModelAttributes.MESSAGE, redirectMessage);
        return Constants.Route.REDIRECT + Constants.Route.STORYBOARDS;
    }
}

