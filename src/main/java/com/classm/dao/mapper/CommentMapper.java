package com.classm.dao.mapper;

import com.classm.bean.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    @Insert("insert into t_comment(user_id, user_name, goods_id, comment, c_date) values (#{c.userId}, #{c.userName}, #{c.goodsId}, #{c.comment}, #{c.date})")
    int save(@Param("c") Comment comment);

    @Select("select id, user_id, user_name, goods_id, comment, c_date from t_comment where goods_id = #{goodsId}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "goods_id", property = "goodsId"),
            @Result(column = "c_date", property = "date")
    })
    List<Comment> query(@Param("goodsId") String goodsId);
}
