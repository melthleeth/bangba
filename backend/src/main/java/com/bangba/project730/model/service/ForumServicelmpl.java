package com.bangba.project730.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangba.project730.model.dao.ForumDao;
import com.bangba.project730.model.dao.UserDao;
import com.bangba.project730.model.dto.FFcommentDto;
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
		fcdto.setForum_no(Integer.parseInt(map.get("forum_no")));
		fcdto.setUser_no(Integer.parseInt(map.get("user_no")));
		fcdto.setCreated_at(map.get("created_at"));
		fcdto.setContent(map.get("content"));


//		System.out.println(fcdto.getForum_no());
//		System.out.println(fcdto.getUser_no());
//		System.out.println(fcdto.getCreated_at());
//		System.out.println(fcdto.getContent());
//		System.out.println(fcdto.getUser_name());

		dao.createComment(fcdto);
		return null;
	}

	@Override
	public List<FFcommentDto> searchComment(int pk_forum) throws Exception {
		// TODO Auto-generated method stub
		List<FcommentDto> lfcdto =  dao.searchComment(pk_forum);
		List<FFcommentDto> lffcdto = new List<FFcommentDto>() {

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<FFcommentDto> subList(int fromIndex, int toIndex) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public FFcommentDto set(int index, FFcommentDto element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public FFcommentDto remove(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public ListIterator<FFcommentDto> listIterator(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ListIterator<FFcommentDto> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int lastIndexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Iterator<FFcommentDto> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public int indexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public FFcommentDto get(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean addAll(int index, Collection<? extends FFcommentDto> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends FFcommentDto> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void add(int index, FFcommentDto element) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean add(FFcommentDto e) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		for(FcommentDto fcdto : lfcdto)
		{
			FFcommentDto ffcdto = new FFcommentDto();
			ffcdto.setPk_fcomment(fcdto.getPk_fcomment());
			ffcdto.setForum_no(fcdto.getForum_no());
			ffcdto.setUser_name(udao.getUserName(fcdto.getUser_no()));
			ffcdto.setImg_path(udao.getImgPath(fcdto.getUser_no()));
			ffcdto.setCreated_at(fcdto.getCreated_at());
			ffcdto.setContent(fcdto.getContent());
			lffcdto.add(ffcdto);
		}
		return lffcdto;
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
