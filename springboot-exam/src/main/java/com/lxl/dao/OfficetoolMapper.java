package com.lxl.dao;

import com.lxl.pojo.Officetool;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OfficetoolMapper {
    /**
     * 列表查询
     * @param officetool
     * @return
     */
    List<Officetool> selectObject(@Param("officetool") Officetool officetool, Integer pageNo, Integer pageSize);

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
     * @param ids
     * @return
     */
    int deleteById(@Param("ids")String ids);


}
