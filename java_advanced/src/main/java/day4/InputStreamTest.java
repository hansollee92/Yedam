package day4;

import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fw = new FileOutputStream("c:/Temp/data.txt"); 
		// 보통 C드라이브에 Temp폴더가 있음(없으면 만들 것)
		
		int readByte;
		while((readByte = System.in.read()) != -1 ) {   //Ctrl + Z
			fw.write(readByte);
		}
		fw.close();
		
		// 읽어들일때는 뭐든지(키보드가 되든, 마우스가 되든) input으로 읽어들이고
		// 출력할때는 뭐든지 output으로 출력한다는 개념을 기억하고 있을 것!
		
	}
}
