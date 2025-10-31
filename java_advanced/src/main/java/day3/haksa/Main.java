package day3.haksa;

import java.util.ArrayList;

//import day2.Student;      // 같은 패키지내에 없기 때문에 import 필요
//import day2.Professor;    // Ctrl + Shift + O : 한번에 삽입
//import dat2.*;            // 하나씩 작성하기 싫으면 * 사용해서 import 작성 가능

// 패키지, import
public class Main {
	public static void main(String[] args) {
		
		// 부모 타입의 참조변수가 자식객체를 참조할 수 있다. (자동형변환promotion)
		Member student = new Student(1, "고길동", 4);
		Member professor = new Professor(100, "나교수", 4000);
		
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(student);
		list.add(professor); 
		
		for(Member mebmer : list) {
			// 다형성 : 참조하는 자식객체의 메서드를 호출 => 실행결과 다르게
			System.out.println(mebmer.toString());
		}
		
		for(Member member : list) {
			// System.out.println(member);
			
			System.out.println(member.name);    // Member 필드만 보임 
			
			if(member instanceof Student) {
				Student temp = (Student)member;    // 강제형변환(casting)
				System.out.println(temp.getGrade());
			}else {
				// 교수타입 형변환 -> 급여출력
				Professor temp = (Professor)member;
				System.out.println(temp.salary);
			}
						
			
//			System.out.println((member instanceof Student) ? 
//					          ((Student)member).getGrade() : 
//					          ((Professor)member).salary);
			
			// instanceof : 참조하는 것은 Member이지만, 실제 생성된 instance를 비교해서
			//              Student라면 grade, Professor라면 salary (p354 7-2. 타입변환)
			
			
			
			
		}
		
		
		

		
	}
}
