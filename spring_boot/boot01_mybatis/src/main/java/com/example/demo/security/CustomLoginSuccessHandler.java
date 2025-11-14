package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.user.service.UserVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			                 HttpServletResponse response,
			                 Authentication auth) throws IOException, ServletException {
		//단건조회
		UserVO dto = (UserVO)auth.getPrincipal();
		
		//session
		request.getSession().setAttribute("userid", dto.getId());
		request.getSession().setAttribute("deptName", dto.getDeptName());
		
		//username, role
		List<String> roleNames = new ArrayList<>();		
		auth.getAuthorities().forEach( authority -> {
			roleNames.add( authority.getAuthority());
		}  );		
		System.out.println("roleName:" + roleNames);
		
		if ( roleNames.contains("ROLE_ADMIN") ) {
			response.sendRedirect("/empMain");
			return;
		} else if ( roleNames.contains("ROLE_USER") ) {
			response.sendRedirect("/board");
			return;
		} 
		response.sendRedirect("/");
	}

}
