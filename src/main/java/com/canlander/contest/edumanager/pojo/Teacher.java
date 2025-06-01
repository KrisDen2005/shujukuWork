package com.canlander.contest.edumanager.pojo;

import com.canlander.contest.edumanager.common.Gender;
import com.canlander.contest.edumanager.common.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int teacherId;
    private String name;
    private Gender gender;
    private Title title;
    private int departmentId;

}
