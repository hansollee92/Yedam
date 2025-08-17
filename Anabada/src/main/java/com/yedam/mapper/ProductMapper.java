package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ProductVO;

public interface ProductMapper {
	List<ProductVO> productList(ProductVO dao);

    public ProductVO selectWish(int memberNo);
    public ProductVO selectProduct(int prdNo);      //상품단건조회
	// 상품 이미지 경로 업데이트
	int updateProductImage(Map<String, Object> param);

	List<ProductVO> selectRecentImage(@Param("limit") int limit); //최신상품 가져오기
	List<ProductVO> selectProductList(Map<String,Object> param);
	
	List<ProductVO> selectCategoryRecent(
		@Param("category") String category,
		@Param("limit") int limit);
	
	 List<ProductVO> selectCategoryPopular(
	    @Param("category") String category,
	    @Param("limit")    int limit);
	 

}
