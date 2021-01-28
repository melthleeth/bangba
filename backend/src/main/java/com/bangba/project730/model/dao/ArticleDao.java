package com.bangba.project730.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangba.project730.model.dto.ArticleDto;

@Mapper
public interface ArticleDao {
	public void createArticle(ArticleDto articledto) throws Exception;
	public ArticleDto searchArticle(List<String> tags) throws Exception;
	public int  searchArticlePK(ArticleDto articledto) throws Exception;
	public void updateArticle(Map<String, String> map) throws Exception;
	public void deleteArticle(int pk_article) throws Exception;
	
	public void addArticleTag(int pk_article, int pk_tag) throws Exception;
	public void addArticleIngredient(int pk_article, int pk_ingredient) throws Exception;
	public void addArticleAlcohol(int pk_article, int pk_alcohol) throws Exception;
	public void addArticleCup(int pk_article, int pk_cup) throws Exception;
	public void addRecipe(String pk_article, String content, String order) throws Exception;
}
