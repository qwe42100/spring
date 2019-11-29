package com.lxl.controller;
import com.lxl.pojo.Area;
import com.lxl.pojo.Student;
import com.lxl.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/student/")
public class StudentController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private StudentService studentService;


    /**
     * 学生管理列表接口
     * @param student
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("list")
    @GetMapping("list")
    public Object getPageInfo(Student student, @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
        logger.info("student:{}",student);
        return studentService.getPageInfo(student,pageNo,pageSize);
    }

    /**
     * 保存学生信息
     * 新增或修改
     * @param student
     * @return
     */
//    @RequestMapping("save")
    @PostMapping("save")
    public Object saveUser(@RequestBody Student student){
        return studentService.save(student);
    }

    /**
     * 删除接口
     * @param ids
     * @return
     */
    @GetMapping("delByIds")
    public Object delByIds(String ids){
        return studentService.delByIds(ids);
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @GetMapping("getById")
    public Object getById(Integer id){
        Map<String,Object> result = new HashMap<>();
        //查询学生信息
        Student student = studentService.getById(id);
        //爱好
        student.setHobbyIds(studentService.getHobbyIdsByStuId(student.getId()));
        result.put("student",student);
        //根据省Id，查询城市列表
        List<Area> cityList = studentService.getAreaListByPid(student.getProvice_id());
        result.put("cityList",cityList);
        //根据城市Id，查询地区列表
        List<Area> areaList = studentService.getAreaListByPid(student.getCity_id());
        result.put("areaList",areaList);


        return result;
    }

    @GetMapping("getDetailById")
    public Object getDetailById(Integer id){
        //查询学生信息
        Student student = studentService.getById(id);
        student.setProvice_name(studentService.getAreaById(student.getProvice_id()).getName());
        student.setCity_name(studentService.getAreaById(student.getCity_id()).getName());
        student.setArea_name(studentService.getAreaById(student.getArea_id()).getName());
        student.setClasses_name(studentService.getClassesById(student.getClasses_id()).getName());
        return student;
    }

    /**
     * 页面初始化接口
     * @param id
     * @return
     */
    @GetMapping("initData")
    public Object initData(Integer id){
        Map<String,Object> initData = new HashMap<>();
        initData.put("classesList",studentService.getClassesAll());
        initData.put("proviceList",studentService.getTopAreaList());
        initData.put("hobbyList",studentService.getHobbyAll());
        return initData;
    }

}
