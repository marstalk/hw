package com.classm.dao.mapper;

import com.classm.bean.Goods;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    @Insert("INSERT INTO `t_goods` (`goods_id`, `name`, `type`, `rentalCost`, `deposit`, `desc`, `addr`) VALUES (#{goodsId}, #{name}, #{type}, #{rentalCost}, #{deposit}, #{desc}, #{addr})")
    int saveGoods(Goods goods);

    @Select("select * from t_goods where name like concat('%', #{goodsName}, '%') and type = #{type}")
    @Results({
            @Result(column = "goods_id", property = "goodsId")
    })
    List<Goods> query(@Param("goodsName") String goodsName, @Param("type") int type);

    @Select("select * from t_goods where goods_id = #{goodsId}")
    @Results({
            @Result(column = "goods_id", property = "goodsId")
    })
    Goods queryById(String goodsId);
}



        ;
