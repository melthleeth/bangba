package com.bangba.project730.model.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangba.project730.model.dto.User;

@Mapper
public interface UserDao {
	public void createUser(User user) throws Exception;
	public void sendEmail(String toAddress, String subject, String body);
	public boolean isDuplicated(String toAddress);

	public User login(Map<String, String> map) throws Exception;
}
