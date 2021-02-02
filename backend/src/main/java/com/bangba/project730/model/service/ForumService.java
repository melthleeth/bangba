package com.bangba.project730.model.service;

import java.util.List;
import java.util.Map;

import com.bangba.project730.model.dto.ForumDto;
import com.bangba.project730.model.dto.SearchForumDto;

public interface ForumService {
	public void createForum(ForumDto forumDto) throws Exception;
	public List<SearchForumDto> searchForumList(String keyword) throws Exception;
	public ForumDto read(int pk_forum) throws Exception;
	public void updateForum(ForumDto forumDto) throws Exception;
	public void deleteForum(int pk_forum) throws Exception;
}



