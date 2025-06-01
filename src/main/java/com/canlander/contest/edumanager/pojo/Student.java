package com.canlander.contest.edumanager.pojo;

import com.canlander.contest.edumanager.common.Gender;
import com.canlander.contest.edumanager.common.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int studentId;
    private String name;
    private Gender gender;
    private int enrollmentYear;
    private Status status;
    private int classId;
}
