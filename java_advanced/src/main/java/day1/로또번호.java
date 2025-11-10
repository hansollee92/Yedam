package day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * 요구사항 :
 * 1. 난수 6개 생성해서 리스트에 저장
 * 2. 1 ~ 15
 * 3. 중복값 허용 안됨
 */
public class 로또번호 {

	public static void main(String[] args) {
		Random random = new Random();
		// 리스트 변수 선언 ==> 중복값 제거하려면 Set을
//		ArrayList<Integer> list = new ArrayList<Integer>();
		Set<Integer> list = new HashSet<Integer>();
		// while(list.size() < 6)
		while (list.size() < 6) {
			// 난수생성(1 ~ 20)
			int randomNum = random.nextInt(20) + 1;
			// 리스트에 추가 ( add() )
			list.add(randomNum);
		}
		// 결과출력
		System.out.println(list);

	}// end main

}// end class
