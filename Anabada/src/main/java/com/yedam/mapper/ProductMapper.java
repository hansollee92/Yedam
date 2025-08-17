package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ProductVO;
import com.yedam.vo.SearchVO;

public interface ProductMapper {

    
    public List<ProductVO> selectProductList();     //상품목록
    public ProductVO selectProduct(int prdNo);      //상품단건조회
    
    
    public ProductVO selectWish(int memberNo);
    
    List<ProductVO> selectProducts(SearchVO s);  // 목록
    int countProducts(SearchVO s);               // 총건수
           
}

      
       
    
    
    
    
    
    
    
    
    

	

