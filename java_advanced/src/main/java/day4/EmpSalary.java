package day4;

import static org.junit.Assume.assumeFalse;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import day3.emp.Employee;

public class EmpSalary {

	// 필드
	private long sum;
	String filename;
	List<Employee> list = new ArrayList<Employee>();
	
	// filename 생성자
	public EmpSalary() {}
	public EmpSalary(String filename) {
		super();
		this.filename = filename;
	}
	
	// getter
	public long getSum() {
		return sum;
	}


	// 메서드
	// 초기화 
	public void init() {
		try {
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNext()) {
				// 한줄씩 읽으면서 split이용하여 배열처리
				String[] arr = scanner.nextLine().split(",");

				int id = Integer.parseInt(arr[0]);
				String name = arr[1];
				long sal = Long.parseLong(arr[7]);

				list.add(new Employee(id, name, sal));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 급여계산
	public void cal() {
		// 명령형 프로그래밍(절차지향, 객체지향) why
		for(Employee e : list) {
			sum += e.getSalary();
		}
		// 선언형 프로그래밍(함수형) what
		sum = list.stream()
				  .mapToLong(Employee::getSalary)
				  .sum();
	}
	
	// 정렬
	public void sort() {
		Comparator<Employee> compare = (o1,o2) -> (int)(o2.getSalary() - o1.getSalary());
		list.sort(compare);
	}
	
	// 출력
	public void print() {
		for(Employee emp :list) {
			System.out.println(emp);
		}
	}
}
