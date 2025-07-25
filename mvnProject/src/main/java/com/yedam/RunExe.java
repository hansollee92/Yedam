package com.yedam;

// 어떤규칙을 물려받는지 알려주기 위해 implements(:구현한다) Runnable을 붙여준다.
// Runnable interface가 가지고 있는 메소드의 기능을 RunExe에서 구현해줘야한다.

// Runnable 인터페이스에 정의된 추상메소드를 정의.
public class RunExe implements Runnable {
            // RunExe에서 오류나는데 마우스 올리면 'Add unimplemented method'클릭
	        // 그럼 아래에 Override가 나타나는데 부모클래스의 상속받는것과 같은 효과여서 붙어있다?
	
	@Override
	public void run() {
		System.out.println("달립니다");
	}
	

}
