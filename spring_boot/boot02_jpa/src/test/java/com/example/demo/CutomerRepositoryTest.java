package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.Customer;
import com.example.demo.repository.CustomerNative;
import com.example.demo.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CutomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressRepository addressRepository;

	// 단위테스트가 끝날때 마다 수행
//	@AfterEach
//		void cleanup() {
//		customerRepository.deleteAll();
//	}

	@Disabled
	@Transactional
	@Commit // @Rollback 해도 되고 위에 있는 것처럼 작성을 해도 된다.
	@Test
	public void 고객_등록() {
		// given
		String name = "홍길동";
		String phone = "011";
		Customer customer = Customer.builder().name(name).phone(phone).build();

		customerRepository.save(customer);
		// when
		List<Customer> customerList = (List<Customer>) customerRepository.findAll();

		// then
		assertEquals(customerList.get(0).getName(), name);
		log.info("조회된	고객	이름:	{}", customerList.get(0).getName());
	}

	//@Disabled
	@Test
	public void 고객_수정() {
		// given - 초기 데이터 저장
		String name = "홍길동";
		String phone = "011";
		Customer saved = customerRepository.save(Customer.builder().name(name).phone(phone).build());

		// when - 고객 정보 수정
		Customer customer = customerRepository.findById(saved.getId()).orElse(new Customer());
		customer.updateNameAndEmail("희동", ""); // setter 대신에 메서드를 만들어서 사용함
		Customer updated = customerRepository.save(customer);

		customer.updateNameAndEmail("고길동", "a@a.a");
		updated = customerRepository.save(customer);

		// then
		assertEquals(updated.getName(), customer.getName());
		log.info("수정된	고객	이름:	{}", updated.getName());
	}

	@Disabled
	@Test
	public void 이름_조회() {
		// given
		String name = "둘리";
		String email = "com";

		// when
		List<Customer> list = customerRepository.findByName(name);
		List<Customer> list2 = customerRepository.findByNameLike("%동%");
		list2.stream().forEach(cust -> System.out.println(cust.getName()));

		// 문제1) 이메일검색
		List<Customer> emailList = customerRepository.findByEmail(email);
		List<Customer> emailList2 = customerRepository.findByEmailLike("%om%");
		emailList2.stream().forEach(lis -> System.out.println("이메일검색: " + lis.getName() + lis.getEmail()));

		// 문제2) 특정 단어가 이름 또는 이메일에 포함된 경우(Or)
//		List<Customer> NameOrEmailList = customerRepository.findByNameOrEmail(name, email);
//		NameOrEmailList.stream().forEach(cust -> System.out.println("이름 또는 이메일 검색: " + cust.getName() + cust.getEmail()));

		// then
		assertEquals(list.get(0).getName(), name);

	}

	@Disabled
	@Test
	public void 네이티브_쿼리() {
		List<Object[]> list = customerRepository.findAllNative("011", "둘리");

		// 이름 폰번호 출력
		for (Object[] item : list) {
			System.out.println(item[0] + " : " + item[1]);
		}

		// List<VO>로 결과받기
		List<CustomerNative> list2 = customerRepository.findAllNativeVO("011", "고길동");
		for (CustomerNative item : list2) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getPhone());
		}

	}

	// JPQL
	@Disabled
	@Test
	public void jpql_test() {
		List<Customer> list = customerRepository.findAllQuery();
		list.stream().forEach(cust -> System.out.println(cust.getName() + " : " + cust.getPhone()));
	}

	// 연관 관계 매핑(일대다)
	@Disabled
	@Test
	public void 일대다() {
		// given(준비)
		// 고객준비
		Customer customerentity = Customer.builder()
				                          .name("길동")
				                          .phone("019")
				                          .email("c@c.c")
				                          .build();
		Customer saved = customerRepository.save(customerentity);
		
		// 주소등록
		addressRepository.save(Address.builder().zipcode("01000")
				                                .address("서울")
				                                .customer(customerentity)
				                                .build());
		addressRepository.save(Address.builder().zipcode("04411").address("대구").customer(customerentity).build());
		
		// when(실행)
		// 고객조회
		Customer customer = customerRepository.findById(saved.getId()).get();
		customer.getAddress()
		        .forEach(addr -> System.out.println(addr.getZipcode() + " : " + addr.getAddress()));
		
		// then(검증)
		assertEquals("04411", customer.getAddress().get(0).getZipcode());
	}

}
