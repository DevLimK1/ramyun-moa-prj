package com.ramyunmoa.web.entity.review;

import java.util.Date;

//ReviewBoard list
public class Review { 
	private int id;
	private String title;
	private String content;
	private int likes;
	private int hit;
	private String img;
	private Date regdate;
//	private String regdate;
	private int productId;
	private int writerId;
	private int gradeId;

	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	//리뷰 목록 검색
	public Review(int id,int writerId, String title, String content, int likes, int hit, Date regdate) {
		this.id=id;
		this.writerId=writerId;
		this.title=title;
		this.content=content;
		this.likes=likes;
		this.hit=hit;
		this.regdate=regdate;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", content=" + content + ", likes=" + likes + ", hit=" + hit
				+ ", img=" + img + ", regdate=" + regdate + ", productId=" + productId + ", writerId=" + writerId
				+ ", gradeId=" + gradeId + "]";
	}
	
//	private int comment;
	

	

}
