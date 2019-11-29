package com.lxl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxl.dao.OfficetoolMapper;
import com.lxl.pojo.Officetool;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficetoolServiceImpl implements OfficetoolService{
    @Autowired
    private OfficetoolMapper officetoolMapper;

    public PageInfo<Officetool> selectObject(Officetool officetool, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Officetool> list = officetoolMapper.selectObject(officetool, pageNo, pageSize);

        return new PageInfo<Officetool>(list);
    }

    public int insert(Officetool officetool) {
        if (officetool.getId()==null){
            officetoolMapper.insert(officetool);
        }
        return officetoolMapper.update(officetool);
    }

    public int update(Officetool officetool) {
        return 0;
    }

    public Officetool getById(Integer id) {
        return officetoolMapper.getById(id);
    }

    public int deleteById(String ids) {
        return officetoolMapper.deleteById(ids);
    }
}
