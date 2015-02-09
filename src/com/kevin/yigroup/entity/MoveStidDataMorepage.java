package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class MoveStidDataMorepage {

	private long id;
	private boolean hasAttr;
	private int index;
	private long parentID;
	private int count;
	private boolean onRed;
	private String iconUrl;
	private String name;
	private String showType;

	private ArrayList<MoveStidDataMorePageList> list;
	private String type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isHasAttr() {
		return hasAttr;
	}

	public void setHasAttr(boolean hasAttr) {
		this.hasAttr = hasAttr;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public long getParentID() {
		return parentID;
	}

	public void setParentID(long parentID) {
		this.parentID = parentID;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isOnRed() {
		return onRed;
	}

	public void setOnRed(boolean onRed) {
		this.onRed = onRed;
	}

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

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public ArrayList<MoveStidDataMorePageList> getList() {
		return list;
	}

	public void setList(ArrayList<MoveStidDataMorePageList> list) {
		this.list = list;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "MoveStidDataMorepage [id=" + id + ", hasAttr=" + hasAttr
				+ ", index=" + index + ", parentID=" + parentID + ", count="
				+ count + ", onRed=" + onRed + ", iconUrl=" + iconUrl
				+ ", name=" + name + ", showType=" + showType + ", list="
				+ list + ", type=" + type + "]";
	}

}
