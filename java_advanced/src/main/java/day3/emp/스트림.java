package day3.emp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class 스트림 {
	public static void main(String[] args) {
		
		String[] strArr = {"키위","포도","바나나","사과","감","사과"};
			
		// 배열에는 stream()이 없기 때문에 stream을 사용하기 위해서는 먼저 stream을 쓸 수 있게 바꿔야한다. -> Stream.of()
		// sorted()는 기본데이터타입이면 그냥 sorted()로 작성가능. 객체타입일때는 Comparared 사용해야함
		// 우리가 보고 싶은걸 paging하듯이 limit
		
		Stream.of(strArr)
		      .sorted()
		      .limit(3)
		      .forEach(System.out::println);
		
		// 가나다 순으로 sorting되어져서 나타난다 -> 감/ 바나나 / 사과

		// 이걸 응용해서 다른 방식으로도 만들어보자. 
		// 사과가 몇개 있나?
		// -> filter count를 이용
		
		long cnt = Stream.of(strArr).filter((String e) -> e.equals("사과")).count();
		System.out.println("사과갯수 : " + cnt);
		
		// 이게 바로 함수식 프로그래밍이고 람다식으로 많이 사용이 된다. 
		
		
		
		
		
		
		List<Employee> list = Arrays.asList(
				new Employee(100, "고길동", 2000),
				new Employee(101, "강감찬", 3000),
				new Employee(102, "김유신", 4000)
		);
		
		// 급여 합계도 구해보자. 
		// https://kapentaz.github.io/java/Java8-stream-sum-%EA%B5%AC%ED%95%98%EA%B8%B0/#
		long sumSalary = list.stream().mapToLong(e -> e.getSalary()).sum();
		System.out.println(sumSalary);
		
		
		
		
	}
}
