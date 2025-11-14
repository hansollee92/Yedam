package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.repository.PostsRepository;
import com.example.demo.service.PostService;
import com.example.demo.service.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{
	
	final PostsRepository postsRepository;  // 생성자방식
	
	@Override
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}

}
