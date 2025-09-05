package com.yedam.board;

public class Member {
	
	//필드 
	private int id;
	private String userName;
	private String pw;
	
	//생성자
	public Member() {}
	public Member(int id, String userName, String pw) {
		super();
		this.id = id;
		this.userName = userName;
		this.pw = pw;
	}
	
	//메소드(getter, setter)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}	
	

}//end of member.
