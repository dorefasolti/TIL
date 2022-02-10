package com.kh.mybatis.common.model.vo;

public class PageInfo {
	private int listCount;//	총 게시글 갯수
	private int currentPage;//	현재페이지(요청한페이지)
	private int pageLimit;//	하단에 보여질 페이징바의 최대목록 갯수
	private int boardLimit;//	해당 페이지에 보여질 게시글 최대 갯수
		
	private int maxPage;//	가장 마지막 페이지(총 게시글 갯수, 게시글 최대 갯수)
	private int startPage;//	페이징바의 시작 수(페이징바 목록 갯수, 요청한 페이지)
	private int endPage;//	페이징바의 끝 수(시작 페이지, 페이징바 목록 갯수, 마지막 페이지)
	public PageInfo() {
		super();
	}
	public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	public final int getListCount() {
		return listCount;
	}
	public final void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public final int getCurrentPage() {
		return currentPage;
	}
	public final void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public final int getPageLimit() {
		return pageLimit;
	}
	public final void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
	public final int getBoardLimit() {
		return boardLimit;
	}
	public final void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}
	public final int getMaxPage() {
		return maxPage;
	}
	public final void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public final int getStartPage() {
		return startPage;
	}
	public final void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public final int getEndPage() {
		return endPage;
	}
	public final void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
	
	
	
}
