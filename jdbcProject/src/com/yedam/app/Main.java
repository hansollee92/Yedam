package com.yedam.app;

import java.util.ArrayList;
import java.util.Scanner;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

// 사용자 입력 -> DB반영.
// DB결과 -> 콘솔출력.
// 컨트롤
//public class Main {
//	public static void main(String[] args) {		
//		//-- DBUtil.java에서 오라클DB와 연결한 것이 잘 연결되었는지 확인하기 위해서 아래와 같이 작업을 해보자
//		
//		DBUtil util = new DBUtil();     
//		Connection conn = util.getConnect();   //DB 세션확보.	
//		// ① DBUtil.java에서 만든 getConnect()메서드를 실행하여 오라클DB에 연결
//		//   연결 성공하면 conn에 Connection 객체가 들어오게 됨
//		
//		
//		// --conn.setAutoCommit(false);    //setAutoCommit을 false로 해주면 자동커밋이 되지 않음
//		// --insert, update도 해야하는데 (예:송금) 그런 경우에 명시적으로 내가 커밋을 해줄수 있게 위에처럼 작성해야함. 	
//		
//		// --Statement stmt = conn.createStatement(); 를 누르면 오류가 뜨는데 shit ctrl o 하고
//		// --오류가 뜨면 Surroudn try/catch를 눌러서 아래와 같이 만들어줌
//		try {
//			Statement stmt = conn.createStatement();   // 쿼리해석 실행 -> 반환.
//			// ② SQL문을 실행하기 위해선 Statement객체 필요
//			//   SQL을 실행할 수 있는 실행기를 만들고 있음
//						
//			int r = stmt.executeUpdate("insert into book(id, title, author) values(1010, '어린왕자', '김어린')");	//데이터 넣어보기 	
//			System.out.println("처리된 건수: " + r);
//			// ③ executeUpdate()는 insert/update/delete와 같은 쿼리를 실행할 때 사용
//			//   실행 결과로 몇 행이 영향을 받았는지(int) 반환해줌(r이 1이면 1개의 행이 삽입된 것)
//			
//			//--if(r>0) {  //r>0 뜻 : 뭐가 입력되었을 때
//			//--	conn.commit();   //커밋.     (커밋을 안하면 sql에서 데이터 보이지 않음)
//			//--}
//			//-- 오류뜨는데 자동커밋이 되었기 때문 (위에서 conn.setAutoCommit(false); true값으로 되어있던걸 false값으로 해줘야지 이 삽입성공확인 조건문 사용 가능)
//			// ④ 삽입에 성공했는지 확인하는 조건문			
//			
//			ResultSet rs = stmt.executeQuery("select * from book");   //--ResultSet 클래스는 결과값을 넣어둘 수 있는 클래스임 이것의 반복문을 통해 데이터를 추출해냄
//			// ⑤ DB에서 데이터를 가져오려면 executeQuery()를 사용
//			//   결과는 ResultSet이라는 테이블 모양의 자료구조로 반환된다.			
//			
//			//반복문. Listener
//			while(rs.next()) {   //--for반복문보다는 while반복문을 많이 사용함
//				// --https://breakthedays.tistory.com/92 이미지 참고
//				// --rs.next()가 true면 반환해주는데 (cursor가)
//				// ⑥ rs.next()는 결과 행이 하나씩 있을 때마다 true를 반환하면서 한 줄씩 이동함
//				
//				System.out.println(rs.getInt("id")+rs.getString("title"));  //--get~뭐시기 들은 보통 데이터를 가져옴(타입에 맞게 데이터 가져오기)
//				// ⑦ rs.getInt() : 데이터 값을 가져옴
//			}
//			System.out.println("end of data");
//			// --그냥 위의 값을 실행을 하면 데이터가 없이 그냥 end of data만 가져오는데 
//			// --오라클에서 커밋을 해주지 않았기 때문이다. (??세션을 가져와서 작업이 진행되는데? 커밋하기 전까지는 세션을 볼 수가 없고? 커밋을 해야지 DB에 영구적으로 반영이 된다)
//			/*
//			  세션(session) 
//			  : 데이터베이스와 사용자가 연결된 하나의 작업 공간
//			  
//			  자바에서 Connection을 만들면 → 그 순간, DB랑 연결된 하나의 세션(Session)이 생성된다.
//			  이 세션은 Java와 오라클이 대화를 주고받는 통로이자 작업이 진행되는 공간
//			  
//			  
//			  
//			 */
//				
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//				
		
		// cmd - ipconfig 명령어 하면 본인의 아이피를 확인할 수 있는데 
		// 이 아이피를 통해서도 접속을 할수가 있는데 
		// 오라클 디벨로터로 들어가서 새로 만들기> localhost되어 있는데에 아이피 입력
		// (접속 오래 걸리면 : 방화벽>고급설정>인바운드규칙>새규칙>포트>특정포트1521>연결허용>오라클접속요청이름설정 만들기)
		// 옆사람 ip에 접속해서 아래 작성해서 실행해보기!
		// select * from tab;
		// select * from book; 으로 확인가능
		
		
		
		// ----------------------------------------------------------------------------------------------------------------------------
		
		// 위에서는 직접적으로 데이터를 직접 넣었지만
		// 실제로는 사용자한테 입력값을 받아야한다. ---> BookDAO class 만들고 method 만들기
		
		
