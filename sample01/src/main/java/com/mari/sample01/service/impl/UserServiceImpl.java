package com.mari.sample01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mari.sample01.common.token.JwtUtil;
import com.mari.sample01.data.CmError;
import com.mari.sample01.data.dao.User;
import com.mari.sample01.data.dto.UserInfo;
import com.mari.sample01.data.req.UserReqDto.UserLoginParam;
import com.mari.sample01.data.req.UserReqDto.UserSignUpParam;
import com.mari.sample01.data.res.UserResDto;
import com.mari.sample01.data.res.UserResDto.UserLoginDto;
import com.mari.sample01.data.res.UserResDto.UserSignUpDto;
import com.mari.sample01.exception.SampleException;
import com.mari.sample01.repository.UserRepository;
import com.mari.sample01.service.UserService;

import net.bytebuddy.description.ModifierReviewable.OfEnumeration;

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
	public UserLoginDto createToken(UserLoginParam user) {
		UserInfo userInfo = validateUser(user);
		if(userInfo == null) {
			throw new SampleException(CmError.CM_UnAuthenticated_Token);
		}
		String token = jwtUtil.createToken(userInfo);
		UserLoginDto userDto = UserLoginDto
				.builder()
				.token(token)
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
