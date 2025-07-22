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
		
	}//end findAll()
	
	
	
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
			if (rs.next()) {
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
	
	
	
	
	// 글 검색(사용자)
	public Post searchUser(String userName) {
		Connection conn = DBUtil.getConnect();
		String query = "select p.boardNo, p.title, m.userName, p.redate "+
		           "    from post p join member2 m on(p.id = m.id) "+
				   "    where m.userName = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Post post = new Post(); 
				post.setBoardNo(rs.getInt("boardNo"));
				post.setTitle(rs.getString("title"));

				Member member = new Member();
				member.setUserName(rs.getString("userName")); 
				post.setMember(member);  //post에 member값 넣기
				
				post.setRedate(rs.getDate("redate"));
				return post;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	// 글 검색(제목, 키워드)
	public Post searchTitle(String keyword) {
		Connection conn = DBUtil.getConnect();
		String query = "select p.boardNo, p.title, m.userName, p.redate "+
		           "    from post p join member2 m on(p.id = m.id) "+
				   "    where p.title " +
		           "    like ?";
		           // 자바에서는 '%?%'문자열로 인식해서 ?를 찾지 못해서 java.sql.SQLException: 부적합한 열 인덱스 오류 나타남
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Post post = new Post(); 
				post.setBoardNo(rs.getInt("boardNo"));
				post.setTitle(rs.getString("title"));

				Member member = new Member();
				member.setUserName(rs.getString("userName")); 
				post.setMember(member);  //post에 member값 넣기
				
				post.setRedate(rs.getDate("redate"));
				return post;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	
	
	
	
	
}
