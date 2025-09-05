package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;

import com.yedam.vo.ProductVO;

public interface ProductMapper {

    public List<ProductVO> selectProductList();                   //상품 목록
    public ProductVO selectProduct(int prdNo);                    //상품 단건조회
    public int updateCntProduct(int prdNo);                       //상품 조회수증가
    public int updateProduct(ProductVO product);                  //상품 수정
    public int deleteProduct(int prdNo);                          //상품 삭제
    public int updateSaleStatus(@Param("saleStatus") String saleStatus, @Param("prdNo") int prdNo);    //상품 판매상태 수정
    
    public List<ProductVO> selectWish(int memberNo);  // 내가 찜한 상품 조회
    public List<ProductVO> selectProducts(SearchDTO search);  // 검색목록
    public int countProducts(SearchDTO search);               // 총건수
    public int insertProduct(ProductVO vo);             // 상품등록
    public List<ProductVO> selectSale(int memberNo);    // 내가 판매하는 물건 조회
    public List<ProductVO> selectPur(int memberNo);     // 내가 구매한 물건 조회
    public String selectProductMember(int prdNo);       // 상품 등록한 사용자 조회


}
