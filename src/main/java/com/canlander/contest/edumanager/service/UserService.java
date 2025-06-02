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
        String string = userMapper.selectUser(user);
        if (string == null || string.equals("")) {
            return false;
        }
        return true;
    }


}
