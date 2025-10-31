package day2;

public class Circle {
	private int radius;// read, write
	private double areaResult; // 캡슐실 read

	public Circle() {
	}

	public Circle(int radius) {
		this.radius = radius;
	};
	
	// 메서드
	// 정적메서드
	public static double calArea(int r) {
		return r * r * Math.PI;
	}
	
	// 메서드 오버로딩(중복선언 : 같은이름 가능, 매개변수 타입, 수 다름)
	public void calArea() {
		areaResult = radius * radius * Math.PI;
	}
	
	// setter, getter
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double getAreaResult() {
		return areaResult;
	}

}
