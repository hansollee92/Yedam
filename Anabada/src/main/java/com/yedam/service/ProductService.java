package com.yedam.service;

import java.util.List;

import com.yedam.vo.ProductVO;
import com.yedam.vo.SearchVO;

public interface ProductService {
	List<ProductVO> productList(ProductVO dao);
	public ProductVO searchWish (int memberNo);
	
	public ProductVO findProduct(int prdNo);    //상품단건조회
	public List<ProductVO> productList();       //상품목록
	
	 List<ProductVO> searchProducts(SearchVO s);
	 int countProducts(SearchVO s);
	  
}
	  
	  
	  
	  
	  
	  
	  
	

