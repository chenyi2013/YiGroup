package com.kevin.yigroup.entity;

public class MovieStid {

	private String stid;
	private MoveStidData data;
	private Time server;

	public String getStid() {
		return stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public MoveStidData getData() {
		return data;
	}

	public void setData(MoveStidData data) {
		this.data = data;
	}

	public Time getServer() {
		return server;
	}

	public void setServer(Time server) {
		this.server = server;
	}

	@Override
	public String toString() {
		return "MovieStid [stid=" + stid + ", data=" + data + ", server="
				+ server + "]";
	}

}
