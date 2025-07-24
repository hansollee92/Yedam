package com.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.yedam.board.DBUtil;

// 게시글 관련 기능 전반을 처리하는 클래스
// findAll() : 게시글 목록 조회
// postCheck(boardNo) : 게시글 확인
// postSearch(column, keyword) : 검색
// postUpload(post) : 등록
// postUpdate(post) : 수정
// postDel(boardNo) : 삭제
// findPost(boardNo) : 단건 조회 (수정/삭제 전 확인용)

public class PostDAO {

	// 메소드
	// 전체 게시글 목록 조회
	public ArrayList<Post> findAll() {
		Connection conn = DBUtil.getConnect();
		ArrayList<Post> list = new ArrayList<Post>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					       "select p.boardNo, p.title, m.userName, p.redate " 
			      + "       from post p join member2 m "
				  + "       on(m.id = p.id) " 
			      + "       order by boardNo desc");

			while (rs.next()) {
				Post post = new Post();
				post.setBoardNo(rs.getInt("boardNo"));
				post.setTitle(rs.getString("title"));

				Member member = new Member();
				member.setUserName(rs.getString("userName"));
				post.setMember(member); // post에 member값 넣기

				post.setRedate(rs.getDate("redate"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	// 게시글 확인
	public Post postCheck(int boardNo) {
		Connection conn = DBUtil.getConnect();
		String query = "select p.boardNo, p.title, m.userName, p.redate, p.content "
				+ "     from post p join member2 m on(m.id = p.id) " 
				+ "     where p.boardNo = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, boardNo);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.setBoardNo(rs.getInt("boardNo"));
				post.setTitle(rs.getString("title"));

				Member member = new Member();
				member.setUserName(rs.getString("userName"));
				post.setMember(member); // post에 member값 넣기

				post.setRedate(rs.getDate("redate"));
				post.setContent(rs.getString("content"));
				return post;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	// 게시글 검색(제목/글쓴이로 검색 가능)
	public ArrayList<Post> postSearch(String column, String keyword) {
		Connection conn = DBUtil.getConnect();
		ArrayList<Post> list = new ArrayList<Post>();
		String query = "select p.boardNo, p.title, m.userName, p.redate" 
		          + "   from post p join member2 m "
				  + "   on(m.id = p.id) " + "   where " + column + " like ? " 
		          + "   order by boardNo desc";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Post post = new Post();
				post.setBoardNo(rs.getInt("boardNo"));
				post.setTitle(rs.getString("title"));

				Member member = new Member();
				member.setUserName(rs.getString("userName"));
				post.setMember(member);

				post.setRedate(rs.getDate("redate"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 게시글 등록
	public boolean postUpload(Post post) {
		Connection conn = DBUtil.getConnect();
		String query = "insert into post (boardNo, title, id, content) " 
		          + "   values (board_seq.nextval, ?, ?, ?)";
		                // 사용자가 로그인이 되어 있다면 자동으로 여기 id값이 입력되게 -> LoginContext 클래스
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, post.getTitle());
			stmt.setInt(2, LoginContext.loginUser.getId()); // LoginContext에 저장된 로그인한 사용자 id값 자동 입력
			stmt.setString(3, post.getContent());

			int r = stmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 글수정
	public boolean postUpdate(Post post) {

		Connection conn = DBUtil.getConnect();
		String query = "update post set title = ?, content = ? where boardNo = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, post.getTitle());
			stmt.setString(2, post.getContent());
			stmt.setInt(3, post.getBoardNo());
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// 게시글 단건 검색
	public Post findPost(int boardNo) {
		Connection conn = DBUtil.getConnect();
		String query = "select p.boardNo, p.title, p.id, m.userName, p.redate, p.content"
				+ "     from post p join member2 m " 
				+ "           on (p.id = m.id) " 
				+ "     where p.boardNo = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, boardNo);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Post post = new Post(
						rs.getInt("boardNo"), 
						rs.getString("title"), 
						Integer.parseInt(rs.getString("id")),
						rs.getDate("redate"), 
						rs.getString("content"));
				return post;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 게시글 삭제
	public boolean postDel(int boardNo) {
		Connection conn = DBUtil.getConnect();
		String query = "delete from post" 
		       + "      where boardNo = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, boardNo);

			int r = stmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
