package com.canlander.contest.edumanager;

import com.canlander.contest.edumanager.Utils.JwtUtils;
import com.canlander.contest.edumanager.common.Role;
import com.canlander.contest.edumanager.pojo.User;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;

@SpringBootTest
class EduManagerApplicationTests {
    private String token;

    @Test
    void contextLoads() {
        JwtUtils jwtUtils = new JwtUtils();
        User user = new User(1, "dengjiehui", "123456", Role.学生, 1, LocalDateTime.now());
        String jwt = jwtUtils.jwt(user);
        token = jwt;
    }

    @Test
    void praseJwtToken() {
        JwtUtils jwtUtils = new JwtUtils();
        contextLoads();
        Claims parse = jwtUtils.parse(token);
        if (parse.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, Object>> iterator = parse.entrySet().iterator();
        User user = new User();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            String key = entry.getKey();
            Object value = entry.getValue();
            try {
                Field field = User.class.getDeclaredField(key); // 根据 key 找到对应字段
                field.setAccessible(true); // 设置可访问私有属性
                Class<?> fieldType = field.getType();
                Object convertedValue = value;
                // 如果是枚举类型，做特殊转换
                if (fieldType.isEnum() && value instanceof String) {
                    convertedValue = Enum.valueOf((Class<Enum>) fieldType, (String) value);
                }
                field.set(user, convertedValue); // 设置属性值
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // 如果 User 类没有这个字段，就跳过
                System.out.println("字段 [" + key + "] 不存在于 User 类中，跳过~");
            }
        }
        System.out.println(user);
    }

}
