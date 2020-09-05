package com.mari.sample01.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mari.sample01.common.token.JwtUtil;
import com.mari.sample01.config.AccessUser;
import com.mari.sample01.data.CmError;
import com.mari.sample01.data.dto.UserInfo;
import com.mari.sample01.exception.SampleException;

import io.jsonwebtoken.Claims;

@Component
public class SecurityAuthenticationFilter extends OncePerRequestFilter {

	@Value("${CONFIG.JWT.HEADER}")
	private String tokenHeader;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = request.getHeader(tokenHeader);
		if(token != null) {
			
			Claims tokenBody = jwtUtil.getBodyFromToken(token);
			if(tokenBody == null) throw new SampleException(CmError.CM_UnAuthenticated_Token);
			
			ObjectMapper mapper = new ObjectMapper();
			UserInfo info = mapper.convertValue(tokenBody.get("info"), UserInfo.class);
			
			AccessUser user = new AccessUser(info);
			
			UsernamePasswordAuthenticationToken auth = 
	                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		filterChain.doFilter(request, response);
	}

}
