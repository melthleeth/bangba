package com.bangba.project730.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bangba.project730.model.dto.AlcoholDto;
import com.bangba.project730.model.dto.ArticleDto;
import com.bangba.project730.model.dto.IngredientDto;
import com.bangba.project730.model.dto.TagDto;

import io.swagger.annotations.ApiOperation;

public interface ArticleService {
	public void createArticle(Map<String, String> map) throws Exception;
	public List<ArticleDto> searchArticle(Map<String, String> map) throws Exception;
	public void updateArticle(Map<String, String> map) throws Exception;
	public void deleteArticle(int pk_article) throws Exception;
	public Map<String,String> detailArticle(int pk_article) throws Exception;

	public List<AlcoholDto> searchAlcohol(String searchtxt) throws Exception;
	public void createIngredient(String name) throws Exception;
	public List<IngredientDto> searchIngredient(String searchtxt) throws Exception;
	public void createTag(String content,int type) throws Exception;
	public List<TagDto> searchTag(String searchtxt) throws Exception;
	
	
	public String createComment(Map<String, String> map)throws Exception;
	public Map<String,String> searchComment(int pk_article)throws Exception;
	public String updateComment(Map<String, String> map)throws Exception;
	public String deleteComment(int pk_acomment)throws Exception;

}
