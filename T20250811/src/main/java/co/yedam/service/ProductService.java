package co.yedam.service;

import java.util.List;

import co.yedam.vo.ProductVO;

public interface ProductService {
	String cheeringMessage();
	String hintMessage(String remainTimeString);
	// 상품목록 메소드정의.
	public List<ProductVO> productList(); 		
	// 상품상세 메소드정의.
	public ProductVO searchProduct(String prdCode);
}
