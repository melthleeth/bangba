package com.bangba.project730.model.service;

import java.util.List;
import java.util.Map;


import com.bangba.project730.model.dto.ForumDto;
import com.bangba.project730.model.dto.SearchForumDto;


public interface ForumService {
	public void createForum(ForumDto forumDto) throws Exception;
	public List<ForumDto> searchForumList(SearchForumDto searchForumDto) throws Exception;
	public ForumDto detailForum(int pk_forum) throws Exception;
	public void updateForum(ForumDto forumDto) throws Exception;
	public void deleteForum(int pk_forum) throws Exception;
	public void updateHits(int hits) throws Exception;
<<<<<<< HEAD
	public List<SearchForumDto> searchNotices() throws Exception;
	

	public String createComment(Map<String, String> map)throws Exception;
	public Map<String,String> searchComment(int pk_forum)throws Exception;
	public String updateComment(Map<String, String> map)throws Exception;
	public String deleteComment(int pk_fcomment)throws Exception;
}
=======
	public List<ForumDto> searchNotices() throws Exception;
	public int getForumListCnt(SearchForumDto searchForumDto) throws Exception;
}


>>>>>>> branch 'backend' of https://lab.ssafy.com/s04-webmobile1-sub3/s04p13a401.git
