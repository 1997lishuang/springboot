package com.zuoye.service;

import com.zuoye.mapper.GoodMapper;
import com.zuoye.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
@Service
public class GoodService  {
    @Autowired
     GoodMapper goodMapper;
//    public List<good> findAll(Integer pageNum,Integer pageSize){
//
//        List<good> goodList = goodMapper.findAll(pageNum,pageSize);
//
//        return goodList;
//    }
    public List<Good> findAll(int pageNum, int pageSize ) {


        List<Good> goodList = goodMapper.findAll( pageNum,pageSize );
        System.out.println(11111);
        return goodList;
    }

    public List<Good> findByWord(String word){
        List<Good> goodList = goodMapper.findByWord(word);

        return goodList;
    }

    public List<Good> findAllGood(){

        List<Good> goodList = goodMapper.findAllGood();

        return goodList;

    }
    public int delete(int id){

        int count = goodMapper.delete(id);

        return count;
    }
    public int insertgood(Good good){

        int count = goodMapper.insertgood(good);

        return count;
    }
    public int updategood(Good good){
        int count = goodMapper.updategood(good);
        return count;
    }
    public  Good findgoodone(int id){

        Good good = goodMapper.findgoodone(id);

        return good;
    }

}
