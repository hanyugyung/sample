package com.mari.sample01.data.res;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SampleDto {
	private String email;
	private List<String> roles;
}
