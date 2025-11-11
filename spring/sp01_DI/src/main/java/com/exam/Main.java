package com.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.factory.TV;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext2.xml");
		
		// 실습1)
		Restaurant restaurant = context.getBean(Restaurant.class);
		restaurant.order();
		
		// 실행하면 아래와 같은 에러가 나타남 
		// >> Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.exam.Restaurant' available
		// No qualifying bean
		// 즉, bean으로 container에 등록된 것이 없기 때문에 나타나고 있는 오류
		
		// Restaurant 클래스에 @Component을 등록하고나면
		// 또 오류가 나타남
		// >> Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.exam.Chef.cook()" because "this.chef" is null
		// "this.chef" is null
		// 즉, chef에 값이 없기 때문에 지금 에러가 나타나고 있음
		// Chef에 @Component 설정하고, Restarant의 필드에 @Autowired 설정하면 오류 사라짐
		
		
		// 실습2) EmpRepository / AuthRepository / EmpService 파일을 넣고
		//       아래가 오류없이 동작하도록 어노테이션 DI를 넣어보세요. 
		EmpService empService = context.getBean(EmpService.class);
		empService.register();
		
		
		// 실습3) 생성자 방식으로 바꿔보세요. 
		// 각각 필드앞에 final을 붙이고 @RequiredArgsConstructor를 붙이기
		
		
	}
}
