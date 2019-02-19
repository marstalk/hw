package com.classm.dao.mapper;

import com.classm.bean.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    @Insert("INSERT INTO `t_order` (`order_id`, `user_id`, `goods_id`, `rent_start_day`, `rent_end_day`, `daily_fee`, `service_fee`, `total_fee`, `pay_type`) VALUES" +
            " (#{order.orderId}, #{order.userId}, #{order.goodsId}, #{order.rentStartDay}, #{order.rentEndDay}, #{order.dailyFee}, #{order.serviceFee}, #{order.totalFee}, #{order.payType})")
    void save(@Param("order")Order order);

    @Select("select * from t_order where order_id = #{orderId}")
    @Results({
            @Result(column = "order_id", property = "orderId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "goods_id", property = "goodsId"),
            @Result(column = "rent_start_day", property = "rentStartDay"),
            @Result(column = "rent_end_day", property = "rentEndDay"),
            @Result(column = "daily_fee", property = "dailyFee"),
            @Result(column = "service_fee", property = "serviceFee"),
            @Result(column = "total_fee", property = "totalFee"),
            @Result(column = "pay_type", property = "payType"),
            @Result(column = "pay_status", property = "payStatus"),
            @Result(column = "audit_status", property = "auditStatus"),
    })
    Order queryById(@Param("orderId") String orderId);
}



