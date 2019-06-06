package com.zuoye.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zuoye.pojo.Carousel;
import com.zuoye.pojo.User;
import com.zuoye.service.CarouselService;
import com.zuoye.service.UserService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CarouselService carouselService;
    @RequestMapping("login")
    public String findByUser(Model model,String username){
        System.out.println(username);
           User user =(User)userService.findByUser(username);
            if (user!=null){
                Page<Carousel> page = PageHelper.startPage(1, 2);
                List<Carousel> carouselList = carouselService.findCarousel();
                System.out.println(carouselList);
                System.out.println(22222);
                PageInfo<Carousel> pageInfo = new PageInfo<Carousel>(carouselList);
                System.out.println(pageInfo);
                model.addAttribute("user",user);
                model.addAttribute("carouselList",carouselList);
                System.out.println(carouselList);

                model.addAttribute("msg","欢迎来到我的商品主页面");
                return "forward:good";
        }
        model.addAttribute("msg","登录失败,请注册");
                return "register.html";
//        System.out.println(user.getUsername());
//        if (user == null) {
//            model.addAttribute("msg","登录失败,请注册");
//            return "register.html";
//        } else {
//            if (username.equals(user.getUsername())&& password.equals(user.getPassword())) {
//                Page<Carousel> page = PageHelper.startPage(1, 2);
//                List<Carousel> carouselList = carouselService.findCarousel();
//                System.out.println(carouselList);
//                System.out.println(22222);
//                PageInfo<Carousel> pageInfo = new PageInfo<Carousel>(carouselList);
//                System.out.println(pageInfo);
//                model.addAttribute("user", user);
//                model.addAttribute("carouselList", carouselList);
//                System.out.println(carouselList);
//
//                model.addAttribute("msg", "欢迎来到我的商品主页面");
//                return "forward:good";
//            } else {
//                model.addAttribute("msg","登录失败,请注册");
//                return "register.html";
//            }
//        }

    }
   @RequestMapping("register")
    public  String sava(Model model,String username,String password){
         if (!username.equals("")&username!=null&!password.equals("")&password!=null){
             try {
                 int row=userService.sava(username,password);
                 System.out.println(row);
                 if (row>0){
                     model.addAttribute("msg","成功注册请登录");
                     return "login.html";
                 }
             }catch (Exception e){
                 throw  new RuntimeException(e.getMessage());
             }
         }
        model.addAttribute("msg","注册失败");
        return "register.html";
    }
   @RequestMapping("update")
    public  String updateUserByname(int id,String username,Model model){
       try{
           System.out.println(id);
           User user=userService.findByUser(username);
           int row= userService.updateUserByname(user);
           model.addAttribute("user",user);
           if(row>0){
               model.addAttribute("success","更新成功");
               return "update.html";
           }else {
               model.addAttribute("false","更新失败");
               return "update.html";
           }
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }
    }
    @RequestMapping("common")
    public String common(){
        return "common/carousel.html";
    }
}
