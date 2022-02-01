package com.readme.admin.model.vo;

import java.sql.Date;

public class Answer {
	
	private int qno;
	private int qWriter;
	private String qTitle;
	private String qContent;
	private Date qDate;
	private String qStatus;
	private String qAnswer;
	private String userId;
	
	
	public Answer() {
		super();
	}


	public Answer(int qno, int qWriter, String qTitle, String qContent, Date qDate, String qStatus, String qAnswer,
			String userId) {
		super();
		this.qno = qno;
		this.qWriter = qWriter;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qDate = qDate;
		this.qStatus = qStatus;
		this.qAnswer = qAnswer;
		this.userId = userId;
	}


	public int getQno() {
		return qno;
	}


	public void setQno(int qno) {
		this.qno = qno;
	}


	public int getqWriter() {
		return qWriter;
	}


	public void setqWriter(int qWriter) {
		this.qWriter = qWriter;
	}


	public String getqTitle() {
		return qTitle;
	}


	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}


	public String getqContent() {
		return qContent;
	}


	public void setqContent(String qContent) {
		this.qContent = qContent;
	}


	public Date getqDate() {
		return qDate;
	}


	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}


	public String getqStatus() {
		return qStatus;
	}


	public void setqStatus(String qStatus) {
		this.qStatus = qStatus;
	}


	public String getqAnswer() {
		return qAnswer;
	}


	public void setqAnswer(String qAnswer) {
		this.qAnswer = qAnswer;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Answer [qno=" + qno + ", qWriter=" + qWriter + ", qTitle=" + qTitle + ", qContent=" + qContent
				+ ", qDate=" + qDate + ", qStatus=" + qStatus + ", qAnswer=" + qAnswer + ", userId=" + userId + "]";
	}
	
	
	
	

}
