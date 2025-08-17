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
    


}
