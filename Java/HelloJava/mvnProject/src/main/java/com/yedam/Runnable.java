package com.yedam;

public interface Runnable {

	
	// 클래스는 실제 기능이 담겨져 있었는데
	// 인터페이스는 규칙만 지정한다. 
	// 즉, 메소드의 이름만 만든다.  run(){}; 이렇게 안만들고 run();이렇게 만든다!
	// 이 인터페이스의 기능을 구현하는 클래스를 통해서 기능을 넣는다!
	// RunExe 클래스를 만들어보자
	
	public void run(); //추상메소드
	
	
}
