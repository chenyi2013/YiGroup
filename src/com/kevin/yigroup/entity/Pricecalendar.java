package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class Pricecalendar {

	private int id;
	private long endtime;
	private float price;
	private long starttime;
	private String desc;
	private ArrayList<Object> range;
	private long dealid;
	private float buyprice;
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getEndtime() {
		return endtime;
	}

	public void setEndtime(long endtime) {
		this.endtime = endtime;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getStarttime() {
		return starttime;
	}

	public void setStarttime(long starttime) {
		this.starttime = starttime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public ArrayList<Object> getRange() {
		return range;
	}

	public void setRange(ArrayList<Object> range) {
		this.range = range;
	}

	public long getDealid() {
		return dealid;
	}

	public void setDealid(long dealid) {
		this.dealid = dealid;
	}

	public float getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(float buyprice) {
		this.buyprice = buyprice;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Pricecalendar [id=" + id + ", endtime=" + endtime + ", price="
				+ price + ", starttime=" + starttime + ", desc=" + desc
				+ ", range=" + range + ", dealid=" + dealid + ", buyprice="
				+ buyprice + ", type=" + type + "]";
	}

}
