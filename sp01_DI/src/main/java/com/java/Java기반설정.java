package com.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.factory.TV;

// 자바기반 DI설정
public class Java기반설정 {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		// ACAC + Ctrl + space로 입력하는 방법도 있음
		
		TV tv = (TV)context.getBean("tv"); 
		tv.powerOn();
		tv.volumeUp();
	}
	
}
