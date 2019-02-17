package com.classm.bean.resp;


import com.classm.bean.Goods;
import com.classm.bean.UserBasic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryGoodsByIdResp {
    private Goods goods;

    private UserBasic owner;

    private List<UserBasic> likes;
}
