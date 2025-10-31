package com.yedam.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 조회, 등록, 수정, 삭제 기능 만들기
public class BookDAO {

	// 메소드

	// 목록조회(다건)
	public ArrayList<Book> findAll() {
		Connection conn = DBUtil.getConnect(); // DBUtil에 static 추가
		ArrayList<Book> list = new ArrayList<Book>(); // 컬렉션(Book)
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book");
			// 반복.
			while (rs.next()) {
				Book book = new Book(); // 기본생성자 방식으로 인스턴스 생성
				book.setId(rs.getInt("id")); // id -> id 필드에 할당.
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				// 컬렉션에 추가.
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}// end of findAll().

	// 도서등록. 매개값(Book), 반환값(boolean)
	public boolean insert(Book book) {
		Connection conn = DBUtil.getConnect();
//		String query = "insert into book(id, title, author, price)"
//				+ "     values("+book.getId()+","+
//				               "'"+book.getTitle()+"','"+    //문자열이기 때문에 앞뒤로 ''가 있어야함 
//				               book.getAuthor()+"',"+
//				               book.getPrice()+")";
//		System.out.println(query); // 위에 쿼리 만들 때, ''다 넣었기때문에 이거 안넣으면 오류뜸. 이걸로 확인
//		
//		// 1)Statement를 이용한 구문만들기 (불편함)
//		try {
//			Statement stmt = conn.createStatement();
//			int r = stmt.executeUpdate(query);   //들어갈 값이 길어서 위에 query변수 만들어서 넣을 것임. 실행된 쿼리의 결과 count 반환(r).
//			if(r>0) { //한건 입력되면
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}		

		String query = "insert into book(id, title, author, price)" + 
		          "     values(?,?,?,?)";
		// 2)PrepareStatement를 이용한 구문 만들기
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, book.getId()); // ?의 첫번째 값을 지정
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getAuthor()); 
			stmt.setInt(4, book.getPrice());

			int r = stmt.executeUpdate();
			if (r > 0) { // 한건 입력되면
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// 도서수정. 매개값(int bno, int price), 반환값(boolean)
	public boolean update(int bno, int price) {
		Connection conn = DBUtil.getConnect();

		String query = "update book " + "     set price = ? " + "     where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, price);
			stmt.setInt(2, bno);

			int r = stmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return false;
	}// end of update.

	// 숙제 : 도서삭제.
	// 삭제(delete), 단건조회(findById) 작성

	// 삭제(delete).
	// 입력 : 도서번호(int bno) 입력
	// 반환 : 성공했으면 true, 실패했으면 false
	public boolean delete(int bno) {
		Connection conn = DBUtil.getConnect(); // DB연결
		String query = "delete from book " + "     where id = ?"; // SQL 쿼리
		try {
			PreparedStatement stmt = conn.prepareStatement(query); // PreparedStatement로 ?에 값넣
			stmt.setInt(1, bno);

			int r = stmt.executeUpdate(); // 실행
			if (r > 0) { // r>0이면 true, 아니면 false
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// 단건조회(findById)

	// 입력 : 도서번호(int) 입력
	// 반환 : Book 객체 하나 (찾으면) 또는 null (없으면)
	public Book findById(int bno) {
		Connection conn = DBUtil.getConnect();
		String query = "select id,title,author,price " + "     from book " + "     where id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, bno);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
