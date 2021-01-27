package com.bangba.project730.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangba.project730.model.dao.AdminDao;
import com.bangba.project730.model.dto.AdminDto;
import com.bangba.project730.model.dto.UserDto;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao dao;
	
	@Override
	public List<UserDto> searchAll() {
		return dao.searchAll();
	}
	
	@Override
	public List<UserDto> searchByName(String keyword) {
		return dao.searchByName(keyword);
	}

	@Override
	public void deleteUser(int user_no) {
		dao.deleteUser(user_no);
	}

	@Override
	public void changeToAdmin(UserDto userDto) {
		dao.changeToAdmin(userDto);
	}

	@Override
	public void banUser(UserDto userDto) {
		dao.banUser(userDto);
	}

	@Override
	public void createAdmin(int user_no) {
		dao.createAdmin(user_no);
	}
}
