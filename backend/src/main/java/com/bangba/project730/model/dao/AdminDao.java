package com.bangba.project730.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bangba.project730.model.dto.UserDto;

@Mapper
public interface AdminDao {
	public List<UserDto> searchByName(String keyword);
	public List<UserDto> searchAll();
	public void deleteUser(int user_no);
	public void changeToAdmin(UserDto userDto);
	public void banUser(UserDto userDto);
	public void createAdmin(int user_no);
}
