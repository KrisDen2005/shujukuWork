package com.canlander.contest.edumanager.service;

import com.canlander.contest.edumanager.mapper.TeacherMapper;
import com.canlander.contest.edumanager.pojo.Teacher;
import com.canlander.contest.edumanager.pojo.TeacherPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    /*查询教师授课的计划*/
    public List<TeacherPlan> searchTeacherPlan(Teacher teacher) {
        List<TeacherPlan> teacherPlans = teacherMapper.selectTeacherPlan(teacher);
        return teacherPlans;
    }
}
