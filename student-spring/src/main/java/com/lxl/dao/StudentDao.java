package com.lxl.dao;
import com.lxl.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface StudentDao {

    List<Student> selectList(@Param("student") Student student);

    int insert(@Param("student") Student student);

    int update(@Param("student") Student student);

    @Delete("delete from t_student where id in (${ids})")
    int deleteByIds(@Param("ids") String ids);

    @Select("select * from t_student where id=#{id}")
    Student selectById(@Param("id") Integer id);
}
