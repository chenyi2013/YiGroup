package com.kevin.yigroup.entity;

public class MoveStidDataListItem {

	private long id;
	private String name;
	private String type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "MoveStidDataListItem [id=" + id + ", name=" + name + ", type="
				+ type + "]";
	}

}
