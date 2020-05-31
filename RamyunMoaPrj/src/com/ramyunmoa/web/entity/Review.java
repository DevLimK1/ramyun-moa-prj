package com.ramyunmoa.web.entity;

import java.util.Date;


public class Review {
	private int id;
	private String brand;
	private String perface; // 지금은 쓰이지 않음
	private int likes;
//	private Timestamp regdate;
	private String regdate;
	private String writerName;
	private String title;
	private String content;
	private int hit;
	private String item; // 말머리
	private int starGrade; // 평점
	private String star; // 별
	private String gradeTitle;

	private int comment;

	public Review() {

	}

	public Review(int id, String item, String star, String regdate, String writerName, String title, int comment) {
		this.id = id;
		this.item = item;
		this.star = star;
		this.regdate = regdate;
		this.writerName = writerName;
		this.title = title;
		this.comment = comment;

	}

	public Review(int id, String brand, String perface, int likes, String regdate, String writerName, String title,
			int comment, String content) {
		this.id = id;
		this.brand = brand;
		this.perface = perface;
		this.likes = likes;
		this.regdate = regdate;
		this.writerName = writerName;
		this.title = title;
		this.comment = comment;
		this.content = content;
	}

	// getReview(int id)
	public Review(int id, String item, String title, String star, int starGrade, String regdate, String writerName,
			int hit, String content, String gradeTitle, int comment, int likes) {
		this.id = id;
		this.item = item;
		this.title = title;
		this.star = star;
		this.starGrade = starGrade;
		this.regdate = regdate;
		this.writerName = writerName;
		this.hit = hit;
		this.content = content;
		this.gradeTitle = gradeTitle;
		this.comment = comment;
		this.likes = likes;

	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getStarGrade() {
		return starGrade;
	}

	public void setStarGrade(int starGrade) {
		this.starGrade = starGrade;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPerface() {
		return perface;
	}

	public void setPerface(String perface) {
		this.perface = perface;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public String getGradeTitle() {
		return gradeTitle;
	}

	public void setGradeTitle(String gradeTitle) {
		this.gradeTitle = gradeTitle;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", brand=" + brand + ", perface=" + perface + ", likes=" + likes + ", regdate="
				+ regdate + ", writerName=" + writerName + ", title=" + title + ", content=" + content + ", hit=" + hit
				+ ", item=" + item + ", starGrade=" + starGrade + ", star=" + star + ", gradeTitle=" + gradeTitle
				+ ", comment=" + comment + "]";
	}

}
