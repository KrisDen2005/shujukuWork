package com.canlander.contest.edumanager.service;

import com.canlander.contest.edumanager.mapper.UserMapper;
import com.canlander.contest.edumanager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean login(User user) {
        System.out.println(user);
        User mapperUser = userMapper.selectUser(user);
        System.out.println("查询到的数据库的user的信息是" + mapperUser);
        if (mapperUser == null) {
            return false;
        }
        return true;
    }


}
