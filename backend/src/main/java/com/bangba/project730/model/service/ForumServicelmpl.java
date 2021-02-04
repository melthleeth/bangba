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
<<<<<<< HEAD
	public List<SearchForumDto> searchForumList(String keyword) throws Exception {
		
		/*
		 * 여기는 포럼 게시판 리스트를 불러오는 곳입니다.
		 * 지금은 페이지 번호에 따라 불러오지 못하지만, 나중에 페이지 번호를 받아 해당 페이지에 들어가는 데이터만 골라서 보낼 예정입니다.
		 * 
		 * 요청 파라미터(예상) : 페이지번호, 페이지당 게시물 수, 검색어, 검색어 카테고리(작성자, 제목, 내용 등등)
		 * 표시되는 정보 : 말머리, 제목, 댓글수, 작성자, 조회수, 업로드일자
		 * 
		 * pk_forum, user_name, title,
		 * category, hits, comment_cnt,
		 * created_at
		 * */
		// return (페이지 당 개시물 수),(페이지번호),(검색결과)에 해당하는 글
		return dao.searchForumList(keyword);
=======
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
>>>>>>> branch 'feature/forum' of https://lab.ssafy.com/s04-webmobile1-sub3/s04p13a401.git
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
