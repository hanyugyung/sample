package com.mari.sample01.common.token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mari.sample01.data.CmError;
import com.mari.sample01.exception.UnAuthenticateException;

@Component
public class JwtInterceptor implements HandlerInterceptor{
	
	@Value("${CONFIG.JWT.HEADER}")
	private String tokenHeader;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String token = request.getHeader(tokenHeader);
		
		if(token == null || !jwtUtil.validateToken(token)) {
			//throw new UnAuthenticateException(CmError.CM_UnAuthenticated_Token);
			return false;
		}
		
		return true;
	}
}
