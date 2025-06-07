package com.canlander.contest.edumanager.Controller;
import com.canlander.contest.edumanager.Utils.JwtUtils;
import com.canlander.contest.edumanager.pojo.User;
import com.canlander.contest.edumanager.service.UserService;
import com.canlander.contest.edumanager.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
@Controller
public class UserController {
    private JwtUtils jwtUtils = new JwtUtils();
    @Autowired
    private UserService userService;
    // 打开登录页面
    @GetMapping("/toLogin")
    public String toLogin(Model model) {
        model.addAttribute("error", false); // 默认无错误
        return "login"; // 返回 login.html 页面
    }
    // 登录提交表单处理
    @PostMapping("/login")
    public String login(UserVo userVo, Model model) {
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        boolean login = userService.login(user);
        if (!login) {
            model.addAttribute("error", true); // 登录失败标记
            return "login"; // 回到登录页
        }
        String jwt = jwtUtils.jwt(user);
        // 登录成功，你可以选择跳转主页或者 session 中保存用户信息
        model.addAttribute("username", user.getUsername());
        model.addAttribute("token", jwt);
        return "index"; // 跳转首页 index.html（你可以根据项目实际修改）
    }
}
