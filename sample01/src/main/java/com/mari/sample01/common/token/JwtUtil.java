package com.mari.sample01.common.token;

import io.jsonwebtoken.Claims;

public interface JwtUtil {
	<T> String createToken(T data);
	Boolean validateToken(String token);
	Claims getBodyFromToken(String token);
}
