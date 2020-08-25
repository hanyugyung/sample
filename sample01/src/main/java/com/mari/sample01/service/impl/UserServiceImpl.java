package com.mari.sample01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mari.sample01.common.token.JwtUtil;
import com.mari.sample01.data.CmError;
import com.mari.sample01.data.dto.UserInfo;
import com.mari.sample01.data.req.UserReqDto;
import com.mari.sample01.data.res.UserResDto;
import com.mari.sample01.exception.SampleException;
import com.mari.sample01.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public UserInfo validateUser(UserReqDto user) {
		if(user.getEmail().equals("admin@aaa.com") && user.getPassword().equals("1234")) {
			UserInfo userInfo = UserInfo.builder()
					.id(1L)
					.email(user.getEmail())
					.role("ADMIN")
					.build();
			return userInfo;
		}
		return null;
	}

	@Override
	public UserResDto createToken(UserReqDto user) {
		UserInfo userInfo = validateUser(user);
		if(userInfo == null) {
			throw new SampleException(CmError.CM_UnAuthenticated_Token);
		}
		String token = jwtUtil.createToken(userInfo);
		UserResDto userDto = UserResDto
				.builder()
				.token(token)
				.build();
		return userDto;
	}

}
