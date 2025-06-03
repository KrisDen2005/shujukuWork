package com.canlander.contest.edumanager.Intercetor;

import com.canlander.contest.edumanager.Utils.JwtUtils;
import com.canlander.contest.edumanager.Utils.ThreadlocalUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
        if (parse == null) {
            return false;
        }

        threadlocalUtils.setThreadLocal();
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
