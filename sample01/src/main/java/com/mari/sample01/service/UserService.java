package com.mari.sample01.service;

import com.mari.sample01.data.dto.UserInfo;
import com.mari.sample01.data.req.UserReqDto;
import com.mari.sample01.data.res.UserResDto;

public interface UserService {

	UserInfo validateUser(UserReqDto user);

	UserResDto createToken(UserReqDto user);

}
