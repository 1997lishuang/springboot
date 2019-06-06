package com.zuoye.pojo;

public class Carousel {
    public int id;
    public  String cardescr;
    public String imgpath;

    @Override
    public String toString() {
        return "Carousel{" +
                "id=" + id +
                ", cardescr='" + cardescr + '\'' +
                ", imgpath='" + imgpath + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardescr() {
        return cardescr;
    }

    public void setCardescr(String cardescr) {
        this.cardescr = cardescr;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
