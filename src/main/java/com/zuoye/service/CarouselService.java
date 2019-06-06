package com.zuoye.service;


import com.zuoye.mapper.CarouselMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarouselService {
    @Autowired
    CarouselMapper carouselMapper;
    public List<com.zuoye.pojo.Carousel> findCarousel(){

        List<com.zuoye.pojo.Carousel> carouselList = carouselMapper.findCarousel();

        return carouselList;
    }
}
