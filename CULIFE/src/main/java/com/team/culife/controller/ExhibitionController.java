package com.team.culife.controller;

import java.nio.charset.Charset;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.team.culife.service.ExhibitionService;
import com.team.culife.service.MemberService;
import com.team.culife.vo.ExhibitionVO;
import com.team.culife.vo.MemberVO;

@RestController
public class ExhibitionController {
	@Inject
	MemberService memberService;
	@Inject
	ExhibitionService exhibitionService;
	
	@GetMapping("authorWrite")
	public ModelAndView authorApply(HttpSession session,ExhibitionVO vo) {
		ModelAndView mav = new ModelAndView();
		Integer memberNo = (Integer)session.getAttribute("logNo");
		MemberVO mvo = memberService.memberSelectByNo(memberNo);
		mav.addObject("mvo", mvo);
		
		System.out.println(mvo.getNickname());
		System.out.println(mvo.getNo());
		 
		mav.setViewName("exhibition/authorWrite");
		return mav;
	}
	/*
	@PostMapping("authorWriteOk") 
		public ResponseEntity<String> authorWriteOk(HttpSession session, HttpServletRequest request, ExhibitionVO vo) { 
		ModelAndView mav = new ModelAndView(); 
		Integer memberNo =(Integer)session.getAttribute("logNo"); ResponseEntity<String> entity = null;

		System.out.println("author " + vo.getAuthor());
		return entity; 
	}
	 */
	/*
	@PostMapping("authorWriteOk")
	public @ResponseBody void authorWriteOk(@RequestParam Map<String, Object> param, HttpServletRequest request, ExhibitionVO vo) {
		System.out.println("memberno "+ (String)param.get("member_no"));
		System.out.println("nickname "+ (String)param.get("author"));
		
		exhibitionService.authorWriteOk(param);
		System.out.println("넘어왔나?");
	}
	*/
	@PostMapping("authorWriteOk")
	public ResponseEntity<String> authorWriteOk(ExhibitionVO vo, HttpServletRequest request){
		vo.setMember_no((Integer)request.getSession().getAttribute("logNo"));
		System.out.println("author " + vo.getAuthor());
		ResponseEntity<String> entity = null;
		System.out.println("no " + vo.getMember_no());
		System.out.println("sns_link  " + vo.getSns_link());
		System.out.println("author_thumbnail " + vo.getAuthor_thumbnail());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html",Charset.forName("UTF-8")));
		
		
        try {
        	exhibitionService.authorWrite(vo);
        	String msg = "<script>alert('글이 등록되었습니다.');location.href='/exhibition/authorWrite';</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
        } catch (Exception e) {
        	e.printStackTrace();
        	String msg = "<script>alert('글등록 실패 하였습니다.');history.back();</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
        }
		
		
		return entity;
	}
	
	
	@GetMapping("exhibitionWrite")
	public ModelAndView exhibitionApply(HttpSession session, ExhibitionVO vo) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exhibition/exhibitionWrite");
		return mav;
	}
	
	@GetMapping("workCreate")
	public ModelAndView workCreate(HttpSession session, ExhibitionVO vo) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exhibition/workCreate");
		return mav;
	}
	
	@GetMapping("workEdit")
	public ModelAndView workEdit(HttpSession session, ExhibitionVO vo) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exhibition/workEdit");
		return mav;
	}
}
