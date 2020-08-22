package com.mari.sample01.common.token;

import com.mari.sample01.data.req.UserReqDto;

public interface JwtUtil {
	<T> String createToken(T data);
	Boolean validateToken(String token);
}
