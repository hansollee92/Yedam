package day4;

public class EmpSalaryTest {
	public static void main(String[] args) {
		
		EmpSalary empSalary = new EmpSalary("c:/Temp/emp.txt");
		
		empSalary.init();     //초기화
		empSalary.cal();      //급여계산
		empSalary.sort();     // 정렬
		empSalary.print();    //출력
		
		System.out.println("급여합계 => " + empSalary.getSum());
	}
}
