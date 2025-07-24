package 이한솔;

import java.util.Scanner;

public class Report2 {

	public static void main(String[] args) {
		// 동전 교환 프로그램
		
		// 입력된 액수만큼 500원, 100원, 50원 10원짜리 동전으로 교환해주는 프로그램
		// 동전의 총개수는 최소화
		// 고액의 동전 먼저 교환
		
		// 실행결과
		// ##교환할 금액 : ____
		// 500원짜리 : __개
		// 100원짜리 : __개
		// 50원짜리 : __개
		// 10원짜리 : __개
		// 교환 금액 : ___원
		// 남은 금액 : ___원	
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("##교환할 금액 : ");
		int money = Integer.parseInt(sc.nextLine());  //사용자 입력금액
	
		int change500 = money / 500;
		int remain = money % 500;
		
		int change100 = remain / 100;		
		remain %= 100;
		
		int change50 = remain / 50;		
		remain %= 50;
		
		int change10 = remain / 10;		
		remain %= 10;
		
		System.out.printf("500원짜리 : %d개\n", change500);
		System.out.printf("100원짜리 : %d개\n", change100);
		System.out.printf("50원짜리 : %d개\n", change50);
		System.out.printf("10원짜리 : %d개\n", change10);
		
		System.out.printf("교환 금액 : %d원\n", money - remain);
		System.out.printf("남은 금액 : %d원\n", remain);
			
		sc.close();	
		
		
		
	}//end main

}//end class
