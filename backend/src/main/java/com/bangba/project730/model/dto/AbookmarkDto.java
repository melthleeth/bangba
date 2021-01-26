package com.bangba.project730.model.dto;

public class AbookmarkDto {
	
	private int pk_abookmark;
	private int article_no;
	private int user_no;
	
	private boolean favorites;

	public int getPk_abookmark() {
		return pk_abookmark;
	}

	public void setPk_abookmark(int pk_abookmark) {
		this.pk_abookmark = pk_abookmark;
	}

	public int getArticle_no() {
		return article_no;
	}

	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public boolean isFavorites() {
		return favorites;
	}

	public void setFavorites(boolean favorites) {
		this.favorites = favorites;
	}
	
}
