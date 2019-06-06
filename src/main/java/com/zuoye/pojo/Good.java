package com.zuoye.pojo;

import java.io.Serializable;

public class Good implements Serializable {

     public int id;
     public String name;
     public int  typeid;

     public Goodtype getGoodtype() {
          return goodtype;
     }

     public void setGoodtype(Goodtype goodtype) {
          this.goodtype = goodtype;
     }

     public Goodtype goodtype;

     @Override
     public String toString() {
          return "good{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", typeid=" + typeid +
                  ", Goodtype=" + goodtype +
                  ", price=" + price +
                  ", imgpath='" + imgpath + '\'' +
                  ", descr='" + descr + '\'' +
                  '}';
     }

     public double getPrice() {
          return price;
     }

     public void setPrice(double price) {
          this.price = price;
     }

     public  double price;

     public int getTypeid() {
          return typeid;
     }

     public void setTypeid(int typeid) {
          this.typeid = typeid;
     }

     public int getId() {
          return id;
     }


     public void setId(int id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getImgpath() {
          return imgpath;
     }

     public void setImgpath(String imgpath) {
          this.imgpath = imgpath;
     }

     public String getDescr() {
          return descr;
     }

     public void setDescr(String descr) {
          this.descr = descr;
     }



     public String imgpath;
     public String  descr;


}
