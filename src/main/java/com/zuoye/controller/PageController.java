package com.zuoye.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zuoye.pojo.Good;
import com.zuoye.pojo.Goodtype;
import com.zuoye.service.GoodService;

import com.zuoye.service.GoodTypeService;
import com.zuoye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private GoodService goodService;
    @Autowired
    UserService userService;
    @Autowired
    GoodTypeService goodTypeService;

    @RequestMapping("good")
    public String getAllPerson(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @RequestParam(defaultValue = "6",value = "pageSize") Integer pageSize){
        Page<Good> page = PageHelper.startPage(pageNum, pageSize);
        List<Good> list = goodService.findAll(pageNum,pageSize);
        System.out.println(1111);
        System.out.println(list);
        PageInfo<Good> pageInfo = new PageInfo<Good>(list);
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getPages());
//        model.addAttribute("list",list);
        model.addAttribute("pageInfo",pageInfo);
        List<Goodtype> goodtypeList = goodTypeService.find();
        model.addAttribute("goodtypeList",goodtypeList);

        return "main.html";
    }
}
