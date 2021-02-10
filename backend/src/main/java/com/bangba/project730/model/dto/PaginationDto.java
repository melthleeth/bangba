package com.bangba.project730.model.dto;

public class PaginationDto {
	
	private int page_num; // 현재 페이지
	
	private int forum_cnt_per_page;// 한 페이지당 보여질 게시글 수
	private int range_cnt = 5; // 한 페이지에 보여지는 범위의 수 
	
	private int page_range; // 현재 페이지 범위 정보
	private int forum_total_cnt; // 게시글 전체 수
	private int range_total_cnt; // 페이지 전체 수
	
	private int forum_start; // 각 페이지에서 시작되는 번호
	private int page_start; // 시작 페이지
	private int page_end; // 끝 페이지
	
	private boolean check_prev; // 이전 페이지로 갈 것인지
	private boolean check_next; // 다음 페이지로 갈 것인지
	
	
	public int getPage_num() {
		return page_num;
	}

	public void setPage_num(int page_num) {
		this.page_num = page_num;
	}

	public int getForum_cnt_per_page() {
		return forum_cnt_per_page;
	}

	public void setForum_cnt_per_page(int forum_cnt_per_page) {
		this.forum_cnt_per_page = forum_cnt_per_page;
	}

	public int getRange_cnt() {
		return range_cnt;
	}

	public void setRange_cnt(int range_cnt) {
		this.range_cnt = range_cnt;
	}

	public int getPage_range() {
		return page_range;
	}

	public void setPage_range(int page_range) {
		this.page_range = page_range;
	}

	public int getForum_total_cnt() {
		return forum_total_cnt;
	}

	public void setForum_total_cnt(int forum_total_cnt) {
		this.forum_total_cnt = forum_total_cnt;
	}

	public int getRange_total_cnt() {
		return range_total_cnt;
	}

	public void setRange_total_cnt(int range_total_cnt) {
		this.range_total_cnt = range_total_cnt;
	}

	public int getForum_start() {
		return forum_start;
	}

	public void setForum_start(int forum_start) {
		this.forum_start = forum_start;
	}

	public int getPage_start() {
		return page_start;
	}

	public void setPage_start(int page_start) {
		this.page_start = page_start;
	}

	public int getPage_end() {
		return page_end;
	}

	public void setPage_end(int page_end) {
		this.page_end = page_end;
	}

	public boolean isCheck_prev() {
		return check_prev;
	}

	public void setCheck_prev(boolean check_prev) {
		this.check_prev = check_prev;
	}

	public boolean isCheck_next() {
		return check_next;
	}

	public void setCheck_next(boolean check_next) {
		this.check_next = check_next;
	}

	public void page_info(int page_num, int page_range, int forum_total_cnt, int forum_cnt_per_page) {
		this.page_num = page_num;
		this.page_range = page_range;
		this.forum_total_cnt = forum_total_cnt;
		this.forum_cnt_per_page = forum_cnt_per_page;
		
		//전체 페이지 숫자 범위 = 전체 게시글 수 / 한 페이지당 보여줄 게시글 수  
		this.range_total_cnt = (int) Math.ceil(forum_total_cnt/forum_cnt_per_page);
		// 시작 페이지
		this.page_start = (page_range -1) * range_cnt + 1;
		//  끝
		this.page_end = page_range * range_cnt;
		// 게시판 시작 번호
		this.forum_start = (page_num - 1) * forum_cnt_per_page;
		//prev 버튼
		this.check_prev = page_range == 1 ? false : true;
		//next 버튼
		this.check_next = page_end > range_total_cnt ? false : true;
		if (this.page_end > this.range_total_cnt) {
			this.page_end = this.range_total_cnt;
			this.check_next = false;
		}
	}
}
