package com.bangba.project730.model.service;

import java.util.List;
import java.util.Map;

import com.bangba.project730.model.dto.ArticleDto;
import com.bangba.project730.model.dto.IngredientDto;

public interface ArticleService {
	public void createArticle(Map<String, String> map) throws Exception;
	public List<ArticleDto> searchArticle(Map<String, String> map) throws Exception;
	public void updateArticle(Map<String, String> map) throws Exception;
	public void deleteArticle(int pk_article) throws Exception;

	public void createIngredient(String name) throws Exception;
	public List<IngredientDto> searchIngredient(String searchtxt) throws Exception;
	public void createTag(String content,int type) throws Exception;
}
