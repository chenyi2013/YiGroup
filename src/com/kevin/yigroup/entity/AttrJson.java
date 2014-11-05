package com.kevin.yigroup.entity;

public class AttrJson {
	private String iconname;
	private int status;
	private int key;

	public String getIconname() {
		return iconname;
	}

	public void setIconname(String iconname) {
		this.iconname = iconname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "AttrJson [iconname=" + iconname + ", status=" + status
				+ ", key=" + key + "]";
	}

}
