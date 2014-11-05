package com.kevin.yigroup.entity;

public class Campaign {

	private String longtitle;
	private String logo;
	private String infourl;
	private String tag;
	private int buystatus;
	private int type;

	public String getLongtitle() {
		return longtitle;
	}

	public void setLongtitle(String longtitle) {
		this.longtitle = longtitle;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getInfourl() {
		return infourl;
	}

	public void setInfourl(String infourl) {
		this.infourl = infourl;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getBuystatus() {
		return buystatus;
	}

	public void setBuystatus(int buystatus) {
		this.buystatus = buystatus;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Campaign [longtitle=" + longtitle + ", logo=" + logo
				+ ", infourl=" + infourl + ", tag=" + tag + ", buystatus="
				+ buystatus + ", type=" + type + "]";
	}

}
