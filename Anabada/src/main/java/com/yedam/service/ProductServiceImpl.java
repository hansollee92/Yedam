package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.CategoryDTO;
import com.yedam.common.DBUtil;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.ProductMapper;
import com.yedam.vo.ProductVO;

public class ProductServiceImpl implements ProductService {

	SqlSession sqlSession = DBUtil.getInstance().openSession();
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

	//상품 목록
	@Override
	public List<ProductVO> productList() {
		return mapper.selectProductList();
	}
	
	//상품 단건조회 + 조회수
	@Override
	public ProductVO findProduct(int prdNo) {
		return mapper.selectProduct(prdNo);
	}
  
	
    @Override
    public List<ProductVO> searchWish(int memberNo) {
        return mapper.selectWish(memberNo);
    }


	@Override
	public List<ProductVO> searchProducts(SearchDTO search, CategoryDTO category) {
		return mapper.selectProducts(search, category);
	}

	@Override
	public int countProducts(SearchDTO search, CategoryDTO category) {
		 return mapper.countProducts(search, category);
	}

	//상품 수정
	@Override
	public boolean productModify(ProductVO product) {
		int r = mapper.updateProduct(product);
		if(r > 0) {
			sqlSession.commit();
			return true;
		}
		return false;
	}


	
 


}


