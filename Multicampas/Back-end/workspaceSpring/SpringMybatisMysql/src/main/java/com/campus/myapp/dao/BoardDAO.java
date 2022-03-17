package com.campus.myapp.dao;

import java.util.List;

import com.campus.myapp.vo.BoardVO;
import com.campus.myapp.vo.PagingVO;

public interface BoardDAO {
	//글등록
	public int boardInsert(BoardVO vo);
	
	//글목록
	public List<BoardVO> boardList(PagingVO pvo);
	
	//총레코드수
	public int totalRecord(PagingVO pVO);
	
	//글 1개 선택
	public BoardVO boardSelect(int no);
	
	//조회수 증가
	public void hitCount(int no);
	
	//글수정
	public int boardUpdate(BoardVO vo);
	//						수정할 정보가 vo 안에들어가 있음
	
	//글삭제
	public int boardDelete(int no, String userid);
}
