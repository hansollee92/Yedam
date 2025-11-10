package day4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	
	public static int menuInput() throws InputMismatchException, MenuException {
		                         // ②에러를 여기서 처리하는 것이 아니라 호출하는 쪽으로 던짐
		
		Scanner sc = new Scanner(System.in);
		System.out.println("가위(1), 바위(2), 보(3), 종료(0): ");
		
		int user;
		user = sc.nextInt();
		// ① 에러를 직접적으로 처리할수도 있고
//		try {
//			user = sc.nextInt();
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//			user = 0;
//		}
		
		// 프로그램오류는 아니지만 업무규칙위배로 인해 일어날 수 있는 오류이기 때문에 에러처리
		if(user > 3) {
			throw new MenuException("입력범위 오류");
		}
		
		return user;
	}
	
	public static void main(String[] args) {
		
		int menu = 0;
		// try-catch-..-catch는 if else if else와 비슷하다. 
		try {
			menu = menuInput();
		} catch (InputMismatchException e) { 
			System.out.println(e.getMessage());
			menu = 0;
		} catch (MenuException e) {   
			//e.printStackTrace(); 
			System.out.println(e.getMessage());
			menu = 1;
		} catch(Exception e) {
			e.printStackTrace(); 
			// 이게 맨 위로 올라가면 오류남 Exception은 항상 젤 마지막! 
		}
		
		System.out.println(menu);
		System.out.println("the end");
		
		
	}
}
