package com.bangba.project730.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.bangba.project730.model.dto.IngredientDto;

@Mapper
public interface IngredientDao {
	
	public void addIngredient(IngredientDto ingredientDto) throws Exception;
	public List<IngredientDto> searchIngredient(String searchtxt) throws Exception;
	public int searchIngredientPK(String name) throws Exception;
	
}
