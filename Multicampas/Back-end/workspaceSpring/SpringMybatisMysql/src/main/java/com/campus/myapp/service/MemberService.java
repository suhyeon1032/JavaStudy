package com.campus.myapp.service;

import com.campus.myapp.vo.MemberVO;

public interface MemberService {
   //ȸ�����
   public int memberInsert(MemberVO vo);
   //�α���
   public MemberVO loginCheck(MemberVO vo);
   //ȸ������������
   public MemberVO memberSelect(String userid);
}