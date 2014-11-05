package com.kevin.yigroup.entity;

public class Share {
	private String message;
	private String url;
	private String imgurl;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Override
	public String toString() {
		return "Share [message=" + message + ", url=" + url + ", imgurl="
				+ imgurl + "]";
	}

}
