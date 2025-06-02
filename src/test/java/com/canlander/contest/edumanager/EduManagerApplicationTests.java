package com.canlander.contest.edumanager;

import com.canlander.contest.edumanager.Utils.JwtUtils;
import com.canlander.contest.edumanager.common.Role;
import com.canlander.contest.edumanager.pojo.User;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;

@SpringBootTest
class EduManagerApplicationTests {
    private String token;

    @Test
    void contextLoads() {
        JwtUtils jwtUtils = new JwtUtils();
        User user = new User(1, "dengjiehui", "123456", Role.STUDENT, 1, LocalDateTime.now());
        String jwt = jwtUtils.jwt(user);
        token = jwt;
    }

    @Test
    void praseJwtToken() {
        JwtUtils jwtUtils = new JwtUtils();
        contextLoads();
        Claims parse = jwtUtils.parse(token);
        Iterator<Map.Entry<String, Object>> iterator = parse.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.print(entry.getKey() + " :  ");
            System.out.println(entry.getValue());
        }
    }

}
