package com.ramyunmoa.web.entity.notice;

public class Feedback {
	private int id;
	private String title;
	private String content;
	private String writerId;
	private String regdate;
	private int hit;

	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Feedback(int id, String title, String content, String writerId, String regdate, int hit) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.writerId = writerId;
		this.regdate = regdate;
		this.hit = hit;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
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
		return "Feedback [id=" + id + ", title=" + title + ", content=" + content + ", writerId=" + writerId
				+ ", regdate=" + regdate + ", hit=" + hit + "]";
	}

	

}
