package com.zuoye.mapper;

import com.zuoye.pojo.Carousel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CarouselMapper {

    public List<Carousel> findCarousel();
}
