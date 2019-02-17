package com.classm.controller;

import com.classm.bean.JsonEntity;
import com.classm.bean.Order;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class OrderController {

    @ApiOperation("place an order")
    @PostMapping("/order")
    public JsonEntity<Order> placeOrder(@RequestBody Order order){
        return null;
    }

}
