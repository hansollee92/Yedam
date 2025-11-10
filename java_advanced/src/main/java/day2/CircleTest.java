package day2;

public class CircleTest {
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		circle.calArea();
		System.out.println(circle.getAreaResult());
		
		// 정적메서드 호출(클래스이름으로 접근, 객체생성안함)
		double result = Circle.calArea(5);
		System.out.println(result);
	}
}
