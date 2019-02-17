package com.classm.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;

    private int userId;

    private String goodsId;

    private Date rentStartDay;

    private Date rentEndDay;

    private BigDecimal dailyFee;

    private BigDecimal serviceFee;

    private BigDecimal totalFee;

    private int payType;

    private int payStatus;



}
