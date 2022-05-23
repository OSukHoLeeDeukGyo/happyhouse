package com.ssafy.vue.dto;

public class ListParameterDto {
	private String key;
	private String word;
	private int start;
	private int countPerPage;
	
	
	public ListParameterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListParameterDto(String key, String word) {
		super();
		this.key = key;
		this.word = word;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@Override
	public String toString() {
		return "ListParameterDto [key=" + key + ", word=" + word + "]";
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
}	
