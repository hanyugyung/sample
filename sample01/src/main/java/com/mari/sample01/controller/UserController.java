package com.mari.sample01.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mari.sample01.aop.annotation.ValidateParam;
import com.mari.sample01.data.CmError;
import com.mari.sample01.data.SampleCmCode;
import com.mari.sample01.data.dao.Goods;
import com.mari.sample01.data.req.UserReqDto.UserLoginParam;
import com.mari.sample01.data.req.UserReqDto.UserSignUpParam;
import com.mari.sample01.data.res.UserResDto.UserLoginDto;
import com.mari.sample01.data.res.UserResDto.UserSignUpDto;
import com.mari.sample01.exception.SampleException;
import com.mari.sample01.service.UserService;

@RequestMapping("/api/users")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * @apiNote 로그인 API
	 * @access Permit ALL
	 */
	@PostMapping("/login")
	public SampleCmCode<UserLoginDto> login(@RequestBody @Valid UserLoginParam param) {
		 return new SampleCmCode<UserLoginDto>(
				 HttpStatus.OK, CmError.CM_Success.getCmCode(), userService.createToken(param));
	}
	
	/**
	 * @apiNote 회원가입 API
	 * @access Permit ALL
	 */
	@PostMapping("/signUp")
	public SampleCmCode<UserSignUpDto> signUp(@RequestBody @Valid UserSignUpParam param) {
		return new SampleCmCode<UserSignUpDto>(
				HttpStatus.OK, CmError.CM_Success.getCmCode(), userService.createUser(param));
	}
}
