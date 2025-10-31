package day3.emp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 람다식 {
	public static void main(String[] args) {
		
		List<Employee> list = Arrays.asList(
				new Employee(100, "고길동", 2000),
				new Employee(101, "강감찬", 3000),
				new Employee(102, "김유신", 4000)
		);
		
		// 1. Comparator 구현객체 -----------------------------------------------------------------------------
		//    sort()를 쓸려면 Comparator 상속받는 객체가 있어야함
		//list.sort(new MySort());
		//System.out.println(list);
		
		// → 그런데 위의 방식은 너무 귀찮음. 아래처럼 계속 객체를 만들어야함
		//   클래스 생성과 객체선언을 한번에 하고 싶음(익명클래스)
		
		// 2. 익명클래스 ---------------------------------------------------------------------------------------
//		list.sort(new Comparator<Employee>(){
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				return (int)(o2.getSalary() - o1.getSalary());
//			}});
//		System.out.println(list);
		
		// → 근데 이 방식도 너무 길다.
		//   그래서 나온 방식이 '람다식표현'이다. 
		
		// 3. 람다표현식 (JS의 화살표함수와 같음) --------------------------------------------------------------------
		//    모든 것을 람다표현식으로 할 수 있는 것은 아니고 상속받을 인터페이스의 오버라이드 메서드가 하나일때
		//    사용법 : (비교값) -> (리턴값)
//		list.sort((Employee o1, Employee o2) -> o1.getFirstName().compareTo(o2.getFirstName()) );
//		System.out.println(list)
		
		// → 근데 이것도 길어서 줄인다면? 
		
		// 4. Comparator 스태틱 메서드 --------------------------------------------------------------------------
//		list.sort(Comparator.comparing(  (Employee e) -> e.getSalary()  ));
//		System.out.println(list);
		
		// → 근데 어차피 매개변수 계속 넘겨주는데 굳이 일일이 매개변수를 적어야하나? 이것도 줄이자!
		
		// 5. 스태틱 메서드 -> 메서드 참조(더블콜론 - 람다표현식 축약문법) --------------------------------------------------
		list.sort(Comparator.comparing(Employee::getSalary) );
		System.out.println(list);
		
		// 위의 5번 방법을 사용하면 
		list.forEach((Employee e) -> System.out.println(e));
		// 위의 방식이 아래처럼 가능
		list.forEach(System.out::println);
		
		
	}
}

class MySort implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getEmployeeId() - o2.getEmployeeId();
	}
	
}



