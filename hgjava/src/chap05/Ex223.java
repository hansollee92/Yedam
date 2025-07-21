package chap05;

import java.util.Scanner;

public class Ex223 {

	public static void main(String[] args) {
		// p223 문제6번
		
		// 키보드로부터 학생수와 학생들의 점수를 입력받아
		// 최고 점수 및 평균점수를 구하는 프로그램
		
		// switch문 이용 
			// 1.학생수 받아서 => 배열의 크기 잡아줌
			// 2.배열의 크기만큼 학생 점수 입력 받아 줌
			// 3. 배열에 저장된 학생 점수 출력해 주 ㅁ
			// 4. 점수 중 최고 점수와 평균점수 계산해서 출력
			// 5. 프로그램 종료
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		int max = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			
			System.out.print("선택> ");
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch(selectNo) {
			case 1:
				System.out.print("학생수> ");
				studentNum = Integer.parseInt(sc.nextLine());
				scores = new int[studentNum];
				break;
			case 2:				
				for(int i=0; i<scores.length; i++) {
					System.out.printf("scores[%d]> ", i);
					scores[i] = Integer.parseInt(sc.nextLine());
				}
				break;
			case 3:
				for(int i=0; i<scores.length; i++) {
					System.out.printf("scores[%d]> %d\n", i, scores[i]);
				}
				break;
			case 4:
				for(int i=0; i<scores.length; i++) {
					sum += scores[i];
					if(max < scores[i]) {
						max = scores[i];
					}
				}
//				for(int score : scores) {
//					sum += score;
//					if(max < score) max = score;
//				}				
				double avg = (double) sum / scores.length;
				System.out.printf("최고 점수: %d\n", max);
				System.out.printf("평균 점수: %f\n", avg);
				break;
			default:
				run = false;
			}
						
		}		
		System.out.println("프로그램 종료");			
		sc.close();		

	}//end main

}//end class
