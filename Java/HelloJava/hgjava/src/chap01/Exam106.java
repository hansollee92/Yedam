package chap01;

import java.io.IOException;

public class Exam106 {

	public static void main(String[] args) throws IOException {
		// 문자열 => 숫자
		String str = "10";
		String str2 = "3.14";
		String str3 = "true";
		
		boolean srt3B = Boolean.parseBoolean(str3);
		if(srt3B) {
			System.out.println("타입 변경 성공");
		}else {
			System.out.println("타입 변경 실패");
		}
		
		int strInt = Integer.parseInt(str);
//		int str2Double = Integer.parseInt(str2); 타입오류
		double str2Double = Double.parseDouble(str2);
		
		System.out.println(strInt + str2Double);
		System.out.println(str + str2);  // 문자열이여서 그냥 합쳐짐
		
		
		//p109 5번		
		char c1 = 'a';
		char c2 = (char)(c1 + 1);
		System.out.println(c2);
		
		//p109 6번
		int x = 5;
		int y = 2;
		double result = x / y ;
		System.out.println(result);
		
		//p109 7번
		int x1 = 5;
		int y1 = 2;
		double result1 = (double) x1 / y1 ;
		System.out.println(result1);
		
		//p109 8번
		double var1 = 3.5;
		double var2 = 2.7;
		int result2 = (int)(var1 + var2);
		System.out.println(result2);
		
		//(!!!)9번
		long var5 = 2L;
		float var6 = 1.8f;
		double var7 = 2.5;
		String var8 = "3.9";
		int result3 = (int)(var5 + var6 + var7) + (int)Double.parseDouble(var8);
		System.out.println(result3);
		System.out.printf("정수 %d,실수 %.1f,실수 %5.2f,문자열 %s,결과 %d\n", var5, var6, var7, var8, result3);

		
		// 표준 입력장치로 키값(유니코드) 입력 받음
//		try {
//			while(true) {
//				System.out.print("문자를 입력하세요>>");
//				int keyCode;
//				while(true) {
//					keyCode = System.in.read();
//					System.out.println(keyCode);
//					if(keyCode == 10) {
//						break;
//					}
//					if(keyCode == 113) {
//						break;
//					}
//				}
//				if(keyCode == 113) {
//					System.out.println("종료");
//					break;
//				}
//			}
//		} catch (IOException e) {
//			System.out.println("입력오류 발생");
//		}
		
		int keyCode;
		
		while(true) {
			keyCode = System.in.read();
			System.out.println(keyCode);
			if(keyCode == 113) {
				break;
			}
		}
		System.out.println("종료");
		//예외처리방법 try-catch방법 / 호출하는애한테 throw 

	}// end main

}// end class
