package com.bangba.project730.model.dao;

import org.apache.ibatis.annotations.Mapper;
import com.bangba.project730.model.dto.AlcoholDto;

@Mapper
public interface AlcoholDao {
	
	public void addAlcohol(AlcoholDto alcoholDto) throws Exception;
	public AlcoholDto searchAlcohol(String type, String name) throws Exception;
	public int searchAlcoholPK(String name) throws Exception;
	
}
