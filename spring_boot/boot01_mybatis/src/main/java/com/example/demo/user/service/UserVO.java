package com.example.demo.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails {

	private static final long serialVersionUID = 1L;  
	
	/*
	 UserVO가 Serializable을 구현하면 JVM은 내부적으로 버전 ID(serialVersionUID) 를 자동 생성합니다.
     그런데 클래스 구조(필드 추가/삭제 등)가 바뀌면 이 값이 자동으로 새로 계산되어 다른 숫자가 됩니다.
     톰캣은 세션을 파일로 저장했다가 다시 로드하면서,
     이 값이 다르면 “이건 예전에 저장된 클래스와 버전이 다르다”고 보고 역직렬화를 거부
     
     그래서 private static final long serialVersionUID = 1L; 넣으니까 해결된 이유
		이걸 직접 지정하면 자동 계산이 멈춰서
		클래스 구조가 바뀌어도 serialVersionUID가 바뀌지 않습니다.
		톰캣이 “아, 그래도 같은 버전의 객체구나” 하고 세션을 정상적으로 복원할 수 있게 되죠.
	 
	 */
	
	private Long id;
	private String loginId;
	private String password;
	private String fullName;
	private String deptName;
	private List<String> role;
	
	// 아래 메소드들을 조정해서 로그인들을 제어할 수 있다. (-> UserDetails에 모두 들어있음)
	// 관리자인지 유저인지 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		for(String r : role) {
			list.add(new SimpleGrantedAuthority(r));
		}
		return list;
	}
	@Override
	public String getUsername() {
		return loginId;
	}
	
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
