package com.canlander.contest.edumanager.mapper;

import com.canlander.contest.edumanager.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select  *  from  User_rg3_8 where username =  #{username} and  password = #{password}")
    public User selectUser(User user);


}
