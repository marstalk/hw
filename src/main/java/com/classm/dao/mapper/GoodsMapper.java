package com.classm.dao.mapper;

import com.classm.bean.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    @Insert("INSERT INTO `t_goods` (`goods_id`, `name`, `type`, `rentalCost`, `deposit`, `desc`, `addr`, `owner`, `type_name`) VALUES" +
            " (#{goodsId}, #{name}, #{type}, #{rentalCost}, #{deposit}, #{desc}, #{addr}, #{owner}, #{typeName})")
    int saveGoods(Goods goods);

    @Select("<script>select * from t_goods " +
            "where 1=1 " +
            "<when test='goodsName!=null'> and name like concat('%', #{goodsName}, '%') </when>" +
            "<when test='type!=0'> and type = #{type} </when> " +
            "order by id limit #{limitA}, #{limitB} </script>")
    @Results({
            @Result(column = "goods_id", property = "goodsId"),
            @Result(column = "type_name", property = "typeName")
    })
    List<Goods> query(@Param("goodsName") String goodsName, @Param("type") int type, @Param("limitA") int limitA, @Param("limitB") int limitB);

    @Select("select * from t_goods where goods_id = #{goodsId}")
    @Results({
            @Result(column = "goods_id", property = "goodsId"),
            @Result(column = "type_name", property = "typeName")
    })
    Goods queryById(String goodsId);

    @Select("<script>select count(1) from t_goods where 1=1 " +
            "<when test='goodsName!=null'> and name like concat('%', #{goodsName}, '%') </when>" +
            "<when test='type!=0'> and type = #{type} </when> </script>")
    long countGoods(@Param("goodsName") String goodsName, @Param("type") int type);
}
