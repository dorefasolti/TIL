package com.readme.admin.model.vo;

import java.sql.Date;

public class Notice {
	private int nno;
	private int nWriter;
	private String nTitle;
	private String nContent;
	private Date noticeEnrollDate;
	private int nCount;
	private String nStatus;
	
	public Notice() {
		super();
	}
	public Notice(int nno, int nWriter, String nTitle, String nContent, Date noticeEnrollDate, int nCount,
			String nStatus) {
		super();
		this.nno = nno;
		this.nWriter = nWriter;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.noticeEnrollDate = noticeEnrollDate;
		this.nCount = nCount;
		this.nStatus = nStatus;
	}
	public int getNno() {
		return nno;
	}
	public void setNno(int nno) {
		this.nno = nno;
	}
	public int getnWriter() {
		return nWriter;
	}
	public void setnWriter(int nWriter) {
		this.nWriter = nWriter;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public Date getNoticeEnrollDate() {
		return noticeEnrollDate;
	}
	public void setNoticeEnrollDate(Date noticeEnrollDate) {
		this.noticeEnrollDate = noticeEnrollDate;
	}
	public int getnCount() {
		return nCount;
	}
	public void setnCount(int nCount) {
		this.nCount = nCount;
	}
	public String getnStatus() {
		return nStatus;
	}
	public void setnStatus(String nStatus) {
		this.nStatus = nStatus;
	}
	@Override
	public String toString() {
		return "Notice [nno=" + nno + ", nWriter=" + nWriter + ", nTitle=" + nTitle + ", nContent=" + nContent
				+ ", noticeEnrollDate=" + noticeEnrollDate + ", nCount=" + nCount + ", nStatus=" + nStatus + "]";
	}
}
