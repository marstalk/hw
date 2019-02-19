package com.classm.service;


import com.classm.advice.BizExceptiton;
import com.classm.bean.Goods;
import com.classm.bean.Order;
import com.classm.bean.User;
import com.classm.dao.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsService goodsService;


    public Order placeOrder(Order order, User user) throws ParseException {

        String goodsId = order.getGoodsId();
        Goods goods = goodsService.queryById(goodsId);
        order.setDailyFee(goods.getRentalCost());
        order.setOrderId("hw-" + System.currentTimeMillis() + "-" +UUID.randomUUID().toString().substring(0, 8));

        //TODO service fee
        order.setServiceFee(BigDecimal.ZERO);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        order.setRentStartDay(sdf.parse(order.getRentStart()));
        order.setRentEndDay(sdf.parse(order.getRentEnd()));
        if (!order.getRentStartDay().before(order.getRentEndDay())) {
            throw new BizExceptiton("start day must before end day.");
        }

        order.setUserId(user.getId());
        order.setTotalFee(calculatetTotalFee(order, goods));
        orderMapper.save(order);

        return queryById(order.getOrderId());
    }

    public Order queryById(String orderId) {
        Order order = orderMapper.queryById(orderId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        order.setRentStart(sdf.format(order.getRentStartDay()));
        order.setRentEnd(sdf.format(order.getRentEndDay()));
        return order;
    }

    private BigDecimal calculatetTotalFee(Order order, Goods goods) {

        int i = differentDaysByMillisecond(order.getRentStartDay(), order.getRentEndDay());
        if (i < 1) {
            throw new BizExceptiton("start day must before end day.");
        }

        BigDecimal totalFee = (new BigDecimal(i).multiply(order.getDailyFee())).add(order.getServiceFee()).add(goods.getDeposit());

        return totalFee;
    }


    public static int differentDaysByMillisecond(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days + 1;
    }
}
