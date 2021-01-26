package com.bangba.project730.model.service;

import java.util.List;
import java.util.Map;

import com.bangba.project730.model.dto.ArticleDto;

public interface ArticleService {
	public void createArticle(Map<String, String> map) throws Exception;
	public ArticleDto searchArticle(List<String> tags) throws Exception;
	public void updateArticle(Map<String, String> map) throws Exception;
	public void deleteArticle(int pk_article) throws Exception;
}
