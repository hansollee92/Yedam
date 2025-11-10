package day4;

import java.io.File;

// jupiter로 import
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// p662
// 폴더=파일 시스템 API (폴더 생성, 삭제, 이름변경, 정보확인, 파일크키확인, ... )
public class FileTest {

	//@Test
	@DisplayName("폴더목록")
	public void test1() {
		File file = new File("c:/Temp");
		// \ 사용할경우 tab이라고 읽기 때문에 \\ 이렇게 작성하거나 / 이거 사용
		
		// 파일 조회
		String[] files = file.list();
		for(String item : files) {
			System.out.println(item);
		}
		
	}
	
	//@Test
	@DisplayName("파일삭제")
	public void test2() {
		File file = new File("c:/Temp", "copy3.txt");
		file.delete();
	}
	
	@Test
	@DisplayName("파일정보 확인")
	public void test3() {
		File file = new File("c:/Temp", "emp.txt");
		System.out.println("파일크기: "+ file.length());    // 파일크기
		System.out.println("파일명: "+ file.getName());    // 파일명
		
		// 확장자 출력 -> txt
		// .의 위치 : indexof
		int idx = file.getName().indexOf(".");
		String ext = file.getName().substring(idx + 1);
		System.out.println("파일 확장자: "+ ext);
	}
	
}
