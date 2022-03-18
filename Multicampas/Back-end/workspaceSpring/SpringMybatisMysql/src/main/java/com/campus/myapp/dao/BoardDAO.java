package com.campus.myapp.dao;

import java.util.List;

import com.campus.myapp.vo.BoardVO;
import com.campus.myapp.vo.PagingVO;

public interface BoardDAO {
	//�۵��
	public int boardInsert(BoardVO vo);
	//�۸��
	public List<BoardVO> boardList(PagingVO pVO);
	//�ѷ��ڵ��
	public int totalRecord(PagingVO pVO);
	//��1������
	public BoardVO boardSelect(int no);
	//��ȸ�� ����
	public void hitCount(int no);
	//�ۼ���
	public int boardUpdate(BoardVO vo);
	//�ۻ���
	public int boardDelete(int no, String userid);
}
