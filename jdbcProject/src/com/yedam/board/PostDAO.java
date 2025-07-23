package com.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.yedam.app.DBUtil;

//목록조회, 글확인, 글검색, 글등록, 글수정, 글삭제 기능
public class PostDAO {

	//메소드
	
	//목록조회
	public ArrayList<Post> findAll(){
		Connection conn = DBUtil.getConnect();
		ArrayList<Post> list = new ArrayList<Post>();		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select p.boardNo, p.title, m.userName, p.redate "+
			                          "       from post p join member2 m " +
					                  "       on(m.id = p.id) " +
			                          "       order by boardNo desc");
			
			while (rs.next()) {
				Post post = new Post(); 
				post.setBoardNo(rs.getInt("boardNo"));
				post.setTitle(rs.getString("title"));

				Member member = new Member();
				member.setUserName(rs.getString("userName")); 
				post.setMember(member);  //post에 member값 넣기
				
				post.setRedate(rs.getDate("redate"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;		
		
	}
	
	
	
	// 글 확인
	public Post postCheck(int boardNo) {
		Connection conn = DBUtil.getConnect();
		String query = "select p.boardNo, p.title, m.userName, p.redate, p.content "+
		          "     from post p join member2 m on(m.id = p.id) "+
				  "     where p.boardNo = ?";
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
				post.setMember(member);  //post에 member값 넣기
				
				post.setRedate(rs.getDate("redate"));
				post.setContent(rs.getString("content"));
				return post;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	
	// 검색 메소드	
	public ArrayList<Post> postSearch(String column, String keyword){
		Connection conn = DBUtil.getConnect();
		ArrayList<Post> list = new ArrayList<Post>();
		String query = "select p.boardNo, p.title, m.userName, p.redate"+
		            "   from post p join member2 m "+
				    "   on(m.id = p.id) "+
		            "   where " + column + " like ? " +   //column값을 정확하게 받아야함!
		            "   order by boardNo desc";		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, "%" + keyword +"%");			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
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
	
	
	
	
	
	// 글등록
	public boolean postUpload(Post post) {		
		Connection conn = DBUtil.getConnect();
		String query = "insert into post (boardNo, title, id, content) "+
		            "   values (board_seq.nextval, ?, ?, ?)";
		                // 사용자가 로그인이 되어 있다면 자동으로 여기 id값이 입력되게 -> LoginContext 클래스 필요
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, post.getTitle());
			stmt.setInt(2, LoginContext.loginUser.getId());   // LoginContext에 저장된 로그인한 사용자 id값 자동 입력
			stmt.setString(3, post.getContent());
			
			int r = stmt.executeUpdate();
			if(r > 0) {
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
			if(r > 0) {
				return true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
	
	// 글 하나 검색
	public Post findPost(int boardNo) {
		Connection conn = DBUtil.getConnect();
		String query = "select p.boardNo, p.title, p.id, m.userName, p.redate, p.content"+
		          "     from post p join member2 m "+
				  "           on (p.id = m.id) "+
		          "     where p.boardNo = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, boardNo);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Post post = new Post(
					    rs.getInt("boardNo"),
					    rs.getString("title"),
					    Integer.parseInt(rs.getString("id")),
					    rs.getDate("redate"),   
					    rs.getString("content")
					);
				return post;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	// 글삭제
	public boolean postDel(int boardNo) {
		Connection conn = DBUtil.getConnect();
		String query = "delete from post" + 
		         "      where boardNo = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, boardNo);
			
			int r = stmt.executeUpdate();
			if(r > 0) {
				return true;
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return false;
	}
	
	
	
	
	
	
}
