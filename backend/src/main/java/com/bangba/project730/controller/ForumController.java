package com.bangba.project730.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bangba.project730.model.dto.ForumDto;
import com.bangba.project730.model.dto.SearchForumDto;
import com.bangba.project730.model.service.ForumService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/forum")
public class ForumController {

	@Autowired
	private ForumService forumService;

	@ApiOperation(value = "자유게시판 생성")
	@PostMapping("/create-forum")
	public String createForum(@RequestBody @ApiParam(value = "자유게시판 하나에 대한 정보", required = true) ForumDto forumDto, Model model) throws Exception {
		try {
			forumService.createForum(forumDto);
			model.addAttribute("msg", "생성 Forum Success");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "생성 Forum Internal Server Error!!");
			return "error";
		}
	}

	@ApiOperation(value = "자유게시판 목록 조회")
	@GetMapping("/search-forum-list")
	public List<ForumDto> searchForumList(Model model
			, @RequestParam(required = false, defaultValue = "1") int page_num
			, @RequestParam(required = false, defaultValue = "1") int page_range
			, @RequestParam(required = false, defaultValue = "title") String search_type
			, @RequestParam(required = false) String keyword
			) throws Exception {

		SearchForumDto searchForumDto = new SearchForumDto();
		searchForumDto.setSearch_type(search_type);
		searchForumDto.setKeyword(keyword);

		int forum_total_cnt = forumService.getForumListCnt(searchForumDto);

		searchForumDto.page_info(page_num, page_range, forum_total_cnt);
		model.addAttribute("pagination", searchForumDto);
		model.addAttribute("searchForumList", forumService.searchForumList(searchForumDto));
		return forumService.searchForumList(searchForumDto);
	}


	@ApiOperation(value = "자유게시판 상세페이지")
	@GetMapping("/{pk_forum}")
	public ForumDto detailForum(@PathVariable @ApiParam(value = "자유게시판 하나에 대한 상세정보", required = true) int pk_forum) throws Exception {
		forumService.updateHits(pk_forum);
		return forumService.detailForum(pk_forum);
	}


	@ApiOperation(value = "자유게시판 수정")
	@PutMapping("/update-forum")
	public String updateForum(@RequestBody @ApiParam(value = "자유게시판 하나에 대한 수정 정보", required = true) ForumDto forumDto, Model model) throws Exception {
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


	@ApiOperation(value = "자유게시판 삭제")
	@DeleteMapping("/delete-forum/{pk_forum}")
	public String deleteForum(@PathVariable @ApiParam(value = "자유게시판 하나 삭제", required = true) int pk_forum) throws Exception {
		try {
			forumService.deleteForum(pk_forum);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@ApiOperation(value = "공지사항 불러오기")
	@GetMapping("/notices")
	public List<ForumDto> searchNotices() throws Exception {
		return forumService.searchNotices();
	}

}
