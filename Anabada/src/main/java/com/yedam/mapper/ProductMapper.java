package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ProductVO;

public interface ProductMapper {
	List<ProductVO> productList(ProductVO dao);
	List<ProductVO> selectWish(int memberNo); // 내가 찜한 상품 조회
	ProductVO selectProduct(int prdNo); //상품단건조회
	int updateProductImage(Map<String, Object> param); // 상품 이미지 경로 업데이트
	String getProductImage(int prdNo); // 상품 이미지 경로 조회
	int clearProductImage(int prdNo); // 상품 이미지 경로 삭제
	List<ProductVO> selectProductList();     //상품목록
    
	
	// 한솔이가 확인하고 아래 주석풀고 사용할지 말지 결정
	
	// 상품 이미지 경로 업데이트
	// public List<ProductVO> selectRecentImage(@Param("limit") int limit); //최신상품 가져오기
	// public List<ProductVO> selectProductList(Map<String,Object> param);
	// public List<ProductVO> selectCategoryRecent(@Param("category") String category, @Param("limit") int limit);
	// public List<ProductVO> selectCategoryPopular(@Param("category") String category,  @Param("limit") int limit);

}
