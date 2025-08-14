package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.ProductMapper;
import com.yedam.vo.ProductVO;

public class ProductServiceImpl implements ProductService {
	
	SqlSession sqlSession = DBUtil.getInstance().openSession();
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

	@Override
	public ProductVO findProduct(int prdNo) {
		return mapper.selectProduct(prdNo);
	}  
  
  @Override
  public ProductVO searchWish(int memberNo) {
      return mapper.selectWish(memberNo);
  }

}

