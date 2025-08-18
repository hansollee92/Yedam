package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.ProductMapper;
import com.yedam.vo.ProductVO;
import com.yedam.vo.SearchVO;

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
	
	// 상품삭제
	@Override
	public boolean productRemove(int prdNo) {
		int r = mapper.deleteProduct(prdNo);
		if(r > 0) {
			sqlSession.commit();
			return true;
		}		
		return false;
	}
	
    @Override
    public List<ProductVO> searchWish(int memberNo) {
        return mapper.selectWish(memberNo);
    }


	@Override
	public List<ProductVO> searchProducts(SearchVO s) {
		return mapper.selectProducts(s);
	}

	@Override
	public int countProducts(SearchVO s) {
		 return mapper.countProducts(s);
	}



 


}


