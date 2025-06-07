package com.canlander.contest.edumanager.mapper;

import com.canlander.contest.edumanager.pojo.Teacher;
import com.canlander.contest.edumanager.pojo.TeacherPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {
    //查询课表
    @Select("select  * from  TeachingPlan_rg3_8 where teacher_id =  #{teahcerId}")
    public List<TeacherPlan> selectTeacherPlan(int  teacherId);

}
