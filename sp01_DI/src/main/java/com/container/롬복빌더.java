package com.container;

public class 롬복빌더 {
	public static void main(String[] args) {
		
		Employee emp = Employee.builder()
				.employeeId(100)
				.email("")
				.build();
		// 생성자 대신으로 builder를 사용해서 값을 바로 넣을 수 있다. 
		
	}
}
