package com.yedam.service;

import com.yedam.vo.ProductVO;

public interface ProductService {

    public ProductVO searchWish (int memberNo);
	  public ProductVO findProduct(int prdNo);    //상품단건조회
	

}
