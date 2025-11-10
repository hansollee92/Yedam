package day1;

import java.util.Random;
import java.util.Scanner;

public class 가위바위보2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String user = ""; // 사용자값
		String username = ""; // 사용자이름
		int computer = 0; // 컴퓨터난수값
		String computerSelect = ""; // 컴퓨터 난수값 문자로 바꾼값
		int draw = 0; // 총 무승부값
		int win = 0; // 총 승리값
		int lose = 0; // 총 패배값
		int setWin = 0; // 세트 승리값
		int setLose = 0; // 세트 패배값

		// 사용자이름 입력 출력
		System.out.print("사용자 이름을 입력해주세요 : ");
		username = scanner.next();
		System.out.println(username + "님 오신것을 환영합니다.");
		// 세트 단위 반목문
		while (true) {
			int gameWin = 0; // 1게임 승리값
			int gameDraw = 0; // 1게임 무승부값
			int gameLose = 0; // 1게임 패배값

			// 1게임 단위 반복문
			while (true) {
				// 메뉴출력
				System.out.print("[가위|바위|보] 중에 하나 입력해주세요 : ");

				// 사용자 값을 입력(가위 바위 보 종료 중에 하나)
				user = scanner.next();

				// 가위 바위 보 가 아니면 다시 입력
				if (!user.equals("가위") && !user.equals("바위") && !user.equals("보"))
					continue; // continue 다시 처음으로 가서 실행하는거

				// 컴퓨터의 선택 난수 생성
				computer = random.nextInt(3) + 1;

				// 컴퓨터 난수 -> 글자 로 변환
				if (computer == 1) {
					computerSelect = "가위";
				} else if (computer == 2) {
					computerSelect = "바위";
				} else if (computer == 3) {
					computerSelect = "보";
				}

				// 사용자와 컴퓨터 선택 출력
				System.out.print("사용자 : " + user + " / " + computerSelect + " : 컴퓨터 / ");

				// 승패 판정 로직
				if (user.equals(computerSelect)) {
					System.out.println("무승부!");
					draw++;
					gameDraw++;
				} else if ((user.equals("가위") && computerSelect.equals("보"))
						|| (user.equals("바위") && computerSelect.equals("가위"))
						|| (user.equals("보") && computerSelect.equals("바위"))) {
					System.out.println("사용자 승리!");
					win++;
					gameWin++;
				} else {
					System.out.println("컴퓨터 승리!");
					lose++;
					gameLose++;
				}

				// 현재 게임에서 몇승 몇패인지
				System.out.println("---------------현재승패----------------");
				System.out.println("승:" + gameWin + ", 무승부:" + gameDraw + ", 패:" + gameLose);
				System.out.println("-------------------------------------");

				// 만약에 3판 2선승제니까 2승을 하면 게임 종료
				if (gameWin == 2) {
					System.out.println("먼저 2승을 달성하였습니다, 세트 승리!");
					setWin++;
					break;
				} else if (gameLose == 2) {
					System.out.println("컴퓨터가 먼저 2승을 달성하였습니다, 세트 패배!");
					setLose++;
					break;
				}
			} // end while

			// 현재 전적 출력
			System.out.println("==================전적결과===================");
			System.out.println("현재 전적 : " + win + "승 " + draw + "무 " + lose + "패");
			System.out.println("세트 승 : " + setWin + ", 세트 패배 : " + setLose);
			System.out.println("==========================================");

			// 게임을 이어서 하고 싶은지에 대한 질문
			String gameKeep = ""; // 게임을 계속 이어나가고 싶은지 에 대한 변수
			System.out.print("게임을 계속 진행하시겠습니까?(y/n) : ");
			gameKeep = scanner.next();

			// y 입력받을경우
			if (gameKeep.equals("y"))
				continue;
			// n 입력받을경우
			if (gameKeep.equals("n"))
				break; // while 문 빠져나가는거

		} // end while
		System.out.println("================" + username + "님의 최종전적결과=================");
		System.out.println("최종 결과 : " + win + "승 " + draw + "무 " + lose + "패");
		System.out.println("총 세트 승 : " + setWin + ", 총 세트 패배 : " + setLose);
		System.out.println("==============================================");
	}// end main

}// end class
