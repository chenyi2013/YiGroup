package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class Hot {

	private String iconUrl;
	private String name;
	private ArrayList<HotItem> list;

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<HotItem> getList() {
		return list;
	}

	public void setList(ArrayList<HotItem> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Hot [iconUrl=" + iconUrl + ", name=" + name + ", list=" + list
				+ "]";
	}

}
