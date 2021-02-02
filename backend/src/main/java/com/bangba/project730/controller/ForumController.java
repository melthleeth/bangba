package com.bangba.project730.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangba.project730.model.dto.ForumDto;
import com.bangba.project730.model.service.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	
	@PostMapping("/create-forum")
	public String createForum(@RequestBody ForumDto forumDto, Model model) throws Exception {
		try {
			forumService.createForum(forumDto);
			model.addAttribute("msg", "Create Forum Success");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "Create Forum Internal Server Error!!");
			return "error";
		}
	}
		
	
	@GetMapping("/search-forum-list")
	public String searchForumList(@RequestBody Map<String, String> map, Model model) throws Exception {
		try {
			forumService.searchForumList(map);
			model.addAttribute("msg", "Success");
//			// 화면에서 잘못한거 검사해서 에러처리 Error Code 400 
//			if(i = problem) {
//				model.addAttribute("msg", "잘못한 이유를 적어보자");
//				return "error";
//			}
			return "main";
		} catch (Exception e) {
			// Error Code 500
			e.printStackTrace();
			model.addAttribute("msg", "Internal Server Error!!");
			return "error";
		}
	}
	
	@PutMapping("/update-forum")
	public String updateForum(@RequestBody ForumDto forumDto, Model model) throws Exception {
		try {
			forumService.updateForum(forumDto);
			model.addAttribute("msg", "Update Forum Success");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "Update Forum Internal Server Error!!");
			return "error";
		}
	}
	
}
