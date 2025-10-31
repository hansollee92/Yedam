package chap05;

import java.util.Calendar;

public class Exam230 {

	public static void main(String[] args) {
		// 요일 
		
		Calendar today = Calendar.getInstance();            
		System.out.println(today);                          //날짜객체를 가져오는 방법

		Week day = null;
		int dayNo = today.get(Calendar.DAY_OF_WEEK);
		switch(dayNo) {
		case 1: day = Week.일요일; break;      //객체로 다 저장되어있음(주소) day도 주소, Week.일요일도 주소! 
		case 2: day = Week.월요일; break;
		case 3: day = Week.화요일; break;
		case 4: day = Week.수요일; break;
		case 5: day = Week.목요일; break;
		case 6: day = Week.금요일; break;
		case 7: day = Week.토요일;
		}
		
		System.out.println("오늘은 " + day + "입니다");
		
		
		// 상수 만드는 방법!!
		// 맨날 스펠링 틀리면 그러니깐... 이렇게 상수로 만들어두고 사용할 수 있게 하는 방법
		// (한정된 데이터)
		// 
		
		// 상수가 객체다!
		// 그래서 주소가 있다!
		
	}//end main

}//end class
