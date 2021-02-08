package com.bangba.project730.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangba.project730.model.dao.ForumDao;
import com.bangba.project730.model.dao.UserDao;
import com.bangba.project730.model.dto.FcommentDto;
import com.bangba.project730.model.dto.ForumDto;
import com.bangba.project730.model.dto.SearchForumDto;


@Service
public class ForumServicelmpl implements ForumService{

	@Autowired
    ForumDao dao;
	
	@Autowired
    UserDao udao;
    
    @Override
    public void createForum(ForumDto forumDto) throws Exception {
        dao.createForum(forumDto);
    }

    @Override
    public int getForumListCnt(SearchForumDto searchForumDto) throws Exception {
        return dao.getForumListCnt(searchForumDto);
    }
    
    @Override
    public List<ForumDto> searchForumList(SearchForumDto searchForumDto) throws Exception {
        return dao.searchForumList(searchForumDto);
    }
    
    @Override
    public ForumDto detailForum(int pk_forum) throws Exception {
        return dao.detailForum(pk_forum);
    }
    
    @Override
    public void updateHits(int hits) throws Exception {
        dao.updateHits(hits);
    }

    @Override
    public void updateForum(ForumDto forumDto) throws Exception {
        dao.updateForum(forumDto);
    }

    @Override
    public void deleteForum(int pk_forum) throws Exception {
        dao.deleteForum(pk_forum);
        
    }
    
    @Override
    public List<ForumDto> searchNotices() throws Exception {
        return dao.searchNotices();
    }
    @Override
	public String createComment(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		FcommentDto fcdto = new FcommentDto();
		fcdto.setForum_no(Integer.parseInt(map.get("pk_forum")));
		fcdto.setUser_no(Integer.parseInt(map.get("user_no")));
		fcdto.setCreated_at(map.get("created_at"));
		fcdto.setContent(map.get("content"));
		dao.createComment(fcdto);
		return null;
	}

	@Override
	public Map<String, String> searchComment(int pk_forum) throws Exception {
		// TODO Auto-generated method stub
		List<FcommentDto> lfcdto =  dao.searchComment(pk_forum);
		Map<String,String> map = new HashMap<String, String>();
		for(FcommentDto fcdto : lfcdto)
		{
			String s="";
			s+=udao.getUserName(fcdto.getUser_no());
			s+=";";
			s+=udao.getImgPath(fcdto.getUser_no());
			s+=";";
			s+=fcdto.getCreated_at();
			s+=";";
			s+=fcdto.getContent();
			map.put(Integer.toString(fcdto.getPk_fcomment()), s);
		}
		return map;
	}

	@Override
	public String updateComment(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		FcommentDto fcdto= new FcommentDto();
		fcdto.setPk_fcomment(Integer.parseInt(map.get("pk_fcomment")));
		fcdto.setContent(map.get("content"));
		dao.updateComment(fcdto);
		return null;
	}

	@Override
	public String deleteComment(int pk_fcomment) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteComment(pk_fcomment);
		return null;
	}
}