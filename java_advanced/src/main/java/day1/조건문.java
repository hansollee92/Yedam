package day1;

public class 조건문 {

	public static void main(String[] args) {
		// 문제1번
		/*
		 * 근무시간(9~18) 맞으면 Y / N
		 */
		int workTime = 10;
		if(workTime >= 9 && workTime <= 18) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
		
		// 문제2번
		int sTime = 9;
		int eTime = 18;	// 점심시간 1시간 빼고
		// 총근무시간이 8시간이상이면 "초과근무" 출력
		int totalTime = eTime - sTime - 1;	// 총근무시간
		if(totalTime >= 8) {
			System.out.println("초과근무");
		} else {
			System.out.println("정상근무");
		}
		
	}

}
