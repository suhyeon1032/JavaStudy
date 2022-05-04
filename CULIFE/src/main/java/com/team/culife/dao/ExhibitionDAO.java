package com.team.culife.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.team.culife.vo.ExhibitionVO;
import com.team.culife.vo.MemberVO;

@Mapper
@Repository
public interface ExhibitionDAO {
	// 작가등록
	public int authorWrite(ExhibitionVO vo);
	public void authorWriteOk(Map<String, Object> map);
}
