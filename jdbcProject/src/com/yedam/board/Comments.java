package com.yedam.board;

import java.util.Date;

public class Comments {
	
	//필드
	private String nickName;
	private String message;
	private Date redate;
	private Post post;
	
	//생성자
	public Comments(){}

	//메소드
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getRedate() {
		return redate;
	}

	public void setRedate(Date redate) {
		this.redate = redate;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	
	
	
}//end of Comments.
