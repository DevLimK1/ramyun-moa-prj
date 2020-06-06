package com.ramyunmoa.web.entity;


public class ReviewCmt {
	private int id;
	private String content;
	private String writerName;
	private String regdate;
	private int likes;
	private int reviewId;//FK
	
	
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
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
