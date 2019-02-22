package com.classm.bean.resp;


import com.classm.bean.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryGoodsResp {
    private List<Goods> goods;
    private long count;
    private int pageNo;
    private int pageSize;
}
