package com.yedam.service;

import java.util.List;

import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.vo.ProductVO;

public interface ProductService {

	  public List<ProductVO> searchSale (int memberNo); // 내가 판매하는 물건 조회
	  public List<ProductVO> searchPur (int memberNo);  // 내가 구매한 물건 조회

	  public List<ProductVO> productList();                 //상품목록
	  public ProductVO findProduct(int prdNo);              //상품(단건조회 + 조회수 + 문의하기 게시판)
	  public boolean productModify(ProductVO product);      //상품수정 	 
	  public boolean productRemove(int prdNo);              //상품삭제
	  public boolean productSaleStatus(String saleStatus, int prdNo);  //상품 판매상태 수정
    
      public ProductVO productInsert();    // 상품등록
  
	  public List<ProductVO> searchProducts(SearchDTO search);  //검색목록 / 검색결과
	  int countProducts(SearchDTO search); //페이징 
	  public List<ProductVO> searchWish (int memberNo);  //찜한 상품 조회  


}	  
	  
	  
	  
