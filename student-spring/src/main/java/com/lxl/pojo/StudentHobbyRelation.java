package com.lxl.pojo;

public class StudentHobbyRelation {
    private Integer id;
    private Integer student_id;
    private Integer hobby_id;

    public StudentHobbyRelation() {
    }

    public StudentHobbyRelation(Integer student_id, Integer hobby_id) {
        this.student_id = student_id;
        this.hobby_id = hobby_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getHobby_id() {
        return hobby_id;
    }

    public void setHobby_id(Integer hobby_id) {
        this.hobby_id = hobby_id;
    }
}
