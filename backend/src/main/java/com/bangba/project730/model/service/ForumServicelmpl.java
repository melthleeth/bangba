package com.bangba.project730.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangba.project730.model.dao.ForumDao;
import com.bangba.project730.model.dto.ForumDto;
import com.bangba.project730.model.dto.SearchForumDto;


@Service
public class ForumServicelmpl implements ForumService{

	@Autowired
	ForumDao dao;
	
	@Override
	public void createForum(ForumDto forumDto) throws Exception {
		dao.createForum(forumDto);
	}

	@Override
	public List<SearchForumDto> searchForumList() throws Exception {
		return dao.searchForumList();
	}
	
	@Override
	public List<SearchForumDto> searchForumKeyword(String keyword) throws Exception {
		return dao.searchForumKeyword(keyword);
	}

	@Override
	public ForumDto read(int pk_forum) throws Exception {
		return dao.read(pk_forum);
	}

	@Override
	public void updateForum(ForumDto forumDto) throws Exception {
		dao.updateForum(forumDto);
	}

	@Override
	public void deleteForum(int pk_forum) throws Exception {
		dao.deleteForum(pk_forum);
		
	}
	
}
