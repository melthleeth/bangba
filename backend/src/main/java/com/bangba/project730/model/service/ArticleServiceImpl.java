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
import com.bangba.project730.model.dto.ArticleDto;
import com.bangba.project730.model.dto.Article_alcoholDto;
import com.bangba.project730.model.dto.Article_ingredientDto;
import com.bangba.project730.model.dto.IngredientDto;
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
		
		int pk=dao.createArticle(dto);
		
		//생성된 아티클의 pk를 유저번호, 제목, 시간으로 찾고 그중에 가장 나중에 만들어진 pk를 가져옴
		//int pk=dao.searchArticlePK(dto);

         int r=1;
		 Set<Map.Entry<String, String>> entrySet = map.entrySet(); //Map.EntrySet 얻기
	     Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();
	     while (entryIterator.hasNext()) {
	            Map.Entry<String, String> entry = entryIterator.next();
	            String key = entry.getKey();
	            String value = entry.getValue();
	            if(key.equals("alcohol"))
	            {
	            	//술추가
	            	Article_alcoholDto aadto= new Article_alcoholDto();
	            	
	        		int apk=adao.searchAlcoholPK(value);
	        		
	        		entry = entryIterator.next();
	 	            String quantity = entry.getValue();
	 	            entry = entryIterator.next();
	 	            String unit = entry.getValue();
	 	            
	        		aadto.setArticle_no(pk);
	        		aadto.setAlcohol_no(apk);
	        		aadto.setQuantity(quantity);
	        		aadto.setUnit(unit);
	        		
	        		dao.addArticleAlcohol(aadto);
	            }
		        else if(key.equals("ingredient"))
		        {
		        	//재료추가
		        	Article_ingredientDto aidto= new Article_ingredientDto();

		    		int ipk=idao.searchIngredientPK(value);
		    		
	 	            entry = entryIterator.next();
	 	            String type = entry.getValue();
		        	entry = entryIterator.next();
	 	            String quantity = entry.getValue();
	 	            entry = entryIterator.next();
	 	            String unit = entry.getValue();
	 	            
	 	            aidto.setArticle_no(pk);
	 	            aidto.setIngredient_no(ipk);
	 	            aidto.setType(Boolean.parseBoolean(type));
	 	            aidto.setQuantity(quantity);
	 	            aidto.setUnit(unit);
	 	            
		    		dao.addArticleIngredient(aidto);
		        }
	            else if(key.equals("tag"))
	            {
	            	//태그추가
	        		int tpk=tdao.searchTagPK(value);
	        		dao.addArticleTag(pk, tpk);
	            }
	            else if(key.equals("recipe"))
	            {
	        		//레시피추가
	        		dao.addRecipe(Integer.toString(pk), value, Integer.toString(r));
	        		r++;
	            }
	        }
	}

	@Override
	public ArticleDto searchArticle(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		TaglistDto tldto = new TaglistDto();
		 Set<Map.Entry<String, String>> entrySet = map.entrySet(); //Map.EntrySet 얻기
	     Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();
	     while (entryIterator.hasNext()) {
	            Map.Entry<String, String> entry = entryIterator.next();
	            String key = entry.getKey();
	            String value = entry.getValue();
	            if(key.equals("searchtxt"))
	            {
	            	tldto.setSearchtxt(value);
	            	
	            }
		        else
		        {
		        	String s=tldto.getTag1();
		        	
		        	if(s==null)
		        		tldto.setTag1(value);
		        	else
		        		s=tldto.getTag2();
		        	
		        	if(s==null)
		        		tldto.setTag2(value);
		        	else
		        		s=tldto.getTag3();
		        	
		        	if(s==null)
		        		tldto.setTag3(value);
		        	else
		        		s=tldto.getTag4();
		        	
		        	if(s==null)
		        		tldto.setTag4(value);
		        	else
		        		s=tldto.getTag5();
		        	
		        	if(s==null)
		        		tldto.setTag5(value);
		        	else
		        		s=tldto.getTag6();
		        	
		        	if(s==null)
		        		tldto.setTag6(value);
		        	else
		        		s=tldto.getTag7();
		        	
		        	if(s==null)
		        		tldto.setTag7(value);
		        	else
		        		s=tldto.getTag8();
		        	
		        	if(s==null)
		        		tldto.setTag8(value);
		        	else
		        		s=tldto.getTag9();
		        	
		        	if(s==null)
		        		tldto.setTag9(value);
		        	else
		        		tldto.setTag10(value);
		        }
	           
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
		
		int pk=dao.createArticle(dto);
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
		idto.setImg_path("1");
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
