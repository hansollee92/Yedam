package day4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

// 기존의 File 대신 -> Paths, Files 사용
public class PathFileTest {
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("c:/Temp");
		
		// 파일목록
		System.out.println("파일목록 ---------");
		Files.walk(path)
			//.forEach(System.out::println);
			.forEach(s -> System.out.println(s));
		
		// 파일 읽기 
		Path file = Paths.get("c:/Temp", "data.txt");
		List<String> lines = Files.readAllLines(file);
		System.out.println("파일읽기 ---------");
		for(String item : lines) {
			System.out.println(item);
		}
		
		// 파일정보 (크기, 생성(변경)시간)
		System.out.println("파일크기: " + Files.size(file));                    // 크기
		System.out.println("파일생성시간: " + Files.getLastModifiedTime(file));  //생성(변경)시간
		
		// 파일 저장
		Path newFile = Paths.get("c:/Temp", "path.txt");
		Files.write(newFile, Arrays.asList("Hello", "Java"));
		
		// 파일명 변경
		// https://mine-it-record.tistory.com/434#google_vignette
//		File oldfile = new File("c:/mine_data/mine(1).txt");
//		oldfile.renameTo(oldfile);
				
		// 파일 삭제 
		
		
	}
}
