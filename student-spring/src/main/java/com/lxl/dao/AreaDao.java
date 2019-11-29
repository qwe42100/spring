package com.lxl.dao;
import com.lxl.pojo.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface AreaDao {
    @Select("select id,name,pid from t_area")
    List<Area> selectAll();

    @Select("select id,name,pid from t_area where id=#{id}")
    Area selectById(@Param("id") Integer id);

    @Select("select id,name,pid from t_area where pid=#{pid}")
    List<Area> selectListByPid(@Param("pid") Integer pid);

    List<Area> getAreaListByIds(@Param("areaIds") List<Integer> areaIds);
}
