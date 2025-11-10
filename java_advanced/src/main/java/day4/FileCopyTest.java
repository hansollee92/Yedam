package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Java에서 Test를 위해서 main을 만드는 것보다는 Junit로 단위테스트를 진행하는 것이 좋다. 
// workspace > build - build path > Library > add library > Junit 추가

public class FileCopyTest {	
	
	@Ignore
	//@Test
	@DisplayName("파일복사")
	public void copy() throws IOException  {
		
		FileOutputStream fw = new FileOutputStream("c:/Temp/copy.txt"); 
		InputStream inputStream = new FileInputStream("c:/Temp/data.txt");
		
		int readByte;
		while((readByte = inputStream.read()) != -1 ) {   //Ctrl + Z
			fw.write(readByte);
		}
		fw.close();
		
	}
	
	
	@Ignore
	//@Test
	@DisplayName("Reader 복사")
	public void copy2() throws IOException {
		FileWriter fw = new FileWriter("c:/Temp/copy3.txt");
		FileReader fr = new FileReader("c:/Temp/data.txt");
		
		int bytesRead = 0;
		char[] readByte = new char[5];
		while((bytesRead = fr.read(readByte)) != -1 ) {   //Ctrl + Z
			fw.write(readByte);
		}
		fw.close();
		
	}
	
	// 여기에서 그냥 Run as.. 실행하면 두개 모두가 실행되기 때문에 '@ignore'을 사용해서 제외시키거나
	// Run as > Run Configuration.. 선택 후 method에서 select > 시행시키고 싶은 메서드만 선택해서 실행
	
	// 왼쪽 Explorer를 보면 src/test/java 부분이 있는데 이쪽에서 사실은 테스트들이 만들어져서 실행되어야한다. 
	// 내일은 Spring 들어갈 예정인데 그렇게 진행할 예정이다. 
	
	
	
	// 한줄씩 읽어내고 싶을 때
	@Ignore
	//@Test
	@DisplayName("버퍼를 통해서 라인입력")
	public void 버퍼입력() throws IOException {
		
		BufferedReader fr = new BufferedReader(new FileReader("c:/Temp/emp.txt"));
		// BufferedReader를 통해서 FileReader를 읽으면 한줄씩 읽어내는 것이 가능
		String str = null;
		while((str = fr.readLine()) != null) {
			// readLine은 null값을 반환하기 때문에 위와 같이 조건을 두고 반복
			System.out.println(str);
			
		}
		fr.close();   // 닫는 것이 정석
		
	}
	
	
	@Test
	@DisplayName("스캐너를 통해서 라인입력")
	public void 스캐너입력() throws IOException{
		
		Scanner scanner = new Scanner(new File("c:/Temp/emp.txt"));
		
		// 여태까지 스캐너를 사용자 입력만 받았지만 위와같이 파일을 읽을 수도 있다. 
		String emp = scanner.nextLine();
		
		// Steven 이름이 출력
		// 1) split 함수 -> 배열로 만들기 
		String[] arr = emp.split(",");
		
		// 2) 출력
		if(arr != null) { 
			System.out.println(arr[1]);			
		}
		
	}
	
	// @Ignore 안먹히면 @Test라도 주석처리해서 빼버릴 것(비권장이긴 하지만)
	
	// 위의 기능들은 엑셀파일을 읽어들일 때 사용할 수 있다.
	 
	
	
}
