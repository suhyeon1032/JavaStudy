package com.campus.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//회원가입, 회원정보 수정, 로그인, 로그아웃
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
	
	//회원가입폼으로 이동하는 매핑
	@GetMapping("memberForm")
	public String memberForm() {
		return "member/memberForm";//    member폴더에 memberForm.jsp파일을 뷰로 사용한다
	}
	//회원등록
	@PostMapping("memberOk")
    public String memeberFormOk(MemberVO vo, Model model) {
		//회원등록
		int cnt = service.memberInsert(vo);
		
		//클라이언트 페이지로 insert result를 보낸다.
		model.addAttribute("cnt", cnt);
		
		return "member/memberResult";
	}
	
	//로그인 폼으로 이동하는 맵
	@GetMapping("loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	//로그인 후
	@PostMapping("loginOk")
	public ModelAndView loginOk(MemberVO vo, HttpSession session) {
		//request usrid, userpwd와 일치하는 레코드의 userid, username를 선택
		MemberVO vo2 = service.loginCheck(vo);
		
		ModelAndView mav = new ModelAndView();
		
		//1)로그인 성공 : session에 아이디와 이름을 저장하고 홈으로 이동
		if(vo2!=null) {
			session.setAttribute("logId", vo2.getUserid());
			session.setAttribute("logName", vo2.getUsername());
			session.setAttribute("logStatus", "Y");
			
			mav.setViewName("redirect:/");//redirect:컨트롤러에서 다른 컨트롤러 매핑 주소를 바로 호출("/"로 매핑된 곳으로 가라
		}else {//2)로그인 실패 : 로그인 폼으로 이동
			mav.setViewName("redirect:loginForm");
		}
		return mav;
	}
	
	//로그아웃으로 이동
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		//세션 객체를 지우면 세션에 저장된 로그인 정보 등 모든 데이터가 삭제되고
		//새로운 세션을 할당한다.
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	//회원정보 수정(폼)
	@GetMapping("memberEdit")
	public ModelAndView memberEdit(HttpSession session) {
		String userid = (String)session.getAttribute("logId");
		
		MemberVO vo = service.memberSelect(userid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo",vo);
		
		mav.setViewName("member/memberEdit");
		
		return mav;
	}
	//회원정보수정(DB)
	@PostMapping("memberEditOk")
	public ResponseEntity mamberEditOk(MemberVO vo, HttpSession session) {
		//session의 로그인 아이디 확인
		vo.setUserid((String) session.getAttribute("logId"));
		
		ResponseEntity<String> entity =null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-Type","text/html;charset=utf-8");
		
		try {//1. 정상구현
			if(service.memberUpdate(vo)!=0) {//1-1 : 수정 성공
				String msg = "<script>";
				msg+="alert('회원정보를 수정했어요!');";
				msg+="location.href='/myapp/member/memberEdit';";
				msg+="</script>";
				entity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);//(문자열,인코딩타입,HttpStatus.OK : 200)
			}else {//1-2 : 수정 실패
				String msg = "<script>";
				msg+="alert('회원정보 수정에 실패했어요..\\n아마..비밀번호 문제..?\\n죄송하지만 처음부터 다시 입력해주실래요?');";
				msg+="location.href='/myapp/member/memberEdit';";
				msg+="</script>";
				entity = new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
			}
			service.memberUpdate(vo);
			
			
		}catch(Exception e) {//2. 예외발생
			e.printStackTrace();
			//등록안됨..
			String msg = "<script>";
			msg+="alert('회원정보 수정에 실패했어요..\\n뭔지...모를..예외가..발생했어요...엉엉..죄송해요..');";
			msg+="history.back();";
			msg+="</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
		}
			return entity;
	}
	
	//아이디 중복검사
	@PostMapping("memberIdCheck")
	@ResponseBody
	public int idCheck(String userid) {
		int cnt = service.idCheck(userid);
		return cnt;
	}
}
