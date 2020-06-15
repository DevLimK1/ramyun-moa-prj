package com.ramyunmoa.web.entity.discussion;

import java.util.Date;
import java.util.List;

public class DiscussionCmt {
	private int id;
	private String content;
	private String writerName;
	private Date regdate;
	private int likes;
	private int discussionId;//FK
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
	
	
	public DiscussionCmt(int id, String content, String writerName, Date regdate, int likes, int discussionId) {
		this.id = id;
		this.content = content;
		this.writerName = writerName;
		this.regdate = regdate;
		this.likes = likes;
		this.discussionId = discussionId;
	}

	
	
	

public DiscussionCmt(int id, String content, String writerName, Date regdate, int likes, int discussionId, int bossId) {
		this.id = id;
		this.content = content;
		this.writerName = writerName;
		this.regdate = regdate;
		this.likes = likes;
		this.discussionId = discussionId;
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


	@Override
	public String toString() {
		return "DiscussionCmt [id=" + id + ", content=" + content + ", writerName=" + writerName + ", regdate="
				+ regdate + ", likes=" + likes + ", discussionId=" + discussionId + ", bossId=" + bossId + ", children="
				+ children + "]";
	}


	public int getDiscussionId() {
		return discussionId;
	}


	public void setDiscussionId(int discussionId) {
		this.discussionId = discussionId;
	}

	
	
	
}
