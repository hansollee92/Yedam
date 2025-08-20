package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.NoticeMapper;
import com.yedam.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

    SqlSession sqlSession = DBUtil.getInstance().openSession();
    NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
	
	//공지사항 다건조회
	@Override
	public List<NoticeVO> noticeList() {
		return mapper.selectNoticeList();
	}

}
