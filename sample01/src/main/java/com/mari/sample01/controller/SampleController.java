package com.mari.sample01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mari.sample01.config.User;
import com.mari.sample01.data.CmError;
import com.mari.sample01.data.dto.SampleDto;
import com.mari.sample01.exception.NotFoundException;

@RestController
public class SampleController {
	
	@GetMapping("/sample")
	public String sample() throws Exception {
		throw new NotFoundException(CmError.CM_Resource_NotFound);
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/limittedSample")	
	public List<SampleDto> getAllUserInfo(@AuthenticationPrincipal User user) {
		
		List<SampleDto> allUserInfo = new ArrayList<SampleDto>();
		
		for(int i = 0 ; i < 10 ; i++) {
			SampleDto dto = new SampleDto();
			dto.setEmail(String.format("email{%d}@aaa.com", i));	
			allUserInfo.add(dto);
		}
		return allUserInfo;
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/unlimittedSample")
	public SampleDto getMyInfo(@AuthenticationPrincipal User user) {
		
		List<String> myRoleLst = user.getAuthorities()
									 .stream()
									 .map(a -> a.toString())
									 .collect(Collectors.toList());
		
		SampleDto dto = new SampleDto();
		dto.setEmail(user.getEmail());
		dto.setRoles(myRoleLst);
		return dto;
	}
}
