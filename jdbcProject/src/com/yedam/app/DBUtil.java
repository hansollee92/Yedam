package com.yedam.app;

import java.sql.Connection;
import java.sql.DriverManager;

// ojdbc11.jar 외부라이브러리를 추가.
public class DBUtil {
	// DB접속정보 활용 -> 세션(Connection객체)
	
	public static Connection getConnect() {
		// 우리가 사용하고 있는 JavaSE-21버전은 이 sql정보를 처리하는 기능을 가지고 있지 않아서 라이브러리를 설치해야한다. 
		// C:\app\admin\product\21c\dbhomeXE\jdbc\lib 접속 하여 ojdbc11.jar 복사
		// D드라이브에 가서 javaprograme에 해당 파일 붙여넣기
		// 이클립스 jdbcProject 마우스 오른쪽 > [Build Path] > [Configue Build Path] 선택
		// libraries 탭 > classpath 선택 > [add external JARs] 해서 폴더에 넣었던 ojdbc11.jar를 가져옴 
		// 그러면 왼쪽 경로있는 쪽에 'Referenced Libraries'가 만들어지고 아래에 'ojdbc11.jar'가 나타난다. 
		// cf) ojdbc11.jar : 오라클 데이터베이스에 접속할 수 있게 해주는 드라이버로 이 파일을 추가해야 java가 오라클 DB와 통신할 수 있음 
		// 위의 과정은 이 이클립스에 ojdbc11.jar를 외부라이브러리로 추가해주는 과정으로 그래야 자바가 코드에서 이걸 인식한다. 
		
		// static을 추가할 것인데 정적메소드로 
		// 원래 인스턴스를 사용할려면 객체를 생성해서(new)사용해야하는데 
		// static을 사용하면 그냥 바로 사용할 수 있다. 
		
		// Class.forName(""); 이라고 작성하면 에러가 나타나는데 마우스를 호버해서 이클립스에서 예외처리 방법을 두가지 알려주는데 Surround 선택!
		
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");    //자바에서 오라클드라이버 로딩
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			// DriverManager라는 클래스를 통해 오라클 DB(sql)접속을 할수가 있는데 접속주소는 저렇고 DB사용자명과 비번을 입력해준다. 
			    // jdbc:oracle:thin:     --오라클 JDBC드라이버 방식(thin 클라이언트 방식)
			    // @localhost:1521       --내컴퓨터(localhost)에 1521포트(오라클 기본포트)로 접속
			    // xe                    --오라클의 DB이름(EX:Express Edition의미)
			// sql exception의 경우도 일어나서 에러표시가 나는데 catch(Exception e)으로 수정하면 된다. (예외처리는 java뒷부분에서 더 자세히 공부할 예정)			
		} catch (Exception e) {    //예외처리
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	
	
	
	
}// end class
