package com.zuoye.mapper;

import com.zuoye.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public int save(String username,String password);
    public User findByUsername(String username);
    public int updateUserByname(User user);
}
