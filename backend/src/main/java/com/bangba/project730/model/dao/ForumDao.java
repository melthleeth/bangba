package com.bangba.project730.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bangba.project730.model.dto.FcommentDto;
import com.bangba.project730.model.dto.ForumDto;
import com.bangba.project730.model.dto.SearchForumDto;

@Mapper
public interface ForumDao {
	public int createForum(ForumDto forumdto) throws Exception;
	public List<ForumDto> searchForumList(SearchForumDto searchForumDto) throws Exception;
	public ForumDto detailForum(int pk_forum) throws Exception;
	public void updateForum(ForumDto forumDto) throws Exception;
	public void deleteForum(int pk_forum) throws Exception;
	public void updateHits(int hits) throws Exception;
<<<<<<< HEAD
	public List<SearchForumDto> searchNotices() throws Exception;

	public void createComment(FcommentDto fcommentDto) throws Exception;
	public List<FcommentDto> searchComment(int pk_forum) throws Exception;
	public void updateComment(FcommentDto fcommentDto) throws Exception;
	public void deleteComment(int pk_acomment) throws Exception;
=======
	public List<ForumDto> searchNotices() throws Exception;
	public int getForumListCnt(SearchForumDto searchForumDto) throws Exception;
>>>>>>> branch 'backend' of https://lab.ssafy.com/s04-webmobile1-sub3/s04p13a401.git
}
