package com.zuoye.service;

import com.zuoye.mapper.GoodTypeMapper;
import com.zuoye.pojo.Goodtype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodTypeService {
    @Autowired
    GoodTypeMapper goodTypeMapper;
    public List<Goodtype> find(){

        List<Goodtype> goodtypeList = goodTypeMapper.find();

        return goodtypeList;
    }
}
