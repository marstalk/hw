package com.classm.dao.mapper;

import com.classm.bean.GoodsUrl;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsUrlMapper {

    @Insert("<script>INSERT INTO `t_goods_pic` (`goods_id`, `pic_url`) VALUES <foreach item='url' collection='goodsUrls' separator=','> (#{url.goodsId}, #{url.picUrl})</foreach></script>")
    int saveUrls(@Param("goodsUrls") List<GoodsUrl> goodsUrls);

    @Select("<script>select * from t_goods_pic where goods_id in <foreach item='goodsId' collection='goodsIds' open='(' separator=',' close=')'> #{goodsId}</foreach></script>")
    @Results({
            @Result(column = "goods_id", property = "goodsId"),
            @Result(column = "pic_url", property = "picUrl")
    })
    List<GoodsUrl> queryByGoodsIds(@Param("goodsIds") List<String> goodsIds);
}
