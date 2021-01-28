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
import com.bangba.project730.model.dto.IngredientDto;
import com.bangba.project730.model.dto.TagDto;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	ArticleDao dao;

	@Autowired
	ArticleDto adto;

	@Autowired
	AlcoholDao adao;

	@Autowired
	CupDao cdao;

	@Autowired
	IngredientDao idao;

	@Autowired
	TagDao tdao;

	@Autowired
	IngredientDto idto;
	
	@Autowired
	TagDto tdto;
	
	@Override
	public void createArticle(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		
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
		int pk=dao.searchArticlePK(adto);

		//재료 생성
		//idao.addIngredient(ingredientDto);
		//태그 생성
		//tdao.addTag(tagDto);
		
		//술추가
		int apk=adao.searchAlcoholPK(map.get("title_eng"));
		dao.addArticleAlcohol(pk, apk);
		
		//컵추가
		int cpk=cdao.searchCupPK(map.get("title_eng"), map.get("title_eng"));
		dao.addArticleCup(pk, cpk);
		
		//재료추가
		int ipk=idao.searchIngredientPK(map.get("title_eng"));
		dao.addArticleIngredient(pk, ipk);
		
		//태그추가
		int tpk=tdao.searchTagPK(map.get("title_eng"));
		dao.addArticleTag(pk, tpk);
		
		//레시피추가
		dao.addRecipe(Integer.toString(pk), map.get("title_eng"), map.get("title_eng"));
	}

	@Override
	public ArticleDto searchArticle(List<String> tags) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchArticle(tags);
	}

	@Override
	public void updateArticle(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		dao.updateArticle(map);
	}

	@Override
	public void deleteArticle(int pk_article) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteArticle(pk_article);
	}

	@Override
	public void createIngredient(String name) throws Exception {
		// TODO Auto-generated method stub
		idto.setName_kor(name);
		idto.setName_eng("");
		idto.setImg_path("");
		idto.setDesc("");
		idao.addIngredient(idto);
	}

	@Override
	public void createTag(String content, int type) throws Exception {
		// TODO Auto-generated method stub
		tdto.setContent_kor(content);
		tdto.setContent_eng(null);
		tdto.setType(type);
		tdao.addTag(tdto);
	}
	
}
