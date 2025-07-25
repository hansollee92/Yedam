package com.yedam.vo;

public class Book {
	
	//필드
	private int id;
	private String title;
	private String author;
	private int price;
	
	//메소드(getter, setter)
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
	
	// 부모클래스(Object)의 toString()을 자식이 물려받는다. (상속)
	// 부모클래스의 메소드를 자식 클래스에 재정의하는 것을 => override.
	
	// 그래서 이것이 없었을 때는 System.out.print(book); 값이 숫자값으로 나왔는데
	// 자식클래스가 부모클래스의 것을 물려받아서 System.out.print(book.toString());이
	// Book [id=1000, title=이것이자바다, author=김저자, price=15000]으로 나타나게 된다.	
	@Override  
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
	//아래처럼 우리 입맛에 맞게끔 만들 수도 있다
	public String toStr() {
		return "id: " + id + ", title: " + title + ", author: " + author + ", price: " + price;
	}
	
	
	
	
	
	
	
	
}
