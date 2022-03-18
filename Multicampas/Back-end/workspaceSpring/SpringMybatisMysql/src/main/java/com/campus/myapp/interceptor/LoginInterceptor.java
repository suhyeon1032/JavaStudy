package com.campus.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	//��Ʈ�ѷ��� ȣ��Ǳ� ���� ����� �޼ҵ�
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		//false: �α������� ������
		//ture : �ش� ��Ʈ�ѷ�(������ ��Ʈ�ѷ�)�� �̵�
		
		//reuest��ü���� session ��ü�� ������
		HttpSession session = request.getSession();
		
		//�α��� ���� ���ϱ�
		String logStatus = (String)session.getAttribute("logStatus");
		
		if(logStatus!=null &&logStatus.equals("Y")) {//�α��� �Ǿ��� ��
			return true; //������ ���� ����~~
		}else {
			//�α��� Ȩ�������� �̵�
			response.sendRedirect(request.getContextPath()+"/member/loginForm");
			return false;
		}
	}
}
