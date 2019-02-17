package com.classm.dao.mapper;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeMapper {

    @Insert("INSERT INTO `t_like` (`user_id`, `goods_id`) VALUES (#{userId}, #{goodsId});")
    int saveLike(@Param("userId") int id, @Param("goodsId") String goodsId);

    @Delete("delete from t_like where user_id = #{userId} and goods_id = #{goodsId}")
    void deleteLike(@Param("userId") int id, @Param("goodsId") String goodsId);

    @Select("select user_id from t_like where goods_id = #{goodsId}")
    List<Integer> findUserByGoodsId(@Param("goodsId") String goodsId);
}
