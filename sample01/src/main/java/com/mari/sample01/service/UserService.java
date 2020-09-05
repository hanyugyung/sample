package com.mari.sample01.service;

import com.mari.sample01.data.dto.UserInfo;
import com.mari.sample01.data.req.UserReqDto.UserLoginParam;
import com.mari.sample01.data.res.UserResDto;

public interface UserService {

	UserInfo validateUser(UserLoginParam param);

	UserResDto createToken(UserLoginParam user);

}
