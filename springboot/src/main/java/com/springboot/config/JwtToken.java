package com.springboot.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JwtToken {
	private static final int EXPIRE_TIME = 1000*60*60;
	private static final String TOKEN_VERIFY = "a1b2c3d4e5f6g7h8i9";
	//试验用的，现在这个方法毛用没有
	public static String sign(String username,String userId) {
		try {
			//过期时间
			Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
			//私钥及加密算法
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_VERIFY);
			//设置头部信息
			Map<String,Object> map = new HashMap<>();
			map.put("typ", "JWT");
			map.put("alg", "HS256");
			//生成标签
			return JWT.create()
					.withHeader(map)
					.withClaim("username", username)
					.withClaim("userId", userId)
					.withExpiresAt(date)
					.sign(algorithm);
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//私钥及加密算法
	public static String hmac256() {
		Algorithm algorithm = Algorithm.HMAC256(TOKEN_VERIFY);
		String token = algorithm.toString();
		return token;
	}
}
