package com.bangba.project730.model.dto;

public class UserDto {
	
	private int pk_user;
	
	private String email;
	private String password;
	private String user_name;
	private String birth;
	private String phone_number;
	
	private boolean user_type;
	private boolean banned;
	
	private String img_path;

	public int getPk_user() {
		return pk_user;
	}

	public void setPk_user(int pk_user) {
		this.pk_user = pk_user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public boolean isUser_type() {
		return user_type;
	}

	public void setUser_type(boolean user_type) {
		this.user_type = user_type;
	}

	public boolean isBanned() {
		return banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	
}
