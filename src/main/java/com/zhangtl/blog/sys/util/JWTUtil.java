package com.zhangtl.blog.sys.util;

import com.zhangtl.blog.sys.entity.BlogUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
* JWT工具类
* */
public class JWTUtil {
    /*
    * 生成token
    * */
    public static String getToken(BlogUser blogUser){
        SignatureAlgorithm signatureAlgorithm =SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = Base64.getDecoder().decode(getBase64Security());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder().setSubject(blogUser.getUsername()).signWith(signatureAlgorithm, signingKey);
        Map<String, String> beanMap = new HashMap<>();
        beanMap.put("username",blogUser.getUsername());
        beanMap.forEach(builder::claim);
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expireMillis = System.currentTimeMillis() + 60 * 60 * 1000;
        builder.setExpiration(new Date(expireMillis)).setNotBefore(now);
       return builder.compact();

    }

    private static String getBase64Security() {
        return Base64.getEncoder().encodeToString("blog".getBytes(StandardCharsets.UTF_8));
    }

    public static Claims paseJWTToken(String token){
        return Jwts.parser()
                .setSigningKey(Base64.getDecoder().decode(getBase64Security()))
                .parseClaimsJws(token).getBody();
    }


}
