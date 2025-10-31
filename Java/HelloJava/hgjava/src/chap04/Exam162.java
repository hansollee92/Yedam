package chap04;

public class Exam162 {

	public static void main(String[] args) {
		// 주사위 게임 --------------------------------------------------------------------------------------------------
		// 주사위를 2개 던져서 합이 10을 넘으면 두수를 더하고 > 덧셈결과 : 000
		// 아니면 두수를 곱한 결과를 출력 > 곱셈결과 : 000
		
		int dice1 = (int)(Math.random() * 6) + 1;
		int dice2 = (int)(Math.random() * 6) + 1;
		
		int resultDice = dice1 + dice2;
		if(resultDice > 10) {
			System.out.printf("%d + %d = %d\n", dice1, dice2, resultDice);
		}else {
			System.out.printf("%d * %d = %d\n", dice1, dice2, dice1 * dice2);
		}		
		
		
		// 오전시간(9~12) 일정 출력 --------------------------------------------------------------------------------------
		// 현재 시간 확인
		// 9시 : 출근합니다
		// 10시 : 회의합니다
		// 11시 : 업무를 봅니다
		// 12시 : 외근을 나갑니다		
		
		int time = (int)(Math.random()*4) + 9;  		 // (!!)n값(여기선4) 빨리 구하는 방법 : 12-9+1 이렇게 계산
		System.out.println("현재 시간 : " + time);
		switch(time) {
		case 9:
			System.out.println("출근합니다");
		case 10:
			System.out.println("회의합니다");
		case 11:
			System.out.println("업무를 봅니다");
		default:
			System.out.println("외근을 나갑니다");
			break;
		}
		System.out.println("오늘 일정 끝");
		
		
		
		// p169 3번문제 if문을 switch문으로 바꾸기 ------------------------------------------------------------------------
		int score = 85;
		System.out.print("등급은 ");			
		switch(score / 10) {
		case 10 :
		case 9 :
			System.out.print("A");
			break;
		case 8 :
			System.out.print("B");
			break;
		case 7 :
			System.out.print("C");
			break;
		default :
			System.out.print("D");
			break;
		}
		System.out.println("입니다.");
		// switch는 if와 다르게 범위를 설정할 수가 없으니 
		// score값에서 10의 자리수만 가져와서 그 수를 나오게 하는 방법으로 설정할 수 있다 
		
		
		
		// 주사위 게임 ------------------------------------------------------------------------------------------------
		// 주사위 2개를 던져서 합이 10이 되면 탈출 (for문)
		// 주사위 순서쌍 출력 ex) (5,2)
		// 5회이상 되면 게임 오버 출력
		
		// 주사위 2개를 5회 던진다(for)
		for(int i=1; i<6; i++) {
			// 주사위 2개 발생
			int dice3 = (int)(Math.random()*6) +1;
			int dice4 = (int)(Math.random()*6) +1;
			
			//순서쌍 출(2,10)			
			System.out.printf(i + "회:" + "(%d,%d)\n", dice3, dice4);
			
			//두개의 합이 10이면 탈출 => 탈출
			if(dice3 + dice4 > 10) {
				System.out.println("게임 성공");
				break;
			}
		}
		System.out.println("게임오버");
		
		
		
		// 반복문 --------------------------------------------------------------------------------------------------
		int i;
		for(i=1; i<=5; i++) {
			System.out.println("i = " + i);
		}
		System.out.println("탈출 1~" + (i-1) + "까지");
		// i가 6일 때 for문을 탈출하니 i값은 6이다. 
		// p174 (i-1)을 해준 이유
		// 하지만 i는 for문안에서 사용해주는게 젤 좋다
		
		
		
		
		

	}//end main

}//end class
