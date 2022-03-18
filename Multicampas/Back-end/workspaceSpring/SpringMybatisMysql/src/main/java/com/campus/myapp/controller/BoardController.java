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
	BoardService service; //inject : ��ü�� ����� ��ȯ
	//1. �� ���
	@GetMapping("boardList")
	public ModelAndView boardList(PagingVO pVO) {
		ModelAndView mav = new ModelAndView();
		
		//�� ���ڵ� ��
		pVO.setTotalRecord(service.totalRecord(pVO));
		mav.addObject("pVO",pVO);
		
		//DBó��
		mav.addObject("list",service.boardList(pVO));
		
		mav.setViewName("board/boardList");//servletcontext�� ���� WEB-INF/views/board/boardList.JSP�� ��ȯ��
		return mav;
	}
	//2. �� ��� ��
	@GetMapping("boardWrite")
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/boardWrite");
		return mav;
	}
	//3. �� ���
	@PostMapping("boardWriteOk")
	public ResponseEntity boardWriteOk(BoardVO vo,HttpServletRequest request) {
		vo.setIp(request.getRemoteAddr());//������ IP
		//�۾���-session�α��� ���̵� ���Ѵ�
		vo.setUserid((String)request.getSession().getAttribute("logId"));
		
		ResponseEntity<String> entity =null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-Type","text/html;charset=utf-8");
		//headers.setContentType(new MediaType("text","html",Charset.forName("UFT-8")));
		try {
			service.boardInsert(vo);
			//������
			String msg = "<script>";
			msg+="alert('���� ��ϵǾ����ϴ�>_<');";
			msg+="location.href='boardList';";
			msg+="</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);//(���ڿ�,���ڵ�Ÿ��,HttpStatus.OK : 200)
		}catch(Exception e){
			e.printStackTrace();
			//��Ͼȵ�..
			String msg = "<script>";
			msg+="alert('�� ��� �����Ͽ����ϴ� ��_��');";
			msg+="history.back();";
			msg+="</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
		}
		return entity;
				
	}
	//4. �� ���� ����
	@GetMapping("boardView")
	public ModelAndView boardView(int no) {
		ModelAndView mav = new ModelAndView();
		
		service.hitCount(no);
		
		mav.addObject("vo",service.boardSelect(no));
		mav.setViewName("board/boardView");
		
		return mav;
	}
	//5. �� ���� ��
	@GetMapping("boardEdit")
	public ModelAndView boardEdit(int no) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vo", service.boardSelect(no));
		mav.setViewName("board/boardEdit");
		
		return mav;
	}
	//�ۼ���(DB)
	@PostMapping("boardEditOk")
	public ResponseEntity<String> boardEditOk(BoardVO vo, HttpSession session) {
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		//header setting
		headers.add("content-Type","text/html;charset=utf-8");
		
		vo.setUserid((String)session.getAttribute("logId"));
		try {
			int result = service.boardUpdate(vo);
			if(result>0) {//���� ����
				entity = new ResponseEntity<String>(getEditSuccessMessage(vo.getNo()), headers, HttpStatus.OK);
			}else {//���� ����
				entity = new ResponseEntity<String>(getEditFailMessage(), headers, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			//���� ����
			e.printStackTrace();
			entity = new ResponseEntity<String>(getEditFailMessage(), headers, HttpStatus.BAD_REQUEST);
		}
		return entity;		
	}

	//�ۻ���
	@GetMapping("boardDel")
	public ModelAndView boardDel(int no, HttpSession session) {
		//id ���ϱ�
		String userid = (String)session.getAttribute("logId");
		
		int result = service.boardDelete(no, userid);
		
		ModelAndView mav = new ModelAndView();
		
		if(result > 0) {//���� ����
			mav.setViewName("redirect:boardList"); //list�� �̵��ϴ� ��Ʈ�ѷ� ȣ��
		}else {//��������
			mav.addObject("no",no);
			mav.setViewName("redirect:boardView");
		}
		return mav;
	}
	
	//�� ���� �޼���(���н�)
	public String getEditFailMessage() {
		String msg="<script>";
		msg+="alert('���� ���� �� �� �����ϴ�.. ): \\n���� ������ �ٽ� �̵��մϴ�');";
		msg+="history.back();";
		msg+="</script>";
		return msg;
	}
	//�� ���� �޼���(������)
	public String getEditSuccessMessage(int no) {
		String msg="<script>";
		msg+="alert('���� ���� �߾��, ��! :] \\n������ ���� �����帱�Կ�-!');";
		msg+="location.href='/myapp/board/boardView?no="+no+"'";
		msg+="</script>";
		return msg;
	}
	
}
