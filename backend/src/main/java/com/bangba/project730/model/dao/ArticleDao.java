package com.bangba.project730.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangba.project730.model.dto.ArticleDto;
import com.bangba.project730.model.dto.TaglistDto;

@Mapper
public interface ArticleDao {
	public int createArticle(ArticleDto articledto) throws Exception;
	public ArticleDto searchArticle(TaglistDto taglistdto) throws Exception;
	public ArticleDto searchArticle1(TaglistDto taglistdto) throws Exception;
	public ArticleDto searchArticle2(TaglistDto taglistdto) throws Exception;
	public ArticleDto searchArticle3(TaglistDto taglistdto) throws Exception;
	public ArticleDto searchArticle4(TaglistDto taglistdto) throws Exception;
	public ArticleDto searchArticle5(TaglistDto taglistdto) throws Exception;
	public ArticleDto searchArticle6(TaglistDto taglistdto) throws Exception;
	public ArticleDto searchArticle7(TaglistDto taglistdto) throws Exception;
	public ArticleDto searchArticle8(TaglistDto taglistdto) throws Exception;
	public ArticleDto searchArticle9(TaglistDto taglistdto) throws Exception;
	public ArticleDto searchArticle10(TaglistDto taglistdto) throws Exception;
	public int  searchArticlePK(ArticleDto articledto) throws Exception;
	public void updateArticle(Map<String, String> map) throws Exception;
	public void deleteArticle(int pk_article) throws Exception;
	
	public void addArticleTag(int pk_article, int pk_tag) throws Exception;
	public void addArticleIngredient(int pk_article, int pk_ingredient) throws Exception;
	public void addArticleAlcohol(int pk_article, int pk_alcohol) throws Exception;
	public void addArticleCup(int pk_article, int pk_cup) throws Exception;
	public void addRecipe(String pk_article, String content, String order) throws Exception;
	
	public void deleteArticleTag(int pk_article, int pk_tag) throws Exception;
	public void deleteArticleIngredient(int pk_article, int pk_ingredient) throws Exception;
	public void deleteArticleAlcohol(int pk_article, int pk_alcohol) throws Exception;
	public void deleteArticleCup(int pk_article, int pk_cup) throws Exception;
	public void deleteRecipe(String pk_article, String content, String order) throws Exception;
}
