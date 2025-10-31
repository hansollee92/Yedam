package day3.shape;

import java.util.ArrayList;

/*
	1. 상속관계에서 부모타입의 변수가 자식객체를 참조가능
	2. 상속후에 매서드를 재정의(오버라이딩) 가능함
	3. 오버라이딩 된 매서드가 있으면 호출하고 없으면 부모의 매서드가 호출됨    
	    → 실행코드는 같지만 참조하는 자식객체의 매서드가 실행되므로 결과는 다르게 나옴
*/

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Shape> list = new ArrayList<Shape>();
		list.add(new Line());   // 다형성 1번
		list.add(new Circle());
		list.add(new Rect());
		
		for(Shape s : list) {
			s.draw();          // 다형성 3번
		}
		
		shapeDraw(new Line());
		shapeDraw(new Circle());
			
	}
	
	// 다형성은 위의 방식보다 아래의 방식으로 많이 사용이 된다. 
	// (이게 없다면 같은 방식을 3번이나 작성해야함)
	public static void shapeDraw(Shape c) {
		c.draw();
	}
	
}
