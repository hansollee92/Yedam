package com.yedam.service;

import com.yedam.common.DBUtil;
import com.yedam.mapper.WishMapper;
import org.apache.ibatis.session.SqlSession;

public class WishServiceImpl implements WishService {

    SqlSession sqlSession = DBUtil.getInstance().openSession();
    WishMapper mapper = sqlSession.getMapper(WishMapper.class);

    @Override
    public int searchProductWish(int prdNo) {
        return mapper.selectProductWish(prdNo);
    }
}
