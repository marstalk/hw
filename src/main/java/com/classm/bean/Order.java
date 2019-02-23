package com.classm.bean;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @ApiModelProperty(required = true)
    private String goodsId;


    @ApiModelProperty(required = true, allowableValues = "{visa, mastercard, amex}")
    private String payType;

    @ApiModelProperty(required = true, value = "rental start date, yyyy-MM-dd", example = "2018-9-1")
    private String rentStart;

    @ApiModelProperty(required = true, value = "rental end date, yyyy-MM-dd", example = "2018-9-5")
    private String rentEnd;

    //hidden

    @ApiModelProperty(hidden = true)
    private BigDecimal dailyFee;

    @ApiModelProperty(hidden = true)
    private BigDecimal serviceFee;

    @ApiModelProperty(hidden = true)
    private BigDecimal totalFee;

    @ApiModelProperty(hidden = true)
    private String orderId;

    @ApiModelProperty(hidden = true)
    private int userId;

    @ApiModelProperty(hidden = true)
    private int payStatus;

    @ApiModelProperty(hidden = true)
    private int auditStatus;

    @ApiModelProperty(hidden = true)
    private Date rentStartDay;

    @ApiModelProperty(hidden = true)
    private Date rentEndDay;

}
