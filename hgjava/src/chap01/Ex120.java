package chap01;

import java.util.Scanner;

public class Ex120 {

	public static void main(String[] args) {
		// p120 문제1 -------------------------------------------------------------------------------------------------
		String name = "감자바";
		int age = 25;
		String tel1 = "010", tel2 = "123", tel3 = "4567";   //모두 타입이 같은 경우 이런식으로 이어서 작성도 가능
		System.out.println("이름: " + name);
		System.out.print("나이: " + age + "\n");
		System.out.printf("전화: %s-%s-%s\n", tel1, tel2, tel3);	//printf는 줄바꿈이 되지 않기 때문에 마지막에 \n 넣어주기
		
		// p120 문제2 --------------------------------------------------------------------------------------------------
		Scanner sc = new Scanner(System.in);
		// 클래스 Sacnner에 sc 이름으로 하나 만들어줘 = 객체 새로 만들껀데(new) Scanner 클래스의 생성자를 이용하여 System.in 표준입력장치로 할꺼야
		// import 단축키 [Ctrl] + [Shift] + [o] 로 import java.util.Scanner; 를 작성해야지 컴파일할때 Scanner클래스를 찾아갈 수 있음
		
		System.out.print("수1 입력 >");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("수2 입력 >");
		int num2 = Integer.parseInt(sc.nextLine());
		
		int result = num1 + num2 ; 
		System.out.println("덧셈 결과= " + result);
		// sysout빨리쓰기 단축키 : [ctrl] + [space]
		// 주석 빨간줄 끄기:window>Preferences>General>Editors>Text Editors>Spelling : Enable spell checking 항목 체크 해제 
		
		sc.close();
		
		
		
		
		
		
		
		
		
		
	}//end main

}//end class
