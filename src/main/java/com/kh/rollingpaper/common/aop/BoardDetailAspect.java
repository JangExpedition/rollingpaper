package com.kh.rollingpaper.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardDetailAspect {


	@Pointcut("execution(String com.kh.rollingpaper.board.controller.BoardController.boardDetail(..))")
	public void pc() {}
	
	@AfterThrowing(pointcut = "pc()", throwing = "e")
	public void errorLog(ProceedingJoinPoint joinPoint, Exception e) {
		Signature signature = joinPoint.getSignature();
		String type = signature.getDeclaringTypeName();
		String methodName = signature.getName();
		
		log.debug("signature = {}", signature);
		log.debug("type = {}", type);
		log.debug("methodName = {}", methodName);
	}
}
