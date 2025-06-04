package com.canlander.contest.edumanager.pojo;

import com.canlander.contest.edumanager.common.CourseType;

public class Course {
    private int courseId;
    private String name;
    private double credit;
    private int hours;
    private CourseType courseType;
    private int prerequisiteId;

    public Course() {
    }

    public Course(int courseId, String name, double credit, int hours, CourseType courseType, int prerequisiteId) {
        this.courseId = courseId;
        this.name = name;
        this.credit = credit;
        this.hours = hours;
        this.courseType = courseType;
        this.prerequisiteId = prerequisiteId;
    }

    /**
     * 获取
     * @return courseId
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * 设置
     * @param courseId
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return credit
     */
    public double getCredit() {
        return credit;
    }

    /**
     * 设置
     * @param credit
     */
    public void setCredit(double credit) {
        this.credit = credit;
    }

    /**
     * 获取
     * @return hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * 设置
     * @param hours
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * 获取
     * @return courseType
     */
    public CourseType getCourseType() {
        return courseType;
    }

    /**
     * 设置
     * @param courseType
     */
    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    /**
     * 获取
     * @return prerequisiteId
     */
    public int getPrerequisiteId() {
        return prerequisiteId;
    }

    /**
     * 设置
     * @param prerequisiteId
     */
    public void setPrerequisiteId(int prerequisiteId) {
        this.prerequisiteId = prerequisiteId;
    }

    public String toString() {
        return "Course{courseId = " + courseId + ", name = " + name + ", credit = " + credit + ", hours = " + hours + ", courseType = " + courseType + ", prerequisiteId = " + prerequisiteId + "}";
    }
}
