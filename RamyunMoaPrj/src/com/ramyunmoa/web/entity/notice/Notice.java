package com.ramyunmoa.web.entity.notice;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String content;
	private String writerId;
	private Date regdate;
	private int hit;
	private boolean pub;

	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int id, String title, String content, String writerId, Date regdate, int hit, boolean pub) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.writerId = writerId;
		this.regdate = regdate;
		this.hit = hit;
		this.pub = pub;
	}

	public boolean getPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
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

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", writerId=" + writerId
				+ ", regdate=" + regdate + ", hit=" + hit + ", pub=" + pub + "]";
	}

	

}
