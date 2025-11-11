package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {

	@Test
	public void test() {
		// Create an encoder with strength 16
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String result = encoder.encode("1234");
		System.out.println(result);
		
		assertThat(encoder.matches("1234", result));		
		// assertEquals("1234", result);
		// 암호할때마다 값이 다르기 때문에 assertEquals로는 비교를 할수가 없고 
		// assertThat을 이용해서 matches를 이용해야한다. 
	}
	
}
