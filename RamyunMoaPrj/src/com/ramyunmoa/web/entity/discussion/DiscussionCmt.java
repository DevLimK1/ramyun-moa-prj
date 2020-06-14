package com.ramyunmoa.web.entity.discussion;

import java.util.Date;
import java.util.List;

public class DiscussionCmt {
	private int id;
	private String content;
	private String writerName;
	private Date regdate;
	private int likes;
	private int reviewId;//FK
	private int bossId;//FK (자기참조)
	private List<DiscussionCmt> children;
	
	public List<DiscussionCmt> getChildren() {
		return children;
	}


	public void setChildren(List<DiscussionCmt> children) {
		this.children = children;
	}


	public DiscussionCmt() {
		// TODO Auto-generated constructor stub
	}
	
	
	public DiscussionCmt(int id, String content, String writerName, Date regdate, int likes, int reviewId) {
		this.id = id;
		this.content = content;
		this.writerName = writerName;
		this.regdate = regdate;
		this.likes = likes;
		this.reviewId = reviewId;
	}

	
	
	

public DiscussionCmt(int id, String content, String writerName, Date regdate, int likes, int reviewId, int bossId) {
		this.id = id;
		this.content = content;
		this.writerName = writerName;
		this.regdate = regdate;
		this.likes = likes;
		this.reviewId = reviewId;
		this.bossId = bossId;
	}


//	public List getChildren() {
//		return children;
//	}
//
//
//	public void setChildren(List children) {
//		this.children = children;
//	}



	public int getBossId() {
		return bossId;
	}


	public void setBossId(int bossId) {
		this.bossId = bossId;
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
				+ ", likes=" + likes + ", reviewId=" + reviewId + ", bossId=" + bossId + ", children=" + children + "]";
	}
	
	
	
}
