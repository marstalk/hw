package com.classm.dao.mapper;


import com.classm.bean.User;
import com.classm.bean.UserBasic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    @Select("select * from t_user")
    List<User> getAll();

    @Select("select * from t_user where email = #{email}")
    @Results({
            @Result(column = "first_name", property = "firstName"),
            @Result(column = "last_name", property = "lastName")
    })
    User findUserByEmail(String email);

    @Select("select * from t_user where phone = #{phone}")
    @Results({
            @Result(column = "first_name", property = "firstName"),
            @Result(column = "last_name", property = "lastName")
    })
    User findUserByPhone(String phone);

    @Select("select * from t_user where id = #{id}")
    @Results({
            @Result(column = "first_name", property = "firstName"),
            @Result(column = "last_name", property = "lastName")
    })
    User findUserById(int id);

    @Select("<script>select id, first_name, last_name from t_user where id in <foreach item='id' collection='ids' open='(' separator=',' close=')'> #{id}</foreach> </script>")
    @Results({
            @Result(column = "first_name", property = "firstName"),
            @Result(column = "last_name", property = "lastName")
    })
    List<UserBasic> findUsersByIds(@Param("ids") List<Integer> userByGoodsId);
}
