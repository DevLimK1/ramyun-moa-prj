package com.ramyunmoa.web.entity.recipe;

import java.util.Date;
import java.util.List;

public class RecipeCmt {
	private int id;
	private String content;
	private String writerName;
	private Date regdate;
	private int likes;
	private int recipeId;//FK
	private int bossId;//FK (자기참조)
	private List<RecipeCmt> children;
	
	public List<RecipeCmt> getChildren() {
		return children;
	}


	public void setChildren(List<RecipeCmt> children) {
		this.children = children;
	}


	public RecipeCmt() {
		// TODO Auto-generated constructor stub
	}
	
	
	public RecipeCmt(int id, String content, String writerName, Date regdate, int likes, int recipeId) {
		this.id = id;
		this.content = content;
		this.writerName = writerName;
		this.regdate = regdate;
		this.likes = likes;
		this.recipeId = recipeId;
	}

	
	
	

public RecipeCmt(int id, String content, String writerName, Date regdate, int likes, int recipeId, int bossId) {
		this.id = id;
		this.content = content;
		this.writerName = writerName;
		this.regdate = regdate;
		this.likes = likes;
		this.recipeId = recipeId;
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



	public int getRecipeId() {
	return recipeId;
}


public void setRecipeId(int recipeId) {
	this.recipeId = recipeId;
}


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
		return "RecipeCmt [id=" + id + ", content=" + content + ", writerName=" + writerName + ", regdate=" + regdate
				+ ", likes=" + likes + ", recipeId=" + recipeId + ", bossId=" + bossId + ", children=" + children + "]";
	}
	
	
	
}
