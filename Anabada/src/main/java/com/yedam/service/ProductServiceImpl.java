package com.yedam.service;

import com.yedam.common.DBUtil;
import com.yedam.mapper.ProductMapper;
import com.yedam.vo.ProductVO;
import org.apache.ibatis.session.SqlSession;

public class ProductServiceImpl implements ProductService {

    SqlSession sqlSession = DBUtil.getInstance().openSession();
    ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);


    @Override
    public ProductVO searchWish(int memberNo) {
        return mapper.selectWish(memberNo);
    }
}
