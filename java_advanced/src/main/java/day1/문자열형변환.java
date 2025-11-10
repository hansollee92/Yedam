package day1;

/*
 * 래퍼클래스
 * char		 int 	 long float double
 * Character Integer Long Float
 * 1. 객체화(내일 클래스 하면서 자세하게 설명)
 * 2. 형변환
 */
public class 문자열형변환 {
	public static void main(String[] args) {
		String strAge = "20";
		// String => int
		int age = Integer.parseInt(strAge);
//		Integer age = Integer.parseInt(strAge); 인트를 인테저에 인테저를 인트에 박싱 언박싱
//		왜 integer를 쓸까? 답은 null값이 가능하기때문에
//		단순 int에는 null값이 들어가면 오류가나는데 integer를하면 null값이 들어갈 수 있다. 
		
		System.out.println(age);
		System.out.println(strAge);
		// int => String
		strAge = Integer.toString(age);
		
		System.out.println(Character.isDigit('a'));	// false 숫자아니라서
		System.out.println(Character.isDigit('1'));	// true 숫자라서
	}
}
