package com.mari.sample01.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.mari.sample01.data.CmError;
import com.mari.sample01.exception.SampleException;

@Aspect
@Component
public class ValidateParam {
	
	@Around("@annotation(com.mari.sample01.aop.annotation.ValidateParam)")
	public Object validateParam(ProceedingJoinPoint point) throws Throwable {
		Object[] params = point.getArgs();
		for(Object param : params) {
			if(param instanceof BindingResult) {
				if(((BindingResult) param).hasErrors()) {
					throw new SampleException(CmError.CM_BadRequest);	//validation dependency 에 따라 이렇게 안해줘도 검증해주는 듯...(만들었는데 쓸일잉 없음)
				}
			}
		}
		return point.proceed();
	}
}
