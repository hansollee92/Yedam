package com.yedam;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.BookMapper;
import com.yedam.vo.Book;

// 목록.
// 단건.
// 등록.
public class BookControl {

	Scanner scn = new Scanner(System.in);
	SqlSession sqlSession = DBUtil.getInstance().openSession(); // openSession의 디폴트값이 false로 자동커밋이 안됨
	BookMapper mapper = sqlSession.getMapper(BookMapper.class);

	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("=================");
			System.out.println("도서정보관리");
			System.out.println("1. 도서목록");
			System.out.println("2. 도서등록");
			System.out.println("0. 이전메뉴");
			System.out.print("선택>>");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 목록
				bookList();
				break;
			case 2: // 등록
				addBook();
				break;
			case 0:
				return; // exe 메소드 종료
			default:
				System.out.println("메뉴를 선택하세요.");
			}

		}
	}// end of exe();

	// 메소드
	// 목록
	void bookList() {
		
		int page = 1;
		int lastPage = 1;   // 마지막페이지 정보)
		
		while(true) {
			List<Book> list = mapper.selectList(page);
			// id / title / price
			System.out.println("도서ID 도서가격   가격");
			System.out.println("=================");
			for (Book book : list) {
				System.out.println(book.showBrief());
			}
			System.out.println("이전(p) 다음(n) 선택>> ");
			String p = scn.nextLine();
			if(p.equals("n")) {
				page++;
			}else if(p.equals("p")) {
				page--;
			}
			
			// 페이지를 넘어갔을때 보이지 않도록 하는 기능 넣어보기~ 
		}
		
		
		
//		bookSearch(); //상세조회.
	}// end of bookList().

	// 등록
	void addBook() {
		System.out.print("도서ID입력>> ");
		String id = scn.nextLine();
		System.out.print("도서제목>> ");
		String title = scn.nextLine();
		System.out.print("도서저자>> ");
		String author = scn.nextLine();
		System.out.print("도서가격>> ");
		String price = scn.nextLine();

		Book book = new Book();
		book.setId(Integer.parseInt(id));
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(Integer.parseInt(price));

		if (mapper.insertBook(book) == 1) {
			sqlSession.commit(); // 커밋처리
			// ** 데이터처리 안되면 콘솔창 다 끄고 다시 실행!
			System.out.println("성공!!");
		}

	}//end of addBook().
	
	
	// 상세조회
	void bookSearch() {
		while (true) {
			System.out.println("=================");
			System.out.print("상세보기(ID입력), 취소(q) 선택>> ");
			
			// try블럭을 실행하다가 예외발생하면 catch 블럭을 실행.
			try {
				int bno = Integer.parseInt(scn.nextLine());
				Book book = mapper.selectBook(bno);
				if (book == null) {
					System.out.println("검색결과 없음");
				} else {
					System.out.println(book.showDetail());
					System.out.println("삭제할래요? (y/N)");
					String flag = scn.nextLine();
					if(flag.equals("") || flag.equals("N")) { //아무것도 입력안하거나, n이거나
						// 삭제안함
						continue;
					}
					// 삭제기능.
					if(mapper.deleteBook(bno) == 1) {
						System.out.println(book.getTitle() + "도서가 삭제되었습니다.");
						break;  //[ctrl]하고 break;를 찍으면 어디까지 끝나는지 이클립스에서 알려주는 기능을 가지고 있다.
					}
					
				}
			} catch (NumberFormatException e) {
				return;  //(??) break와 return의 차이?
			}			

		}
	}// end of bookSearch()
	
	

	
	
	
	
	
	
	
	
	
	
	

}// end of class
