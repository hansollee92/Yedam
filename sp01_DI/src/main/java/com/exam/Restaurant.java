package com.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {

	// 필드
	@Autowired
	Chef chef;
	
	public void order() {
		chef.cook();
	}
	
	
}
