package 이한솔;

import java.util.Scanner;

public class Report3 {

	public static void main(String[] args) {
		// 숫자 추측 게임
		
		// 1~100까지의 수를 발생
		// 어떤 수인지 알아 맞히는 게임 프로그램
		
		// 실행 결과 
		// 숫자 입력 : ___
		// down하세요! or up하세요! or 축하합니다!
		
		Scanner sc = new Scanner(System.in);
		
		int number = (int)(Math.random()*100) + 1;
		while(true) {
			System.out.print("숫자 입력 : ");
			int userNum = Integer.parseInt(sc.nextLine());
			if(userNum > number) {
				System.out.println("down하세요!!");
			}else if(userNum < number) {
				System.out.println("up하세요!!");
			}else {
				System.out.println("축하합니다!!");
				break;
			}
		}
		sc.close();	

	}

}
