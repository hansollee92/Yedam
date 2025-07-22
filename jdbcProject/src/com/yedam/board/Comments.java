package com.yedam.board;

public class Comments {
	
	//필드
	private String user;
	private String message;
	private int boardNo;
	
	//생성자
	public Comments(){}
	public Comments(String user, String message, int boardNo) {
		super();
		this.user = user;
		this.message = message;
		this.boardNo = boardNo;
	}	
	
	//메소드
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	
}//end of Comments.
