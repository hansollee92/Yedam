package com.example.demo.user.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.service.UserService;
import com.example.demo.user.service.UserVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UserMapper userMapper;
	
	@Override
	public UserVO getUser(String loginId) {
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 단건조회 
		UserVO vo = userMapper.getUser(username);
		
		// 사용자 계정 유무 확인
		if(vo == null) {
			throw new UsernameNotFoundException("없는 아이디입니다.");
		}
		return vo; //UserDatails 구현클래스만 가능
		
	}

}
