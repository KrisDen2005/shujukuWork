package com.canlander.contest.edumanager.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.canlander.contest.edumanager.pojo.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private   final   String  tokenKey  =  "dengjiehuiniubi666" ;

    /**
     * 根据用户id,账号生成token
     *
     * @param u
     * @return
     */
    public static String getToken(User u) {
        String token = "";
        try {
            //过期时间 为1970.1.1 0:0:0 至 过期时间  当前的毫秒值 + 有效时间
            Date expireDate = new Date(new Date().getTime() + 6000 * 1000);
            //秘钥及加密算法                            秘钥自定义
            Algorithm algorithm = Algorithm.HMAC256("MtYang");
            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带id，账号信息，生成签名
            Map  <String  , Object  >  claim  =  new HashMap<>() ;
            token = JWT.create()
                    .withHeader(header)   //第一部分

                    .withExpiresAt(expireDate)
                    .sign(algorithm);     //第三部分
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }
    /**
     * 验证token是否有效
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            //验签
            Algorithm algorithm = Algorithm.HMAC256("MtYang");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {//当传过来的token如果有问题,抛出异常
            return false;
        }
    }

    /**
     * 获得token 中playload部分数据,按需使用
     *
     * @param token
     * @return
     */
    public static DecodedJWT getTokenInfo(String token) {

        return JWT.require(Algorithm.HMAC256("MtYang")).build().verify(token);
    }

}
