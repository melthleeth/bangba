package com.bangba.project730.model.dto;

public class FollowDetailDto {
	private int pk_user;
	private String user_name;
	private int is_follow;
	
	public int getPk_user() {
		return pk_user;
	}
	public void setPk_user(int pk_user) {
		this.pk_user = pk_user;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int isIs_follow() {
		return is_follow;
	}
	public void setIs_follow(int is_follow) {
		this.is_follow = is_follow;
	}
}
