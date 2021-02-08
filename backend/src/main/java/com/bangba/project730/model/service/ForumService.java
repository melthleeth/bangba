package com.bangba.project730.model.service;

import java.util.List;
import java.util.Map;


import com.bangba.project730.model.dto.ForumDto;
import com.bangba.project730.model.dto.SearchForumDto;


public interface ForumService {
	public void createForum(ForumDto forumDto) throws Exception;
	public List<SearchForumDto> searchForumList(int page_num) throws Exception;
	public List<SearchForumDto> searchForumKeyword(String keyword) throws Exception;
	public ForumDto detailForum(int pk_forum) throws Exception;
	public void updateForum(ForumDto forumDto) throws Exception;
	public void deleteForum(int pk_forum) throws Exception;
	public void updateHits(int hits) throws Exception;
	public List<SearchForumDto> searchNotices() throws Exception;
	

	public String createComment(Map<String, String> map)throws Exception;
	public Map<String,String> searchComment(int pk_forum)throws Exception;
	public String updateComment(Map<String, String> map)throws Exception;
	public String deleteComment(int pk_fcomment)throws Exception;
}