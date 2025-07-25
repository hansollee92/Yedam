package com.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// MyBatis 환경을 읽어들이고 SqlSessionFactory를 생성해주는 기능을 넣을 예정
public class DBUtil {

	//
	public static SqlSessionFactory getInstance() {
		String resource = "com/yedam/common/mybatis-config.xml";
		// 우리가 만들어야할 파일이 mybatis-config.xml 이거인데 이걸 읽어들여서 자바에서 쓰는 객체로 변환해주는 작업을 한다.
		// 내부적으로 어떤식으로 흘러가는지는 정확히 알수없지만 SqlSessionFactoryBuilder()이 그걸 처리한다.
		
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}



