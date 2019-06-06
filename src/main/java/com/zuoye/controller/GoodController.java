package com.zuoye.controller;


import com.zuoye.pojo.Good;
import com.zuoye.pojo.Goodtype;
import com.zuoye.service.GoodService;
import com.zuoye.service.GoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@MultipartConfig
public class GoodController {
    @Autowired
    GoodService goodService;
    //模糊查询接口
    @RequestMapping("ajaxfind")
    @ResponseBody
    public void findByWord(String word,Model model){
        List<Good> goodList = goodService.findByWord(word);
        model.addAttribute("goodList",goodList);
        System.out.println(goodList);
    }
    @GetMapping("show")
    public String findAll(Model model){

        List<Good> goodList = goodService.findAllGood();
        System.out.println(goodList);
        model.addAttribute("goodList",goodList);

        return "admin.html";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable(name="id") int id,Model model){
        int count = goodService.delete(id);
        if(count>0){
            List<Good> goodList = goodService.findAllGood();
            model.addAttribute("goodList",goodList);
            model.addAttribute("删除成功","msg");

            return "admin.html";
        }
            model.addAttribute("删除失败","msg");

        return "faise.html";
    }

   @RequestMapping("insertgood")
    public String insertgood(Model model, MultipartFile imgpath, HttpServletRequest request, @Valid Good good, BindingResult bindingResult){

        //1获取图片的路径； 获取真实的路径，获取图片的原始名字   2给图片加新的名字   3保存图片；

       System.out.println(3232);
       if(!imgpath.isEmpty()&&imgpath.getSize()>0){
           //获取文件的原始名字
           String filename=imgpath.getOriginalFilename();
           System.out.println(filename);
           ///获取真实的路径
           String path=request.getServletContext().getRealPath("img/");
           System.out.println(path);

           File file =new File(path);
           if(!file.exists()){
               file.mkdir();
           }
           String nowname=System.currentTimeMillis()+filename;
           good.setImgpath(nowname);

           try {
               imgpath.transferTo(new File(path+nowname));

           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       int count = goodService.insertgood(good);
       List<Good> goodList = goodService.findAllGood();
       System.out.println(goodList);
       model.addAttribute("goodList",goodList);
       List msg=new ArrayList();
       msg.add("添加成功");
       msg.add("添加失败");

     if(count>0){
         model.addAttribute("添加成功",msg);
         return "admin.html";
     }
         model.addAttribute("添加失败",msg);
         return "faise.html";
   }





   @GetMapping("updategoodget/{id}")
   public String findgoodone(@PathVariable(name="id")int id,Model model){
       System.out.println(id);
       Good findgoodone = goodService.findgoodone(id);
       System.out.println(findgoodone.getImgpath());

       if(findgoodone!=null){


           model.addAttribute("findgoodone",findgoodone);
           return "adminUpdate.html";
       }
       return "faise.html";

   }






    @RequestMapping("updategood")
    public String updategood(Good good,Model model){

        System.out.println(good);
//        int id=good.getId();
        Good good1=goodService.findgoodone(good.getId());
        good.setImgpath(good1.getImgpath());
        System.out.println(good);
        int count = goodService.updategood(good);
        Good findgoodone = goodService.findgoodone(good.getId());
        System.out.println(findgoodone.getImgpath());
        model.addAttribute("findgoodone",findgoodone);


       if(count>0){
           model.addAttribute("更新成功","msg");

           return "admin.html";
       }

         model.addAttribute("更新失败","msg");

          return "adminUpdate.html";

    }


}
