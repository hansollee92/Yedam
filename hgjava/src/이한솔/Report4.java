package 이한솔;

public class Report4 {

	public static void main(String[] args) {
		// 구구단 프로그램
		
		// 아래와 같이 출력되도록 구구단 프로그램 만들기
		// 2단      3단      4단.....
		// 2x1=2  3x1=3 .... 
		// 2x2=4  3x2=6 ....
		
		for(int i=2; i<=9; i++) {
			System.out.printf("%d단\t", i);
		}
		System.out.println();
		for(int i=1; i<=9; i++) {
			for(int dan=2; dan<=9; dan++) {
				System.out.printf("%dx%d=%2d\t", dan, i, dan*i);
			}
			System.out.println();
		}
		

	}//end main

}//end class
