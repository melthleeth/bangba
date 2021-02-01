package com.bangba.project730.model.service;

import java.util.List;
import java.util.Map;

import com.bangba.project730.model.dto.ForumDto;

public interface ForumService {
	public void createForum(Map<String, String> map) throws Exception;
	public List<ForumDto> listAll() throws Exception;
	public ForumDto read(int pk_forum) throws Exception;
	public void updateForum(Map<String, String> map) throws Exception;
	//public void updateForum(int pk_forum) throws Exception;
	public void deleteForum(int pk_forum) throws Exception;
}
