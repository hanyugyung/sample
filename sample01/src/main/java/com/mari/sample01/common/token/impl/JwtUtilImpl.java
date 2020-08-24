package com.mari.sample01.common.token.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mari.sample01.common.token.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtUtilImpl implements JwtUtil {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${CONFIG.JWT.ISS}")
	private String iss;
	
	@Value("${CONFIG.JWT.SECRET}")
	private String secretKey;
	
	@Value("${CONFIG.JWT.EXPIRED.TIME}")
	private Long expiredTime;
	
	private Boolean isTokenExpired(Date exp) {
		return new Date().after(exp);
	}
	
	private byte[] generateKey() {
		byte[] key = null;
		try {
			key = secretKey.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.warn("Encoding Error");
		}
		return key;
	}
	
	@Override
	public <T> String createToken(T data) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("info", data);
		
		//exp - 토큰이 만료되는 시각, iat - 토큰이 발급된 시각
		Date exp = new Date(expiredTime);
		
		String token = Jwts.builder()
				.setIssuer(iss)
				.setExpiration(exp)
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, this.generateKey())
				.compact();
		return token;
	}
	
	@Override
	public Boolean validateToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parser()
					  .setSigningKey(secretKey)
					  .parseClaimsJws(token);
			
			Date exp = claims.getBody().getExpiration();
			if(isTokenExpired(exp)) {
				logger.info("Expired Token");
				return false;
			}
			return true;
		}catch(SignatureException se) {
			logger.error("InValid Signature", se);
		}catch(Exception e) {
			logger.info("token validation fail", e);
		}
		
		return false;
	}

}
