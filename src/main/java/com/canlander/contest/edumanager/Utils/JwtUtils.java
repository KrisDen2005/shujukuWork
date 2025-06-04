package com.canlander.contest.edumanager.Utils;

import com.canlander.contest.edumanager.pojo.User;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private final String tokenKey = "dengjiehuiniubi666";

    public String jwt(User user) {
        JwtBuilder builder = Jwts.builder(); //获取JWT生成器
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getUserId());
        claims.put("username", user.getUsername());
        claims.put("role", user.getRole());
        claims.put("refId", user.getRefId());
        claims.put("password", user.getPassword());
        //使用JWT生成器创建一个JWT
        String jwtToken = builder
                //Header
                .setHeaderParam("typ", "JWT")//类型
                .setHeaderParam("alg", "HS256")//使用的算法
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))//失效日期：当前时间+24小时
                .setId(user.getUsername() + System.currentTimeMillis())
                //signature
                .signWith(SignatureAlgorithm.HS256, tokenKey)//使用的算法+签名密钥
                //调用compact()方法将三部分拼接起来并用'.'分隔
                .compact();
        return jwtToken;
    }

    public Claims parse(String token) {
        //jwt方法加密出来的密钥
        JwtParser parser = Jwts.parser();//获取JWT解密工具
        Jws<Claims> claimsJws = parser.setSigningKey(tokenKey).parseClaimsJws(token); //根据签名密钥对JWT进行解密
        Claims claims = claimsJws.getBody();
        return claims;
    }

}
