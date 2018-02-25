package com.prorg.controller;

import com.prorg.helper.Constants;
import com.prorg.helper.result.Response;
import com.prorg.model.CourierDetails;
import com.prorg.model.Order;
import com.prorg.model.StatusType;
import com.prorg.model.User;
import com.prorg.service.OrderService;
import com.prorg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @RequestMapping(value = Constants.Courier.NEW_ORDER, method = RequestMethod.POST)
    public String saveCourierDetails(HttpServletRequest request, HttpSession session,
                                     Model model, @RequestParam CommonsMultipartFile fileUpload) throws Exception {

        Response<User> userById = userService.getUserById((int) session.getAttribute(Constants.SessionKeys.LOGGED_IN_USER));
        Response<User> carrierById = userService.getUserById(Integer.valueOf(request.getParameter("carrier")));

        CourierDetails courierDetails = new CourierDetails()
                .setLength(Integer.parseInt(request.getParameter("length")))
                .setWidth(Integer.parseInt(request.getParameter("width")))
                .setHeight(Integer.parseInt(request.getParameter("height")))
                .setWeight(Integer.parseInt(request.getParameter("weight")))
                .setContent(request.getParameter("content"))
                .setInflammable(Boolean.parseBoolean(request.getParameter("isInflammable")))
                .setBreakable(Boolean.parseBoolean(request.getParameter("isBreakable")))
                .setTobacco(Boolean.parseBoolean(request.getParameter("isTobacco")))
                .setEstimatedPrice(Double.parseDouble(request.getParameter("estimatedPrice")))
                .setInsurance(Boolean.parseBoolean(request.getParameter("isInsurance")))
                .setBillPhoto(fileUpload.getBytes());

        Order order = new Order()
                .setCarrier(carrierById.data())
                .setPlacedBy(userById.data())
                .setStatus(StatusType.ORDER_PLACED)
                .setCourierDetails(courierDetails);

        Response save = orderService.saveOrder(order);

        model.addAttribute(Constants.ModelAttributes.MESSAGE, save.isSuccessful() ? "Success" : "Failed");
        return Constants.Route.REDIRECT + Constants.Route.ROOT;
    }

    @RequestMapping(value = Constants.Courier.GET_ORDER, method = RequestMethod.GET)
    public String saveCourierDetails(Model model, @PathVariable("id") int maskedId) throws Exception {
        Response orderById = orderService.getOrderByMaskedId(maskedId);
        if (orderById.isSuccessful()) {
            model.addAttribute(Constants.ModelAttributes.RESULT, orderById.data());
        }
        return Constants.Route.REDIRECT + Constants.Route.ROOT;
    }
}
