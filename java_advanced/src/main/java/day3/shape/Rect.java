package day3.shape;

public class Rect extends Shape {
	
	// field
	private String color;

	// method
	@Override
	public String toString() {
		return "Rect [sx="+ this.getEx() + ", sy="+ this.getEy() + ", ex=" + this.getEx() + ", ey=" + this.getEy() + "]";
	}
	
	@Override
	public void draw() {
		System.out.println("사각형을 그리다");
	}
	
}
