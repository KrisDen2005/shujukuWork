package com.canlander.contest.edumanager.pojo;

public class TeacherPlan {
    private int planId;
    private int majorId;
    private int courseId;
    private int semester;
    private int teacherId;

    public TeacherPlan() {
    }

    public TeacherPlan(int planId, int majorId, int courseId, int semester, int teacherId) {
        this.planId = planId;
        this.majorId = majorId;
        this.courseId = courseId;
        this.semester = semester;
        this.teacherId = teacherId;
    }

    /**
     * 获取
     * @return planId
     */
    public int getPlanId() {
        return planId;
    }

    /**
     * 设置
     * @param planId
     */
    public void setPlanId(int planId) {
        this.planId = planId;
    }

    /**
     * 获取
     * @return majorId
     */
    public int getMajorId() {
        return majorId;
    }

    /**
     * 设置
     * @param majorId
     */
    public void setMajorId(int majorId) {
        this.majorId = majorId;
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
     * @return semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * 设置
     * @param semester
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * 获取
     * @return teacherId
     */
    public int getTeacherId() {
        return teacherId;
    }

    /**
     * 设置
     * @param teacherId
     */
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String toString() {
        return "TeacherPlan{planId = " + planId + ", majorId = " + majorId + ", courseId = " + courseId + ", semester = " + semester + ", teacherId = " + teacherId + "}";
    }
}
