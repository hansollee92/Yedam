package day3.emp;

import java.util.List;
import java.util.stream.Collectors;

// 테이블 전체 레코드 담기
// 등록, 수정, 삭제, 조회, 전체조회, 정렬
public class EmployeeList {
	
	List<Employee> list;

	public EmployeeList(List<Employee> list) {
		this.list = list;
	}
	
	// 전체조회
	public void selectAll() {
		for(Employee emp : list) {
			System.out.println(emp);
		}
	}
	
	// 등록
	public void insert(Employee employee) {
		list.add(employee);
	}
	
	// 사번 조회(find) 
	public Employee findById(int id) {
		for(Employee emp : list) {
			if(id == emp.getEmployeeId()) {
				return emp;
			}
		}
		return null;
	}
	
    // 이름 조회(find) : String일때는 == 으로 비교 못하는거 기억하고 있을 것! 
//	public Employee findByName(String firstName) {
//		for(Employee emp : list) {
//			if(firstName.equals(emp.getFirstName())) {
//				return emp;
//			}
//		}
//		return null;
//	}
	public Employee findByName(String firstName) {
		return list.stream()
		           .filter((Employee e) -> firstName.equals(e.getFirstName()) )
		           .findFirst()
		           .get();
	}
	
	// 검색(filter)
	public List<Employee> findBySalary(int salary){
		return list.stream()
		           .filter((Employee e) -> e.getSalary() > salary )
		           .collect(Collectors.toList());
	}
	
	// 정렬 (이름순으로 정렬)
	public List<Employee> findOrderByName(){
//		return list.stream()
//				   .sorted((Employee a, Employee b) -> a.getFirstName().compareTo(b.getFirstName()))
//				   .collect(Collectors.toList()); 
		// stream은 비파괴함수이기 때문에 return을 앞에 붙여줘야하는데 
		// list.sort는 파괴함수이기 때문에(원본을 바꿔버림) return을 자기자신을 받지 굳이 return을 앞에 적어주진 않는다. 
		
		// Employee a, Employee b에서 Employee 생략가능한 이유는 앞에 제너릭으로 <Employee> 이렇게 명시해줬기 때문에 생략가능
		list.sort((a, b) -> a.getFirstName().compareTo(b.getFirstName()));
		return list;
		
	}
	
	// 정렬 (급여순으로 정렬)
	public List<Employee> findOrderBySalary(){
		return list.stream()
				   .sorted((Employee a, Employee b) -> (int)(a.getSalary() - b.getSalary()) )
				   .collect(Collectors.toList());
	}
		
	// 수정
	
	// 삭제 
	
	
}
