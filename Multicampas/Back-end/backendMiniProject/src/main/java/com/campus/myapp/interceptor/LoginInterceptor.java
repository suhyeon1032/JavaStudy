package com.campus.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	// 컨트롤러가 호출되기 전에 실행될 메소드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		// false : 로그인으로 보내기
		// true : 해당 컨트롤러로 이동한다.
		
		// request객체에서 session객체를 얻어오기
		HttpSession session = request.getSession();
		
		// 로그인 상태를 구하기 null
		String logStatus = (String)session.getAttribute("logStatus");
		
		// 반드시 null도 확인해야함
		if(logStatus != null && logStatus.equals("Y")) {	// 로그인 되었을 때
			return true;	// 가던 길 가기
		}else {	// 로그인 안되었을 때
			// 로그인 폼페이지로 이동
			response.sendRedirect(request.getContextPath()+"/member/loginForm");
			return false;
		}
	}
}
