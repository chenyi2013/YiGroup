package com.kevin.yigroup.entity;

public class DealInfo {
	
	private String stid;
	private DealData data;
	private Time time;
	private Paging paging;
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	public DealData getData() {
		return data;
	}
	public void setData(DealData data) {
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
		return "DealInfo [stid=" + stid + ", data=" + data + ", time=" + time
				+ ", paging=" + paging + "]";
	}
	
	

}
