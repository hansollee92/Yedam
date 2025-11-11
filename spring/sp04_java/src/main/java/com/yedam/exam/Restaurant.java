package com.yedam.exam;

public class Restaurant {

	// 필드
	Chef chef;
	
	// 생성자	
	public Restaurant(Chef chef) {
		super();
		this.chef = chef;
	}
	
	public void order() {
		chef.cook();
	}
	
}
