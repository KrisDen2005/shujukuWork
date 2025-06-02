package com.canlander.contest.edumanager.pojo;

import com.canlander.contest.edumanager.common.Role;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime ;
public class User  implements Serializable {
    private  int userId  ;
    private  String  username  ;
    private  String  password  ;
    private Role role  ;
    private   int   refId ;
    private LocalDateTime   createTime ;

    public User() {
    }

    public User(int userId, String username, String password, Role role, int refId, LocalDateTime createTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.refId = refId;
        this.createTime = createTime;
    }


    /**
     * 获取
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
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

    /**
     * 获取
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * 设置
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * 获取
     * @return refId
     */
    public int getRefId() {
        return refId;
    }

    /**
     * 设置
     * @param refId
     */
    public void setRefId(int refId) {
        this.refId = refId;
    }

    /**
     * 获取
     * @return createTime
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String toString() {
        return "User{userId = " + userId + ", username = " + username + ", password = " + password + ", role = " + role + ", refId = " + refId + ", createTime = " + createTime + "}";
    }
}
