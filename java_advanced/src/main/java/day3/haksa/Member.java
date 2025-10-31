package day3.haksa;

public class Member {

	int no;
	String name;
	String addr;

	public Member() {
		super();
	}

	public void update() {} 
	public void delete() {} 
	
	@Override
	public String toString() {
		return "Member [no=" + no + ", name=" + name + "]";
	}
	
	// 위에서 보면 부모인 Member클래스임에도 @Override라고 되어 있는데 왜냐하면,
	// 자바에서 모든 클래스의 최상위 부모는 Object로 Object를 상속받음

}