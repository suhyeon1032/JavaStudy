package com.team.culife.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.team.culife.vo.ExhibitionVO;
import com.team.culife.vo.MemberVO;


public interface ExhibitionService {
	// 작가등록
	public int authorWrite(ExhibitionVO vo);
	public void authorWriteOk(Map<String, Object> map);
}
