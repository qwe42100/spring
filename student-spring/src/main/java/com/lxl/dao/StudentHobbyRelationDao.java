package com.lxl.dao;
import com.lxl.pojo.StudentHobbyRelation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;
@Mapper
@Repository
public interface StudentHobbyRelationDao {
    @Select("select id,name,pid from t_sudent_hobby_relation")
    List<StudentHobbyRelation> selectAll();

    @Select("select id,name,pid from t_sudent_hobby_relation where id=#{id}")
    StudentHobbyRelation selectById(@Param("id") Integer id);

    @Insert("insert into t_sudent_hobby_relation(student_id,hobby_id) values(#{studentHobbyRelation.student_id},#{studentHobbyRelation.hobby_id}) ")
    int insert(@Param("studentHobbyRelation") StudentHobbyRelation studentHobbyRelation);

    @Delete("delete from t_sudent_hobby_relation where student_id=#{stuId}")
    int deleteByStuId(@Param("stuId") Integer stuId);

    @Select("select hobby_id from t_sudent_hobby_relation where student_id=#{stuId}")
    List<Integer> getHobbyIdsByStuId(@Param("stuId") Integer stuId);

    @Select("select hobby_id from t_sudent_hobby_relation where student_id=#{stuId}")
    Set<Integer> getHobbyIdsSetByStuId(@Param("stuId") Integer stuId);
}
