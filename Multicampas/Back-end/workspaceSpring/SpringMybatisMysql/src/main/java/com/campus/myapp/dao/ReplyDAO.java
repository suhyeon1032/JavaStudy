package com.campus.myapp.dao;

import java.util.List;

import com.campus.myapp.vo.ReplyVO;

public interface ReplyDAO {
	//��۵��
	public int replyWrite(ReplyVO vo);
	//��۸��
	public List<ReplyVO> replyList(int no);
	//��ۼ���
	public int replyEdit(ReplyVO vo);
	//��ۻ���
	public int replyDel(int replyno, String userid);
}
