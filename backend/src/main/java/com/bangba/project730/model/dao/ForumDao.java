package com.bangba.project730.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangba.project730.model.dto.ForumDto;


@Mapper
public interface ForumDao {
	public void createForum(ForumDto forumdto) throws Exception;
	public List<ForumDto> listAll() throws Exception;
	public ForumDto read(int pk_forum) throws Exception;
	public void updateForum(Map<String, String> map) throws Exception;
	//public void updateForum(int pk_forum) throws Exception;
	public void deleteForum(int pk_forum) throws Exception;

	// public void addImage(int pk_forum, int pk_fimg) throws Exception;


}
