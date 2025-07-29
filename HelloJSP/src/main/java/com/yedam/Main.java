package com.yedam;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

// 25-07-29-화 Map 개념 익히기
//interface Controller{
//	// 이것도 하나의 데이터타입이다.	
//	public void exe();	
//}
//class Sample implements Controller{
//	// Controller 인터페이스의 기능을 구현해줘야하는 Sample 클래스 
//	// Controller 인터페이스에 있는 규칙을 무조건 구현해줘야한다. 아니면 에러뜸
//	@Override
//	public void exe() {
//		System.out.println("Sample 클래스");
//	}
//}
//public class Main {
//	
//	public static void main(String[] args) {
//		
//		// Map 타입을 알아보자
//		
//		// 여러개의 값들을 넣기 위해서 우리는 배열을 사용했었다. 
////		int[]
//				
//		// 컬렉션은 아래와 같이 작업을 했었다.
////		ArrayList<Book> list = new ArrayList<>();
////		ArrayList<Book> list = new ArrayList<Book>(); 이렇게 명확하게 적어도 되는데 위에처럼 안적혀있으면 알아서 왼쪽 Book을 보고 알아서 판단함
////		Book book = list.get(0);   // ArrayList는 인덱스로 값을 가져왔었는데 Map은 key값을 넣으면 value값을 반환해줌
//		
//		// 키=값 을 쌍으로 담을 수 있는 것은 
//		Map<String, Integer> map = new HashMap<String, Integer>();     //Integer : 정수타입을 처리해주는 클래스
//		map.put("홍길동", 80);   
//		map.put("박길동", 78);
////		map.put(200, 78);    에러 (key, value)가 지정된 데이터타입으로 들어와야함
//		// 이런식으로 key와 value를 함께 담아 놓는 것을 Map이라고 한다. 
//		
//		Integer result = map.get("홍길동");   //이렇게 key를 담으면 value를 반환해줌, value는 Int니깐 저렇게 적어줘야함
//		System.out.println(result);
//		
//		Map<String, Controller> controls = new HashMap<>();
////		== Map<String, Controller> controls = new HashMap<String, Controller>();
//		// 우리가 선언했던 인터페이스였던 Controller가 데이터타입으로 왔다.
//		controls.put("Sample", new Sample());   //Sample클래스의 기능을 호출하겠다 
//		//                     여기서 올수있는 데이터타입이 위에서 우리가 Controller라고 했으니 그것을 구현하는 인스턴스가 들어가면 된다. (규칙맞음)
//		controls.put("Test", new Controller() {
//			@Override
//			public void exe() {
//				System.out.println("Test입니다.");
//			}			
//		}); // 이건 익명구현객체(클래스). 이런식으로 직접적으로 적을 수도 있음. 
//		
//		Controller val = controls.get("Sample"); // 마찬가지로 controls에 Sample이라는 키를 넣어주면 그럼, Sample()의 객체값이 나올것임
//		// 그래서 Controller val 이렇게 값을 넣어줄 수 있음 
//		
//		val.exe();
//		// 그리고 이 val은 Controller이니 exe()라는 메소드가 있어서 이걸 실행할 수 있다. 
//		
//		Controller val2 = controls.get("Test");
//		val2.exe();
//		
//		// ---> 이렇게 key값을 다르게 해서 결과값을 다르게 만들 수 있다. 
//		// 이 key를 우리는 abc.do , ddc.do 이런식으로 만들려고 한다. 
//		controls.put("abc.do", new Sample()); 
//		controls.put("efg.do", new Controller() {
//			@Override
//			public void exe() {
//				System.out.println("Test입니다.");
//			}			
//		});
//		
//		Controller val3 = controls.get("abc.do");
//		val2.exe();
//		Controller val4 = controls.get("efg.do");
//		val2.exe();
//		
//		// 이 방식으로 FrontController에 등록을 해볼 것이다. 
//		
//		
//		
//	}
// }
	
	
public class Main {
	public static void main(String[] args) {
		
		BoardService svc = new BoardServiceImpl();  //업무기능
		
//		SqlSession sqlSession = DBUtil.getInstance().openSession();
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		
		// 목록
//		List<BoardVO> list = mapper.selectList();
//		for(BoardVO board : list) {
//			System.out.println(board.toString());
//		}
		
		int searchNo = 1;

		// 단건조회
		// 조회수(viewCnt) 기능 넣기		
		// -> 조회 + 조회수는 함께 
		// => 업무(조회: 글번호조회 + 조회카운트)
//		BoardVO board = mapper.selectBoard(searchNo);
//		mapper.updateCount(searchNo);
		
		BoardVO board = svc.searchBoard(searchNo);
			
		
		System.out.println(board.toString());

	}
	

}
