package com.kh.mybatis.board.model.vo;

import java.sql.Date;

/**
 * @author MIRA
 *
 */
public class Reply {
	private int replyNo;
	private String replyContent;
	private int refBoardNo;
	private String replyWriter;
	private Date createDate;
	private String status;
	public Reply() {
		super();
	}
	public Reply(int replyNo, String replyContent, int refBoardNo, String replyWriter, Date createDate, String status) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.refBoardNo = refBoardNo;
		this.replyWriter = replyWriter;
		this.createDate = createDate;
		this.status = status;
	}
	public final int getReplyNo() {
		return replyNo;
	}
	public final String getReplyContent() {
		return replyContent;
	}
	public final int getRefBoardNo() {
		return refBoardNo;
	}
	public final String getReplyWriter() {
		return replyWriter;
	}
	public final Date getCreateDate() {
		return createDate;
	}
	public final String getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", refBoardNo=" + refBoardNo
				+ ", replyWriter=" + replyWriter + ", createDate=" + createDate + ", status=" + status + "]";
	}
	
	
	
}
