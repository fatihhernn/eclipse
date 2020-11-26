package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	//setup pointcut declerations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//do the same for service and dao
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage() ")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display method we are calling
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("======>>>>>>in @Before : calling method : "+theMethod+"<<<<<<<<=======");
		
		//display the arguments to the methods
		
		
		//get the arguments 
		Object[] args=theJoinPoint.getArgs();
		
		//loop thru and siplay args
		for (Object tempArgs : args) {
			myLogger.info("=========>>>>>ARGUMENT: "+tempArgs+"<<<<<<<<============0");
		}
	}
	
	
	//add @Afterreturning advice
	
	@AfterReturning(pointcut = "forAppFlow()",
					returning = "theResult"	
					)
	public void afterReturning(JoinPoint theJoinPoint,Object theResult) {
		
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("======>>>>>>in @AFTERRETURNING : calling method : "+theMethod+"<<<<<<<<=======");
		
		//display data returned
		myLogger.info("======>>>>>>result: "+theResult);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
