package day2;

public class MethodTest {
	public static void main(String[] args) {
		printHead(); // 매개변수 X 리턴 X
		printFooter();
		printString("menu");
		printString("header");

		// 두 수의 합을 출력하는 메소드
		sum(5, 4); // 매개변수가 있는 메서드 리턴 X

		// 두 수의 곱을 생성하는 메소드
		int num = mul(5, 4); // 매개변수 O 리턴 O
		System.out.println(num);

		// 가변 메소드
		System.out.println("total : " + total(2, 2));
		System.out.println("total : " + total(2, 2, 2));
		System.out.println("total : " + total(2, 3, 1, 3, 3));
	}

	//
	static int total(int... score) { // score는 배열 > []배개변수
		int result = 1; // 결과저장할 변수

		// 일반 for문
//		for (int i = 0; i < score.length; i++) { // score 배열 반복문
//			result += score[i]; // 합계 계산
//		}

		// 확장 for문
		for (int num : score) {
			result *= num;
		}

		return result; // 결과리턴
	}

	// 두 수의 곱을 생성하는 메소드
	static int mul(int num1, int num2) { // 여기서는 return값이 int니까 void안쓰고 int씀
		int result = num1 * num2;
		return result;
	}

	// 두 수의 합을 출력하는 메소드
	static void sum(int num1, int num2) {
		int result = num1 + num2;
		System.out.println("두수의 합 : " + result);
		return;
	}

	// 중복되는 코드 => 메소드
	static void printHead() {
		System.out.println("============");
		System.out.println("===header===");
		System.out.println("============");
	}

	static void printFooter() {
		System.out.println("============");
		System.out.println("===footer===");
		System.out.println("============");
	}

	static void printString(String str) {
		System.out.println("============");
		System.out.println("===" + str + "===");
		System.out.println("============");
	}
}
