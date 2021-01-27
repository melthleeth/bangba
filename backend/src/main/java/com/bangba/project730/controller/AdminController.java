package com.bangba.project730.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bangba.project730.model.dto.UserDto;
import com.bangba.project730.model.service.AdminService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@ApiOperation(value = "관리자 기능 - 회원 전체 검색", response = String.class)
	@GetMapping(value="/search/all")
	@ResponseBody public List<UserDto> searchAll() {
		return adminService.searchAll();
	}
	
	@ApiOperation(value = "관리자 기능 - 회원 이름 검색", response = String.class)
	@GetMapping(value="/search/{keyword}")
	@ResponseBody public List<UserDto> searchByName(@PathVariable String keyword) {
		if(keyword == "") {
			return adminService.searchAll();
		} else {
			return adminService.searchByName(keyword);
		}
	}
	
	@ApiOperation(value = "관리자 기능 - 회원 삭제", response = String.class)
	@DeleteMapping(value="/delete/{user_no}")
	@ResponseBody public List<UserDto> deleteUser(@PathVariable int user_no) {
		adminService.deleteUser(user_no);
		return adminService.searchAll();
	}
	
	@ApiOperation(value = "관리자 기능 - 회원 관리자로 변경", response = String.class)
	@PutMapping(value="/change")
	@ResponseBody public List<UserDto> changeToAdmin(@RequestParam UserDto userDto) {
		adminService.changeToAdmin(userDto);
		adminService.createAdmin(userDto.getPk_user());
		return adminService.searchAll();
	}
	
	@ApiOperation(value = "관리자 기능 - 회원 영구정지", response = String.class)
	@PutMapping(value="/ban/{user_no}")
	@ResponseBody public List<UserDto> banUser(@RequestParam UserDto userDto) {
		adminService.banUser(userDto);
		return adminService.searchAll();
	}
}
