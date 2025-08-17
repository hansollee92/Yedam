package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ProductVO;

public interface ProductMapper {

    
    public List<ProductVO> selectProductList();     //상품목록
    public ProductVO selectProduct(int prdNo);      //상품단건조회
    
    
    public ProductVO selectWish(int memberNo);
    
    
    
    
    
    
    
    
    
	// 상품 이미지 경로 업데이트
	public int updateProductImage(Map<String, Object> param);

	public List<ProductVO> selectRecentImage(@Param("limit") int limit); //최신상품 가져오기
	public List<ProductVO> selectProductList(Map<String,Object> param);
	
	public List<ProductVO> selectCategoryRecent(@Param("category") String category, @Param("limit") int limit);
	
	public List<ProductVO> selectCategoryPopular(@Param("category") String category,  @Param("limit") int limit);
	 

}
