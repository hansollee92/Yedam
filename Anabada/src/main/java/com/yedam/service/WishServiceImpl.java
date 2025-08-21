package com.yedam.service;

import com.yedam.common.DBUtil;
import com.yedam.mapper.WishMapper;
import com.yedam.vo.WishVO;
import org.apache.ibatis.session.SqlSession;

public class WishServiceImpl implements WishService {

    SqlSession sqlSession = DBUtil.getInstance().openSession();
    WishMapper mapper = sqlSession.getMapper(WishMapper.class);

    @Override
    public int countProductWish(int prdNo) {
        return mapper.countWishMember(prdNo);
    }

    @Override
    public int findProductMember(int prdNo) {
        return mapper.selectWishProduct(prdNo);
    }

    @Override
    public boolean registerWish(WishVO wish) {
        int r = mapper.insertWish(wish);
        if (r > 0) {
            sqlSession.commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeWish(WishVO wish) {
        int r = mapper.deleteWish(wish);
        if (r > 0) {
            sqlSession.commit();
            return true;
        }
        return false;
    }
}
