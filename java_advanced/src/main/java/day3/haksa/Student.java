package day3.haksa;

public class Student extends Member {
	
	// 필드
	int grade;

	// 생성자
	public Student() {}
	public Student(int no, String name, int grade) {
		this.no = no;
		this.name = name;
		this.grade = grade;
	}
	
	// getter, setter
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	

	// method
	@Override
	public String toString() {
		return "Member [no=" + no + 
				       ", name=" + name + 
				       ", grade=" + grade +
				       "]";
	}
	// Member, 즉 부모의 toString이 나타나야하지만 재정의 했기 때문에 Student의 toString이 나타남 
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	

}
