package chap04;

import java.util.Scanner; 

public class Bank183 {

	public static void main(String[] args) {
		
		// p183 문제7번 ---------------------------------------------------------------------------------------------
		// while문, Scanner	
		
		
		// 은행업무
		int balance = 0;       //계좌(잔고변수)
		boolean run = true;    //실행제어 변수
		Scanner sc = new Scanner(System.in);  //표준입력장치를 받기위한
		int money;
		
		while(run){
			// 업무 1:예금, 2:출금, 3:조회, 4:종료		
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			
			System.out.print("선택> ");
			int selNum = Integer.parseInt(sc.nextLine());   //nextLine()메소드로 엔터 전까지 모든 문자열 가져옴
			
			switch(selNum) {
			case 1: 
				System.out.print("예금액>");
				money = Integer.parseInt(sc.nextLine());
				balance += money;
				break;
			case 2: 
				System.out.print("출금액>");
				money = Integer.parseInt(sc.nextLine());
				
				// 출금액이 부족할 경우 잔액 부족 출력
				if(balance < money) {
					System.out.printf("출금액이 부족합니다.\n출금 가능 금액 : %d원\n", balance);  //출금가능금액 출력
				}else {
					balance -= money;
				}
				break;
			case 3: 
				System.out.printf("잔고> %d\n", balance);
				break;
			default : 
				run = false;   
				// 그냥 break만 하면 switch문은 빠져나오지만 while문은 종료되지 않기 때문에 false값을 넣어줘야함
			}
		}
		System.out.println("프로그램 종료");	
		sc.close();
		
		
		
		
		
		
		
		
		

	}//end main

}//end class
