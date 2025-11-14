package com.example.demo.repository;

import com.example.demo.common.BaseTimeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
public class Address extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String zipcode;
	private String address;
	private String detailAddress;
	
	@Builder
	public Address(String zipcode, String address, String detailAddress, Customer customer) {
		super();
		this.zipcode = zipcode;
		this.address = address;
		this.detailAddress = detailAddress;
		this.customer = customer;
	}
	
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	Customer customer;
	
	
	
}
