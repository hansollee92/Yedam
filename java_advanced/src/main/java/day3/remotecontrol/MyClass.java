package day3.remotecontrol;

public class MyClass {
	
	// 필드
	RemoteControl rc;

	// 생성자
	public MyClass(RemoteControl rc) {
		this.rc = rc;
	}
	
	//메서드
	void methodA() {
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(7);
	}
	
	void methodB() {
		rc.turnOn();
		rc.setVolume(5);
	}

	// 내가 코드를 딱히 건들지 않고 내가 넣어주는 객체에 따라 메서드들이 조절되고 있음
	
}
