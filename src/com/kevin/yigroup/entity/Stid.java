package com.kevin.yigroup.entity;

public class Stid {

	private String stid;
	private long dealid;

	public String getStid() {
		return stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public long getDealid() {
		return dealid;
	}

	public void setDealid(long dealid) {
		this.dealid = dealid;
	}

	@Override
	public String toString() {
		return "Stid [stid=" + stid + ", dealid=" + dealid + "]";
	}

}
