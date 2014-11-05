package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class GoodsType {

	private int id;
	private int index;
	private int parentID;
	private int count;
	private String name;
	private boolean onRed;
	private ArrayList<GoodsType> list;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOnRed() {
		return onRed;
	}

	public void setOnRed(boolean onRed) {
		this.onRed = onRed;
	}

	public ArrayList<GoodsType> getList() {
		return list;
	}

	public void setList(ArrayList<GoodsType> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", index=" + index + ", parentID="
				+ parentID + ", count=" + count + ", name=" + name + ", onRed="
				+ onRed + ", list=" + list + "]";
	}

}
