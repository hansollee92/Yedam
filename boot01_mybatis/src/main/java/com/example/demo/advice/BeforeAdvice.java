package com.example.demo.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

// Advice 클래스 = 공통로직
// Aspect 클래스 = Advice + pointcut

@Log4j2
@Component
@Aspect
public class BeforeAdvice {
	@Pointcut("execution(* com.example..*Impl.*(..))")
	public void  allpointcut() {}

	
	@Before("allpointcut()")
	public void beforeLog(JoinPoint jp) {
		//메서드명
		String methodName = jp.getSignature().getName();
		//methodName += ":" + jp.toLongString();
		//methodName += ":" + jp.toShortString();

		//인수(argument)
		Object[] args = jp.getArgs();
		Object arg1 =  (args != null && args.length>0 ? args[0] : "") ;
		log.debug("[사전처리로그] beforeLog \n[" + methodName +"] [arg] " + arg1);
	}
		
	
    @Around("@annotation(PrintExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // 실제 메서드 실행

        long executionTime = System.currentTimeMillis() - start;
        
        String methodName = joinPoint.getSignature().toShortString();
        
        log.info("{} 실행 시간: {}ms", methodName, executionTime );

        return result;
    }
		
	
}
