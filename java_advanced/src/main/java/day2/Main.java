package day2;
/*
 * 테스트
 */
public class Main {
	public static void main(String[] args) {
		// 2. 객체 생성
				// 참조변수	  // 인스턴스(힙(메모리)에 저장공간이 할당)
		Student student = new Student();
		student.no = 2006001;
		student.name = "고길동";
		student.addr = "대구";		
		Student s3 = new Student(2001, "돌리");
		Student s4 = new Student(2001, "또치", "서울");
		
		Professor prof = new Professor();
		
		// 3. 사용
		student.addLecture();
		
		// 얕은복사
		Student student2 = student;
		student2.name = "홍길동";
		System.out.println(student.name);
		System.out.println(student == student2);
	}
}
