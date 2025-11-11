package com.exam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// 단위테스트 -> 통합테스트 -> 인수테스트
// 클래스, front -> 메서드 컨트롤러 -> 서비스 -> 리포지토리
// 단위테스트를 하는 이유는 앞에 서비스, 리포지토리.. 등 아직 만들어지지 않은 상황에서도 테스트가 가능하기 때문에 한다.

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class EmpServiceTest {
	
	// p61 JUnit으로 단위테스트를 한다면 테스트 하고자 하는 클래스의 같은 패키지를 만들어주고 클래스를 만들어서 진행하면 된다. 
	// @ContextConfiguration("classpath:applicationContext2.xml")
	// @ContextConfiguration가 나타나지 않는다면 pom.xml에서 spring-test가 들어가지 않았음 (04.스프링프로젝트.pdf - 22페이지 코드 참고)
	
	// @ExtendWith(SpringExtension.class) : 뭘 테스트할것인지 적어주는 것인데 더 자세한 설명은 3일차에서 설명할 예정
	
	@Autowired
	EmpService empService;    // @Autowired안하면 nullPoint 오류뜸
	
	@Autowired
	Restaurant restaurant;
	
	@Test
	public void test() {
		empService.register();
	}
	
	@Test
	public void test2() {
		restaurant.order();
	}
	
}
