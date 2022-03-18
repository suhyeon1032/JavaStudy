package com.campus.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	//컨트롤러가 호출되기 전에 실행될 메소드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		//false: 로그인으로 보내기
		//ture : 해당 컨트롤러(접속한 컨트롤러)로 이동
		
		//reuest객체에서 session 객체를 얻어오기
		HttpSession session = request.getSession();
		
		//로그인 상태 구하기
		String logStatus = (String)session.getAttribute("logStatus");
		
		if(logStatus!=null &&logStatus.equals("Y")) {//로그인 되었을 때
			return true; //가던길 마저 가소~~
		}else {
			//로그인 홈페이지로 이동
			response.sendRedirect(request.getContextPath()+"/member/loginForm");
			return false;
		}
	}
}
