package com.mari.sample01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mari.sample01.data.req.UserReqDto.UserLoginParam;
import com.mari.sample01.data.res.UserResDto;
import com.mari.sample01.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/login")
	public UserResDto login(@RequestBody UserLoginParam param) {
		return userService.createToken(param);
	}
}
