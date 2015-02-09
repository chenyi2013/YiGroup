package com.kevin.yigroup.entity;

public class MoveStidDataMorePageList {

	private boolean hasAttr;
	private long id;
	private int count;
	private boolean onRed;
	private boolean withNoDeal;
	private String name;
	private String showType;
	private String type;
	public boolean isHasAttr() {
		return hasAttr;
	}
	public void setHasAttr(boolean hasAttr) {
		this.hasAttr = hasAttr;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public boolean isWithNoDeal() {
		return withNoDeal;
	}
	public void setWithNoDeal(boolean withNoDeal) {
		this.withNoDeal = withNoDeal;
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
	@Override
	public String toString() {
		return "MoveStidDataMorePageList [hasAttr=" + hasAttr + ", id=" + id
				+ ", count=" + count + ", onRed=" + onRed + ", withNoDeal="
				+ withNoDeal + ", name=" + name + ", showType=" + showType
				+ ", type=" + type + "]";
	}
	
	

}
