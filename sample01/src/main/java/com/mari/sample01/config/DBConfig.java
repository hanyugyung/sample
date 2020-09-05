package com.mari.sample01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing	//jpa auditing 을 자동화 하기 위해 추가함(@createdDate, @lastMo~ 등의 어노테이션이 작동하기 위함)
@Configuration
public class DBConfig {

}
