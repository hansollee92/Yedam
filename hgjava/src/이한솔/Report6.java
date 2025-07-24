package 이한솔;

import java.util.Scanner;

public class Report6 {

	public static void main(String[] args) {
		// 가위, 바위, 보 게임 프로그램
		
		// 가위, 바위, 보 중에 하나를 선택하면,
		// 컴퓨터가 생성한 난수값과 비교하여
		// 누가 이겼는지 화면에 출력하는 프로그램 생성 
		// 2보다 큰 수 입력하면 game over 출력 => 종료
		
		// 실행결과 
		// ## 가위(0) 바위(1) 보(2) : ___
		// 사람 __ 컴 __ 비겼음 
		// 사람 __ 컴 __ 승리
		// game over
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int com = (int)(Math.random()*3);
			System.out.print("## 가위(0) 바위(1) 보(2) : ");
			int user = Integer.parseInt(sc.nextLine());
			
			if(user > 2) {
				break;
			}else if(user == com) {
				System.out.printf("사람 %d, 컴 %d 비겼음\n", user, com);
			}else if(user == ( com + 1 ) % 3) {
				System.out.printf("사람 %d, 컴 %d, 사람 승리!!\n", user, com);
			}else {
				System.out.printf("사람 %d, 컴 %d, 컴 승리!!\n", user, com);
			}			
			
//			if(user > 2) {
//				break;
//			}else if(user == 0 && com == 2 
//					|| user == 1 && com == 0 
//					|| user == 2 && com == 1) {
//				System.out.printf("사람 %d, 컴 %d, 사람 승리!!\n", user, com);
//			}else if(com == 0 && user == 2 
//					|| com == 1 && user == 0 
//					|| com == 2 && user == 1) {
//				System.out.printf("사람 %d, 컴 %d, 사람 승리!!\n", user, com);
//			}else {
//				System.out.printf("사람 %d, 컴 %d 비겼음\n", user, com);
//			}			
		}		
		System.out.println("game over");
		sc.close();		

		
		
		

	}//end main

}//end class
