package day3.shape;

public class Shape {

	// field
	private int sx;  // 시작좌표
	private int sy;
	private int ex;  // 끝좌표
	private int ey;
	private int w;   // 굵기
	
	// 생성자
	public Shape() {}
	public Shape(int sx, int sy, int ex, int ey) {
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
	}
	
	// setter, getter
	public int getSx() {
		return sx;
	}
	public void setSx(int sx) {
		this.sx = sx;
	}
	public int getSy() {
		return sy;
	}
	public void setSy(int sy) {
		this.sy = sy;
	}
	public int getEx() {
		return ex;
	}
	public void setEx(int ex) {
		this.ex = ex;
	}
	public int getEy() {
		return ey;
	}
	public void setEy(int ey) {
		this.ey = ey;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	
	// method
	@Override
	public String toString() {
		return "Shape [toString()=" + super.toString() + "]";
	}
	
	public void draw() {
		System.out.println("도형을 그리다");
	}
		
	
}
