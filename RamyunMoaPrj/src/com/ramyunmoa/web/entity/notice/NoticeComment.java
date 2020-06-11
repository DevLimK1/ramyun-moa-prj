package com.ramyunmoa.web.entity.notice;

public class NoticeComment {
	private int id;
	private String content;
	private String writerId;
	private String regdate;
	private int boardId;
	
	public NoticeComment() {
		// TODO Auto-generated constructor stub
	}
	
	public NoticeComment(int id, String content, String writerId, String regdate, int boardId) {
		this.id = id;
		this.content = content;
		this.writerId = writerId;
		this.regdate = regdate;
		this.boardId = boardId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	
	
	
}
