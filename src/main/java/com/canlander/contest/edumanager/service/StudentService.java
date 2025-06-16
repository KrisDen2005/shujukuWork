package com.canlander.contest.edumanager.service;

import com.canlander.contest.edumanager.common.Result;
import com.canlander.contest.edumanager.dto.StudentCourseGradeDto;
import com.canlander.contest.edumanager.mapper.StudentMapper;
import com.canlander.contest.edumanager.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public boolean enrollment(Student student) {
        Student byStudentName = studentMapper.findByStudentName(student.getName());
        if(byStudentName == null) {
           int i  =   studentMapper.enrollment(student);
            if(i > 0) {
                return true;
            }
        }
        return false;
    }


    public boolean transferStudentMajor(int studentId, int major) {
        int i = studentMapper.transferStudentMajor(studentId, major);
        if(i > 0) {
            return true;
        }
        return false;
    }

    public boolean updateStudentStatus(int studentId, String status) {
        int i = studentMapper.updateStudentStatus(studentId, status);
        if(i > 0) {
            return true;
        }
        return false;
    }

    public List<StudentCourseGradeDto> getStudentCoursesWithGrades(Integer studentId) {
        return studentMapper.selectStudentCoursesWithGrades(studentId);
    }

}
