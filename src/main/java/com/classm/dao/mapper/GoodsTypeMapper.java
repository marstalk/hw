package com.classm.dao.mapper;

import com.classm.bean.GoodsType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsTypeMapper {

    @Select("select * from t_goods_type")
    List<GoodsType> queryAll();
}
