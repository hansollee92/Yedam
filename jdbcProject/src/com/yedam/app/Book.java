package com.yedam.app;

public class Book {
	
	// 필드
	private int id;
	private String title;
	private String author;
	private int price;
	
	// 생성자
	// 생성자 직접 만들어도 되지만 마우스 오른쪽 버튼 [Source] > [Greate construtor using filed] 선택하면 자동으로 생성자 만들어짐 (이클립스 제공)
	public Book() {
		// 기본생성자
	}
	public Book(int id, String title, String author, int price) {
		super();   //부모클래스. (상속)
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	// 메소드(getter, setter)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
}
