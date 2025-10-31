package day3.shape;

public class Circle extends Shape {

	// field
	private String color;    // 면색상
	
	// method
	@Override
	public String toString() {
		return "Circle [sx="+ this.getEx() + ", sy="+ this.getEy() + ", ex=" + this.getEx() + ", ey=" + this.getEy() + "]";
	}
	
	@Override
	public void draw() {
		System.out.println("원을 그리다");
	}
	
}
