package com.lxl.service;

import com.lxl.dao.TypeMapper;
import com.lxl.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Type> selectList() {
        return typeMapper.selectList();
    }
}
