package com.bangba.project730.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangba.project730.model.dao.ForumDao;
import com.bangba.project730.model.dto.ForumDto;


@Service
public class ForumServicelmp implements ForumService{

	@Autowired
	ForumDao dao;
	
	@Override
	public void createForum(Map<String, String> map) throws Exception {
		ForumDto dto = new ForumDto();
		//아티클 생성
		dto.setUser_no(Integer.parseInt(map.get("user_no")));
		dto.setTitle(map.get("title"));
		dto.setCategory(map.get("category"));
		dto.setLike_cnt(0);
		dto.setHits(0);
		dto.setCreated_at(map.get("created_at"));
		dto.setUpdated_at("updated_at");
		dto.setContent(map.get("content"));
	}

	@Override
	public List<ForumDto> listAll() throws Exception {
		
		return dao.listAll();
	}

	@Override
	public ForumDto read(int pk_forum) throws Exception {
		return dao.read(pk_forum);
	}

	@Override
	public void updateForum(Map<String, String> map) throws Exception {
		dao.updateForum(map);
		
	}

	@Override
	public void deleteForum(int pk_forum) throws Exception {
		dao.deleteForum(pk_forum);;
		
	}
	
}
