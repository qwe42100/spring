package com.lxl.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.security.PrivateKey;
import java.util.Date;

public class Officetool {
    private Integer id;//主键
   private String  name;//名称
    private String description;//描述
    private Integer typeid;//办公用品分类
    private String price;//单价
    private Integer num;//数量
   private Date dt;//采购日期
    //供应商
    private String supplier;
    //采购人
    private String username;
    //开始采购日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDt;
    //结束采购日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDt;
    //分类名称
    private String tname;

    public Officetool() {
    }

    @Override
    public String toString() {
        return "Officetool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", typeid=" + typeid +
                ", price='" + price + '\'' +
                ", num=" + num +
                ", dt=" + dt +
                ", supplier='" + supplier + '\'' +
                ", username='" + username + '\'' +
                ", startDt=" + startDt +
                ", endDt=" + endDt +
                ", tname='" + tname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Officetool(Integer id, String name, String description, Integer typeid, String price, Integer num, Date dt, String supplier, String username, Date startDt, Date endDt, String tname) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.typeid = typeid;
        this.price = price;
        this.num = num;
        this.dt = dt;
        this.supplier = supplier;
        this.username = username;
        this.startDt = startDt;
        this.endDt = endDt;
        this.tname = tname;
    }
}
