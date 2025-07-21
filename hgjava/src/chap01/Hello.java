package chap01;

/*Java는 객체지향언어이기 때문에 이 안에서 '변수', '함수'라고 사용하지 않음 > '필드', '메소드'라고 사용한다.
public 공용, static 고정되었다, void = 이 메소드는 리턴값이 없다
main(String[] args) 자바 실행, String[] args -- 매개변수 (문자열 배열이고 'args(아그스)'이름의 매개변수)
{} 이 안의 것을 실행해줘!*/

public class Hello {

	public static void main(String[] args) {
		// 출력문
		System.out.println("hello java!!");
		// 자바에서는 자바스크립트와 다르게 문자열은 ""안에 넣어야함!
		// 시스템에 출력(out)하는데 println(한줄로 표시하는) 걸로 하겠다
		
		int a = 7;
		System.out.println(a);
		// 변수를 설정해두고 쓰지 않으면 노란색으로 표시됨
		
		// 변수의 값 교환
		int x = 10;
		int y = 50;
		int temp = y;
		y = x;
		x = temp;
		
		System.out.println("x=" + x + " y=" + y);		
		
		
		// 기본타입
		char font = 'A';
		int intChar = font + 1;
		char font2 = (char)intChar;  //그냥 intChar하면 안되는게 int를 char에 넣을려고 하니 크기값이 큰걸 작은데 넣을려고 하니 안됨
		System.out.println(font);    //글자A 출력
		System.out.print(intChar + "\n");  //65숫자 출력
		System.out.println(font2);    //글자B 출력
		
		
		// 문자열 저장 => String 객체타입 변수 생성
		String str = "홍길동";
		System.out.println(str);
		
		
		// 연산 : 정수 => 기본타입 int, 실수 => 기본타입 double
		int su1 = 1;
		int su2 = 3;
//		int result = su1 / su2;
		double result = su1 / su2;    // int / int = int
		
		// 결과 = 0.33333...
		result = (double) su1 / su2;
		System.out.println(result);

		
		
		// 25-07-15-화요일
		// p143 문자열비교 ---------------------------------------------------------------------------------------
		String str1 = "신용권";
		String str2 = "신용권";
		String str3 = new String("신용권"); // 새로운 객체를 만들어서 거기에 '신용권'저장해줘
		boolean resultStr = str1 == str2;
		boolean resultobj = str2 == str3;
		System.out.println(resultStr); // 객체 주소 비교 => 같은 객체인지 확인 (같은객체, true)
		System.out.println(resultobj); // 객체 주소 비교 (다른객체, false)
		System.out.println(str1.equals(str3));  //객체데이터비교
		
		//          변수           주소    힙
        // str1  -- 100    ----> 100   "신용권" (리터럴 신용권)
		// str2  -- 100    ---->
		// str3  -- 200    ----> 200   "신용권" (객체 새로 잡아 넣은 신용권)
		// 
		// resultStr은 같은 주소여서 true => 같은 객체
		// resultobj은 다른 주소여서 false 
		
		
		// &=, |=, ^= 연산 -------------------------------------------------------------------------------------
		int r1 = 1 & 2; 
		int r2 = 1 | 2;
		int r3 = 1 ^ 2;
		System.out.println("and 연산 = " + r1);
		System.out.println("or 연산 = " + r2);
		System.out.println("xor 연산 = " + r3);
		
		/* 결과값이 0,3,3으로 나타나는 이유는 아래와 같다
		       2진수
		 1 -->  0 1
		 2 -->  1 0
		       -----
		    and 0 0 ----> 10진수 변환 : 0
		    or  1 1 ---->          : 3
		    xor 1 1 ---->          : 3
		 */
		
		// 몸풀기 연습문제 ----------------------------------------------------------------------------------------
		// 수 20이 4의 배수이면서 5의 배수인지 체크(if)
		// '결과 = 20은 4와 5의 배수 입니다' 출력(printf)
		// 아니면 20은 4와 5의 배수가 아닙니다  출력
		int su = 55;
		if(su % 4 == 0 && su % 5 == 0) {
			System.out.printf("%d은 4와 5의 배수입니다\n", su);
		}else {
			System.out.printf("%d은 4와 5의 배수가 아닙니다\n", su);
		}
		// (??) if조건에서 &, &&의 차이는?
		
		// 홀수 짝수 구별 (삼항연산자)
		// 수는 20을 이용
		String result12 = (su % 2 == 0) ? "짝수" : "홀수";
		System.out.println(result12);
		
		
		
		
		
		

	}//end main

}//end class
