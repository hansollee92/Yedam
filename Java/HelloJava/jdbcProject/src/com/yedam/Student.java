package com.yedam;
// 속성 => 필드
// 기능 => 메소드
// 속성 : 학생번호, 이름, 연락처, 혈액형 
public class Student {

	// 앞에 private가 붙으면 Student클래스 외의 클래스에서 이 속성을 쓸려면 접근할 수가 없다. 
	// getter(), setter()를 통해서만 접근할 수 있는데 데이터 접근 제한을 둬서 데이터를 보호하기 위한 것
	// 그래서 이 getter, setter 메소드가 필요(아래!)
	private int stdNo;      //자바에서는 carmelcase방식사용함. std_no(oracle) std-no(x)
	private String stdName;
	private String phone;
	private String bloodType;
	
	
	
	// 생성자
	public Student() {
		//기본생성자
	}
	public Student(int stdNo, String stdName, String phone, String bloodType) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.phone = phone;
		this.bloodType = bloodType;
	}

	
	
	
	// 메소드(getter, setter)
	public void setStdNo(int stdNo) {     //stdNo의 setter
		this.stdNo = stdNo;
	}
	public int getStdNo() {    //stdNo의 getter
		return stdNo;
	}
	
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdName() {
		return stdName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getBloodType() {
		return bloodType;
	}
	
	
	// 위와 같이 일일이 작성해도 되고
	// 이클립스에서는 getter, setter 자동으로 만들어주는 방식을 제공해주고 있는데 
	// 편집기 마우스 오른쪽 버튼 > [Source] > [Generate Getter and Setters..] > [Select All] 로 만들수도 있음
	
	
	
}
