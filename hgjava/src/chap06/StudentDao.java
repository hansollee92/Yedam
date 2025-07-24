package chap06;

public class StudentDao {
	//학생데이터 생성
	
	
	//필드 필요없음	
	//생성자 기본생성자만 있으면 됨 그래서 굳이 만들지 않음 => 컴파일 자동 생성(javac) 
	
	//메소드	
	Student[] stData(){
		Student[] students = {
				new Student("홍길동", 100, 100, 100),
				new Student("강길동", 90, 40, 90),
				new Student("이길동", 100, 50, 100),
				new Student("황길동", 100, 40, 50),
				new Student("고길동", 70, 100, 100),
				new Student("성춘향", 89, 100, 95),
				new Student("김춘향", 90, 90, 90),
				new Student("이춘향", 30, 50, 25),
				new Student("황춘향", 75, 40, 88),
				new Student("고춘향", 70, 99, 45)
		};
		return students;
		
	}
	
}//end class
