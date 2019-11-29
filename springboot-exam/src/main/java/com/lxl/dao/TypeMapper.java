package com.lxl.dao;

import com.lxl.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {
    /**
     * 查询所有分类
     * @return
     */
    @Select("select * from t_type")
    List<Type> selectList();
}
