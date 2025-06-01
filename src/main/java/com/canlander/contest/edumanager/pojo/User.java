package com.canlander.contest.edumanager.pojo;

import com.canlander.contest.edumanager.common.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime ;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  implements Serializable {
    private  int userId  ;
    private  String  username  ;
    private  String  password  ;
    private Role role  ;
    private   int   refId ;
    private LocalDateTime   createTime ;
}
