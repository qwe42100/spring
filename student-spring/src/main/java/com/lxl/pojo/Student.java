package com.lxl.pojo;

import java.util.Date;
import java.util.List;

public class Student {

    private Integer id;
    private String name;
    private int age;
    private Date create_time;
    private String header_img;

    private String sex;
    private Date birthday;
    private Integer classes_id;
    private String introduction;

    private Integer provice_id;
    private Integer city_id;
    private Integer area_id;


    //非数据属性
    private String classes_name;
    private Integer age_start;
    private Integer age_end;
    private String provice_name;
    private String city_name;
    private String area_name;
    private List<Integer> hobbyIds;
    private String hobbyNames;
    private String hobbyName;

    /**
     * 定义ｇｅｔ方法
     * @return
     */
    public String getFileName(){
        if(this.getHeader_img()==null){
            return null;
        }
        return this.getHeader_img().substring(this.header_img.lastIndexOf("/")+1);
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getHobbyNames() {
        return hobbyNames;
    }

    public void setHobbyNames(String hobbyNames) {
        this.hobbyNames = hobbyNames;
    }

    public Integer getAge_start() {
        return age_start;
    }

    public List<Integer> getHobbyIds() {
        return hobbyIds;
    }

    public void setHobbyIds(List<Integer> hobbyIds) {
        this.hobbyIds = hobbyIds;
    }

    public String getProvice_name() {
        return provice_name;
    }

    public void setProvice_name(String provice_name) {
        this.provice_name = provice_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getClasses_name() {
        return classes_name;
    }

    public void setClasses_name(String classes_name) {
        this.classes_name = classes_name;
    }

    public void setAge_start(Integer age_start) {
        this.age_start = age_start;
    }

    public Integer getAge_end() {
        return age_end;
    }

    public void setAge_end(Integer age_end) {
        this.age_end = age_end;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getClasses_id() {
        return classes_id;
    }

    public void setClasses_id(Integer classes_id) {
        this.classes_id = classes_id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getProvice_id() {
        return provice_id;
    }

    public void setProvice_id(Integer provice_id) {
        this.provice_id = provice_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public Integer getId() {
        return id;
    }

    public String getHeader_img() {
        return header_img;
    }

    public void setHeader_img(String header_img) {
        this.header_img = header_img;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", create_time=" + create_time +
                ", header_img='" + header_img + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", classes_id=" + classes_id +
                ", introduction='" + introduction + '\'' +
                ", provice_id=" + provice_id +
                ", city_id=" + city_id +
                ", area_id=" + area_id +
                ", age_start=" + age_start +
                ", age_end=" + age_end +
                '}';
    }
}
