package com.bangba.project730.model.dao;

import org.apache.ibatis.annotations.Mapper;
import com.bangba.project730.model.dto.AlcoholDto;

@Mapper
public interface AlcoholDao {
	
	public void addAlcohol(AlcoholDto alcoholDto) throws Exception;
	public void searchAlcohol(String type, String name) throws Exception;
	
}
