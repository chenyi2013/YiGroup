package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class FavorableInfo {
	private String stid;
	private ArrayList<Favorable> data;
	private Time time;
	private Paging paging;
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	public ArrayList<Favorable> getData() {
		return data;
	}
	public void setData(ArrayList<Favorable> data) {
		this.data = data;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	@Override
	public String toString() {
		return "FavorableInfo [stid=" + stid + ", data=" + data + ", time="
				+ time + ", paging=" + paging + "]";
	}
	
	

}
