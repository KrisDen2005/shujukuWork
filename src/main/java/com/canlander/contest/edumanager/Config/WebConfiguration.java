package com.canlander.contest.edumanager.Config;

import com.canlander.contest.edumanager.Intercetor.LoginIntercetor;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercetor())
                .addPathPatterns("/**")  // 拦截所有请求
                .excludePathPatterns("/login", "/register" , "/toLogin"); // 排除某些请求（比如登录、注册）
    }
    //枚举类的mybatis的映射  ：
    @Bean
    public TypeHandlerRegistry typeHandlerRegistry() {
        return new TypeHandlerRegistry();
    }
}
