package com.canlander.contest.edumanager.Controller;

import com.canlander.contest.edumanager.common.Result;
import com.canlander.contest.edumanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /*教师授课课程记录*/
    @PostMapping("course")
    public Result searchCourse() {
       // teacherService.searchTeacherPlan();
        return null;
    }
}
