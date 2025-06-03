package com.canlander.contest.edumanager.Controller;

import com.canlander.contest.edumanager.Utils.JwtUtils;
import com.canlander.contest.edumanager.common.Result;
import com.canlander.contest.edumanager.pojo.User;
import com.canlander.contest.edumanager.service.UserService;
import com.canlander.contest.edumanager.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private JwtUtils jwtUtils = new JwtUtils();
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Result Login(@RequestBody UserVo userVo) {
        System.out.println("user的类是" + userVo);
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        boolean login = userService.login(user);
        System.out.println("进入到登录的页面" + login);
        if (!login) {
            System.out.println("登录失败 ");
            return new Result(500, "用户名错误", null);
        }
        String jwt = jwtUtils.jwt(user);
        System.out.println("登录成功");
        return new Result(200, "sucess", jwt);
    }


}
