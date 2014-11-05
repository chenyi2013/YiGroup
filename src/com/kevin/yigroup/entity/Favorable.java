package com.kevin.yigroup.entity;

public class Favorable {
	
	private int id;
	private boolean module;
	private Share share;
	private String title;
	private String newimageurl;
	private String maintitle;
	private String subtitle;
	private int type;
	private String imageurl;
	private String imgurl_large;
	private long solds;
	private String deputytitle;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isModule() {
		return module;
	}
	public void setModule(boolean module) {
		this.module = module;
	}
	public Share getShare() {
		return share;
	}
	public void setShare(Share share) {
		this.share = share;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNewimageurl() {
		return newimageurl;
	}
	public void setNewimageurl(String newimageurl) {
		this.newimageurl = newimageurl;
	}
	public String getMaintitle() {
		return maintitle;
	}
	public void setMaintitle(String maintitle) {
		this.maintitle = maintitle;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getImgurl_large() {
		return imgurl_large;
	}
	public void setImgurl_large(String imgurl_large) {
		this.imgurl_large = imgurl_large;
	}
	public long getSolds() {
		return solds;
	}
	public void setSolds(long solds) {
		this.solds = solds;
	}
	public String getDeputytitle() {
		return deputytitle;
	}
	public void setDeputytitle(String deputytitle) {
		this.deputytitle = deputytitle;
	}
	@Override
	public String toString() {
		return "Favorable [id=" + id + ", module=" + module + ", share="
				+ share + ", title=" + title + ", newimageurl=" + newimageurl
				+ ", maintitle=" + maintitle + ", subtitle=" + subtitle
				+ ", type=" + type + ", imageurl=" + imageurl
				+ ", imgurl_large=" + imgurl_large + ", solds=" + solds
				+ ", deputytitle=" + deputytitle + "]";
	}
	
	

}
