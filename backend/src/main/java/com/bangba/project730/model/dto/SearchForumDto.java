package com.bangba.project730.model.dto;

public class SearchForumDto {
	private int pk_forum;		// id
	private String user_name;		// user name
	
	private String title;		// 제목
	private String category;	// 카테고리
			
	private int hits;			// 조회수
	
	private int comment_cnt;	// 댓글 개수
	
	private String created_at;	// 작성일
//	private String updated_at;	// 마지막 업데이트 날짜
	private int forum_cnt_per_page; // 페이지 당 게시글 노출시킬 갯수
	private int page_num; // 보여줄 페이지 번호
	

	public int getPk_forum() {
		return pk_forum;
	}
	public void setPk_forum(int pk_forum) {
		this.pk_forum = pk_forum;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getComment_cnt() {
		return comment_cnt;
	}
	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getForum_cnt_per_page() {
		return forum_cnt_per_page;
	}
	public void setForum_cnt_per_page(int forum_cnt_per_page) {
		this.forum_cnt_per_page = forum_cnt_per_page;
	}
	public int getPage_no() {
		return page_num;
	}
	public void setPage_no(int page_num) {
		this.page_num = page_num;
	}
	
}
