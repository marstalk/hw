package com.classm.controller;

import com.classm.bean.JsonEntity;
import com.classm.bean.Order;
import com.classm.bean.ResponseHelper;
import com.classm.bean.User;
import com.classm.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@RestController
@RequestMapping("/security")
public class OrderController extends BaseController{
    @Autowired
    private OrderService orderService;

    @ApiOperation("place an order")
    @PostMapping("/order")
    public JsonEntity<Order> placeOrder(HttpServletRequest request, @RequestBody Order order) throws ParseException {

        User user = currentUser(request);
        Order palacedOrder = orderService.placeOrder(order, user);
        return ResponseHelper.of(palacedOrder);
    }

}
