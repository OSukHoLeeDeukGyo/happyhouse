package com.ssafy.vue.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Qna (공지사항정보)", description = "글번호, 제목, 내용, 작성자아이디, 작성일을 가진   Domain Class")
public class Qna {
	@ApiModelProperty(value = "글번호")
	private int articleno;
	@ApiModelProperty(value = "작성자아이디")
	private String userid;
	@ApiModelProperty(value = "제목")
	private String subject;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "조회수")
	private int hit;
	@ApiModelProperty(value = "작성일")
	private String regtime;

	public int getArticleno() {
		return articleno;
	}

	public void setArticleno(int articleno) {
		this.articleno = articleno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

}