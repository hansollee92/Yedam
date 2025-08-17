package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ProductVO;

public interface ProductMapper {

    public List<ProductVO> selectProductList();     //상품 목록
    public ProductVO selectProduct(int prdNo);      //상품 단건조회
    public int updateCntProduct(int prdNo);         //상품 조회수증가 
    public int updateProduct(ProductVO product);    //상품 수정
    
    public List<ProductVO> productList(ProductVO dao);
	  public List<ProductVO> selectWish(int memberNo); // 내가 찜한 상품 조회

	  public int updateProductImage(Map<String, Object> param); // 상품 이미지 경로 업데이트
	  public String getProductImage(int prdNo); // 상품 이미지 경로 조회
	  public int clearProductImage(int prdNo); // 상품 이미지 경로 삭제
    

}
