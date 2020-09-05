package com.mari.sample01.service;

import com.mari.sample01.data.dto.UserInfo;
import com.mari.sample01.data.req.UserReqDto.UserLoginParam;
import com.mari.sample01.data.req.UserReqDto.UserSignUpParam;
import com.mari.sample01.data.res.UserResDto;
import com.mari.sample01.data.res.UserResDto.UserLoginDto;
import com.mari.sample01.data.res.UserResDto.UserSignUpDto;

public interface UserService {

	UserLoginDto createToken(UserLoginParam user);

	UserSignUpDto createUser(UserSignUpParam param);

}
