package chap06_1;

import java.util.Scanner;

public class BookData {
	
	//필드
	//생성자
	//메소드
	
	Scanner sc = new Scanner(System.in);
	// 리턴값이 없으면 void를 작성
	// 있으면 리턴값과 일치하는 데이터타입을 작성해줘야함
	Book[] bookData(int n) {
		           //여기서 n은 배열의 크기를 결정해주는 매개변수
		
		Book[] bookDao = new Book[n]; 
				
		for(int i=0; i<n; i++) {
			
			System.out.printf("%d 번째 도서 정보 입력\n", i+1);
			
			System.out.print("도서번호> ");			
			int bookNo = Integer.parseInt(sc.nextLine());
			
			System.out.print("도서제목> ");			
			String title = sc.nextLine();
			
			System.out.print("도서가격> ");			
			int price = Integer.parseInt(sc.nextLine());
			
			bookDao[i] = new Book(bookNo, title, price);
		}
		
		return bookDao;		
	}

}
