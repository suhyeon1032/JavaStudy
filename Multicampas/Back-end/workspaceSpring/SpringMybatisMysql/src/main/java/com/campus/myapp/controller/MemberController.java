package com.campus.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//ȸ������, ȸ������ ����, �α���, �α׾ƿ�
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.MemberService;
import com.campus.myapp.vo.MemberVO;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Inject
	MemberService service;
	
	//ȸ������������ �̵��ϴ� ����
	@GetMapping("memberForm")
	public String memberForm() {
		return "member/memberForm";//    member������ memberForm.jsp������ ��� ����Ѵ�
	}
	//ȸ�����
	@PostMapping("memberOk")
    public String memeberFormOk(MemberVO vo, Model model) {
		//ȸ�����
		int cnt = service.memberInsert(vo);
		
		//Ŭ���̾�Ʈ �������� insert result�� ������.
		model.addAttribute("cnt", cnt);
		
		return "member/memberResult";
	}
	
	//�α��� ������ �̵��ϴ� ��
	@GetMapping("loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	//�α��� ��
	@PostMapping("loginOk")
	public ModelAndView loginOk(MemberVO vo, HttpSession session) {
		//request usrid, userpwd�� ��ġ�ϴ� ���ڵ��� userid, username�� ����
		MemberVO vo2 = service.loginCheck(vo);
		
		ModelAndView mav = new ModelAndView();
		
		//1)�α��� ���� : session�� ���̵�� �̸��� �����ϰ� Ȩ���� �̵�
		if(vo2!=null) {
			session.setAttribute("logId", vo2.getUserid());
			session.setAttribute("logName", vo2.getUsername());
			session.setAttribute("logStatus", "Y");
			
			mav.setViewName("redirect:/");//redirect:��Ʈ�ѷ����� �ٸ� ��Ʈ�ѷ� ���� �ּҸ� �ٷ� ȣ��("/"�� ���ε� ������ ����
		}else {//2)�α��� ���� : �α��� ������ �̵�
			mav.setViewName("redirect:loginForm");
		}
		return mav;
	}
	
	//�α׾ƿ����� �̵�
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		//���� ��ü�� ����� ���ǿ� ����� �α��� ���� �� ��� �����Ͱ� �����ǰ�
		//���ο� ������ �Ҵ��Ѵ�.
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	//ȸ������ ����(��)
	@GetMapping("memberEdit")
	public ModelAndView memberEdit(HttpSession session) {
		String userid = (String)session.getAttribute("logId");
		
		MemberVO vo = service.memberSelect(userid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo",vo);
		
		mav.setViewName("member/memberEdit");
		
		return mav;
	}
	//ȸ����������(DB)
	@PostMapping("memberEditOk")
	public ResponseEntity mamberEditOk(MemberVO vo, HttpSession session) {
		//session�� �α��� ���̵� Ȯ��
		vo.setUserid((String) session.getAttribute("logId"));
		
		ResponseEntity<String> entity =null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-Type","text/html;charset=utf-8");
		
		try {//1. ������
			if(service.memberUpdate(vo)!=0) {//1-1 : ���� ����
				String msg = "<script>";
				msg+="alert('ȸ�������� �����߾��!');";
				msg+="location.href='/myapp/member/memberEdit';";
				msg+="</script>";
				entity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);//(���ڿ�,���ڵ�Ÿ��,HttpStatus.OK : 200)
			}else {//1-2 : ���� ����
				String msg = "<script>";
				msg+="alert('ȸ������ ������ �����߾��..\\n�Ƹ�..��й�ȣ ����..?\\n�˼������� ó������ �ٽ� �Է����ֽǷ���?');";
				msg+="location.href='/myapp/member/memberEdit';";
				msg+="</script>";
				entity = new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
			}
			service.memberUpdate(vo);
			
			
		}catch(Exception e) {//2. ���ܹ߻�
			e.printStackTrace();
			//��Ͼȵ�..
			String msg = "<script>";
			msg+="alert('ȸ������ ������ �����߾��..\\n����...��..���ܰ�..�߻��߾��...����..�˼��ؿ�..');";
			msg+="history.back();";
			msg+="</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
		}
			return entity;
	}
	
	//���̵� �ߺ��˻�
	@PostMapping("memberIdCheck")
	@ResponseBody
	public int idCheck(String userid) {
		int cnt = service.idCheck(userid);
		return cnt;
	}
}
