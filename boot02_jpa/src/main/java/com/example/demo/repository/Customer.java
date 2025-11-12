package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/* ORM */
//@DynamicUpdate
@NoArgsConstructor   // 빌더를 하면 이거 넣어줘야함
@Getter
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)    // 이거 빼먹으면 기본키 생성이 안됨
	Long id;
	
	@Column(length = 20, nullable = false)
	String name;
	String phone;
	
	String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	LocalDateTime regdate;
	
	// 생성자
	// 그냥 위에 builder하면 모든거에 대해서 빌더를 만들텐데 우리는 name, phone, email만 필요하니
	// 이렇게 생성자를 만들어서 위에 빌더를 붙여준다. 
	@Builder
	public Customer(String name, String phone, String email, Address address) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address.add(address);
	}
	
	
	// 메서드
	public void updateNameAndEmail(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	List<Address> address = new ArrayList<Address>();
	
	
}
