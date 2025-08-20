package com.yedam.mapper;


import org.apache.ibatis.annotations.Param;

import com.sun.tools.javac.util.List;
import com.yedam.vo.CommuVO;

public class commuMapper {

public List<CommuVO> selcetCommu(int commuNo);  // 전체 조회  
public CommuVO selectCommuOne(int commuNo); // 단건 조회
public int insertCommu(CommuVO vo); // 등록
public int update(CommuVO vo);  // 수정
public int delete(@Param("commuNo") int commuNo); // 삭제
}


}
