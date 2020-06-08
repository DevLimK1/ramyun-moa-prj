package com.ramyunmoa.web.entity.review;

public class Grade {
	private int id;
	private int value;
	private String content;
	
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	
	public Grade(int id, int value, String content) {
		this.id = id;
		this.value = value;
		this.content = content;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Grade [id=" + id + ", value=" + value + ", content=" + content + "]";
	}
	
	
}
