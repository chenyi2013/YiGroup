package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class Terms {

	private ArrayList<String> content;
	private String title;

	public ArrayList<String> getContent() {
		return content;
	}

	public void setContent(ArrayList<String> content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Terms [content=" + content + ", title=" + title + "]";
	}

}
