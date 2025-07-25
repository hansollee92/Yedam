package com.yedam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DBUtil;
import com.yedam.mapper.BookMapper;
import com.yedam.vo.Book;

public class Main {

	public static void main(String[] args) {
		
		//Object ;  > [Ctrl]+호버해서 Object를 살펴보기
		
//		DBUtil util = new DBUtil();  //인스턴스를 통해서 메모리 로딩.
//		SqlSessionFactory factory = util.getInstance();
//		SqlSession sqlSession = factory.openSession();   //SqlSession 객체를 반환.
		
		SqlSessionFactory factory = DBUtil.getInstance();  //static 선언.
		SqlSession sqlSession = factory.openSession();  
				
		// 단건조회.
//		Book book = sqlSession.selectOne("com.yedam.mapper.BookMapper.selectBook", 1000);
//		System.out.print(book);    //--com.yedam.vo.Book@4218500f 출력
//		System.out.print(book.toString());   //--Book [id=1000, title=이것이자바다, author=김저자, price=15000] 출력
//		System.out.println(book.toStr());   //--id: 1000, title: 이것이자바다, author: 김저자, price: 15000 출력
				
		// 목록조회.
//		List<Book> list = sqlSession.selectList("com.yedam.mapper.BookMapper.selectList");
//		for(Book book : list) {
//			System.out.println(book.toStr());
//		}
		// --위의 방식은 사실 조금 불편함. ↓↓↓↓↓↓↓↓↓↓↓
		// --그래서 최근은 다른 방식을 사용하는데 --> 인터페이스에 대해서 알아야한다. 
		// --com.yedam 아래에 Runnable 이라는 interface를 만들어보자
		
		// --RunExe는 Runnable을 구현하는 클래스.
//		RunExe exe = new RunExe();
		// --RunExe은 Runnable의 기능을 구현하는 클래스이다 보니 Runnable에 소속되어있고 그래서 아래와 같이 쓸 수 있다(자식)
		Runnable exe = new RunExe();
		exe.run();   // 인터페이스 - 구현클래스. 		
		
		// --ex 차의 기능원리를 몰라도 그냥 '기능'자체만 알면 운전을 할 수 있다
		// --위의 목록조희에서 사용한 방식은 mapper도 알아야하고 selectList기능도 알아야하는데 잘못 작성해서 오류가 날수도 있다! 
		// --근데 그런 오류들은 실행을 해보지 않으면 오류를 모름 
		// --(개발자입장에서는 에러표시가 나면 좋음)
		// --그래서 BookMapper.xml에서 만든 기능들을 BookMapper.java interface를 만들어서 규칙을 정의한다. 
		
		// --위에서 했던 인터페이스 - 구현클래스의 방식으로 이 BookMapper를 사용해보고자 한다.
		
		// 인터페이스 - 구현클래스.
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
//		Book book = mapper.selectBook(1001);    -- 위의 단건조회와 같은 역할
		List<Book> list = mapper.selectList();
		for(Book book : list) {
			System.out.println(book.toStr());
		}
		
		

		

	}

}    
