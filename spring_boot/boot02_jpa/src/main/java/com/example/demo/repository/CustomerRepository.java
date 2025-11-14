package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByName(String name);
	List<Customer> findByNameLike(String name);
	
	// 특정단어가 포함된 이메일 조회
	List<Customer> findByEmail(String email);
	List<Customer> findByEmailLike(String email);
	
	// 이름 또는 특정단어가 포함된 이메일 조회
	List<Customer> findByNameOrEmail(String name, String email);
	
	
	
	// 네이티브 쿼리(스프링부트_JPA.pdf p29)
	// @Query(value="SELECT * FROM customer WHERE phone = ?1 OR name = ?2", nativeQuery = true) ?1 ?2 이런식으로 작성도 가능하며
	// 아래와 같이 @Param해서 작성도 가능하다. 
	@Query(value="SELECT * FROM customer WHERE phone = :phone OR name = :name", nativeQuery = true)
	List<Object[]> findAllNative(@Param("phone") String phone, @Param("name") String name);
	
	@Query(value="SELECT * FROM customer WHERE phone = :phone OR name = :name", nativeQuery = true)
	List<CustomerNative> findAllNativeVO(@Param("phone") String phone, @Param("name") String name);
	
	
	
	// JPQL
	@Query("SELECT c FROM Customer c ORDER BY id DESC")    
	List<Customer> findAllQuery();
	// 테이블명, 칼럼이 아니기 때문에 대소문자 구분함
	
	
	
	
	
	
	
	
	
	
	
}
