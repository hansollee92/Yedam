package day2;

public class Professor {

	int no;
	String name;
	String addr;
	int roomNo;

	// 기본생성자(매개변수가 없는)
	// 생성자가 하나도 선언된게 없으면 컴파일러가 추가
	public Professor() {
		this(0, "무명"); // 다른 생성자를 호출
	}

	public Professor(int no, String name) {
		this.no = no;
		this.name = name;
	}

}
