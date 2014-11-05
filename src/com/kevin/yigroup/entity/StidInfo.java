package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class StidInfo {

	private String stid;
	private ArrayList<Stid> stids;
	private ArrayList<StidData> data;
	private Time server;
	private Paging paging;

	public String getStid() {
		return stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public ArrayList<Stid> getStids() {
		return stids;
	}

	public void setStids(ArrayList<Stid> stids) {
		this.stids = stids;
	}

	public ArrayList<StidData> getData() {
		return data;
	}

	public void setData(ArrayList<StidData> data) {
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
		return "StidInfo [stid=" + stid + ", stids=" + stids + ", data=" + data
				+ ", server=" + server + ", paging=" + paging + "]";

	}

}
