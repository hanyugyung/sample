package com.mari.sample01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mari.sample01.common.token.JwtUtil;
import com.mari.sample01.data.CmError;
import com.mari.sample01.data.dto.UserInfo;
import com.mari.sample01.data.req.UserReqDto.UserLoginParam;
import com.mari.sample01.data.res.UserResDto;
import com.mari.sample01.exception.SampleException;
import com.mari.sample01.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public UserInfo validateUser(UserLoginParam param) {
		if(param.getEmail().equals("admin@aaa.com") && param.getPassword().equals("1234")) {
			UserInfo userInfo = UserInfo.builder()
					.id(1L)
					.email(param.getEmail())
					.role("ADMIN")
					.build();
			return userInfo;
		}
		return null;
	}

	@Override
	public UserResDto createToken(UserLoginParam user) {
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
