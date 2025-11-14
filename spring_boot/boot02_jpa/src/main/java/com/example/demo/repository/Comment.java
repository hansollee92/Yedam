package com.example.demo.repository;

import com.example.demo.common.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Table(name="comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Comment extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(columnDefinition = "clob", nullable = false)
	private String content;  // 댓글내용
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Posts posts;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Customer customer; // 작성자

}
