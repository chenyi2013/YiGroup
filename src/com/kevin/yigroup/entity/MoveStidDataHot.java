package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class MoveStidDataHot {

	private String iconUrl;
	private String name;
	private ArrayList<MoveStidDataListItem> list;

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

	public ArrayList<MoveStidDataListItem> getList() {
		return list;
	}

	public void setList(ArrayList<MoveStidDataListItem> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "MoveStidDataHot [iconUrl=" + iconUrl + ", name=" + name
				+ ", list=" + list + "]";
	}

}
