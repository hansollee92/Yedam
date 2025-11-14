package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration       //설정파일임을 알려주는 것
@EnableJpaAuditing   //JpaAuditing기능을 넣음
public class JpaConfig {
	
	// 생성시간, 수정시간 자동으로 관리하기 위해서 JpaConfig를 위와 같이 설정
	
	// @EnableJpaAuditing을 위해서 해당 Class를 만들었는데 이걸 하기 싫다면 com.example.demo에 있는 JpaApplication.java에 @EnableJpaAuditing 직접 넣어도 상관은 없다.
	// 우리는 따로 관리하기 위해서 이렇게 만들고 있음 

}
