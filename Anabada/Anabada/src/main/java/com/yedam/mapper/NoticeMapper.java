package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.NoticeVO;

public interface NoticeMapper {
	
   public List<NoticeVO> selectNoticeList();    // 전체 공지
    
}
