package com.classm.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class Goods {

    @ApiModelProperty(value = "absolute path of pic", required = true)
    private List<String> picUrls;

    @ApiModelProperty(value = "generated by API")
    private String goodsId;

    @ApiModelProperty(required = true)
    private String name;

    @ApiModelProperty(required = true)
    private int type;

    @ApiModelProperty(hidden = true)
    private String typeName;

    @ApiModelProperty(required = true)
    private BigDecimal rentalCost;

    @ApiModelProperty(required = true)
    private BigDecimal deposit;

    private String desc;

    private String addr;

    private int owner;

    public void addPicUrl(String url) {
        if (this.getPicUrls() == null) {
            this.setPicUrls(new ArrayList<>());
        }
        this.getPicUrls().add(url);
    }

}
