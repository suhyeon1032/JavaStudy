package com.campus.myapp.dao;

import com.campus.myapp.vo.MemberVO;

public interface MemberDAO {

	//회원등록
	public int memberInsert(MemberVO vo);
	//로그인
	public MemberVO loginCheck(MemberVO vo);
	//회원정보수정폼
	public MemberVO memberSelect(String userid);
	//회원정보수정(DB)
	public int memberUpdate(MemberVo vo) {
		return dao.memberUpdate(vo);
	}
}