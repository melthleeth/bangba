package com.bangba.project730.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bangba.project730.model.dto.ArticleTotalDto;
import com.bangba.project730.model.dto.UserDto;
import com.bangba.project730.model.dto.UserRankDto;
import com.bangba.project730.model.service.AdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	

	@ApiOperation(value = "관리자 기능 - 회원 전체 검색", response = String.class)
	@GetMapping(value="/members")
	@ResponseBody public List<UserDto> searchAll() {
		return adminService.searchAll();
	}
	
	@ApiOperation(value = "관리자 기능 - 회원 이름 검색", response = String.class)
	@GetMapping(value="/members/{keyword}")
	@ResponseBody public List<UserDto> searchByName(@PathVariable @ApiParam(value="검색할 유저의 이름", required = true)String keyword) {
		if(keyword == "") {
			return adminService.searchAll();
		} else {
			return adminService.searchByName(keyword);
		}
	}
	
	@ApiOperation(value = "관리자 기능 - 회원 삭제", response = String.class)
	@DeleteMapping(value="/member/{user_no}")
	@ResponseBody public List<UserDto> deleteUser(@PathVariable @ApiParam(value="유저의 pk", required = true)int user_no) {
		adminService.deleteUser(user_no);
		return adminService.searchAll();
	}
	
	@ApiOperation(value = "관리자 기능 - 회원 관리자로 변경")
	@PutMapping(value="/member/type", headers = { "Content-type=application/json" })
	@ResponseBody public List<UserDto> changeToAdmin(@RequestBody @ApiParam(value="회원 한 명의 정보를 담는 객체", required = true) UserDto userDto) {
		adminService.changeToAdmin(userDto);
		adminService.createAdmin(userDto.getPk_user());
		return adminService.searchAll();
	}
	
	@ApiOperation(value = "관리자 기능 - 회원 영구정지", response = String.class)
	@PutMapping(value="/member/ban")
	@ResponseBody public List<UserDto> banUser(@RequestBody @ApiParam(value="회원 한 명의 정보를 담는 객체", required = true) UserDto userDto) {
		adminService.banUser(userDto);
		return adminService.searchAll();
	}
	@ApiOperation(value = "관리자 기능 - 주간 회원 랭킹", response = String.class)
	@PutMapping(value="/member/userrank")
	@ResponseBody public List<UserRankDto> userRankWeekly() {
		return adminService.userRankWeekly();
	}
	@ApiOperation(value = "관리자 기능 - 주간 레시피 랭킹", response = String.class)
	@PutMapping(value="/member/articlerank")
	@ResponseBody public List<ArticleTotalDto> articleRankWeekly() throws Exception {
		return adminService.articleRankWeekly();
	}
}
