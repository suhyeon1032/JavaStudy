package com.campus.myapp.dao;

import com.campus.myapp.vo.MemberVO;

public interface MemberDAO {

	//ȸ�����
	public int memberInsert(MemberVO vo);
	//�α���
	public MemberVO loginCheck(MemberVO vo);
	//ȸ������������
	public MemberVO memberSelect(String userid);
	//ȸ����������(DB)
	public int memberUpdate(MemberVo vo) {
		return dao.memberUpdate(vo);
	}
}