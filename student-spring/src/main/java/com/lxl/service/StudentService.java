package com.lxl.service;
import com.github.pagehelper.PageInfo;
import com.lxl.pojo.Area;
import com.lxl.pojo.Classes;
import com.lxl.pojo.Hobby;
import com.lxl.pojo.Student;
import java.util.List;
public interface StudentService {
    /**
     * 列表页接口
     * @param student
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Student> getPageInfo(Student student, int pageNo, int pageSize);

    /**
     * 保存（新增/编辑）
     * @param student
     * @return
     */
    boolean save(Student student);

    /**
     * 删除
     * @param ids
     * @return
     */
    boolean delByIds(String ids);

    /**
     * 根据学生Id，查询学生
     * @param id
     * @return
     */
    Student getById(Integer id);

    /**
     * 查询所有班级
     * @return
     */
    List<Classes> getClassesAll();

    /**
     * 根据pid，查询城市列表
     * @param pid
     * @return
     */
    List<Area> getAreaListByPid(Integer pid);

    /**
     * 查询一级城市列表
     * @return
     */
    List<Area> getTopAreaList();

    /**
     * 根据Id，查询地区
     * @param id
     * @return
     */
    Area getAreaById(Integer id);

    /**
     * 根据Id，查询班级信息
     * @param classes_id
     * @return
     */
    Classes getClassesById(Integer classes_id);

    /**
     * 查询所有爱好
     * @return
     */
    List<Hobby> getHobbyAll();

    /**
     * 根据学生Id，查询爱好Ids
     * @param id
     * @return
     */
    List<Integer> getHobbyIdsByStuId(Integer id);
}
