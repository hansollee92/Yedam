package 이한솔;

import java.util.Scanner;

public class Report5 {

	public static void main(String[] args) {
		// 섭씨-화씨 온도 변환 프로그램
		
		// 섭씨 온도(C) = 5/9 * (F-32)
		// 화씨 온도(F) = 9 / 5 * C + 32
		// 1. 화씨 -> 섭씨
		// 2. 섭씨 -> 화씨
		// 3. 종료
		
		Scanner sc = new Scanner(System.in);

		boolean run = true;
		while(run) {
			System.out.println("-------------------------");
			System.out.println("1. 화씨 => 섭씨");
			System.out.println("2. 섭씨 => 화씨");
			System.out.println("3. 종료");
			System.out.println("-------------------------");
			
			System.out.print("▶ 번호 선택 : ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case 1:
				System.out.print("▶ 화씨 온도 입력 : ");
				double degreeF = Double.parseDouble(sc.nextLine());
				double cal1 = 5.0 / 9 * (degreeF - 32);
				System.out.printf("  섭씨온도 = %f\n", cal1);
				break;
			case 2:
				System.out.print("▶ 화씨 온도 입력 : ");
				double degreeC = Double.parseDouble(sc.nextLine());
				double cal2 = 9.0 / 5 * degreeC + 32;
				// double로 강제변환해도 되지만 숫자값을 .0을 붙여서 소숫점 값을 넣어도 된다(오류1)
				// 섭씨->화씨 변환하는 계산식 괄호 없음! 
				System.out.printf("  섭씨온도 = %f\n", cal2);
				// 실수값을 받았으니 %d가 아니라 %f로 적어야지 오류 없음 (오류2)
				break;
			default : 
				run = false;
			}			
		}
		System.out.println("program end");		
		sc.close();

	}//end main

}//end class
