package com.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yedam.board.DBUtil;

public class CommentsDAO {

	// 메소드
	// 댓글보기(by boardNo)
	public ArrayList<Comments> findComments(int boardNo) {
		Connection conn = DBUtil.getConnect();
		ArrayList<Comments> list = new ArrayList<Comments>();
		String query = "select commentsNo, nickName, message, boardNo, "
				+ "            to_char(redate, 'YYYY-MM-DD HH24:MI') \"redate\" "
				+ "     from comments " 
				+ "     where boardNo = ? " 
				+ "     order by commentsNo";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, boardNo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Comments comments = new Comments();
				comments.setCommentsNo(rs.getInt("commentsNo"));
				comments.setNickName(rs.getString("nickName"));
				comments.setMessage(rs.getString("message"));
				comments.setBoardNo(rs.getInt("boardNo"));
				comments.setRedate(rs.getString("redate"));
				list.add(comments);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 댓글등록
	public boolean commentUpload(Comments comment) {
		Connection conn = DBUtil.getConnect();
		String query = "insert into comments (commentsNo, nickName, message, boardNo) "
				+ "     values (comments_seq.nextval, ?, ?, ?)";
		// 게시글 번호는 그 글에 들어와있으니 자동으로 입력되게(bno)

		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, comment.getNickName());
			stmt.setString(2, comment.getMessage());
			stmt.setInt(3, comment.getBoardNo());

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
