package com.canlander.contest.edumanager.Controller;

import com.canlander.contest.edumanager.common.Result;
import com.canlander.contest.edumanager.dto.StudentCourseGradeDto;
import com.canlander.contest.edumanager.pojo.Student;
import com.canlander.contest.edumanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 入学登记
     * @param student
     * @return
     */
    @PostMapping("enrollment")
    public Result enrollment(@RequestBody Student student) {
        boolean flag = studentService.enrollment(student);
        if (flag) {
            return Result.success();
        }
        return Result.error("用户名已存在");
    }

    /**
     * 转专业
     *
     * @param studentId
     * @param major
     * @return
     */
    @PostMapping("/transfer-major")
    public Result transferStudentMajor(int studentId, int major) {
        boolean flag = studentService.transferStudentMajor(studentId, major);
        if (flag) {
            return Result.success();
        }
        return Result.error("修改失败");
    }

    @PostMapping("change-status")
    public Result updateStudentStatus(int studentId, String status) {
        boolean flag = studentService.updateStudentStatus(studentId, status);
        if (flag) {
            return Result.success();
        }
        return Result.error("修改失败");
    }

    /**
     * 获取学生的课程和成绩信息
     *
     * @param studentId
     * @return
     */
    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<StudentCourseGradeDto>> getStudentCoursesWithGrades(
            @PathVariable Integer studentId) {

        List<StudentCourseGradeDto> courses = studentService.getStudentCoursesWithGrades(studentId);
        return ResponseEntity.ok(courses);
    }



}
