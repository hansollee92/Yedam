package chap06_1;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);       
		boolean run = true;   
		
		int user_bookNo = 0;    // 사용자한테서 입력받을 책수를 저장할 변수 선언 및 초기화(0)
		
		BookData bk = new BookData();   //
		Book[] bookDao = bk.bookData(user_bookNo);         
		
		while(run) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1.도서수 입력 2.도서정보 등록 3.도서정보 전체조회 4.도서정보 분석 5.종료");
			System.out.println("-------------------------------------------------------");
			
			System.out.printf("선택> ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case 1:
				System.out.printf("도서 수> ");
				user_bookNo = Integer.parseInt(sc.nextLine());
				break;
			case 2:
				bookDao = bk.bookData(user_bookNo);
				break;
			case 3: 
				for(int i=0; i<bookDao.length; i++) {
					System.out.println(bookDao[i].bookInfo());
				}
				break;
			case 4:
				//최고가격
				int max = 0;
				for(int i=0; i<bookDao.length; i++) {
					if(max < bookDao[i].getPrice()) max = bookDao[i].getPrice();
				}
				System.out.printf("최고 가격 : %d\n", max);
				//최저가격
				int min = 99999999;
				for(int i=0; i<bookDao.length; i++) {
					if(min > bookDao[i].getPrice()) min = bookDao[i].getPrice();
				}
				System.out.printf("최저 가격 : %d\n", min);
				//평균가격(소수 첫째 자리)
				int sum = 0;
				for(int i=0; i<bookDao.length; i++) {
					sum += bookDao[i].getPrice();
				}
				double avg = (double)sum / bookDao.length ;
				System.out.printf("평균 가격은 %.3f원 입니다.\n", avg);
				break;
			default : 
				run = false;
			}
			
		}//end while
		System.out.println("프로그램 종료");
				
		sc.close();
		

	}//end main

}//end class
