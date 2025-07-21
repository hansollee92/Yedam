package chap06_1;

public class Book {	
	
	// 필드(field)
//	int bookNo;
//	String title;
//	int price; 
	
	private int bookNo;
	private String title;
	private int price; 
	// 이렇게 private는 외부에서 접근할 수 없기 때문에 BookMain에 오류가 생겨남
	// 이걸 사용할려면 getter, setter를 만들어야함 
	// : 상단 [Source] > [Generate getters and setters... 선택] > [getter 선택]
	// 하단 메소드에 뭔가 생겨났음! 즉, BookMain.java가서 getBookNo() 이렇게 해야지 사용이 가능하다는 말! 
	
	// setter는 잘못된 데이터가 입력될 수 없도록 할 때 사용함 (점수를 넣을때 -점수가 들어오는 것을 막기 위해서 setter를 한번 걸칠 수 있게 )	
	// 필드보호를 위해서 접근 제한자는 우리가 사용해야한다!!!
	
	
	// 생성자(constructor)
	Book(int bookNo, String title, int price){
		this.bookNo = bookNo;
		this.title = title;
		this.price = price;
	}
	
	// 메소드(method)
	
		public int getBookNo() {
		return bookNo;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

		//도서전체조회
		String bookInfo(){
			return "도서번호: " + this.bookNo + " 가격: " + this.price + "원";
		}

		
	

}//end class;














