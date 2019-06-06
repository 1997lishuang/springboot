package com.zuoye.mapper;

import com.zuoye.pojo.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface GoodMapper {
    public List<Good> findAll(int pageNum, int pageSize );

    public List<Good> findByWord(String word);

    public List<Good> findAllGood();

    public int delete(int id);

    public int insertgood(Good good);

    public int updategood(Good good);

    public  Good findgoodone(int id);
}
