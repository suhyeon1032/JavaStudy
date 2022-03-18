package com.campus.myapp.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.campus.myapp.service.ReplyService;
import com.campus.myapp.vo.ReplyVO;

@RestController
public class ReplyController {
	@Inject
	ReplyService service;
	
	//1. ��� ���
	@RequestMapping(value="/reply/writeOk", method=RequestMethod.POST)
	public int writeOk(ReplyVO vo, HttpSession session) {
		//1) DB�� replyBoard�� ������ userid�� session�� logId������ ����(���� �α��ε� ���̵�)
		vo.setUserid((String)session.getAttribute("logId"));
		//2) �ش� ���̵��, ��� ���(sql)
		return service.replyWrite(vo);
	}
	//2. ��� ���
	@RequestMapping("/reply/list")
	public List<ReplyVO> list(int no) {
		return service.replyList(no);
	}
	//3. ��� ����
	@PostMapping("/reply/editOk")
	public int editOk(ReplyVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logId"));
		return service.replyEdit(vo);
	}
	//4. ��� ����
	@GetMapping("/reply/del")
	public int delOk(int replyno, HttpSession session) {
		return service.replyDel(replyno, (String)session.getAttribute("logId"));
	}
}