//	}
//}

public class Main {
	public static void main(String[] args) {		
		boolean run = true;    //반복조건에 사용.
		Scanner scn = new Scanner(System.in);
		BookDAO dao = new BookDAO();  //도서목록을 조회.
		while(run) {
			System.out.println("―――――――――――――――――――――――――――――――――――");
			System.out.println("📚 도서 관리 시스템");
			System.out.println("1. 도서목록");
			System.out.println("2. 도서등록");
			System.out.println("3. 도서수정");
			System.out.println("4. 도서삭제");
			System.out.println("9. 종료");
			System.out.println("―――――――――――――――――――――――――――――――――――");
			System.out.print("> 선택: ");
			int menu = scn.nextInt();   //입력값을 menu 변수에 대입
			switch(menu) {
			case 1: //도서목록.
				ArrayList<Book> list = dao.findAll(); //반환값이 ArrayList<Book>
				System.out.println("도서번호\t도서명\t\t저자\t가격");
				System.out.println("-----------------------------------");
				for(int i=0; i<list.size(); i++) {
					System.out.println(list.get(i).getId()+"\t"+
				                       list.get(i).getTitle()+"\t"+
							           list.get(i).getAuthor()+"\t"+
				                       list.get(i).getPrice());
				}//end of for.
				break;
			case 2: //도서등록.
				System.out.print("> 도서번호: ");
				int bno = scn.nextInt();scn.nextLine();            //반환값 int
				// nextInt()는 사용자가 1003을 넣고 엔터를 쳤을 경우 사용자가 입력했던 '1003'만 읽어서 담아준다. 엔터가 처리되지 않았다. 
				// nextLine()은 엔터까지 모두 처리해준다. 그래서 scn.nextLine()을 한번 더 입력해주는 방식으로 이 문제를 처리해줄 수 있다.
				// 또는 Integer.parseInt(nextLine())과 같이 처리해야함
				System.out.print("> 도서제목: ");
				String title = scn.nextLine();                     //반환값 String
				System.out.print("> 저자: ");
				String author = scn.nextLine(); 
				System.out.print("> 가격: ");
				int price = scn.nextInt();scn.nextLine();			
				Book book = new Book(bno, title, author, price);
				if(dao.insert(book)) {
					System.out.println("정상 등록");
				}else {
					System.out.println("등록 중 오류 발생");
				}			
				break;
			case 3: //도서수정.
				System.out.print("> 도서번호: ");
				bno = scn.nextInt(); scn.nextLine();
				System.out.print("> 가격: ");
				price = scn.nextInt(); scn.nextLine();
				
				if(dao.update(bno, price)) {
					System.out.println("정상 수정");
				}else {
					System.out.println("수정 중 오류 발생");
				}
				
			break;	
			case 4: //도서삭제.
			break;
			case 9: //종료.
				run = false;
			}//end of switch.
		}//end of while.
		System.out.println("end of program.");
	}//end of main().


}




// 교수님 git주소 : changholee2010/HelloJava 참고
