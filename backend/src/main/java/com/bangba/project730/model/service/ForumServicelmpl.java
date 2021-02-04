package com.bangba.project730.model.service;

import java.util.List;

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
	public List<SearchForumDto> searchForumList(int page_num) throws Exception {
		if (page_num <=0 ) {
			page_num = 1;
		}
		page_num = (page_num -1) * 10;
		return dao.searchForumList(page_num);
	}
	
	@Override
	public List<SearchForumDto> searchForumKeyword(String keyword) throws Exception {
		return dao.searchForumKeyword(keyword);
	}

	@Override
	public ForumDto detailForum(int pk_forum) throws Exception {
		return dao.detailForum(pk_forum);
	}
	
	@Override
	public void updateHits(int hits) throws Exception {
		dao.updateHits(hits);
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
