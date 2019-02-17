package com.classm.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsUrl {
    private int id;

    private String goodsId;

    private String picUrl;

    public GoodsUrl(String goodsId, String picUrl) {
        this.goodsId = goodsId;
        this.picUrl = picUrl;
    }
}
