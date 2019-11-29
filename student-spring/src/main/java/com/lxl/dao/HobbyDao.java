package com.lxl.dao;
import com.lxl.pojo.Area;
import com.lxl.pojo.Hobby;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface HobbyDao {

    @Select("select * from t_hobby")
    List<Hobby> selectAll();

    @Select("select * from t_hobby where id=#{id}")
    Area selectById(@Param("id") Integer id);

    List<Area> getListByIds(@Param("ids") List<Integer> ids);
}
