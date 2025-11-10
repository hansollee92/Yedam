package day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열과반복문3 {

	public static void main(String[] args) {
		ArrayList<Integer> score = new ArrayList<Integer>();
		// list에 값을 넣을때 1번방법
		score.add(5);
		score.add(4);
		score.add(3);
		score.add(5);
		score.add(2);
		// list에 값을 넣을때 2번방법		
		List<Integer> list2 = (List<Integer>)Arrays.asList(5,4,3,5,2);
		
		// 통과된 건수를 저장할 변수를 선언
		int passCount = 0;
		
		// 성적 출력
		for(int i = 0; i < score.size(); i++) {
		
			// 출력
			System.out.print(score.get(i) + " ");
			
			// 통과여부출력 (3점이상이면 success / fail)
			if(score.get(i) >= 3) {
				System.out.println("success");
				passCount++;
			} else {
				System.out.println("fail");
			}
		}// end for
		// 통과된 건수 출력
		System.out.println("통과한 성적 갯수 : " + passCount);

	}

}
