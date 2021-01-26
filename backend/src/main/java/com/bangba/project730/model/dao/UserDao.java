package com.bangba.project730.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangba.project730.model.dto.UserDto;

@Mapper
public interface UserDao {
	public void createUser(UserDto user) throws Exception;
	public void sendEmail(String toAddress, String subject, String body);
	public int isDuplicated(String toAddress);

	public UserDto login(Map<String, String> map) throws Exception;
}
