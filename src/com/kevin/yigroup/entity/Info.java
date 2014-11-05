package com.kevin.yigroup.entity;

import java.util.HashMap;

public class Info {

	private String stid;
	private Data data;
	private HashMap<String, Integer> server;

	public String getStid() {
		return stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public HashMap<String, Integer> getServer() {
		return server;
	}

	public void setServer(HashMap<String, Integer> server) {
		this.server = server;
	}

	@Override
	public String toString() {
		return "Info [stid=" + stid + ", data=" + data + ", server=" + server
				+ "]";
	}

}
