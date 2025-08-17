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

	@Override
	public ProductVO findProduct(int prdNo) {
		return mapper.selectProduct(prdNo);
	}

    @Override
    public List<ProductVO> searchWish(int memberNo) {
      return mapper.selectWish(memberNo);
    }

    @Override
    public List<ProductVO> productList(ProductVO dao) {
        return mapper.productList(dao);
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
    public String getProductImage(int prdNo) {
        return mapper.getProductImage(prdNo);
    }

    @Override
    public int clearProductImage(int prdNo) {
        return mapper.clearProductImage(prdNo);
    }



}


