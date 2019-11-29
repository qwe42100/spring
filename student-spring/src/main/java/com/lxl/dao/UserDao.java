package com.lxl.dao;

import com.lxl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface UserDao {

    int insert(@Param("user") User user);

    @Select("select * from t_user where username=#{username}")
    User selectByUsername(@Param("username") String username);
}
