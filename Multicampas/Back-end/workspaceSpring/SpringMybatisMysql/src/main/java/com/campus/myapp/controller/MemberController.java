package com.campus.myapp.controller;

import org.springframework.stereotype.Controller;
// ȸ������, ȸ����������, �α���, �α׾ƿ�
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	//ȸ������������ �̵��ϴ� ����
	@GetMapping("/member/memberForm")
	public String memberForm() {
		return "member/memberForm"; //	member������ memberForm.jsp������ ��� ����Ѵ�.
		// return ""�� views�������� �ִ� ������ ����.
	}
}
