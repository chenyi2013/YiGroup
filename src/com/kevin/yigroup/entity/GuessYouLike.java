package com.kevin.yigroup.entity;

import java.util.HashMap;

public class GuessYouLike {

	private HashMap<String, SurveyContent> data;
	private Time server;
	private Paging paging;

	public HashMap<String, SurveyContent> getData() {
		return data;
	}

	public void setData(HashMap<String, SurveyContent> data) {
		this.data = data;
	}

	public Time getServer() {
		return server;
	}

	public void setServer(Time server) {
		this.server = server;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@Override
	public String toString() {
		return "GuessYouLike [data=" + data + ", server=" + server
				+ ", paging=" + paging + "]";
	}

}
