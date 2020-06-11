package com.ramyunmoa.web.entity.admin.board;

import java.sql.Date;

public class BoardAdmin {

	private int id;
	private String title;
	private String content;
	private int likes;
	private int hit;
	private Date regdate;
	private int pub;
	private String nickname;

	public BoardAdmin(int id, String title, String content, int likes, int hit, Date regdate, int pub,
			String nickname) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.likes = likes;
		this.hit = hit;
		this.regdate = regdate;
		this.pub = pub;
		this.nickname = nickname;
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

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getPub() {
		return pub;
	}

	public void setPub(int pub) {
		this.pub = pub;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "BoardAdmin [id=" + id + ", title=" + title + ", content=" + content + ", likes=" + likes + ", hit="
				+ hit + ", regdate=" + regdate + ", pub=" + pub + ", nickname=" + nickname + "]";
	}

}
