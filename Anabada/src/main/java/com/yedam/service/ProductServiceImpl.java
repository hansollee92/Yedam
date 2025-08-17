package com.yedam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
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
	
	//상품 단건조회
	@Override
	public ProductVO findProduct(int prdNo) {
		return mapper.selectProduct(prdNo);
	}


  @Override
  public List<ProductVO> searchWish(int memberNo) {
    return mapper.selectWish(memberNo);
  }

  @Override
  public int updateProductImage(int prdNo, String prdImg) {
      if (prdImg == null || prdImg.isBlank()) {
          throw new IllegalArgumentException("prdImg가 비어있습니다.");
      }
      Map<String, Object> param = new HashMap<>();
      param.put("prd_no", prdNo);
      param.put("prd_img", prdImg);
      return mapper.updateProductImage(param);
  }
  
  @Override
	public List<ProductVO> getMainRecent(int limit) {
		int safeLimit = (limit <= 0 || limit > 50) ? 12 : limit; //기본값/ 상한선
		return mapper.selectRecentImage(limit);
	}

  @Override
	public List<ProductVO> findList(Map<String,Object> param) {
	    return mapper.selectProductList(param);
	}

	@Override
	public List<ProductVO> productList(ProductVO dao) {
		// TODO Auto-generated method stub
		return null;
	}

}


