package com.yedam.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.yedam.config.RootConfig;

@SpringJUnitConfig(classes = {RootConfig.class})
public class RestaurantTest {
	
	@Autowired
	ApplicationContext ctx;
	
	@Test
	public void test() {
		Restaurant r1 = ctx.getBean(Restaurant.class);
		Restaurant r2 = ctx.getBean(Restaurant.class);
		assertEquals(r1, r2);
	}
}
