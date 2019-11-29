package com.lxl.service;

import com.lxl.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TypeService {
    /**
     * 查询所有分类
     * @return
     */
    List<Type> selectList();
}
