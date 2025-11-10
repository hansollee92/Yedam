package game;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {
	public void start() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int user = 0; // 사용자값
		int computer = 0; // 컴퓨터난수값
		int userRetry = 0; // 재시도 입력값

		while (true) {
			int count = 0; // 시도 횟수
			// 메뉴출력
			System.out.print("게임을 시작합니다. 숫자를 입력해주세요 : ");

			// 컴퓨터의 선택 생성
			computer = (int) (Math.random() * 10) + 1;

			while (true) {
				// 사용자 값을 입력
				user = scanner.nextInt();

				count++;
				System.out.println("시도횟수 : " + count);
				if (user == computer) {
					System.out.println("정답입니다!");
					break;
				} else if ((user > 100) || (user < 1)) {
					System.out.println("입력값이 범위에서 벗어났습니다.");
				} else if (user > computer) {
					System.out.println("Down" + computer);
				} else if (user < computer) {
					System.out.println("Up" + computer);
				}

			} // end while

			System.out.println("다시 시도하시겠습니까? 다시시도:1, 취소:아무거나 누르세요 ");
			userRetry = scanner.nextInt();

			if (userRetry == 1) {
				continue;
			} else {
				break;
			}

		} // end while
	}
}
