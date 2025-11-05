package com.container;

// xml 기반 DI 설정 (생성자, setter)
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.factory.TV;

// Spring의 “DI(의존성 주입, Dependency Injection)”와 IoC(제어의 역전, Inversion of Control) 개념을 실제로 보여주는 대표적인 예제
public class XML기반설정 {
	public static void main(String[] args) {
		
		// 컨테이너 == 어플리케이션컨텍스트
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		// ApplicationContext : 스프링 컨테이너 역할 → “객체(Bean)”들을 대신 생성하고 관리
		// ClassPathXmlApplicationContext : XML 설정 파일(applicationContext.xml)을 읽어서 그 안에 정의된 **Bean(객체)**들을 메모리에 생성
		// 즉, 이 한 줄로 “스프링 컨테이너를 시작하고, 등록된 객체들을 로드한다”는 뜻
		
		// TV tv = (TV)context.getBean("tv"); // getBean : 스프링이 만든 객체를 이름으로 가져옴 (이름으로 찾아감)
		TV tv = context.getBean(TV.class);    // (타입으로 찾아감)
		tv.powerOn();
		tv.volumeUp();
		
	}
}
