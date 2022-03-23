package com.campus.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.MemberService;
import com.campus.myapp.vo.MemberVO;

@RestController
public class MemberController {
	@Inject
	MemberService service;

	@GetMapping("/member/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/loginForm");
		return mav;
	}

	@PostMapping("/member/loginOk")
	public ResponseEntity<String> loginOk(MemberVO vo, HttpSession session) {
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=utf-8");

		try {
			MemberVO rVo = service.login(vo);
			if (rVo != null) {// �α��� ����
				session.setAttribute("logId", rVo.getUserid());
				session.setAttribute("logName", rVo.getUsername());
				session.setAttribute("logStatus", "Y");

				String msg = "<script>location.href='/'; </script>";
				entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
			} else {
				throw new Exception(); // �α��� ���� �� ���� �߻���Ű��
			}
		} catch (Exception e) {
			e.printStackTrace();
			// �α��� ����
			String msg = "<script>alert('�α��ο� �����Ͽ����ϴ�.');history.go(-1);</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@GetMapping("/member/logout")
	public ModelAndView logout(HttpSession session) {
		// ���� ���Ű� �α׾ƿ��̴�. ���ο� ������ �Ҵ� �ȴ�. ���� ������ ������ ���ش�.
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
}
