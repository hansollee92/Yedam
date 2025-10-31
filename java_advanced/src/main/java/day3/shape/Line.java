package day3.shape;

public class Line extends Shape {

	// field
	private int style;
	
	// 생성자는 상속이 X
	// 부모가 private가 안되어있다면 this.no = no;이 가능하지만
	// private가 되어있다면 본인만 접근이 가능하기 때문에 super() 이렇게 작성가능.
	// 상속을 하고 싶다면, 부모의 private를 protected로 설정하면 자식은 사용 가능
	public Line() {}
	public Line(int sx, int sy, int ex, int ey) {
		super(sx, sy, ex, ey);
	}
	public Line(int sx, int sy, int ex, int ey, int style) {
		super(sx, sy, ex, ey);
		this.style = style;
	}
	
	// getter, setter
	public int getStyle() {
		return style;
	}
	public void setStyle(int style) {
		this.style = style;
	}
	
	// method
	// private로 하면 접근이 되지 않기 때문에(상속은 됨) getter으로 접근 
	@Override
	public String toString() {
		return "Line [sx="+ this.getEx() + ", sy="+ this.getEy() + ", ex=" + this.getEx() + ", ey=" + this.getEy() + "]";
	}
	
	@Override
	public void draw() {
		System.out.println("선을 그리다");
	}
	
	
}
