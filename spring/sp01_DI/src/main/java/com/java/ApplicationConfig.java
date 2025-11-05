package com.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.container.AppleSpeaker;
import com.container.Speaker;
import com.factory.SamsungTV;
import com.factory.TV;

//@Configuration
public class ApplicationConfig {

	@Bean
	public Speaker speaker() {
		return new AppleSpeaker();
	}
	// 위의 부분은 <bean id="speaker" class="com.container.AppleSpeaker"></bean>와 동일함
	
	@Bean
	public TV tv() {
		// 생성자 방식
		 return new SamsungTV(speaker());
		
		// setter 방식
//		SamsungTV tv = new SamsungTV();
//		tv.setSpeaker(speaker());
//		return tv;
		
		// 두개의 방식 중에서 생성자방식이 간단하기 때문에 보통 생성자방식 사용
	}
	
	
}
