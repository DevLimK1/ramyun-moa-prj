package com.ramyunmoa.web.entity.review;

import java.util.Date;

public class Member {
	private int id;
	private String uid;
	private String nickname;
	private String email;
	private String pwd;
	private String gender;
	private String grade;
	private Date regdate;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(int id, String uid, String nickname) {
		this.id = id;
		this.uid = uid;
		this.nickname = nickname;
	}
	
	public Member(int id, String uid, String nickname, String email, String pwd, String gender, String grade,
			Date regdate) {
		this.id = id;
		this.uid = uid;
		this.nickname = nickname;
		this.email = email;
		this.pwd = pwd;
		this.gender = gender;
		this.grade = grade;
		this.regdate = regdate;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public Date getRegdate() {
		return regdate;
	}



	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", uid=" + uid + ", nickname=" + nickname + ", email=" + email + ", pwd=" + pwd
				+ ", gender=" + gender + ", grade=" + grade + ", regdate=" + regdate + "]";
	}
	
	
}
