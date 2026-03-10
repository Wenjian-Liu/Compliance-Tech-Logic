package com.wenjian.regtech.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CompliancePerformanceAspect {
	private static final Logger logger = LoggerFactory.getLogger(CompliancePerformanceAspect.class);

	// 切点表达式：拦截 service 包下所有方法执行
	@Around("execution(* com.wenjian.regtech.service.*.*(..))")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		// 执行原有的业务逻辑
		Object proceed = joinPoint.proceed();

		long executionTime = System.currentTimeMillis() - start;
		logger.info("[Performance] {} executed in {}ms", joinPoint.getSignature(), executionTime);

		return proceed;
	}
}