package com.canlander.contest.edumanager.Controller;

import com.canlander.contest.edumanager.Utils.ThreadlocalUtils;
import com.canlander.contest.edumanager.common.Result;
import com.canlander.contest.edumanager.common.Role;
import com.canlander.contest.edumanager.pojo.TeacherPlan;
import com.canlander.contest.edumanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class TeacherController {
    private ThreadlocalUtils threadlocalUtils = new ThreadlocalUtils();
    @Autowired
    private TeacherService teacherService;

    @GetMapping("course")
    public String toSearchCourse() {
        return "teacherCourseIndex";
    }

    /*教师授课课程记录*/
    @PostMapping("course")
    public Result searchCourse() throws Exception {
        Map<Role, Integer> usermap = threadlocalUtils.getThreadLocal();
        Set<Role> roles = usermap.keySet();
        Role userRole = null;
        for (Role role : roles) {
            userRole = role;
        }
        if (userRole != Role.教师) {
            throw new Exception("这一个是教师的查询，  你不是教师");
        }
        Integer refId = usermap.get(userRole);
        List<TeacherPlan> teacherPlans = teacherService.searchTeacherPlan(refId);
        return new Result(200, "sucess", teacherPlans);
    }
}
