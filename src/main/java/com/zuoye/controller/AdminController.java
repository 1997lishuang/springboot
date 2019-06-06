package com.zuoye.controller;

import com.zuoye.pojo.Admin;
import com.zuoye.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;
    @RequestMapping("adminlogin")
    public String findAmdminByname(String name,String password) {
        System.out.println(password);
        System.out.println(name);
        Admin admin = adminService.findAmdminByname(name);
        System.out.println(admin);
        if (admin==null){
            return "adminlogin.html";
        }else {
            if (name.equals(admin.getName())&&password.equals(admin.getPassword())) {
                System.out.println(admin.getName());
                System.out.println(admin.getPassword());
                return "admin.html";
            } else {
                return "adminlogin.html";
            }
        }
    }

}
