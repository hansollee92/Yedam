package com.yedam.board;

import java.util.Date;

public class Post {

	//필드
	private int boardNo;
	private String title;
	private int id;
	private Date redate;
	private String content;
	private Member member;
	
	//생성자
	public Post() {}
	public Post(int boardNo, String title, int id, Date redate, String content) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.id = id;
		this.redate = redate;
		this.content = content;
	}
	
	//메소드	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getRedate() {
		return redate;
	}
	public void setRedate(Date redate) {
		this.redate = redate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}	
	
	
	
}//end of Post.
