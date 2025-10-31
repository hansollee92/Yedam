package day1;

public class 배열과반복문2 {

	public static void main(String[] args) {
		// 성적 5개
		int[] score = {5,4,3,5,2};
		
		// 통과된 건수를 저장할 변수를 선언
		int passCount = 0;
		
		// 성적 출력
		for(int i : score) {
			// 출력
			System.out.print(i + " ");
			
			// 통과여부출력 (3점이상이면 success / fail)
			if(i >= 3) {
				System.out.println("success");
				passCount++;
			} else {
				System.out.println("fail");
			}
		}
		// 통과된 건수 출력
		System.out.println("통과한 성적 갯수 : " + passCount);

	}

}
