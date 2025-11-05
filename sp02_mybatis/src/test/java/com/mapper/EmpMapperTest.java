package com.mapper;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/datasource-context.xml")
public class EmpMapperTest {
	
	@Autowired EmpMapper empMapper;
	
	@Test
	public void 단건조회() {
		Map map = empMapper.selectone(100);
		System.out.println(map);
	}
	
	@Disabled   // JUnit 5ver은 @Ignore가 아니라 @Disabled
	@Test
	public void 전제조회() {
		List<Employee> list = empMapper.selectall();
		System.out.println("--------------------");
		System.out.println(list.get(1));
	}
}
