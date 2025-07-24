package chap01;

import java.util.Scanner;

public class Ex149 {

	public static void main(String[] args) {
		// 25-07-15-화요일
		// p149 확인문제
		// 이유 주석으로 표시, 오류 수정
		
		// 문제1
		int b = 5;  
		b = -b;
		int result = 10 / b;
		System.out.println(result);
		// 이유 : byte에 부호연산자 붙었기 때문에 오류
		
		// 문제2
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		System.out.println(z);
		// 31
		
		// 문제3
		// !(stop)
		
		// 문제4 (나머지값이상 확인필요)
		int pencils = 534;
		int students = 30;
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);
		int pencilsLeft = pencils % students;
		System.out.println(pencilsLeft);
		
		// 문제5
		int var1 = 5;
		int var2 = 2;
		double var3 = (double)var1 / var2;
		int var4 = (int)(var3*var2);
		System.out.println(var4);
		// 이유 : 정수인 int를 나누기하니 실수값으로 나오지 않기 떄문에 형변환 필요
		
		// 문제6
		int value = 356;
		int valueR = (value / 100) * 100;
		System.out.println(valueR);
		
		// 문제7
		double var5 = 10;
		double var6 = var5 / 100;
		if(var6 == 0.1) {
			System.out.println("10%입니다.");
		}else {
			System.out.println("10%가 아닙니다.");;
		}
		// float는 0.1을 정확하게 표현할수 없음, double로 바꾸면 됨
		
		// 문제8
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (double)((lengthTop + lengthBottom) * height) / 2;
		System.out.println(area);		
		
		// 문제9
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수 :");		
		double num1 = Double.parseDouble(sc.nextLine());		
		System.out.print("두 번째 수 :");
		double num2 = Double.parseDouble(sc.nextLine());
		double num3 = num1 / num2;
		System.out.println("-------------------");
		if(num2 == 0 | num2 == 0.0) {
			System.out.println("결과 : 무한대");
		}else {
			System.out.println(num3);
		}		
		
		// 문제10
		int var7 = 10;
		int var8 = 3;
		int var9 = 14;
		double var10 = var7 * var7 * Double.parseDouble(var8 + "." + var9);
		System.out.println("원의 넓이:" + var10);
		
		
		// 문제11 
		System.out.print("아이디 :");
		String name = sc.nextLine();		
		System.out.print("패스워드 :");
		String strPassword = sc.nextLine();		
		int password = Integer.parseInt(strPassword);		
		if(name.equals("java")) {
			if(password == 12345) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패: 패스워드가 틀림");
			}
		}else {
			System.out.println("로그인 실패: 아이디 존재하지 않음");
		}		
		
		
		
		// 문제12
		int x2= 10;
		int y2 = 5;
		System.out.println((x2>7) && (y2<=5));   //true
		System.out.println((x2%3 == 2) || (y2%2 !=1));   //false
				
		// 문제13
		int value2 = 0;
		value2 += 10;
		value2 -= 10;
		value2 *= 10;
		value2 /= 10;
		System.out.println(value2);		
		
		// 문제14 : 가
		
		// --------------------------------------------------------------------------------------------------
		
		// 윤년 계산 프로그램
		// 4로 나누어서 떨어지고, 100으로 나누어 떨어지지 않으면 윤년
		//                  400으로 나누어 떨어지면 윤년
		
		System.out.printf("##년도 입력: ");
		int year = Integer.parseInt(sc.nextLine());
		if(year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)) {
			System.out.printf("%d년은 윤년입니다.\n", year);
			//if(year % 400 == 0 || year % 100 != 0) {
			//	System.out.printf("%d년은 윤년입니다.\n", year);
			//}else {
			//	System.out.printf("%d년은 평년입니다.\n", year);
			//}
		}else {
			System.out.printf("%d년은 평년입니다.\n", year);
		}		
		
		sc.close();
		
		
	}//end main

}//end class
