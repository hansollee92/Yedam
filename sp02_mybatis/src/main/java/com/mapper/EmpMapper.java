package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {
	List<Employee> selectall();         // 다건조회(목록)
	Map selectone(int id);         // 단건조회
}

// @Mapper를 넣어주는 이유는 
// @Mapper는 MyBatis에서 **이 인터페이스가 Mapper(즉, SQL을 실행할 객체)**라는 것을 스프링이 인식하게 해주는 어노테이션이에요.
// <mybatis-spring:scan>이 com.mapper 패키지를 자동 스캔하긴 하지만,그 안의 인터페이스가 Mapper라는 표시(@Mapper)가 있어야 실제 Bean으로 등록됩니다.