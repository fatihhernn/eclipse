package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	
		// 1 let's start with an @Before advice
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
		private void forDaoPackage() {}
		
		// 2 create pointcut for getter methods
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
		private void getter() {}
		
		// 3 create pointcut for setter methods
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
		private void setter() {}
		
		// 4 create pointcut : include package .. exclude getter/setter
		@Pointcut("forDaoPackage() && !(getter() || setter())")
		private void forDaoPackageNoGetterSetter() {}
		
		// 5 
		@Before("forDaoPackageNoGetterSetter()") 
		public void beforeAddAccountAdvice() {
			//önce burasý çalýþýr sonra metod çalýþýr..
			System.out.println("\n=====>>> Executing @Before advice on beforeAddAccountAdvice()");	
		}
		
		@Before("forDaoPackageNoGetterSetter()") 
		public void performApiAnalytics() {
			System.out.println("\n=====>>> Executing @Before advice on performApiAnalytics()");
		}
}
