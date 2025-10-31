package day3.remotecontrol;

public class Main {

	public static void main(String[] args) {

		MyClass myClass = new MyClass(new Television());
		myClass.methodB();
		
		myClass = new MyClass(new Audio());
		myClass.methodA();
		
	}

}
