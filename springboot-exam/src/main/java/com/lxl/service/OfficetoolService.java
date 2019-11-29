package com.lxl.service;

import com.github.pagehelper.PageInfo;
import com.lxl.pojo.Officetool;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OfficetoolService {
    /**
     * 列表查询
     * @param officetool
     * @return
     */
    PageInfo<Officetool> selectObject(Officetool officetool, Integer pageNo, Integer pageSize);

    /**
     * 添加
     * @param officetool
     * @return
     */
    int insert(Officetool officetool);

    /**
     * 修改
     * @param officetool
     * @return
     */
    int update(Officetool officetool);

    /**
     * 查询对象
     * @param id
     * @return
     */
    Officetool getById(Integer id);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteById(String ids);


}
