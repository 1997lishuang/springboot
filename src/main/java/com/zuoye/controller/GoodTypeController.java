package com.zuoye.controller;

import com.zuoye.pojo.Goodtype;
import com.zuoye.service.GoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GoodTypeController {
    @Autowired
     private  GoodTypeService goodTypeService;

    @RequestMapping("findgoodtype")
    public String find(Model model){
        List<Goodtype> goodtypeList = goodTypeService.find();
        model.addAttribute("goodtypeList",goodtypeList);
        return "admin.html";
    }
}
