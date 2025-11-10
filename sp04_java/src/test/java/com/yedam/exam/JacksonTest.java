package com.yedam.exam;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
	
	@Test
	public void toObject() throws JsonMappingException, JsonProcessingException {
		
		//{"name":"hong","age":10}
		// cmd에서 만들었던 node {"name":"hong","age":10} 이부분을 복사해서 "" 안에 넣으면 자동으로 왼쪽처럼 만들어줌
		String json = "{\"name\":\"hong\",\"age\":10}";    
		ObjectMapper objectMapper = new ObjectMapper();
		Sample sample = objectMapper.readValue(json, Sample.class); // .readValue = JSON.parse()
		
		System.out.println("name= " + sample.getName());
	}
	
	
	@Test
	public void toJson() throws JsonProcessingException {
		
		Sample sample = new Sample();
		sample.setName("홍길동");
		sample.setAge(20);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String str = objectMapper.writeValueAsString(sample);
		
		System.out.println(str);
	}
	
	
}
