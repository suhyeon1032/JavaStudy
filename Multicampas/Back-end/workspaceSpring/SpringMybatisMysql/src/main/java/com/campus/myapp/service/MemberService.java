package com.campus.myapp.service;

import com.campus.myapp.vo.MemberVO;

public interface MemberService {
	//회원등록
	public int memberInsert(MemberVO vo);
	
	public MemberVO loginCheck(MemberVO vo);
	
	public MemberVO memberSelect(String userid);
	
	public int memberUpdate(MemberVO vo);
	
	public int idCheck(String userid);
}
