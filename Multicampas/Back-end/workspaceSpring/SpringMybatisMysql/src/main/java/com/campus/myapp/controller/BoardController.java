package com.campus.myapp.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.BoardService;
import com.campus.myapp.vo.BoardVO;
import com.campus.myapp.vo.PagingVO;

@RestController //Controller + ResponseBody
@RequestMapping("/board/*")
public class BoardController {
	@Inject 
	BoardService service; //inject : 객체를 만들어 반환
	//1. 글 목록
	@GetMapping("boardList")
	public ModelAndView boardList(PagingVO pVO) {
		ModelAndView mav = new ModelAndView();
		
		//총 레코드 수
		pVO.setTotalRecord(service.totalRecord(pVO));
		mav.addObject("pVO",pVO);
		
		//DB처리
		mav.addObject("list",service.boardList(pVO));
		
		mav.setViewName("board/boardList");//servletcontext를 통해 WEB-INF/views/board/boardList.JSP로 변환됨
		return mav;
	}
	//2. 글 등록 폼
	@GetMapping("boardWrite")
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/boardWrite");
		return mav;
	}
	//3. 글 등록
	@PostMapping("boardWriteOk")
	public ResponseEntity boardWriteOk(BoardVO vo,HttpServletRequest request) {
		vo.setIp(request.getRemoteAddr());//접속자 IP
		//글쓴이-session로그인 아이디를 구한다
		vo.setUserid((String)request.getSession().getAttribute("logId"));
		
		ResponseEntity<String> entity =null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-Type","text/html;charset=utf-8");
		//headers.setContentType(new MediaType("text","html",Charset.forName("UFT-8")));
		try {
			service.boardInsert(vo);
			//정상구현
			String msg = "<script>";
			msg+="alert('글이 등록되었습니다>_<');";
			msg+="location.href='boardList';";
			msg+="</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);//(문자열,인코딩타입,HttpStatus.OK : 200)
		}catch(Exception e){
			e.printStackTrace();
			//등록안됨..
			String msg = "<script>";
			msg+="alert('글 등록 실패하였습니다 ㅠ_ㅠ');";
			msg+="history.back();";
			msg+="</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
		}
		return entity;
				
	}
	//4. 글 내용 보기
	@GetMapping("boardView")
	public ModelAndView boardView(int no) {
		ModelAndView mav = new ModelAndView();
		
		service.hitCount(no);
		
		mav.addObject("vo",service.boardSelect(no));
		mav.setViewName("board/boardView");
		
		return mav;
	}
	//5. 글 수정 폼
	@GetMapping("boardEdit")
	public ModelAndView boardEdit(int no) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vo", service.boardSelect(no));
		mav.setViewName("board/boardEdit");
		
		return mav;
	}
	//글수정(DB)
	@PostMapping("boardEditOk")
	public ResponseEntity<String> boardEditOk(BoardVO vo, HttpSession session) {
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		//header setting
		headers.add("content-Type","text/html;charset=utf-8");
		
		vo.setUserid((String)session.getAttribute("logId"));
		try {
			int result = service.boardUpdate(vo);
			if(result>0) {//수정 성공
				entity = new ResponseEntity<String>(getEditSuccessMessage(vo.getNo()), headers, HttpStatus.OK);
			}else {//수정 못함
				entity = new ResponseEntity<String>(getEditFailMessage(), headers, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			//수정 실패
			e.printStackTrace();
			entity = new ResponseEntity<String>(getEditFailMessage(), headers, HttpStatus.BAD_REQUEST);
		}
		return entity;		
	}

	//글삭제
	@GetMapping("boardDel")
	public ModelAndView boardDel(int no, HttpSession session) {
		//id 구하기
		String userid = (String)session.getAttribute("logId");
		
		int result = service.boardDelete(no, userid);
		
		ModelAndView mav = new ModelAndView();
		
		if(result > 0) {//삭제 성공
			mav.setViewName("redirect:boardList"); //list로 이동하는 컨트롤러 호출
		}else {//삭제실패
			mav.addObject("no",no);
			mav.setViewName("redirect:boardView");
		}
		return mav;
	}
	
	//글 수정 메세지(실패시)
	public String getEditFailMessage() {
		String msg="<script>";
		msg+="alert('글을 수정 할 수 없습니다.. ): \\n수정 폼으로 다시 이동합니다');";
		msg+="history.back();";
		msg+="</script>";
		return msg;
	}
	//글 수정 메세지(성공시)
	public String getEditSuccessMessage(int no) {
		String msg="<script>";
		msg+="alert('글을 수정 했어요, 얍! :] \\n수정한 글을 보여드릴게요-!');";
		msg+="location.href='/myapp/board/boardView?no="+no+"'";
		msg+="</script>";
		return msg;
	}
	
}
