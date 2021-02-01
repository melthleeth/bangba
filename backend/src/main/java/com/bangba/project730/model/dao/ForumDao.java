package com.bangba.project730.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangba.project730.model.dto.AlcoholDto;
import com.bangba.project730.model.dto.ArticleDto;
import com.bangba.project730.model.dto.CupDto;
import com.bangba.project730.model.dto.IngredientDto;
import com.bangba.project730.model.dto.TagDto;

@Mapper
public interface ForumDao {
	public void createForum(ArticleDto articledto) throws Exception;
	public ArticleDto searchArticle(List<String> tags) throws Exception;
	public int  searchArticlePK(ArticleDto articledto) throws Exception;
	public void updateArticle(Map<String, String> map) throws Exception;
	public void deleteArticle(int pk_article) throws Exception;

	public void addAlcohol(AlcoholDto alcoholDto) throws Exception;
	public void addCup(CupDto cupDto) throws Exception;
	public void addIngredient(IngredientDto ingredientDto) throws Exception;
	public void addTag(TagDto tagDto) throws Exception;
	
	public void addArticleTag(int pk_article, int pk_tag) throws Exception;
	public void addArticleIngredient(int pk_article, int pk_ingredient) throws Exception;
	public void addArticleAlcohol(int pk_article, int pk_alcohol) throws Exception;
	public void addArticleCup(int pk_article, int pk_cup) throws Exception;

	public void searchTag(int pk_article, int pk_tag) throws Exception;
	public void searchIngredient(int pk_article, int pk_ingredient) throws Exception;
	public void searchAlcohol(int pk_article, int pk_alcohol) throws Exception;
	public void searchCup(int pk_article, int pk_cup) throws Exception;
}
