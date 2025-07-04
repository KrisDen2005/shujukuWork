package com.canlander.contest.edumanager.vo;

public class UserVo {
    private  String  username  ;
    private  String   password ;

    public UserVo() {
    }

    public UserVo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "UserVo{username = " + username + ", password = " + password + "}";
    }
}
