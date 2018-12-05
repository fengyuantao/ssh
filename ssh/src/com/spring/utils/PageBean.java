package com.spring.utils;

import java.util.List;

public class PageBean {

	private Integer currentPage;
	private Integer pageCount;
	private Integer totalPage;
	private Integer totalCount;
	private List list;
	
	
	
	
	public PageBean(Integer currentPage, Integer pageCount, Integer totalCount) {
		
		this.currentPage = currentPage;
		if(this.currentPage == null) {
			this.currentPage = 1;
		}
		
		this.pageCount = pageCount;
		if(this.pageCount == null) {
			this.pageCount = 3;
		}
		this.totalCount = totalCount;
		//计算总页数
		this.totalPage = (this.totalCount + this.pageCount -1)/this.pageCount;
		if(this.currentPage < 1) {
			this.currentPage = 1;
		}
		if(this.currentPage > this.totalPage) {
			this.currentPage = this.totalCount;
		}
		
		
	}
	
	//计算开始索引
	public Integer getStartIndex() {
		return (this.currentPage - 1) * this.pageCount;
	}
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
	
	
	
}
