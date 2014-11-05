package com.kevin.yigroup.entity;

public class MeiTuanFood {

	private String title;
	private String imageUrl;
	private int within;
	private String serviceUrl;
	private String comment;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getWithin() {
		return within;
	}

	public void setWithin(int within) {
		this.within = within;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "MeiTuanFood [title=" + title + ", imageUrl=" + imageUrl
				+ ", within=" + within + ", serviceUrl=" + serviceUrl
				+ ", comment=" + comment + "]";
	}

}
