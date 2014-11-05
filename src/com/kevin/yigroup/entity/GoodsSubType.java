package com.kevin.yigroup.entity;

public class GoodsSubType {

	private int id;
	private boolean hasAttr;
	private int count;
	private boolean onRed;
	private String name;
	private String showType;
	private String type;
	private String showStyle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isHasAttr() {
		return hasAttr;
	}

	public void setHasAttr(boolean hasAttr) {
		this.hasAttr = hasAttr;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShowStyle() {
		return showStyle;
	}

	public void setShowStyle(String showStyle) {
		this.showStyle = showStyle;
	}

	@Override
	public String toString() {
		return "GoodsSubType [id=" + id + ", hasAttr=" + hasAttr + ", count="
				+ count + ", onRed=" + onRed + ", name=" + name + ", showType="
				+ showType + ", type=" + type + ", showStyle=" + showStyle
				+ "]";
	}

}
