package 이한솔;

import java.util.Scanner;

public class Report1 {

	public static void main(String[] args) {
		// 윤년 계산
		
		// 입력된 년도가 윤년인지 계산하는 프로그램
		// 4로 나누어 떨어지고
		// 100으로 나누어 떨어지지 않으면 윤년
		// 400으로 나누어 떨어지면 윤년
		
		// 출력 
		// ##년도 입력 : ____
		// ____년은 윤년입니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("##년도 입력 : ");
		int year = Integer.parseInt(sc.nextLine());
		
		if(year % 4 == 0) {
			if(year % 100 != 0 || year % 400 == 0) {
				System.out.printf("%d년은 윤년입니다\n", year);
			}else {
				System.out.printf("%d년은 평년입니다\n", year);
			}
		}else {
			System.out.printf("%d년은 평년입니다\n", year);
		}		
		
		sc.close();

	}//end main

}//end class
