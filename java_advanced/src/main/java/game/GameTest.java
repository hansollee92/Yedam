package game;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
//		// 2. 객체로 생성
//		RockPaperScissors rps = new RockPaperScissors();
//		
//		// 3. 객체 사용
//		rps.start();

		Scanner sc = new Scanner(System.in);

		game: while (true) {
			// 게임 시작할 때 나타나는
			System.out.println("게임선택: 1.가위바위보  2.숫자맞추기  0:종료");
			int menu = sc.nextInt(); // 게임선택 입력받기

			// 입력받은 게임 선택하는 switch 조건문
			switch (menu) {
			case 1: // 1번게임, 가위바위보
				new RockPaperScissors().start(); // 요런식으로 바로 객체생성 후 사용가능한듯
				break;
			case 2: // 2번게임, 숫자맞추기
				new GuessNum().start();
				break;
			case 0: // 0번게임
				break game;
			} // end switch
		} // end while
		System.out.println("게임종료");
	} // end main
} // end class
