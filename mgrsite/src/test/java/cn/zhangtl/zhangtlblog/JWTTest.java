package cn.zhangtl.zhangtlblog;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/*参照
* https://www.jianshu.com/p/29d7eea97339
* http://www.ruanyifeng.com/blog/2019/04/oauth-grant-types.html
* */
@SpringBootTest
public class JWTTest {
    private static final String JWT_SECRET = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";

    @Test
    public void createToken(){
        Date now = new Date();
        Date expriation = new Date(now.getTime() + 60000);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","小明");
        map.put("age",12);
        JwtBuilder builder = Jwts.builder().addClaims(map)
                .setId(Long.valueOf(System.currentTimeMillis()).toString())
                .signWith(SignatureAlgorithm.HS256,generalKey())
                .setIssuedAt(now)
                .setExpiration(expriation);
        /*token*/
        String compact = builder.compact();
        System.out.println(compact);
        Claims claims = verifyJwt(compact);
        System.out.println(claims);
    }
    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public  SecretKey generalKey() {
        String stringKey = JWT_SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 验证jwt
     */
    public  Claims verifyJwt(String token) {
        //签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey();
        Claims claims;
        try {
            claims = Jwts.parser()  //得到DefaultJwtParser
                    .setSigningKey(key)         //设置签名的秘钥
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }//设置需要解析的jwt
        return claims;

    }


}
