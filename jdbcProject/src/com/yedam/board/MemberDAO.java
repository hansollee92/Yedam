package com.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yedam.app.DBUtil;

public class MemberDAO {

	// 메소드		
	// 로그인 유저
	public Member login (int id, String pw) {
		Connection conn = DBUtil.getConnect();
		String query = "select id, userName, pw " + 
		          "     from member2 " + 
				  "     where id = ? " +
		          "       and pw = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id); 
			stmt.setString(2, pw);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setUserName(rs.getString("userName"));
				member.setPw(rs.getString("pw"));				
				return member;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	
}
