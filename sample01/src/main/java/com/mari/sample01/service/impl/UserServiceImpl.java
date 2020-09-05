package com.mari.sample01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mari.sample01.common.token.JwtUtil;
import com.mari.sample01.data.CmError;
import com.mari.sample01.data.dao.User;
import com.mari.sample01.data.dto.UserInfo;
import com.mari.sample01.data.req.UserReqDto.UserLoginParam;
import com.mari.sample01.data.req.UserReqDto.UserSignUpParam;
import com.mari.sample01.data.res.UserResDto.UserLoginDto;
import com.mari.sample01.data.res.UserResDto.UserSignUpDto;
import com.mari.sample01.exception.SampleException;
import com.mari.sample01.repository.UserRepository;
import com.mari.sample01.service.UserService;


@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	private void isExistSameLoginId(String loginId) {
		userRepository
			.findByLoginId(loginId)
			.ifPresent(object -> {
				throw new SampleException(CmError.CM_LoginId_Conflict);	
			});
	}
	
	private UserInfo validateUser(UserLoginParam param) {
		User one = userRepository
			.findByLoginId(param.getLoginId())
			.orElseThrow(() -> new SampleException(CmError.CM_Login_Fail));
		
		if(!new BCryptPasswordEncoder().matches(param.getPassword(), one.getPassword())) {
			throw new SampleException(CmError.CM_Login_Fail);
		}
		
		return UserInfo.builder()
				.id(one.getId())
				.loginId(one.getLoginId())
				.name(one.getName())
				.role(one.getRole())
				.build();
	}

	@Override
	public UserLoginDto createToken(UserLoginParam user) {
		UserInfo userInfo = validateUser(user);
		String token = jwtUtil.createToken(userInfo);
		UserLoginDto userDto = UserLoginDto
				.builder()
				.token(token)
				.name(userInfo.getName())
				.build();
		return userDto;
	}

	@Override
	public UserSignUpDto createUser(UserSignUpParam param) {
		isExistSameLoginId(param.getLoginId());
		User newUser = User.of(param);
		try {
			newUser = userRepository.save(newUser);
		}catch(Exception e) {
			throw new SampleException(CmError.CM_Internal_ServerError);
		}
		return UserSignUpDto.ofEntity(newUser);
	}

}
