package com.ronalxie.server.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {
    public static final String CLAIM_KEY_USERNAME="sub";
    public static final String CLAIM_KEY_CREATED="created";

    @Value("${jwt.secret}")
    private static String secret;

    @Value("${jwt.expiration}")
    private static Long expiration;

    /**
     * 根据用户信息生成token
     */
    public static String getToken(UserDetails userDetails){
        Map<String,Object> claims=new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }
    private static String generateToken(Map<String,Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+expiration*1000))
                .signWith(SignatureAlgorithm.ES512,secret)
                .compact();
    }

    /**
     * 根据token获取登录信息
     */
    public static String getUserNameByToken(String token){
        String username;
        Claims claims=Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        username=claims.getSubject();
        return username;
    }

    /**
     * 刷新token
     */
    public String refreshToken(String token){
        Claims claims=Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /**
     * 验证token是否有效
     *
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameByToken(token);
        return username != null && username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否可以被刷新
     *
     * @param token
     * @return
     */
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 判断token是否失效
     *
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token) {

        Date expireDate = getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /**
     * 从token获取当前失效时间
     *
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 从token中获取荷载
     * 异常处理?
     *
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        }
        return claims;
    }

}
