package com.bangba.project730.model.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangba.project730.model.dao.AlcoholDao;
import com.bangba.project730.model.dao.ArticleDao;
import com.bangba.project730.model.dao.CupDao;
import com.bangba.project730.model.dao.IngredientDao;
import com.bangba.project730.model.dao.TagDao;
import com.bangba.project730.model.dto.AlcoholDto;
import com.bangba.project730.model.dto.ArticleDto;
import com.bangba.project730.model.dto.Article_alcoholDto;
import com.bangba.project730.model.dto.Article_ingredientDto;
import com.bangba.project730.model.dto.Article_tagDto;
import com.bangba.project730.model.dto.IngredientDto;
import com.bangba.project730.model.dto.RecipeDto;
import com.bangba.project730.model.dto.TagDto;
import com.bangba.project730.model.dto.TaglistDto;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	ArticleDao dao;

	@Autowired
	AlcoholDao adao;

	@Autowired
	CupDao cdao;

	@Autowired
	IngredientDao idao;

	@Autowired
	TagDao tdao;
	
	@Override
	public void createArticle(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub

		ArticleDto dto =  new ArticleDto();
		
		//아티클 생성
		dto.setUser_no(Integer.parseInt(map.get("user_no")));
		dto.setTitle_kor(map.get("title_kor"));
		dto.setTitle_eng(map.get("title_eng"));
		dto.setLike_cnt(0);
		dto.setBookmark_cnt(0);
		dto.setHits(0);
		dto.setCreated_at(map.get("created_at"));
		dto.setUpdated_at(map.get("created_at"));
		dto.setLike_weekly(0);
		dto.setContent(map.get("content"));
		dto.setImg_path(map.get("img_path"));
		if(map.get("category").equals("admin"))
			dto.setCategory(true);
		else
			dto.setCategory(false);
		dto.setAbv(Integer.parseInt(map.get("abv")));
		dto.setCup_no(Integer.parseInt(map.get("cup_no")));
		
		dao.createArticle(dto);
		
		//생성된 아티클의 pk를 유저번호, 제목, 시간으로 찾고 그중에 가장 나중에 만들어진 pk를 가져옴
		int pk=dao.searchArticlePK(dto);

		String s=map.get("alcohol");
		String[] ss=s.split(",");
		for(String a:ss)
		{
			String[] sss=a.split("/");
			int apk=adao.searchAlcoholPK(sss[0]);
			Article_alcoholDto aadto= new Article_alcoholDto();
			aadto.setArticle_no(pk);
			aadto.setAlcohol_no(apk);
			aadto.setQuantity(sss[1]);
			aadto.setUnit(sss[2]);
			dao.addArticleAlcohol(aadto);
		}
		
		s=map.get("ingredient");
		ss=s.split(",");
		for(String a:ss)
		{
			String[] sss=a.split("/");
			int ipk=idao.searchIngredientPK(sss[1]);
			Article_ingredientDto aidto = new Article_ingredientDto();
			aidto.setArticle_no(pk);
			aidto.setIngredient_no(ipk);
			if(sss[0].equals("재료"))
				aidto.setType(true);
			else
				aidto.setType(false);
			aidto.setQuantity(sss[2]);
			aidto.setUnit(sss[3]);
			dao.addArticleIngredient(aidto);
		}
		
		s=map.get("tag");
		ss=s.split(",");
		for(String a:ss)
		{
			int tpk=tdao.searchTagPK(a);
			dao.addArticleTag(pk, tpk);
		}
		
		s=map.get("recipe");
		ss=s.split(",");
        int r=1;
		for(String a:ss)
		{
			RecipeDto rdto= new RecipeDto();
			rdto.setArticle_no(pk);
			rdto.setContent(a);
			rdto.setNum(r);
			dao.addRecipe(rdto);
			r++;
		}
	}

	@Override
	public ArticleDto searchArticle(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		TaglistDto tldto = new TaglistDto();
		String s = map.get("searchtxt");
		tldto.setSearchtxt(s);
		s=map.get("tag");
		String[] ss=s.split(",");
		int i=0;
		for(String a:ss)
		{
			switch (i) {
			case 0:
				tldto.setTag1(a);
				break;
			case 1:
				tldto.setTag2(a);
				break;
			case 2:
				tldto.setTag3(a);
				break;
			case 3:
				tldto.setTag4(a);
				break;
			case 4:
				tldto.setTag5(a);
				break;
			case 5:
				tldto.setTag6(a);
				break;
			case 6:
				tldto.setTag7(a);
				break;
			case 7:
				tldto.setTag8(a);
				break;
			case 8:
				tldto.setTag9(a);
				break;
			case 9:
				tldto.setTag10(a);
				break;
			default:
				break;
			}
			i++;
		}
		return dao.searchArticle(tldto);
		
	}

	@Override
	public void updateArticle(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub

		ArticleDto dto =  new ArticleDto();
		
		//아티클 생성
		dto.setUser_no(Integer.parseInt(map.get("user_no")));
		dto.setTitle_kor(map.get("title_kor"));
		dto.setTitle_eng(map.get("title_eng"));
		dto.setLike_cnt(0);
		dto.setBookmark_cnt(0);
		dto.setHits(0);
		dto.setCreated_at(map.get("created_at"));
		dto.setUpdated_at("created_at");
		dto.setLike_weekly(0);
		dto.setContent(map.get("content"));
		dto.setImg_path(map.get("img_path"));
		if(map.get("category").equals("admin"))
			dto.setCategory(true);
		else
			dto.setCategory(false);
		dto.setAbv(Integer.parseInt(map.get("abv")));
		dto.setCup_no(Integer.parseInt(map.get("cup_no")));
		
		//생성된 아티클의 pk를 유저번호, 제목, 시간으로 찾고 그중에 가장 나중에 만들어진 pk를 가져옴
		int pk=dao.searchArticlePK(dto);
		dao.updateArticle(dto);
	}

	@Override
	public void deleteArticle(int pk_article) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteArticle(pk_article);
	}

	@Override
	public void createIngredient(String name) throws Exception {
		// TODO Auto-generated method stub
		IngredientDto idto= new IngredientDto();
		idto.setName_kor(name);
		idto.setName_eng("");
		idto.setImg_path("");
		idto.setContent("새로추가된 재료");
		idao.addIngredient(idto);
	}

	@Override
	public void createTag(String content, int type) throws Exception {
		// TODO Auto-generated method stub
		TagDto tdto = new TagDto();
		tdto.setContent_kor(content);
		tdto.setContent_eng("");
		tdto.setType(type);
		tdao.addTag(tdto);
	}
	
}
