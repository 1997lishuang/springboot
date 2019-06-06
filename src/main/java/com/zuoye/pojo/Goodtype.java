package com.zuoye.pojo;

public class Goodtype {

    public  int id;

    @Override
    public String toString() {
        return "Goodtype{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }

    public String typename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
