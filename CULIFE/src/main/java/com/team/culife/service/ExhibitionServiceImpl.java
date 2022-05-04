package com.team.culife.service;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.culife.dao.ExhibitionDAO;
import com.team.culife.vo.ExhibitionVO;
import com.team.culife.vo.MemberVO;

@Service
public class ExhibitionServiceImpl implements ExhibitionService {

	@Inject
	ExhibitionDAO dao;
	
	@Override
	public int authorWrite(ExhibitionVO vo) {
		return dao.authorWrite(vo);
	}

	@Override
	@Autowired
	public void authorWriteOk(Map<String, Object> map) {
	}
}
