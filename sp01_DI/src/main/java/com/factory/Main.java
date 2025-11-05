package com.factory;

public class Main {
	public static void main(String[] args) {
		                   // String[] args
		                   // : mian 메서드에 있는 이 매개변수를 '명령행 인수'라고 부른다. 
		
		BeanFactory factory = new BeanFactory();
		
		// 상속과 다형성 - 부모타입의 참조변수가 자식객체를 참조할 수 있다. 
		TV tv = (TV)factory.getBean(args[0]);
		
		tv.powerOn();	// 다형성 - 참조하는 객체(대상)의 메세드(오버라이딩 된)를 호출
		tv.volumeUp();  

	}
}
