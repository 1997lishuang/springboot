package com.zuoye.service;

import com.zuoye.mapper.AdminMapper;
import com.zuoye.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public Admin findAmdminByname(String name){
        Admin admin = adminMapper.findAmdminByname(name);
        return admin;
    }
}
