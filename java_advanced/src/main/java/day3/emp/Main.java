package day3.emp;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		// asList : 배열을 list로 만들어주는 메서드
		List<Employee> list = Arrays.asList(
				new Employee(100, "고길동", 2000),
				new Employee(101, "강감찬", 3000),
				new Employee(102, "김유신", 4000)
		);
		
		EmployeeList empList = new EmployeeList(list);
		
		// 전체출력
//		 empList.selectAll();
		
		System.out.println(empList.findById(101));
		System.out.println(empList.findByName("김유신"));
		System.out.println("이름순 정렬 ---");
		System.out.println(empList.findOrderByName());
		System.out.println("급여순 정렬 ---");
		System.out.println(empList.findOrderBySalary());
		
	}
}
