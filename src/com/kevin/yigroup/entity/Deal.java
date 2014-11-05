package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class Deal {

	private int dt;
	private String brandname;
	private String cate;
	private String range;
	private String mealcount;
	private int status;
	private String mtitle;
	private String mdcLogoUrl;
	private String smstitle;
	private ArrayList<Campaign> campaigns;
	private String squareimgurl;
	private int ctype;
	private String mlls;
	private String subcate;
	private int id;
	private ArrayList<AttrJson> attrJson;
	private String title;
	private int price;
	private int festcanuse;
	private float value;
	private String coupontitle;
	private int rate_count;
	private float rating;
	private String cateDesc;
	private int campaignprice;
	private int nobooking;
	private String imgurl;

	public int getDt() {
		return dt;
	}

	public void setDt(int dt) {
		this.dt = dt;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getMealcount() {
		return mealcount;
	}

	public void setMealcount(String mealcount) {
		this.mealcount = mealcount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public String getMdcLogoUrl() {
		return mdcLogoUrl;
	}

	public void setMdcLogoUrl(String mdcLogoUrl) {
		this.mdcLogoUrl = mdcLogoUrl;
	}

	public String getSmstitle() {
		return smstitle;
	}

	public void setSmstitle(String smstitle) {
		this.smstitle = smstitle;
	}

	public ArrayList<Campaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(ArrayList<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public String getSquareimgurl() {
		return squareimgurl;
	}

	public void setSquareimgurl(String squareimgurl) {
		this.squareimgurl = squareimgurl;
	}

	public int getCtype() {
		return ctype;
	}

	public void setCtype(int ctype) {
		this.ctype = ctype;
	}

	public String getMlls() {
		return mlls;
	}

	public void setMlls(String mlls) {
		this.mlls = mlls;
	}

	public String getSubcate() {
		return subcate;
	}

	public void setSubcate(String subcate) {
		this.subcate = subcate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<AttrJson> getAttrJson() {
		return attrJson;
	}

	public void setAttrJson(ArrayList<AttrJson> attrJson) {
		this.attrJson = attrJson;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getFestcanuse() {
		return festcanuse;
	}

	public void setFestcanuse(int festcanuse) {
		this.festcanuse = festcanuse;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getCoupontitle() {
		return coupontitle;
	}

	public void setCoupontitle(String coupontitle) {
		this.coupontitle = coupontitle;
	}

	public int getRate_count() {
		return rate_count;
	}

	public void setRate_count(int rate_count) {
		this.rate_count = rate_count;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getCateDesc() {
		return cateDesc;
	}

	public void setCateDesc(String cateDesc) {
		this.cateDesc = cateDesc;
	}

	public int getCampaignprice() {
		return campaignprice;
	}

	public void setCampaignprice(int campaignprice) {
		this.campaignprice = campaignprice;
	}

	public int getNobooking() {
		return nobooking;
	}

	public void setNobooking(int nobooking) {
		this.nobooking = nobooking;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Override
	public String toString() {
		return "Deal [dt=" + dt + ", brandname=" + brandname + ", cate=" + cate
				+ ", range=" + range + ", mealcount=" + mealcount + ", status="
				+ status + ", mtitle=" + mtitle + ", mdcLogoUrl=" + mdcLogoUrl
				+ ", smstitle=" + smstitle + ", campaigns=" + campaigns
				+ ", squareimgurl=" + squareimgurl + ", ctype=" + ctype
				+ ", mlls=" + mlls + ", subcate=" + subcate + ", id=" + id
				+ ", attrJson=" + attrJson + ", title=" + title + ", price="
				+ price + ", festcanuse=" + festcanuse + ", value=" + value
				+ ", coupontitle=" + coupontitle + ", rate_count=" + rate_count
				+ ", rating=" + rating + ", cateDesc=" + cateDesc
				+ ", campaignprice=" + campaignprice + ", nobooking="
				+ nobooking + ", imgurl=" + imgurl + "]";
	}

}
