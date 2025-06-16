package com.canlander.contest.edumanager.mapper;

import com.canlander.contest.edumanager.dto.StudentCourseGradeDto;
import com.canlander.contest.edumanager.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    //根据用户名查询用户
    @Select("select * from student_rg3_8 where name=#{studentName}")
    Student findByStudentName(String studentName);

    //学生注册
    @Insert("insert into student_rg3_8 ( name, gender, enrollment_year, status, class_id,major_id) values (#{name},#{gender},#{enrollmentYear},#{status},#{classId},#{majorId});")
    int  enrollment(Student student);

    //转专业
    @Update("update student_rg3_8 set major_id=#{major} where student_id=#{studentId};")
    int transferStudentMajor(int studentId, int major);

    //修改学生状态
    @Update("update student_rg3_8 set status=#{status} where student_id=#{studentId};")
    int updateStudentStatus(int studentId, String status);

    // 学生课程和成绩查询
    @Select("SELECT c.course_id, c.name as course_name, c.credit, c.course_type, c.hours, g.score " +
            "FROM course_rg3_8 c " +
            "JOIN enrollment_rg3_8 e ON c.course_id = e.course_id " +
            "LEFT JOIN grade_rg3_8 g ON e.student_id = g.student_id AND e.course_id = g.course_id " +
            "WHERE e.student_id = #{studentId}")
    List<StudentCourseGradeDto> selectStudentCoursesWithGrades(Integer studentId);
}
