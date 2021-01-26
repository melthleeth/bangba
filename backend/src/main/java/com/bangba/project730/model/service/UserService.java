package com.bangba.project730.model.service;

import java.util.Map;

import com.bangba.project730.model.dto.UserDto;

public interface UserService {
	// 회원가입 관련 함수
	public void createUser(UserDto user) throws Exception;
	public void sendEmail(String toAddress, String subject, String body);
	public int isDuplicated(String toAddress);
	
	// 로그인 관련 함수 
	public UserDto login(Map<String, String> map) throws Exception;
}
