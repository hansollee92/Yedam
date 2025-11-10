package day1;

import java.util.HashMap;
import java.util.Set;

public class 맵 {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		// 추가
		map.put(100, "홍길동");
		map.put(110, "나길동");
		map.put(120, "강길동");
		
		// 삭제
		map.remove(100);
		System.out.println("삭제 후 : " + map);
		
		// 변경
		map.put(110, "이순신");
		System.out.println("변경 후 : " + map);
		
		// 조회
		System.out.println("120번 사원은 " + map.get(120));
		
		// 다건조회
		Set<Integer> keys = map.keySet();
		for(Integer key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
		
	}// end main
}// end class
