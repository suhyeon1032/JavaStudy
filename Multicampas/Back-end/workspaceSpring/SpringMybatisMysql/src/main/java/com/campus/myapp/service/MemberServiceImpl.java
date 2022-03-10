package com.campus.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.campus.myapp.dao.MemberDAO;
import com.campus.myapp.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

   @Inject      //dao�� ��ü �����Ѵ�. == @AutoWired
   MemberDAO dao;
   
   @Override
   public int memberInsert(MemberVO vo) {
      return dao.memberInsert(vo);
   }

   @Override
   public MemberVO loginCheck(MemberVO vo) {
      // TODO Auto-generated method stub
      return dao.loginCheck(vo);
   }

   @Override
   public MemberVO memberSelect(String userid) {
      // TODO Auto-generated method stub
      return dao.memberSelect(userid);
   }

}