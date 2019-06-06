package com.zuoye.service;

import com.zuoye.mapper.UserMapper;
import com.zuoye.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findByUser(String username){
          User  user =userMapper.findByUsername(username);

        return user;
    }
    public int sava(String username, String password){
           int row=userMapper.save(username,password);
           System.out.println(row);
          return row;
    }
    public int updateUserByname(User user){
        int row=userMapper.updateUserByname(user);
        System.out.println(row);
        return row;
    }
}
