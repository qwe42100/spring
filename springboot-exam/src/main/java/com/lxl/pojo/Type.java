package com.lxl.pojo;

public class Type {
    //分类id
    private Integer id;
    //分类名称
    private String tname;

    public Type() {
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Type(Integer id, String tname) {
        this.id = id;
        this.tname = tname;
    }
}
