package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ProductVO;
import com.yedam.vo.SearchVO;

public interface ProductMapper {

    public List<ProductVO> selectProductList();       //상품 목록
    public ProductVO selectProduct(int prdNo);        //상품 단건조회
    public int updateCntProduct(int prdNo);           //상품 조회수증가
    public int updateProduct(ProductVO product);      //상품 수정
    public List<ProductVO> selectWish(int memberNo);  // 내가 찜한 상품 조회
    public ProductVO selectWish(int memberNo);        //찜목록
    public List<ProductVO> selectProducts(SearchVO s);  // 목록
    public int countProducts(SearchVO s);               // 총건수
    public int insertProduct(ProductVO vo);             // 상품등록

}
