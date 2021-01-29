package com.bangba.project730.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangba.project730.model.dto.UserDto;

@Mapper
public interface UserDao {
	public void createUser(UserDto user) throws Exception;
	public void sendEmail(String toAddress, String subject, String body);
	public int isDuplicatedEmail(String toAddress);
	public int isDuplicatedName(String name);

	public UserDto login(Map<String, String> map) throws Exception;
	
	public UserDto getMyPage(int pk_user);
	public void updateMyPage(UserDto userDto);
	public void deleteMyPage(int pk_user);
}
