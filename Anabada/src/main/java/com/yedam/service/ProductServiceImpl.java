package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
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

	// 내가 판매하는 물건 조회
	@Override
	public List<ProductVO> searchSale(int memberNo) {
		return mapper.selectSale(memberNo);
	}

	// 내가 구매한 물건 조회
	@Override
	public List<ProductVO> searchPur(int memberNo) {
		return mapper.selectPur(memberNo);
	}

	//상품 단건조회 + 조회수
	@Override
	public ProductVO findProduct(int prdNo) {
		ProductVO product = mapper.selectProduct(prdNo);
		int r = mapper.updateCntProduct(prdNo);
		if(r > 0) {
			sqlSession.commit();
		}
		return product;
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
	

	//상품 등록
	@Override
	public boolean productInsert(ProductVO vo) {
	 int r = mapper.insertProduct(vo);
	    if (r > 0) {
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
	
	// 상품 판매상태 수정
	@Override
	public boolean productSaleStatus(String saleStatus, int prdNo) {		
		 int r = mapper.updateSaleStatus(saleStatus, prdNo);
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
	public List<ProductVO> searchProducts(SearchDTO search) {
		return mapper.selectProducts(search);
	}

	@Override
	public int countProducts(SearchDTO search) {
		 return mapper.countProducts(search);
	}





	
 


}


