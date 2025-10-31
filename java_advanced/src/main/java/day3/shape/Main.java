package day3.shape;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Shape> list = new ArrayList<Shape>();
		list.add(new Line());
		list.add(new Circle());
		list.add(new Rect());
		
		for(Shape s : list) {
			s.draw();
		}
		
		
		
	}
}
