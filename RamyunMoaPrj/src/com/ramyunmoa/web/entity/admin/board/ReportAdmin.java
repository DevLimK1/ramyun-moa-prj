package com.ramyunmoa.web.entity.admin.board;

import java.sql.Date;

public class ReportAdmin {

	private int id;
	private String title;
	private String content;
	private String nickname;
	private Date regdate;
	private int hit;
	private String reportId;
	private String reportTitle;
	private String reportContent;
	private String reportNickname;
	private Date reportRegdate;

	public ReportAdmin(int id, String title, String content, String nickname, Date regdate, int hit, String reportId,
			String reportTitle, String reportContent, String reportNickname, Date reportRegdate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.nickname = nickname;
		this.regdate = regdate;
		this.hit = hit;
		this.reportId = reportId;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.reportNickname = reportNickname;
		this.reportRegdate = reportRegdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getReportNickname() {
		return reportNickname;
	}

	public void setReportNickname(String reportNickname) {
		this.reportNickname = reportNickname;
	}

	public Date getReportRegdate() {
		return reportRegdate;
	}

	public void setReportRegdate(Date reportRegdate) {
		this.reportRegdate = reportRegdate;
	}

	@Override
	public String toString() {
		return "ReportAdmin [id=" + id + ", title=" + title + ", content=" + content + ", nickname=" + nickname
				+ ", regdate=" + regdate + ", hit=" + hit + ", reportId=" + reportId + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", reportNickname=" + reportNickname + ", reportRegdate="
				+ reportRegdate + "]";
	}

}
