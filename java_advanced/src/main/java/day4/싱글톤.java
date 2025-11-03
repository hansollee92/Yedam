package day4;

// 싱글톤 만드는 법
public class 싱글톤 {
	public static void main(String[] args) {
		
		// Dept dept1 = new Dept(); 
		// Dept dept2 = new Dept();
		// 이렇게 해두면 메모리 관리가 힘들다. 계속해서 new해서 만들면 메모리가 소모됨
		// 그래서 이걸 하나만 사용될 수 있도록 '싱글톤'을 사용할 수 있도록 함
		
		// 3) 클래스로 불러온다
		Dept dept1 = Dept.getInstance();
		Dept dept2 = Dept.getInstance();
		
		System.out.println(dept1 == dept2);
		
	}
}

class Dept{
	
	// 1) private로 막아버린다.
	private static Dept instance = new Dept();
	private Dept() {}
	
	// 2) private이니 getter 생성
	public static Dept getInstance() {
		return instance;
	};
	
	
	
}
