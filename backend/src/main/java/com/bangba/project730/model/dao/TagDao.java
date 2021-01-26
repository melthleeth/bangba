package com.bangba.project730.model.dao;

import org.apache.ibatis.annotations.Mapper;
import com.bangba.project730.model.dto.TagDto;

@Mapper
public interface TagDao {

	public void addTag(TagDto tagDto) throws Exception;
	public void searchTag(String content) throws Exception;
	
}
