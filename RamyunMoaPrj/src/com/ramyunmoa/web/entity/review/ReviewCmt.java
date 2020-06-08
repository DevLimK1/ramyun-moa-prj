package com.ramyunmoa.web.entity.review;

import java.util.Date;

public class ReviewCmt {
	private int id;
	private String content;
	private String writerName;
	private Date regdate;
	private int likes;
	private int reviewId;//FK
	
	public ReviewCmt() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ReviewCmt(int id, String content, String writerName, Date regdate, int likes, int reviewId) {
		this.id = id;
		this.content = content;
		this.writerName = writerName;
		this.regdate = regdate;
		this.likes = likes;
		this.reviewId = reviewId;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	@Override
	public String toString() {
		return "ReviewCmt [id=" + id + ", content=" + content + ", writerName=" + writerName + ", regdate=" + regdate
				+ ", likes=" + likes + ", reviewId=" + reviewId + "]";
	}
	
	
	
}
