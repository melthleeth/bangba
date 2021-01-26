package com.bangba.project730.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangba.project730.model.dao.AlcoholDao;
import com.bangba.project730.model.dao.ArticleDao;
import com.bangba.project730.model.dao.CupDao;
import com.bangba.project730.model.dao.IngredientDao;
import com.bangba.project730.model.dao.TagDao;
import com.bangba.project730.model.dto.ArticleDto;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	ArticleDao dao;
	
	@SuppressWarnings("null")
	@Override
	public void createArticle(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		ArticleDto adto = null;

		AlcoholDao aldao;
		CupDao cdao;
		IngredientDao idao;
		TagDao tdao;
		
		//이미지 경로
		//아티클 생성
		adto.setUser_no(Integer.parseInt(map.get("user_no")));
		adto.setTitle_kor(map.get("title_kor"));
		adto.setTitle_eng(map.get("title_eng"));
		adto.setLike_cnt(0);
		adto.setBookmark_cnt(0);
		adto.setHits(0);
		adto.setCreated_at(map.get("created_at"));
		adto.setUpdated_at("created_at");
		adto.setLike_weekly(0);
		adto.setContent(map.get("content"));
		adto.setImg_path(map.get("img_path"));
		if(map.get("category").equals("admin"))
			adto.setCategory(true);
		else
			adto.setCategory(false);
		adto.setAbv(Integer.parseInt(map.get("abv")));
		dao.createArticle(adto);
		
		//생성된 아티클의 pk를 유저번호, 제목, 시간으로 찾고 그중에 가장 나중에 만들어진 pk를 가져옴
		int temp=dao.searchArticlePK(adto);
		
		//태그 생성
		
		//재료 생성
		
		//태그추가
	
		//재료추가
		//술추가
		//레시피추가
		//컵추가
	}

	@Override
	public ArticleDto searchArticle(List<String> tags) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateArticle(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(int pk_article) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
