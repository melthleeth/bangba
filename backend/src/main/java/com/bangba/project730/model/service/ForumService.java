package com.bangba.project730.model.service;

import java.util.List;

import com.bangba.project730.model.dto.ForumDto;
import com.bangba.project730.model.dto.SearchForumDto;

public interface ForumService {
	public void createForum(ForumDto forumDto) throws Exception;
<<<<<<< HEAD
	public List<SearchForumDto> searchForumList(String keyword) throws Exception;
	public ForumDto read(int pk_forum) throws Exception;
=======
	public List<SearchForumDto> searchForumList(int page_num) throws Exception;
	public List<SearchForumDto> searchForumKeyword(String keyword) throws Exception;
	public ForumDto detailForum(int pk_forum) throws Exception;
>>>>>>> branch 'feature/forum' of https://lab.ssafy.com/s04-webmobile1-sub3/s04p13a401.git
	public void updateForum(ForumDto forumDto) throws Exception;
	public void deleteForum(int pk_forum) throws Exception;
	public void updateHits(int hits) throws Exception;
}



