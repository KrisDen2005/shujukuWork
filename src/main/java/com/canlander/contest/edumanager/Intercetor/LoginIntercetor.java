package com.canlander.contest.edumanager.Intercetor;

import com.canlander.contest.edumanager.Utils.JwtUtils;
import com.canlander.contest.edumanager.Utils.ThreadlocalUtils;
import com.canlander.contest.edumanager.common.Role;
import com.canlander.contest.edumanager.pojo.User;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
public class LoginIntercetor implements HandlerInterceptor {
    private JwtUtils jwtUtils = new JwtUtils();
    private ThreadlocalUtils threadlocalUtils = new ThreadlocalUtils();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null || token.equals("")) {
            return false;
        }
        Claims parse = jwtUtils.parse(token);
        //解析的是错误的 ， 或者解析的是空白的
        if (parse.isEmpty()) {
            return false;
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
            Map<Role, Integer> userMap = new HashMap<Role, Integer>();
            userMap.put(user.getRole(), user.getRefId());
            threadlocalUtils.setThreadLocal(userMap);
        }
        System.out.println(user);
        return true;
    }
    // threadlocalUtils.setThreadLocal();


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
