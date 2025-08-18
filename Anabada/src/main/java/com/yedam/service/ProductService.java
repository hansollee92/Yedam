package com.yedam.service;

import java.util.List;

import com.yedam.vo.ProductVO;
import com.yedam.vo.SearchVO;

public interface ProductService {
	public boolean productModify(ProductVO product);   //상품수정 	 
	public ProductVO findProduct(int prdNo);       //상품(단건조회 + 조회수)
	public List<ProductVO> searchWish (int memberNo); // 찜한 상품 조회
	public List<ProductVO> searchProducts(SearchVO s);  //검색목록
	public int countProducts(SearchVO s); //페이징
	public List<ProductVO> productList();          //상품목록
	public List<ProductVO> searchSale (int memberNo); // 내가 판매하는 물건 조회
	public List<ProductVO> searchPur (int memberNo);  // 내가 구매한 물건 조회

}	  
	  
	  
	  
	  
	  
	  
	


	
	
	
   

	
	


