package com.lxl.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxl.dao.*;
import com.lxl.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ClassesDao classesDao;
    @Autowired
    private AreaDao areaDao;
    @Autowired
    private HobbyDao hobbyDao;
    @Autowired
    private StudentHobbyRelationDao studentHobbyRelationDao;

    @Override
    public PageInfo<Student> getPageInfo(Student student, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
       /* //根据name查询爱好Id
        String hobbyName = student.getHobbyName();
        //根据爱好Ids，查询studentIds
        //把studentIds，传到dao层，id in（查询studentIds）*/
        List<Student> studentList = studentDao.selectList(student);
        List<Classes> classesAll = classesDao.selectAll();
//        List<Area> areaAll = areaDao.selectAll();
        //获取省、市、区的地区Id
        List<Integer> areaIds = new ArrayList<>();
        List<Integer> proviceIds = studentList.stream().map(stu -> stu.getProvice_id()).collect(Collectors.toList());
        areaIds.addAll(proviceIds);
        List<Integer> cityIds = studentList.stream().map(stu -> stu.getCity_id()).collect(Collectors.toList());
        areaIds.addAll(cityIds);
        List<Integer> aIds = studentList.stream().map(stu -> stu.getArea_id()).collect(Collectors.toList());
        areaIds.addAll(aIds);
        //查询地区数据
        List<Area> areaAll = areaDao.getAreaListByIds(areaIds);
        //爱好
        List<Hobby> hobbyAll = hobbyDao.selectAll();
        studentList.forEach(stu->{
                //设置班级名称
          /*  Classes classes = classesDao.selectById(stu.getClasses_id());
            stu.setClasses_name(classes.getName());*/
            classesAll.forEach(classes -> {
                if(stu.getClasses_id().intValue()==classes.getId().intValue()){
                    stu.setClasses_name(classes.getName());
                }
            });
            //爱好
            String hobbyNames = getHobbyNames(stu, hobbyAll);
            stu.setHobbyNames(hobbyNames);
            /*Set<Integer> hobbyIdsByStuId = studentHobbyRelationDao.getHobbyIdsSetByStuId(stu.getId());
            final StringBuffer hobbyNames = new StringBuffer();
            hobbyAll.forEach(hobby -> {
                if(hobbyIdsByStuId.contains(hobby.getId())){
                    String name = hobby.getName();
                    if("".equals(hobbyNames.toString())){
                        hobbyNames.append(name);
                    }else{
                        hobbyNames.append("/"+name);
                    }
                }
            });
            stu.setHobbyNames(hobbyNames.toString());*/
            //设置地区名称
            areaAll.forEach(area->{
                if(stu.getProvice_id().intValue()==area.getId().intValue()){
                    stu.setProvice_name(area.getName());
                }else if(stu.getCity_id().intValue()==area.getId().intValue()){
                    stu.setCity_name(area.getName());
                }else if(stu.getArea_id().intValue()==area.getId().intValue()){
                    stu.setArea_name(area.getName());
                }
            });

        });
        return new PageInfo<>(studentList);
    }

    private String  getHobbyNames(Student stu,List<Hobby> hobbyAll){
        Set<Integer> hobbyIdsByStuId = studentHobbyRelationDao.getHobbyIdsSetByStuId(stu.getId());
        final StringBuffer hobbyNames = new StringBuffer();
        hobbyAll.forEach(hobby -> {
            if(hobbyIdsByStuId.contains(hobby.getId())){
                String name = hobby.getName();
                if("".equals(hobbyNames.toString())){
                    hobbyNames.append(name);
                }else{
                    hobbyNames.append("/"+name);
                }
            }
        });
        return hobbyNames.toString();
    }

    @Override
    @Transactional
    public boolean save(Student student) {
        /** 新增**/
        if(student.getId()==null){
            student.setCreate_time(new Date());
            studentDao.insert(student);
        }else{
            //修改
            studentDao.update(student);
        }
        //根据学生Id，删除兴趣爱好
        studentHobbyRelationDao.deleteByStuId(student.getId());
        //保存兴趣爱好
        List<Integer> hobbyIds = student.getHobbyIds();
        if(hobbyIds!=null){
            hobbyIds.forEach(hobbyId->{
                StudentHobbyRelation studentHobbyRelation = new StudentHobbyRelation(student.getId(),hobbyId);
                studentHobbyRelationDao.insert(studentHobbyRelation);
            });
        }
        //sutdent表保存兴趣爱好
        List<Hobby> hobbyAll = hobbyDao.selectAll();
        String hobbyNames = getHobbyNames(student, hobbyAll);
        student.setHobbyNames(hobbyNames);
        studentDao.update(student);
        return true;
    }

    @Override
    public boolean delByIds(String ids) {
        return studentDao.deleteByIds(ids)>0;
    }

    @Override
    public Student getById(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public List<Classes> getClassesAll() {
        return classesDao.selectAll();
    }

    @Override
    public List<Area> getAreaListByPid(Integer pid) {
        return areaDao.selectListByPid(pid);
    }

    @Override
    public List<Area> getTopAreaList() {
        return getAreaListByPid(1);
    }

    @Override
    public Area getAreaById(Integer id) {
        return areaDao.selectById(id);
    }

    @Override
    public Classes getClassesById(Integer classes_id) {
        return classesDao.selectById(classes_id);
    }

    @Override
    public List<Hobby> getHobbyAll() {
        return hobbyDao.selectAll();
    }

    @Override
    public List<Integer> getHobbyIdsByStuId(Integer stuId) {
        return studentHobbyRelationDao.getHobbyIdsByStuId(stuId);
    }
}
