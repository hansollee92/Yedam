package com.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.factory.TV;

// 자동등록
public class 자동등록 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext2.xml");
		
		TV tv = context.getBean(TV.class);
		tv.powerOn();
		tv.volumeUp();
		
	}
}
