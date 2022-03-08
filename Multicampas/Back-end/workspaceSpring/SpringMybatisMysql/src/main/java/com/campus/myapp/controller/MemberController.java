package com.campus.myapp.controller;

import org.springframework.stereotype.Controller;
// 회원가입, 회원정보수정, 로그인, 로그아웃
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	//회원가입폼으로 이동하는 매핑
	@GetMapping("/member/memberForm")
	public String memberForm() {
		return "member/memberForm"; //	member폴더에 memberForm.jsp파일을 뷰로 사용한다.
		// return ""은 views페이지에 있는 곳으로 간다.
	}
}
